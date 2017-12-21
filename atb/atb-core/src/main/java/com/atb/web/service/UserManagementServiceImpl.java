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
package com.atb.web.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.atb.common.DomainConstants;
import com.atb.common.GenericSearchCriteria;
import com.atb.common.Util;
import com.atb.model.User;
import com.atb.model.UserProfile;
import com.atb.model.UserRole;
import com.atb.web.dao.UserManagementDao;

@Service("userManagementService")
@Transactional
public class UserManagementServiceImpl
    implements UserManagementService
{

    @Autowired
    private UserManagementDao userManagementDao;

    /**
     * @param changeNoteDao the changeNoteDao to set
     */
    public void setUserManagementDao(UserManagementDao userManagementDao)
    {
        this.userManagementDao = userManagementDao;
    }

    /**
     * This method is used get all the active users from the USERS table.
     * 
     * @return
     */
    @Override
    public List<User> getAllActiveUsers()
    {
        return userManagementDao.getAllActiveUsers();
    }

    /**
     * This method is used to save the new user
     * 
     * @param user
     * @throws Exception
     */
    @Override
    public void createUser(User user)
        throws Exception
    {
        user.setUserStatus(DomainConstants.ACTIVE);
        user.setCreatedDate(new Date());
        user.setPassword(Util.encryptPassword(user.getPassword()));
        userManagementDao.createUser(user);
    }

    /**
     * This method is used to update the existing user
     * 
     * @param user
     * @throws Exception
     */
    @Override
    public void updateUser(User user, boolean updatePwd)
        throws Exception
    {
        user.setModifiedDate(new Date());
        if (updatePwd)
            user.setPassword(Util.encryptPassword(user.getPassword()));
        userManagementDao.updateUser(user);
    }

    /**
     * This method is used to delete the user
     * 
     * @param user
     */

    @Override
    public void deleteUser(User user)
    {
        user.setUserStatus(DomainConstants.IN_ACTIVE);
        user.setModifiedDate(new Date());
        userManagementDao.deleteUser(user);
    }

    /**
     * This method is used to find the user by the user ID
     * 
     * @param userId
     * @return
     */
    @Override
    public User findUserById(Long userId)
    {
        return userManagementDao.findUserById(userId);
    }

    

    /**
     * This method will check for the user name in the users table and returns true if user name
     * already exists.
     * 
     * @param userName
     * @return boolean
     */
    public boolean checkforExistingUserName(String userName)
    {
        return userManagementDao.checkforExistingUserName(userName);
    }

    /**
     * This method will check for the user name in the profiles table and returns true if profile
     * name already exists.
     * 
     * @param profileName
     * @return boolean
     */
    public boolean checkforExistingProfileName(String profileName)
    {
        return userManagementDao.checkforExistingProfileName(profileName);
    }

    /**
     * This method is used get all the users from the USERS table based on the given search
     * criteria.
     * 
     * @param genericSearchCriteria
     * @return List<User>
     */
    @Override
    public List<User> findAllUsers(GenericSearchCriteria genericSearchCriteria)
    {
        return userManagementDao.findAllUsers(genericSearchCriteria);
    }

    
    public List<User> getAllActiveUsersByName(String name)
    {
        return userManagementDao.getAllActiveUsersByName(name);
    }

    public void createUserProfile(UserProfile userProfile)
    {
        userManagementDao.createUserProfile(userProfile);
    }

    public void updateUserProfile(UserProfile userProfile)
    {
        userManagementDao.updateUserProfile(userProfile);
    }

    public void deleteUserProfile(UserProfile userProfile)
    {
        userManagementDao.deleteUserProfile(userProfile);
    }

   

    @Override
    public void saveUserRole(UserRole userRole)
    {
        userManagementDao.saveUserRole(userRole);
    }

    @Override
    public void removeUserRole(UserRole userRole)
    {
        userManagementDao.removeUserRole(userRole);

    }

    @Override
    public boolean userRoleNotExistsAlready(Long userId, Long roleId)
    {
        return userManagementDao.userRoleNotExistsAlready(roleId, userId);
    }

    public List<User> getAllActiveUsersByRoleIdList(List<Long> roleIds)
    {
        return userManagementDao.getAllActiveUsersByRoleIdList(roleIds);
    }

    

    @Override
    public void deleteRoleByUserId(User user)
    {
        userManagementDao.deleteRoleByUserId(user);
    }

    @Override
    public void updateUserRole(UserRole userRole)
    {
        userManagementDao.updateUserRole(userRole);
    }

    @Override
    public List<UserRole> isLoggedInUserHaveRole(Long roleId, Long userId)
    {
        return userManagementDao.isLoggedInUserHaveRole(roleId, userId);
    }

	
	
	@Override
	public List<User> getAllActiveOwnersByRoleIdList(List<Long> roleIds) {
		// TODO Auto-generated method stub
		 return userManagementDao.getAllActiveOwnersByRoleIdList(roleIds);
	}

	@Override
	public int getUserCount(GenericSearchCriteria genericSearchCriteria) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getProfileCount(GenericSearchCriteria genericSearchCriteria) {
		// TODO Auto-generated method stub
		return 0;
	}

}
