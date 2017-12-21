/**
 * 
 */
package com.atb.filters;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.atb.common.SessionData;
import com.atb.web.controllers.LoginHandler;

/**
 * @author rejikrishnan.rr
 *
 */

public class AuthenticationFliter/* implements Filter*/{
	/*private static final Log           log = LogFactory.getLog(AuthenticationFliter.class);
	
	public void init(FilterConfig arg0) throws ServletException {
		
	}
	
	public void doFilter(ServletRequest req, ServletResponse resp,  
	        FilterChain chain) throws IOException, ServletException {
		
		log.error("Do filter method ......");	
		HttpSession session = ((HttpServletRequest)req).getSession();
		HttpServletRequest httpRequest = ((HttpServletRequest)req);
		HttpServletResponse httpResponse = ((HttpServletResponse)resp);
		String requestSubmitted = "";
		if(null!= httpRequest.getRequestURL()){
			requestSubmitted = AuthenticationUtil.getSubstringUrl(httpRequest.getRequestURL().toString());
			log.info("requestSubmitted : "+requestSubmitted);
		}
		if (null!= session && null!= (SessionData)session.getAttribute("sessionData")){
            
			log.info("SessionData"+(SessionData)session.getAttribute("sessionData"));
           // log.info("Session Data **************************88 ");
            chain.doFilter(req, resp);            
        }else {
        	log.info("No sessionData found, setting up new session");
        	String uri = (String)((HttpServletRequest)req).getRequestURI();
        	
        	if(null!=uri && (uri.contains("/atb/loginProcess.do") ||  uri.contains("/atb/layouts/") || uri.contains("/atb/reusable-components/") || uri.contains("/atb/resources/") || uri.contains("/atb/passwordForgot.do") || uri.contains("/atb/forgotPassword.do") || uri.contains("/atb/backToHome.do"))&& null != httpRequest.getMethod() && "POST".equalsIgnoreCase(httpRequest.getMethod())){
        		log.info("loginProcess"+uri+"login.do" + "Servlet context path : "+((HttpServletRequest)req).getContextPath());
        		chain.doFilter(req, resp);   
        	}else{
        		log.info("forwarding to login.do"+uri+"login.do" + "Servlet context path : "+((HttpServletRequest)req).getContextPath());
            	RequestDispatcher requestDispach = ((HttpServletRequest)req).getRequestDispatcher("login.do");
            	requestDispach.forward(req, resp);
            	RequestDispatcher requestDispach = ((HttpServletRequest)req).getRequestDispatcher("login.do");
            	requestDispach.include(req, resp);
            	
            	if(null!= uri && uri.contains(".html")){
            		RequestDispatcher requestDispach = ((HttpServletRequest)req).getRequestDispatcher("loginPage.jsp");
            		log.info("************ : "+httpRequest.getRequestURL().toString() + "requestSubmitted : "+requestSubmitted);
                	//requestDispach.include(httpRequest, httpResponse);
            		
            		httpResponse.sendRedirect(requestSubmitted+"atb/login.do");
        		}else{
        			log.info("--------------- : "+httpRequest.getRequestURL().toString());
        			RequestDispatcher requestDispach = ((HttpServletRequest)req).getRequestDispatcher("login.do");
                	requestDispach.forward(httpRequest, httpResponse);
        		}
        		//httpResponse.sendRedirect("http://localhost:8081/atb/login.do");
        		
        	}
        	
        }
		
	}
	public void destroy() {
		
	}*/
	
	
}
