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
package com.atb.web.dao;

import java.util.List;

import com.atb.common.GenericSearchCriteria;
import com.atb.model.Menu;
import com.atb.model.User;
import com.atb.model.UserProfile;
import com.atb.model.UserRole;

public interface UserManagementDao
{

    /**
     * This method is used get all the active users from the USERS table.
     * 
     * @return List<User>
     */
    public List<User> getAllActiveUsers();

    /**
     * This method is used to save the new user
     * 
     * @param user
     */
    public void createUser(User user);

    /**
     * This method is used to update the existing user
     * 
     * @param user
     */
    public void updateUser(User user);

    /**
     * This method is used to delete the user
     * 
     * @param user
     */
    public void deleteUser(User user);

    /**
     * This method is used to find the user by the user ID
     * 
     * @param userId
     * @return User
     */
    public User findUserById(Long userId);

    /**
     * This method is used get all the active profiles from the PROFILES table.
     * 
     * @return List<Profile>
     */
    

    /**
     * This method will check for the user name in the users table and returns true if user name
     * already exists.
     * 
     * @param userName
     * @return boolean
     */
    public boolean checkforExistingUserName(String userName);

    /**
     * This method will check for the user name in the profiles table and returns true if profile
     * name already exists.
     * 
     * @param profileName
     * @return boolean
     */
    public boolean checkforExistingProfileName(String profileName);

    /**
     * This method is used get all the users from the USERS table based on the search criteria.
     * 
     * @param genericSearchCriteria
     * @return List<User>
     */
    public List<User> findAllUsers(GenericSearchCriteria genericSearchCriteria);

    /**
     * This method is used get all the profiles from the PROFILES table based on the given criteria.
     * 
     * @param genericSearchCriteria.
     * @return List<Profile>
     */
    

    public List<User> getAllActiveUsersByName(String name);

    public void createUserProfile(UserProfile userProfile);

    public void updateUserProfile(UserProfile userProfile);

    public void deleteUserProfile(UserProfile userProfile);

   

    public User checkforExistingEmail(String email, String userName);

    public User validateUser(String userName, String password);
   

    public List<User> getAllActiveUsersByRoleId(Long roleId);
    
    public List<User> getAllActiveFCAndApprover();

    public List<Menu> getAllMenus();

   
    
    public void saveUserRole(UserRole userRole);
    
    public void removeUserRole(UserRole userRole);

    public boolean userRoleNotExistsAlready(Long roleId, Long userId);

    public List<User> getAllActiveUsersByRoleIdList(List<Long> roleIds);
    
    

    public void deleteRoleByUserId(User user);

    public void updateUserRole(UserRole userRole);
    
    public List<UserRole> isLoggedInUserHaveRole(Long roleId, Long userId);
    
   /* *//**
     * @author harish.u.kumar
     * 
     *         Validate Work Order whether the calibrationSpecialist isAvalible Or Not.
     * 
     * @param GenericSearchCriteria
     * @return List of Objects
     *//*
    public int validateCalibrationSpecialist(String userName,Long userId);*/

	public List<User> getAllActiveOwnersByRoleIdList(List<Long> roleIds);

}
