/**
 * Copyright (c) 2017 ATB
 * All rights reserved.
 * 
 * Version: V01
 * Created on: June 02, 2016
 * Created by: Kanimozhi Mahendran
 * Created Reference: ATB
 *  
 */
package com.atb.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import com.atb.common.DomainConstants;
import com.atb.common.SequenceConstants;

@Entity
@Table(name = "USERS")
public class User
    implements HibernateMappedEntity
{

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "USER_ID", nullable = false)
    @GenericGenerator(name = DomainConstants.SEQ_NAME_USER, strategy = DomainConstants.SEQUENCE_STRATERGY, parameters = @Parameter(name = DomainConstants.PARAMATER_NAME, value = SequenceConstants.USER_ID_SEQ))
    @GeneratedValue(generator = DomainConstants.SEQ_NAME_USER)
    private Long              id;

    @Column(name = "USER_NAME")
    private String            userName;

    @Column(name = "PASSWORD")
    private String            password;

    @Column(name = "FIRST_NAME")
    private String            firstName;

    @Column(name = "LAST_NAME")
    private String            lastName;

    @Column(name = "EMAIL_ADDRESS")
    private String            email;

    @Column(name = "CONTACT_NUMBER")
    private String            contactNumber;

    @Column(name = "COST_CENTER")
    private String            costCenter;
   

    @Column(name = "USER_TYPE")
    private String            userType;

    @Column(name = "USER_MODE")
    private String            userMode;

    @Column(name = "USER_STATUS")
    private String            userStatus;

    @Column(name = "CREATED_BY")
    private String            createdBy;

    @Column(name = "CREATED_DATE")
    private Date              createdDate;

    @Column(name = "MODIFIED_BY")
    private String            modifiedBy;

    @Column(name = "MODIFIED_DATE")
    private Date              modifiedDate;

    @Column(name = "PASSWORD_CHANGED")
    private String            passwordChanged;

    @Column(name = "LAST_LOGIN_DATE")
    private Date              lastLoginDate;
    
	@Column(name = "ROLE_NAME")
    private String  roleName;

	@Transient
	private String firstandLastName;

    /**
	 * @return the roleName
	 */
	public String getRoleName() {
		return roleName;
	}

	/**
	 * @param roleName the roleName to set
	 */
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	@Transient
    private boolean           selected         = false;

    @Transient
    private String            oldPassword;

    

    /**
     * @return the selected
     */
    public boolean isSelected()
    {
        return selected;
    }

    /**
     * @param selected the selected to set
     */
    public void setSelected(boolean selected)
    {
        this.selected = selected;
    }

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
     * @return the userName
     */
    public String getUserName()
    {
        return userName;
    }

    /**
     * @param userName the userName to set
     */
    public void setUserName(String userName)
    {
        this.userName = userName;
    }

    /**
     * @return the userName
     */
    public String getPassword()
    {
        return password;
    }

    /**
     * @param userName the userName to set
     */
    public void setPassword(String password)
    {
        this.password = password;
    }

    /**
     * @return the firstName
     */
    public String getFirstName()
    {
        return firstName;
    }

    /**
     * @param firstName the firstName to set
     */
    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    /**
     * @return the lastName
     */
    public String getLastName()
    {
        return lastName;
    }

    /**
     * @param lastName the lastName to set
     */
    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    /**
     * @return the email
     */
    public String getEmail()
    {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email)
    {
        this.email = email;
    }

    /**
     * @return the contactNumber
     */
    public String getContactNumber()
    {
        return contactNumber;
    }

    /**
     * @param contactNumber the contactNumber to set
     */
    public void setContactNumber(String contactNumber)
    {
        this.contactNumber = contactNumber;
    }

    /**
     * @return the userType
     */
    public String getUserType()
    {
        return userType;
    }

    /**
     * @param userType the userType to set
     */
    public void setUserType(String userType)
    {
        this.userType = userType;
    }

    /**
     * @return the userMode
     */
    public String getUserMode()
    {
        return userMode;
    }

    /**
     * @param userMode the userMode to set
     */
    public void setUserMode(String userMode)
    {
        this.userMode = userMode;
    }

    /**
     * @return the userStatus
     */
    public String getUserStatus()
    {
        return userStatus;
    }

    /**
     * @param userStatus the userStatus to set
     */
    public void setUserStatus(String userStatus)
    {
        this.userStatus = userStatus;
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

    /**
     * @return the modifiedBy
     */
    public String getModifiedBy()
    {
        return modifiedBy;
    }

    /**
     * @param modifiedBy the modifiedBy to set
     */
    public void setModifiedBy(String modifiedBy)
    {
        this.modifiedBy = modifiedBy;
    }

    /**
     * @return the modifiedDate
     */
    public Date getModifiedDate()
    {
        return modifiedDate;
    }

    /**
     * @param modifiedDate the modifiedDate to set
     */
    public void setModifiedDate(Date modifiedDate)
    {
        this.modifiedDate = modifiedDate;
    }

    

    /**
     * @return the passwordChanged
     */
    public String getPasswordChanged()
    {
        return passwordChanged;
    }

    /**
     * @param passwordChanged the passwordChanged to set
     */
    public void setPasswordChanged(String passwordChanged)
    {
        this.passwordChanged = passwordChanged;
    }

    /**
     * @return the lastLoginDate
     */
    public Date getLastLoginDate()
    {
        return lastLoginDate;
    }

    /**
     * @param lastLoginDate the lastLoginDate to set
     */
    public void setLastLoginDate(Date lastLoginDate)
    {
        this.lastLoginDate = lastLoginDate;
    }

    /**
     * @return the costCenter
     */
    public String getCostCenter()
    {
        return costCenter;
    }

    /**
     * @param costCenter the costCenter to set
     */
    public void setCostCenter(String costCenter)
    {
        this.costCenter = costCenter;
    }

    /**
     * @return the oldPassword
     */
    public String getOldPassword()
    {
        return oldPassword;
    }

    /**
     * @param oldPassword the oldPassword to set
     */
    public void setOldPassword(String oldPassword)
    {
        this.oldPassword = oldPassword;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode()
    {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object obj)
    {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (!(obj instanceof User))
            return false;
        User other = (User) obj;
        if (id == null)
        {
            if (other.id != null)
                return false;
        }
        else if (!id.equals(other.id))
            return false;
        return true;
    }

   

	public String getFirstandLastName() {
		firstandLastName=this.firstName+" "+this.lastName;
		return firstandLastName;
	}

	public void setFirstandLastName(String firstandLastName) {
		this.firstandLastName = this.firstName+" "+this.lastName;
	}

}
