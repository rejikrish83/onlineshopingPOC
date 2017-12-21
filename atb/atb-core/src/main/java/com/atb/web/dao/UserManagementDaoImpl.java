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

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.atb.common.DomainConstants;
import com.atb.common.GenericSearchCriteria;
import com.atb.common.Util;
import com.atb.model.Menu;
import com.atb.model.User;
import com.atb.model.UserProfile;
import com.atb.model.UserRole;
import com.atb.web.dao.support.DomainObjectDaoSupport;

public class UserManagementDaoImpl extends DomainObjectDaoSupport implements UserManagementDao {

	private static final Log log = LogFactory.getLog(UserManagementDaoImpl.class);

	// select * from users
	// role roleId
	/**
	 * This method is used get all the active users from the USERS table.
	 * 
	 * @return List<User>
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<User> getAllActiveUsers() {
		final String query = "select user from User user where user.userStatus in ('" + DomainConstants.ACTIVE
				+ "') order by user.userName";
		return (List<User>) getHibernateTemplate().find(query);
	}

	/**
	 * This method is used to save the new user
	 * 
	 * @param user
	 */
	@Override
	public void createUser(User user) {
		createDomainObject(user);
	}

	/**
	 * This method is used to update the existing user
	 * 
	 * @param user
	 */
	@Override
	public void updateUser(User user) {
		saveOrUpdateDomainObject(user);
	}

	/**
	 * This method is used to delete the user
	 * 
	 * @param user
	 */
	@Override
	public void deleteUser(User user) {
		saveOrUpdateDomainObject(user);
	}

	/**
	 * This method is used to find the user by the user ID
	 * 
	 * @param userId
	 * @return User
	 */
	@Override
	public User findUserById(Long userId) {
		return getHibernateTemplate().get(User.class, userId);
	}

	

	
	/**
	 * This method will check for the user name in the users table and returns
	 * true if user name already exists.
	 * 
	 * @param userName
	 * @return boolean
	 */
	@SuppressWarnings("unchecked")
	public boolean checkforExistingUserName(String userName) {
		userName = userName.toLowerCase();
		List<User> users = (List<User>) getHibernateTemplate()
				.find("from " + User.class.getName() + " as user where lower(user.userName)=? ", userName);
		return users.isEmpty();
	}

	
	/**
	 * This method is used get all the users from the USERS table based on the
	 * given criteria.
	 * 
	 * @param genericSearchCriteria
	 * @return List<User>
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<User> findAllUsers(GenericSearchCriteria genericSearchCriteria) {
		String sortColumn = genericSearchCriteria.getSortingColumn();

		log.info("sortColumn  " + sortColumn);

		String pattern = Util.getSearchPattern(genericSearchCriteria);
		String getUsersByApplyingCriteria = "select user from " + User.class.getName()
				+ " user where lower(user.userName) like " + pattern + " or lower(user.firstName) like " + pattern
				+ " or lower(user.lastName) like " + pattern + " or lower(user.email) like " + pattern
				+ " or lower(user.site.siteName) like " + pattern + " or lower(user.userType) like " + pattern
				+ " or lower(user.userStatus) like " + pattern + "or lower(user.contactNumber) like " + pattern
				+ " or lower(user.userMode) like " + pattern + " or lower(user.costCenter) like " + pattern
				+ " or lower(user.roleName) like " + pattern
				+ " order by user." + genericSearchCriteria.getSortingColumn() + " "
				+ genericSearchCriteria.getSortingOrder();

		return (List<User>) getHibernateTemplate().getSessionFactory().getCurrentSession()
				.createQuery(getUsersByApplyingCriteria).setMaxResults(genericSearchCriteria.getPageSize())
				.setFirstResult(genericSearchCriteria.getPage() * genericSearchCriteria.getPageSize()).list();
	}

	

	@SuppressWarnings("unchecked")
	@Override
	public List<User> getAllActiveUsersByName(String name) {
		final String query = "select user from User user where user.userName like ('%" + name
				+ "%') and user.userStatus like 'Active'";
		return (List<User>) getHibernateTemplate().find(query);
	}

	

	

	/**
	 * This method is used to save the new userProfile
	 * 
	 * @param userProfile
	 */
	@Override
	public void createUserProfile(UserProfile userProfile) {
		createDomainObject(userProfile);
	}

	/**
	 * This method is used to update userProfile
	 * 
	 * @param userProfile
	 */
	@Override
	public void updateUserProfile(UserProfile userProfile) {
		if (userProfile.getId() == null) {
			createDomainObject(userProfile);
		} else {
			saveOrUpdateDomainObject(userProfile);
		}
	}

	/**
	 * This method is used to delete userProfile
	 * 
	 * @param userProfile
	 */
	@Override
	public void deleteUserProfile(UserProfile userProfile) {
		saveOrUpdateDomainObject(userProfile);
	}

	

	

