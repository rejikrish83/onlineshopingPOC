/**
 * Copyright (c) 2017 ATB
 * All rights reserved.
 * 
 * Version: V01
 * Created on: June 02, 2016
 * Created by: Maria Prakash
 * Created Reference: ATB
 *  
 */
package com.atb.web.controllers;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.atb.common.SessionData;
import com.atb.model.User;
import com.atb.web.service.UserManagementService;

@Controller
public class LoginHandler
{

    @Autowired
    private UserManagementService      userManagementService;

    

    private static final Log           log = LogFactory.getLog(LoginHandler.class);

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model)
    {
        return "login";
    }

    @RequestMapping(value = "/passwordChange", method = RequestMethod.GET)
    public String changePassword(Model model, HttpServletRequest request)
    {
        return "passwordChange";
    }

    @RequestMapping(value = "/passwordForgot", method = RequestMethod.POST)
    public String passwordForgot(Model model)
    {
        return "passwordForgot";
    }

    @RequestMapping(value = "/backToHome", method = RequestMethod.POST)
    public String backToHome(Model model)
    {
        return "redirect:login.do";
    }

    @RequestMapping(value = "/loginProcess", method = RequestMethod.POST)
    public String loginProcess(HttpServletRequest request, @ModelAttribute("user") User user, BindingResult result,
        ModelMap map)
    {
        boolean loginSucess = false;
        try
        {
            log.info(" **** Do all the SOS and LDAP operations *** ");

            User validUser =
               null;
            if (null != validUser)
            {
                try
                {
                    log.info(" **** Testing Login Action in Controller *** ");

                    HttpSession session = request.getSession();
                    SessionData sessionData = (SessionData) request.getSession().getAttribute("sessionData");

                    if (sessionData == null)
                    {
                        log.info("No sessionData found, setting up new session");
                        sessionData = setupGTMTSession(session, validUser);
                        log.info("Session Data **************************88 ");
                        sessionData = (SessionData) request.getSession().getAttribute("sessionData");
                        log.info(sessionData.getUserName());
                    }
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }

               /* if (DomainConstants.NO.equalsIgnoreCase(validUser.getPasswordChanged()))
                {
                    return "redirect:passwordChange.do";
                }
                else
                {
                    loginSucess = true;
                }*/
            }

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        if (loginSucess)
        {
            return "redirect:loginSuccess.do";
        }
        else
        {
            String errormsg = "Invalid Username / Password";
            map.put("errMsg", errormsg);
            return "redirect:login.do";
        }

    }

    @RequestMapping(value = "/loginSuccess", method = RequestMethod.GET)
    public String loginSuccess(HttpServletRequest request)
    {
    	/*request.getSession().setMaxInactiveInterval(ATBRoleConstants.SESSION_TIMEOUT_TIME.intValue());*/
       // getMenuListForLoggedInUser(request);
        return "landingHomePage";
    }

   

  

    private SessionData setupGTMTSession(HttpSession session, User loggedInUser)
    {
        SessionData sessionData = new SessionData();
        sessionData.setUserName(loggedInUser.getUserName());
        sessionData.setUser(loggedInUser);
        sessionData.setUserId(loggedInUser.getId());
       /* session.setAttribute(DomainConstants.SESSION_DATA, sessionData);*/

        return sessionData;
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(HttpServletRequest request)
    {
        try
        {
            User currentUser = ((SessionData) request.getSession().getAttribute("sessionData")).getUser();
            currentUser.setLastLoginDate(new Date());
            userManagementService.updateUser(currentUser, false);

            log.info(" **** Testing Logout Action in Controller *** ");
            HttpSession session = request.getSession(false);

            // If session found then tries to kill the previous session
            if (session != null)
            {
                String currSessionId = session.getId();
                log.info("trying to invalidate session id: " + currSessionId);
                session.invalidate();
                log.info("Session with id: " + currSessionId + " was Invalidated");
            }
            else
            {
                log.info(" Session not FOUND");
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        return "redirect:login.do";
    }

    

    @RequestMapping(value = "/changePassword", method = RequestMethod.POST)
    public String changePassword(HttpServletRequest request, @ModelAttribute("user") User user, BindingResult result,
        HttpSession session)
    {

        Long userId = ((SessionData) request.getSession().getAttribute("sessionData")).getUserId();
        try
        {

            User validUser = userManagementService.findUserById(userId);
            if (null != validUser)
            {
                validUser.setPassword(user.getPassword());
                //validUser.setPasswordChanged(DomainConstants.YES);
                userManagementService.updateUser(validUser, true);
                setupGTMTSession(session, validUser);
            }

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        return "redirect:login.do";

    }

    @RequestMapping(value = "/fssLoginSuccess", method = RequestMethod.GET)
    public String fssLoginSuccess(HttpServletRequest request)
    {
        return "fssApprovePage";
    }

}
