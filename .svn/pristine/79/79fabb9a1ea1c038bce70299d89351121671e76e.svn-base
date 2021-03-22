package com.dev.warehouse.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtil {
	
    /** 
     * @param 需要判断的字符串
     * @return 判断结果
     */
    public static boolean isNullOrBlank(String value) {
        if(value == null){
        	return true;
        }
        if("".equals(value)){
        	return true;
        }
        return false;
    }
    
    /**
     * @param 需要判断的字符串
     * @return 判断结果
     */
    public static boolean isNotNullAndBlank(String value) {
        if(value == null){
        	return false;
        }
        if("".equals(value)){
        	return false;
        }
        return true;
    }
    
    /**
     * @param 需要是否是邮件
     * @return 判断结果
     */
    public static boolean isEmailAddress(String emailAddress) {
		if (emailAddress == null)
			return false;
		String regEx1 = "^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
		Pattern p;
		Matcher m;
		p = Pattern.compile(regEx1);
		m = p.matcher(emailAddress);
		if (m.matches())
			return true;
		else
			return false;
	}
    
    /**
     * @param 需要检测的字符串
     * @param 最小长度
     * @param 最大长度
     * @return 判断结果
     */
    public static boolean lengthCheck(String value, 
    		int minLength, int maxLength) {
	   if(value == null){
		   return false;
       }
       if("".equals(value)){
    	   return false;
       }
       if(value.length() >= minLength && value.length() <= maxLength){
    	   return true;
       }else{
    	   return false;
       }
	}
}
