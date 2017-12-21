/**
 * Copyright (c) 2017 ATB
 * All rights reserved.
 * 
 * Version: V01
 * Created on: December 16, 2016
 * Created by: Kanimozhi Mahendran
 * Created Reference: GTMT Sprint 5
 *  
 */
package com.atb.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import com.atb.common.DomainConstants;
import com.atb.common.SequenceConstants;

@Entity
@Table(name = "USER_ROLES")
public class UserRole
    implements HibernateMappedEntity
{

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "USER_ROLE_ID", nullable = false)
    @GenericGenerator(name = DomainConstants.SEQ_NAME_USER_ROLE, strategy = DomainConstants.SEQUENCE_STRATERGY, parameters = @Parameter(name = DomainConstants.PARAMATER_NAME, value = SequenceConstants.USER_ROLE_ID_SEQ))
    @GeneratedValue(generator = DomainConstants.SEQ_NAME_USER_ROLE)
    private Long              userRoleId;

  

    @Column(name = "USER_ID")
    private Long              userId;

    @Column(name = "STATUS")
    private String            status;

    /**
     * @return the userRoleId
     */
    public Long getUserRoleId()
    {
        return userRoleId;
    }

    /**
     * @param userRoleId the userRoleId to set
     */
    public void setUserRoleId(Long userRoleId)
    {
        this.userRoleId = userRoleId;
    }


    /**
     * @return the status
     */
    public String getStatus()
    {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(String status)
    {
        this.status = status;
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
