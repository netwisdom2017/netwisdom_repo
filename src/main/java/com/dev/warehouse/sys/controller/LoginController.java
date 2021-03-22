package com.dev.warehouse.sys.controller;

import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.LineCaptcha;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.dev.warehouse.bus.entity.StudentInfo;
import com.dev.warehouse.bus.service.IStudentInfoService;
import com.dev.warehouse.response.ResponseBean;
import com.dev.warehouse.sys.entity.User;
import com.dev.warehouse.sys.service.IUserService;
import com.dev.warehouse.sys.vo.UserVo;
import com.dev.warehouse.utils.JWTUtil;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@RestController
@RequestMapping("login")
public class LoginController {

    @Autowired
    private IUserService userService;
    
    @Autowired
    private IStudentInfoService studentInfoService;
    

    @RequestMapping("login")
    public ResponseBean login(@RequestBody UserVo userVo){

        //Subject subject = SecurityUtils.getSubject();
        //AuthenticationToken token = new JWTToken(userVo.getLoginname());
        try {
        	 QueryWrapper<User> queryWrapper = new QueryWrapper<User>();
             queryWrapper.eq("loginname",userVo.getLoginname());
             //通过用户名从数据库中查询出该用户
             User user = userService.getOne(queryWrapper);
             if (null != user){
            	//拿到明文密码
             	String password = userVo.getPwd();
             	//从数据库拿到盐
                String salt = user.getSalt();
                //拿到预期密码
                String secret = new Md5Hash(password,salt,2).toString();
             	//如果用户登录信息正确，拿到权限
                if(user.getPwd().equals(secret)){
                	 String token = JWTUtil.sign(
             				user.getLoginname(),user.getPwd());
                	 //取得学員ID
                	 QueryWrapper<StudentInfo> studentInfoWrapper = new QueryWrapper<StudentInfo>();
                	 studentInfoWrapper.eq("username", user.getLoginname());
                     //通过用户名从数据库中查询出该用户
                	 StudentInfo studentInfo = studentInfoService.getOne(studentInfoWrapper);
                	 return new ResponseBean(200, "登录成功！", token, studentInfo);
                }else{
                	 return new ResponseBean(500, "密码不正确！", null);
                }
             }else{
                 return new ResponseBean(500, "用户名不存在！", null);
             }
        } catch (AuthenticationException e) {
        	  return new ResponseBean(500, "登录失败！", null);
        }
    }

    /**
     * 得到登陆验证码
     * @param response
     * @param session
     * @throws IOException
     */
    @RequestMapping("getCode")
    public void getCode(HttpServletResponse response, HttpSession session) throws IOException{
        //定义图形验证码的长和宽
        LineCaptcha lineCaptcha = CaptchaUtil.createLineCaptcha(116, 36,4,5);
        session.setAttribute("code",lineCaptcha.getCode());
        try {
            ServletOutputStream outputStream = response.getOutputStream();
            lineCaptcha.write(outputStream);
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
