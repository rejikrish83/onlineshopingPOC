package com.atb.common;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.atb.model.User;

public class SessionUtils
{

    public static User getUser(HttpServletRequest request)
    {
        return getSessionData(request).getUser();
    }

   

    public static Long getUserId(HttpServletRequest request)
    {
        HttpSession httpSession = request.getSession();
        if (httpSession == null)
        {
            return null;
        }
        SessionData sd = SessionUtils.getSessionData(request);
        if (sd == null)
        {
            return null;
        }
        return sd.getUserId();
    }

    public static String getUserName(HttpServletRequest request)
    {
        HttpSession httpSession = request.getSession();
        if (httpSession == null)
        {
            return null;
        }
        SessionData sd = SessionUtils.getSessionData(request);
        if (sd == null)
        {
            return null;
        }
        return sd.getUserName();
    }

    public static SessionData getSessionData(HttpServletRequest request)
    {
        return (SessionData) request.getSession().getAttribute("sessionData");
    }

    public static String getUserFullName(HttpServletRequest request)
    {
        HttpSession httpSession = request.getSession();
        if (httpSession == null)
        {
            return null;
        }
        SessionData sd = SessionUtils.getSessionData(request);
        if (sd == null)
        {
            return null;
        }
        return sd.getUser().getFirstName() + " " + sd.getUser().getLastName();
    }

}
