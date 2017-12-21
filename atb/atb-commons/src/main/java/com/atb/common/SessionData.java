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
package com.atb.common;

import java.io.Serializable;

import com.atb.model.User;

public class SessionData
    implements Serializable
{

    /**
     * 
     */
    private static final long serialVersionUID = 4511878969785099194L;

  

    private String            userName;

    private User              user;

    private Long              userId;

    /**
     * @return the userId
     */
    public String getUserName()
    {
        return userName;
    }

    /**
     * @param userId the userId to set
     */
    public void setUserName(String userName)
    {
        this.userName = userName;
    }

    /**
     * @return the user
     */
    public User getUser()
    {
        return user;
    }

    /**
     * @param user the user to set
     */
    public void setUser(User user)
    {
        this.user = user;
    }

    /**
     * @return the userId
     */
    public Long getUserId()
    {
        return userId;
    }

    /**
     * @param userId the userId to set
     */
    public void setUserId(Long userId)
    {
        this.userId = userId;
    }

}