	@SuppressWarnings("unchecked")
	@Override
	public User checkforExistingEmail(String email, String userName) {
		List<User> users = (List<User>) getHibernateTemplate()
				.find("from " + User.class.getName() + " as user where user.userName like '" + userName
						+ "' and user.email like '" + email + "' and user.userStatus like 'Active'");

		if (Util.isNeitherNullNorEmpty(users)) {
			return users.get(0);
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public User validateUser(String userName, String password) {
		List<User> users = (List<User>) getHibernateTemplate()
				.find("from " + User.class.getName() + " as user where user.userName like '" + userName
						+ "' and user.password like '" + password + "' and user.userStatus like 'Active'");
		if (Util.isNeitherNullNorEmpty(users)) {
			return users.get(0);
		}
		return null;
	}

	

	@SuppressWarnings("unchecked")
	@Override
	public List<User> getAllActiveUsersByRoleId(Long roleId) {

		final String query = "select user from " + User.class.getName() + " user where user.userStatus in ('"
				+ DomainConstants.ACTIVE + "') and user.id in (select uRole.userId from " + UserRole.class.getName()
				+ " as uRole where uRole.role.roleId = ?) order by user.userName";
		return (List<User>) getHibernateTemplate().find(query, roleId);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Menu> getAllMenus() {
		return (List<Menu>) getHibernateTemplate().find("select menu from Menu menu");
	}

	
	@Override
	public void saveUserRole(UserRole userRole) {
		createDomainObject(userRole);
	}

	@Override
	public void removeUserRole(UserRole userRole) {
		deleteDomainObject(userRole);
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean userRoleNotExistsAlready(Long roleId, Long userId) {
		List<UserRole> users = (List<UserRole>) getHibernateTemplate().find(
				"from " + UserRole.class.getName() + " as uRole where uRole.userId = ? and uRole.role.roleId = ? ",
				userId, roleId);
		if (Util.isNeitherNullNorEmpty(users)) {
			return false;
		}
		return true;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> getAllActiveUsersByRoleIdList(List<Long> roleIds) {

		final String query = "select user from " + User.class.getName() + " user where user.userStatus in ('"
				+ DomainConstants.ACTIVE + "') and user.id in (select uRole.userId from " + UserRole.class.getName()
				+ " as uRole where uRole.role.roleId in (" + Util.getListOfLongAsCommaSeparated(roleIds)
				+ ")) order by user.userName";
		return (List<User>) getHibernateTemplate().find(query);
	}

	@Override
	public void deleteRoleByUserId(User user) {
		final String query = "delete UserRole userRole where userRole.userId in (" + user.getId() + ")";

		getHibernateTemplate().bulkUpdate(query);

	}

	@Override
	public void updateUserRole(UserRole userRole) {
		if (userRole.getUserRoleId() == null) {
			createDomainObject(userRole);
		} else {
			saveOrUpdateDomainObject(userRole);
		}
	}

	@SuppressWarnings("unchecked")
	public List<UserRole> isLoggedInUserHaveRole(Long roleId, Long userId) {
		final String query = "select uRole from " + UserRole.class.getName()
				+ " as uRole where uRole.userId = ?  and uRole.role.roleId = ? ";
		return (List<UserRole>) getHibernateTemplate().find(query, userId, roleId);

	}

	/*@Override
	public int validateCalibrationSpecialist(String userName,Long userId) {
		String getValidateCalibrationSpecialistByApplyingCriteria = "select distinct count(*) from "
				+ WorkOrder.class.getName()
				+ " workOrder, User user where workOrder.workOrderExecutor.id=user.id and user.userName='" + userName
				+ "' and workOrder.workOrderExecutor.id="+userId+" and workOrder.workOrderStatus IN (1,3,4)";

		int totalValidateCalibrationSpecialistCount = ((Long) getHibernateTemplate().getSessionFactory()
				.getCurrentSession().createQuery(getValidateCalibrationSpecialistByApplyingCriteria).uniqueResult())
						.intValue();
		return totalValidateCalibrationSpecialistCount;
	}
*/
	
	@Override
	public List<User> getAllActiveOwnersByRoleIdList(List<Long> roleIds) {


		final String query = "select user from " + User.class.getName() + " user where user.userStatus in ('"
				+ DomainConstants.ACTIVE + "') and user.id in (select uRole.userId from " + UserRole.class.getName()
				+ " as uRole where uRole.role.roleId in (" + Util.getListOfLongAsCommaSeparated(roleIds)
				+ ")) order by user.userName";
		return (List<User>) getHibernateTemplate().find(query);
	}

	@Override
	public boolean checkforExistingProfileName(String profileName) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<User> getAllActiveFCAndApprover() {
		// TODO Auto-generated method stub
		return null;
	}

}
