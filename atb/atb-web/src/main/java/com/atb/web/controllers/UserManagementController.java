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
package com.atb.web.controllers;

import java.util.List;

import javax.management.relation.Role;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.atb.common.GenericSearchCriteria;
import com.atb.common.SessionData;
import com.atb.common.SessionUtils;
import com.atb.common.Util;
import com.atb.dto.SessionConfigurationDetails;
import com.atb.model.User;
import com.atb.web.service.UserManagementService;

@Controller
@RestController
public class UserManagementController
{

    private static final Log           log = LogFactory.getLog(UserManagementController.class);

    @Autowired
    private UserManagementService      userManagementService;

  

    /*@RequestMapping(value = "/getUserList/", method = RequestMethod.POST)
    public ResponseEntity<List<User>> findAllUsers(@RequestBody GenericSearchCriteria genericSearchCriteria) throws Exception
    {
        List<User> users = userManagementService.findAllUsers(genericSearchCriteria);
        List<User> updatedUser = new ArrayList<User>();
        if (Util.isNullOrEmpty(users))
        {
            return new ResponseEntity<List<User>>(HttpStatus.NO_CONTENT);
        }
       
       for(User user: users){
    	   String prefix = "";
		   StringBuilder rolName = new StringBuilder();
		   List<Role> allRoleList = userManagementService.getRolesForUser(user.getId());
		   if (Util.isNullOrEmpty(user.getRoleName())) {
			   for (Role selectedRole : allRoleList)
               {
                  
                   log.info("INSIDE ROLENAME===================");
                   rolName.append(prefix);
                   prefix = ",";
                   //rolName
                   log.info("get the role name for selected role name >>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+ selectedRole.getRoleName());
                   rolName.append(selectedRole.getRoleName());
                   log.info("rolName========="+ rolName.toString());
      
               }
			   user.setRoleName(rolName.toString());
			   userManagementService.updateUser(user,false);
		   }
    	   updatedUser.add(user);
       }
        
        return new ResponseEntity<List<User>>(updatedUser, HttpStatus.OK);
    }*/

