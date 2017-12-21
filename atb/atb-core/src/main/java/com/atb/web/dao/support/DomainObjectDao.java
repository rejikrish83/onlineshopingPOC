/**
 * Copyright (c) 2017 ATB
 * All rights reserved.
 * 
 * Version: V01
 * Created on: May 02, 2016
 * Created by: Maria Prakash
 * Created Reference: ATB
 *  
 */
package com.atb.web.dao.support;

import com.atb.model.HibernateMappedEntity;

public interface DomainObjectDao {

	void createDomainObject(HibernateMappedEntity entity);
    void deleteDomainObject(HibernateMappedEntity entity);
    void saveOrUpdateDomainObject(HibernateMappedEntity entity);
}
