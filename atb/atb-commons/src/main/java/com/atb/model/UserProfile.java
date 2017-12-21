/**
 * Copyright (c) 2017 ATB
 * All rights reserved.
 * 
 * Version: V01
 * Created on: June 10, 2016
 * Created by: Kanimozhi Mahendran
 * Created Reference: ATB
 *  
 */
package com.atb.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import com.atb.common.DomainConstants;
import com.atb.common.SequenceConstants;

@Entity
@Table(name = "USER_PROFILES")
public class UserProfile
    implements HibernateMappedEntity, Cloneable
    
{

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "USER_PROFILE_ID", nullable = false)
    @GenericGenerator(name = DomainConstants.SEQ_NAME_USER_PROFILE, strategy = DomainConstants.SEQUENCE_STRATERGY, parameters = @Parameter(name = DomainConstants.PARAMATER_NAME, value = SequenceConstants.USER_PROFILE_ID_SEQ))
    @GeneratedValue(generator = DomainConstants.SEQ_NAME_USER_PROFILE)
    private Long              id;

    @ManyToOne
    @JoinColumn(name = "USER_ID", nullable = false)
    private User              user;

  

    @Column(name = "CREATED_BY")
    private String            createdBy;

    @Column(name = "CREATED_DATE")
    private Date              createdDate;

    /**
     * @return the id
     */
    public Long getId()
    {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id)
    {
        this.id = id;
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
     * @return the createdBy
     */
    public String getCreatedBy()
    {
        return createdBy;
    }

    /**
     * @param createdBy the createdBy to set
     */
    public void setCreatedBy(String createdBy)
    {
        this.createdBy = createdBy;
    }

    /**
     * @return the createdDate
     */
    public Date getCreatedDate()
    {
        return createdDate;
    }

    /**
     * @param createdDate the createdDate to set
     */
    public void setCreatedDate(Date createdDate)
    {
        this.createdDate = createdDate;
    }

}
