package com.dev.warehouse.bus.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * 项目名称：guigui
 * 类名称：UserInfo 
 * 类描述：ユーザー情報
 * 2021-03-20 修改备注：
 * 
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("user_info")
@ToString
@ApiModel
public class UserInfo implements Serializable {
	
	private static final long serialVersionUID=1L;
	/*ユーザーID
	 * 			
	 */
	@TableId(value = "user_id", type = IdType.AUTO)
	@ApiModelProperty(value="ユーザーID")
	private Integer userId;
	/*パスワード
	 * 			
	 */
	@ApiModelProperty(value="パスワード")
	private String password;
	/*メールアドレス
	 * 			
	 */  
	@ApiModelProperty(value="メールアドレス")
	private String mailAddress;
	/*ニックネーム	
	 * 			
	 */  
	@ApiModelProperty(value="ニックネーム")
	private String nickname;
	/*性別
	 * 			
	 */  
	@ApiModelProperty(value="性別")
	private Integer sex;
	/*アイコンパス
	 * 			
	 */  
	@ApiModelProperty(value="アイコンパス")
	private String iconPath;
	/*コメント
	 * 			
	 */  
	@ApiModelProperty(value="コメント")
	private String comment;
	/*携帯種類表示フラグ
	 * 			
	 */  
	@ApiModelProperty(value="携帯種類表示フラグ")
	private int phoneCategoryShowFlag;
	/*ユーザーグループID
	 * 			
	 */  
	@ApiModelProperty(value="ユーザーグループID")
	private int userGroupId;
	/*ソルト
	 * 			
	 */  
	@ApiModelProperty(value="ソルト")
	private String salt;

}