   /* @RequestMapping(value = "/getRoles/", method = RequestMethod.GET)
    public ResponseEntity<List<Role>> getAllRoles()
    {
        List<Role> roles = userManagementService.getAllRoles();
        if (Util.isNullOrEmpty(roles))
        {
            return new ResponseEntity<List<Role>>(HttpStatus.NO_CONTENT);
        }
        
        return new ResponseEntity<List<Role>>(roles, HttpStatus.OK);
    }

    @RequestMapping(value = "/getSites/", method = RequestMethod.GET)
    public ResponseEntity<List<Site>> getAllSites()
    {
        List<Site> sites = userManagementService.getAllSites();
        if (Util.isNullOrEmpty(sites))
        {
            return new ResponseEntity<List<Site>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Site>>(sites, HttpStatus.OK);
    }
*/
    @RequestMapping(value = "/getUserCount/", method = RequestMethod.POST)
    public ResponseEntity<Integer> findUsersCount(@RequestBody GenericSearchCriteria genericSearchCriteria)
    {
        int userCount = userManagementService.getUserCount(genericSearchCriteria);
        if (userCount == 0)
        {
            return new ResponseEntity<Integer>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<Integer>(userCount, HttpStatus.OK);
    }

    /**
     * 
     * @param userId
     * @return
     */
    @RequestMapping(value = "/getUser/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> getUserDetails(@PathVariable("id") Long userId)
    {
        User user = userManagementService.findUserById(userId);
        if (user == null)
        {
            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<User>(user, HttpStatus.OK);
    }

    /**
     * 
     * @param user
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/createUser", method = RequestMethod.POST)
    public ResponseEntity<User> saveNewUserDetails(@RequestBody User user, HttpServletRequest request)
        throws Exception
    {

        if (user == null)
        {
            return new ResponseEntity<User>(HttpStatus.NO_CONTENT);
        }
        else if (!userManagementService.checkforExistingUserName(user.getUserName()))
        {
            return new ResponseEntity<User>(new HttpHeaders(), HttpStatus.FOUND);
        }
        else
        {
        	 List<Role> selectedRoleList = null;
             String prefix = "";
             StringBuilder rolName = new StringBuilder();
             if (Util.isNeitherNullNorEmpty(selectedRoleList))
             {
                 log.info("roleList size::" + selectedRoleList.size());
                 for (Role selectedRole : selectedRoleList)
                 {
                    
                     log.info("INSIDE ROLENAME===================");
                     rolName.append(prefix);
                     prefix = ",";
                     //rolName
                     log.info("get the role name for selected role name >>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+ selectedRole.getRoleName());
                     rolName.append(selectedRole.getRoleName());
                     log.info("rolName========="+ rolName.toString());
        
                 }
             }

            user.setRoleName(rolName.toString());
            user.setPassword(Util.generateRandomPassword());
            user.setPasswordChanged("NO");
            user.setCreatedBy(SessionUtils.getUserName(request));
            userManagementService.createUser(user);
          
            System.out.println("Util.decryptPassword(user.getPassword())"+Util.decryptPassword(user.getPassword()));
           // emailManagementService.sendMailToUser(user, DomainConstants.EMAIL_TYPE_CREATE);
            return new ResponseEntity<User>(user, HttpStatus.CREATED);
        }

    }

   

    @RequestMapping(value = "/updateUser/{id}", method = RequestMethod.POST)
    public ResponseEntity<User> updateUserDetails(@PathVariable("id") Long userId, @RequestBody User user,
        HttpServletRequest request)
        throws Exception
    {

        User currentUser = userManagementService.findUserById(userId);
      
        if (currentUser == null)
        {
            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
        }
        if (!currentUser.getUserName().equals(user.getUserName()))
        {
            if (userManagementService.checkforExistingUserName(user.getUserName()))
            {
                return new ResponseEntity<User>(HttpStatus.FOUND);
            }
        }
       /* List<Role> roles = userManagementService.getAllRoles();
        if (Util.isNullOrEmpty(roles))
        {
            return new ResponseEntity<List<Role>>(HttpStatus.NO_CONTENT);
        }*/
       

        updateUserDetails(currentUser, user);
        List<Role> selectedRoleList = null;
        String prefix = "";
        StringBuilder rolName = new StringBuilder();
        if (Util.isNeitherNullNorEmpty(selectedRoleList))
        {
            log.info("roleList size::" + selectedRoleList.size());
            for (Role selectedRole : selectedRoleList)
            {
               
                log.info("INSIDE ROLENAME===================");
                rolName.append(prefix);
                prefix = ",";
                //rolName
                log.info("get the role name for selected role name >>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+ selectedRole.getRoleName());
                rolName.append(selectedRole.getRoleName());
                log.info("rolName========="+ rolName.toString());
   
            }
        }

        currentUser.setRoleName(rolName.toString());
        currentUser.setModifiedBy(SessionUtils.getUserName(request));
        userManagementService.updateUser(currentUser, false);
        
        return new ResponseEntity<User>(currentUser, HttpStatus.CREATED);

    }

    /**
     * 
     * @param genericSearchCriteria
     * @return
     */
    @RequestMapping(value = "/getProfileList/", method = RequestMethod.POST)
    public ResponseEntity<List<Profile>> getProfileList(@RequestBody GenericSearchCriteria genericSearchCriteria)
    {
        List<Profile> profiles = null;
        if (Util.isNullOrEmpty(profiles))
        {
            return new ResponseEntity<List<Profile>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Profile>>(profiles, HttpStatus.OK);
    }

    @RequestMapping(value = "/getProfileCount/", method = RequestMethod.POST)
    public ResponseEntity<Integer> findProfilesCount(@RequestBody GenericSearchCriteria genericSearchCriteria)
    {
        int profileCount = userManagementService.getProfileCount(genericSearchCriteria);
        if (profileCount == 0)
        {
            return new ResponseEntity<Integer>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<Integer>(profileCount, HttpStatus.OK);
    }

    /**
     * 
     * @param profile
     * @return
     */
    @RequestMapping(value = "/createProfile", method = RequestMethod.POST)
    public ResponseEntity<Void> createProfile(@RequestBody Profile profile, HttpServletRequest request)
    {
        if (profile == null)
        {
            return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
        }
        
        else
        {
            
            return new ResponseEntity<Void>(new HttpHeaders(), HttpStatus.CREATED);
        }

    }

    /**
     * 
     * @param profileId
     * @param profile
     * @return
     */
    @RequestMapping(value = "/updateProfile/{id}", method = RequestMethod.POST)
    public ResponseEntity<Profile> updateProfileDetails(@PathVariable("id") Long profileId,
        @RequestBody Profile profile, HttpServletRequest request)
    {
       
        return new ResponseEntity<Profile>(new HttpHeaders(), HttpStatus.CREATED);

    }

    

   

   

    /**
     * 
     * @param currentUser
     * @param user
     * @throws Exception
     */
    private void updateUserDetails(User currentUser, User user)
        throws Exception
    {
        currentUser.setUserName(user.getUserName());
        currentUser.setFirstName(user.getFirstName());
        currentUser.setLastName(user.getLastName());
        currentUser.setEmail(user.getEmail());
        currentUser.setContactNumber(user.getContactNumber());
        currentUser.setUserType(user.getUserType());
       // currentUser.setSite(user.getSite());
        currentUser.setUserMode(user.getUserMode());
        currentUser.setUserStatus(user.getUserStatus());
        currentUser.setCostCenter(user.getCostCenter());
    }

    

   

    

   
    @RequestMapping(value = "/changeUserPassword/{id}", method = RequestMethod.POST)
    public ResponseEntity<User> updateUserPassword(@PathVariable("id") Long userId, @RequestBody User user,
        HttpServletRequest request)
        throws Exception
    {

        User currentUser = userManagementService.findUserById(userId);
        if (currentUser == null)
        {
            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
        }

        User validUser =
            null;

        if (null != validUser)
        {
            currentUser.setPassword(user.getPassword());
            //currentUser.setPasswordChanged(DomainConstants.YES);
            updateUserDetails(currentUser, user);
            userManagementService.updateUser(currentUser, true);

            updateUserDataInSession(currentUser, request);

        }
        else
        {
            log.info("old password does not match");
            return new ResponseEntity<User>(HttpStatus.NOT_ACCEPTABLE);
        }

        return new ResponseEntity<User>(new HttpHeaders(), HttpStatus.CREATED);
    }

    private void updateUserDataInSession(User currentUser, HttpServletRequest request)
    {
        SessionData sessionData = new SessionData();
        sessionData.setUserName(currentUser.getUserName());
        sessionData.setUser(currentUser);
        sessionData.setUserId(currentUser.getId());
        //request.getSession().setAttribute(DomainConstants.SESSION_DATA, sessionData);
    }

    @RequestMapping(value = "/getUserForProfile/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> getUserDetailsForProfile(HttpServletRequest request)
    {
        Long userId = ((SessionData) request.getSession().getAttribute("sessionData")).getUserId();
        User user = userManagementService.findUserById(userId);
        if (user == null)
        {
            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<User>(user, HttpStatus.OK);
    }

    @RequestMapping(value = "/getSessionConfiguration/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SessionConfigurationDetails> getSessionConfiguration(HttpServletRequest request)
    {
        //request.getContextPath();
    	
        SessionConfigurationDetails sessionDetails = new SessionConfigurationDetails();
        if (sessionDetails == null)
        {
            return new ResponseEntity<SessionConfigurationDetails>(HttpStatus.NOT_FOUND);
        }
        sessionDetails.setContextPathValue(request.getContextPath());
        //sessionDetails.setConfiguredSession(ATBRoleConstants.SESSION_TIMEOUT_TIME-300);
        return new ResponseEntity<SessionConfigurationDetails>(sessionDetails, HttpStatus.OK);
    }
    
    /*@RequestMapping(value = "/getValidateCalibrationSpecialistCount/", method = RequestMethod.POST)
    public ResponseEntity<Integer> validateCalibrationSpecialist(@RequestBody User user)
    {
			int usersCount=0;
			 List<Role> userRoles = userManagementService.getRolesForUser(user.getId());
			 for (Role role : userRoles) {
				 log.info("role.getRoleId()"+role.getRoleId());
				if(role.getRoleId().equals(DomainConstants.CALIBRATION_SPECIALIST)){
					usersCount=userManagementService.validateCalibrationSpecialist(user.getUserName(),user.getId());
				}
			}
			return new  ResponseEntity<Integer>(usersCount, HttpStatus.OK);
    }*/

}
