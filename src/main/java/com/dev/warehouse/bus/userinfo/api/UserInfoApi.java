package com.dev.warehouse.bus.userinfo.api;

import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dev.warehouse.bus.entity.UserInfo;
import com.dev.warehouse.bus.userinfo.service.IUserInfoService;
import com.dev.warehouse.enumInfo.PhoneCategoryShowFlagEnum;
import com.dev.warehouse.enumInfo.RegisterTypeEnum;
import com.dev.warehouse.enumInfo.UserGroupIdEnum;
import com.dev.warehouse.response.ResponseBean;
import com.dev.warehouse.sys.common.AppFileUtils;
import com.dev.warehouse.sys.common.ConstInfo;
import com.dev.warehouse.utils.StringUtil;

import cn.hutool.core.util.IdUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(tags = "ユーザー管理API")
@RequestMapping("/user")
public class UserInfoApi {
	
	@Autowired
    private IUserInfoService userInfoService;
    
    /**
     * ユーザー情報を新規登録する(1.メール 2.Wechat)
     * @param mailAddress
     * @param password
     * @param nickname
     * @param sex
     * @param iconPath
     * @param registerType
     * @return
     */
    @ApiOperation("ユーザー新規登録")
    @ApiImplicitParams({
    	@ApiImplicitParam(name="mailAddress", value="メールアドレス"),
    	@ApiImplicitParam(name="password", value="パスワード"),
    	@ApiImplicitParam(name="nickname", value="ニックネーム"),
    	@ApiImplicitParam(name="sex", value="性別"),
    	@ApiImplicitParam(name="iconPath", value="アイコンパス"),
    	@ApiImplicitParam(name="registerType", value="登録種類", dataType="int",required = true)
    })
    @PostMapping("userinfo/register")
    public ResponseBean loadAnalyseByStudyScheduleIdForApp(
    		String mailAddress, String password, String nickname,
    		Integer sex, String iconPath, @RequestParam(required = true) int registerType){

    	UserInfo userInfo = new UserInfo();
    	//ユーザーグループID(デフォルト：普通ユーザー)
        userInfo.setUserGroupId(UserGroupIdEnum.COMMON_USER.getValue());
        //携帯種類表示フラグ(デフォルト：表示)
        userInfo.setPhoneCategoryShowFlag(PhoneCategoryShowFlagEnum.SHOW.getValue());
    	
    	//メール登録の場合、チェックを行います
    	if(registerType == RegisterTypeEnum.MAIL.getValue()){
    		//判断邮件、密码是否为空或空字符串
    		if(StringUtil.isNullOrBlank(mailAddress)
    				|| StringUtil.isNullOrBlank(password)){
    			return new ResponseBean(ConstInfo.ERROR, "「メールアドレス」、「パスワード」:両方入力してください", null, null);
    		}
            //判断是否为邮件格式
    		if(!StringUtil.isEmailAddress(mailAddress)){
    			return new ResponseBean(ConstInfo.ERROR, "メールアドレス形式は正しくありません", null, null);
    		}
    		//判断密码长度在6-16之间
            if(!StringUtil.lengthCheck(password, 6, 16)){
            	return new ResponseBean(ConstInfo.ERROR, "パスワードは6-16桁を入力してください", null, null);
    		}
            //ユーザー新規登録処理(メール)を行います　START
            userInfo.setMailAddress(mailAddress);
            //パスワード暗号化処理 START
            //设置盐
            String salt = IdUtil.simpleUUID().toUpperCase();
            userInfo.setSalt(salt);
            //设置密码
            userInfo.setPassword(new Md5Hash(password,salt,2).toString());
            //パスワード暗号化処理 END
            boolean result = userInfoService.save(userInfo);
            if(result){
            	//トークン取得 TODO
            	return new ResponseBean(ConstInfo.OK, "ユーザー登録成功しました", userInfo, null);
            }else{
            	return new ResponseBean(ConstInfo.ERROR, "ユーザー登録失敗しました", null, null);
            }
            //ユーザー新規登録処理(メール)を行います END
    	}else{//Wechat登録の場合
    		//ユーザー新規登録処理(Wechat)を行います　START
    		//性別設定
            userInfo.setSex(sex);
            //ニックネーム設定
            userInfo.setNickname(nickname);
            //アイコンパス設定   1.Wechat写真をサーバーへ保存する　2.新しいパス発行
            String newSavePath = AppFileUtils.downloadFileFromUrl(iconPath);
            userInfo.setIconPath(newSavePath);
            boolean result = userInfoService.save(userInfo);
            if(result){
            	//トークン取得 TODO
            	return new ResponseBean(ConstInfo.OK, "ユーザー登録成功しました", userInfo, null);
            }else{
            	return new ResponseBean(ConstInfo.ERROR, "Wechat連携失敗しました", null, null);
            }
            //ユーザー新規登録処理(Wechat)を行います END
    	}
    }
}

