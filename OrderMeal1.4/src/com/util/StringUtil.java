package com.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtil {
	public static boolean isEmpty(String str){
		if("".equals(str)||str==null){
			return true;
		}else{
			return false;
		}
	}
	
	public static boolean isNotEmpty(String str){
		if(!"".equals(str)&&str!=null){
			return true;
		}else{
			return false;
		}
	}

    public static boolean checkEmail(String email){  
     boolean flag = false;  
     try{  
      String check = "^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";  
      Pattern regex = Pattern.compile(check);  
      Matcher matcher = regex.matcher(email);  
      flag = matcher.matches();  
     }catch(Exception e){  
      flag = false;  
     }  
       
     return flag;  
    }  
    /**  
     * 
     * @param mobiles  
     * @return  [0-9]{5,9}  
     */  
    public static boolean isMobileNO(String mobiles){  
     boolean flag = false;  
     try{  
      Pattern p = Pattern.compile("^((13[0-9])|(15[^4,\\D])|(18[0,5-9]))\\d{8}$");  
      Matcher m = p.matcher(mobiles);  
      flag = m.matches();  
     }catch(Exception e){  
      flag = false;  
     }  
     return flag;  
    }  
      
    public static boolean isNum(String str){	
    	return str.matches("^[-+]?(([0-9]+)([.]([0-9]+))?|([.]([0-9]+))?)$");	
    	}


    public static void gui_lv(String[] sss)
    {
    	
    }
}  
