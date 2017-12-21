/**
 * 
 */
package com.atb.filters;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author rejikrishnan.rr
 *
 */
public class AuthenticationUtil {
	
	public static String getSubstringUrl(String url){
		 String returnUrl = "";
		 Pattern pattern = Pattern.compile("atb");
		 Matcher matcher = pattern.matcher( url);
		 if (matcher.find())
		 {
			 returnUrl = url.substring(0, matcher.start());
		 }			
		return returnUrl;
				        
	    }

}
