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

import java.math.BigDecimal;

import org.hibernate.Session;
import org.springframework.aop.framework.AopContext;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate4.HibernateCallback;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.atb.model.HibernateMappedEntity;

public abstract class DomainObjectDaoSupport extends HibernateDaoSupport {
	
	@Transactional(propagation = Propagation.REQUIRED)
    public void createDomainObject(HibernateMappedEntity entity)
    {
        createDomainObject(entity, true);
    }

	@Transactional(propagation = Propagation.REQUIRED)
    public void createDomainObject(HibernateMappedEntity entity, boolean flush)
    {
        try
        {
            getHibernateTemplate().save(entity);
            if (flush)
            {
                getHibernateTemplate().flush();
            }
        }
        catch (DataAccessException e)
        {
        	// Logging Module will take care of logging the exception.
        	// So just Throw the exception.
        	throw e;
        }
    }

	@Transactional(propagation = Propagation.REQUIRED)
    public void deleteDomainObject(HibernateMappedEntity entity)
    {
        try
        {
            getHibernateTemplate().delete(entity);
        }
        catch (DataAccessException e)
        {
        	// Logging Module will take care of logging the exception.
            // So just Throw the exception.
            throw e;
        }
    }
    
	@Transactional(propagation = Propagation.REQUIRED)
    public void saveOrUpdateDomainObject(HibernateMappedEntity entity)
    {
        try
        {
            getHibernateTemplate().saveOrUpdate(entity);
        }
        catch (DataAccessException e)
        {
        	// Logging Module will take care of logging the exception.
            // So just Throw the exception.
            throw e;
        }
    }
    
	
    @SuppressWarnings({"rawtypes", "unchecked"})
    @Transactional(propagation = Propagation.REQUIRED)
    public BigDecimal getNextSequenceValue(final String sequenceName)
    {
        return (BigDecimal) getHibernateTemplate().execute(new HibernateCallback() {
            public Object doInHibernate(Session session)
            {
                return session.createSQLQuery("SELECT " + sequenceName + ".NextVal FROM DUAL").uniqueResult();
            }
        });
    }
    
  
    protected DomainObjectDao getCurrentProxy()
    {
        return (DomainObjectDao) AopContext.currentProxy();
    }
    
    protected String getQuestionMarkString(int quantity)
    {
        StringBuffer questionMarkBuffer = new StringBuffer();

        for (int i = 0; i < quantity; i++)
        {
            if (questionMarkBuffer.length() > 0)
            {
                questionMarkBuffer.append(',');
            }
            questionMarkBuffer.append('?');
        }

        return questionMarkBuffer.toString();
    }
    
    @Transactional(propagation = Propagation.REQUIRED)
    public void evictDomainObject(HibernateMappedEntity entity)
    {
        try
        {
            getHibernateTemplate().evict(entity);
        }
        catch (DataAccessException e)
        {
            // Logging Module will take care of logging the exception.
            // So just Throw the exception.
            throw e;
        }
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void clearHibernateSessionCache()
    {
        try
        {
            getHibernateTemplate().clear();
        }
        catch (DataAccessException e)
        {
            // Logging Module will take care of logging the exception.
            // So just Throw the exception.
            throw e;
        }
    }

	

	
}
