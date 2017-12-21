/**
 * Copyright (c) 2017 ATB
 * All rights reserved.
 * 
 * Version: V01
 * Created on: Aug 18, 2016
 * Created by: Maria Prakash
 * Created Reference: GTMT Sprint 2
 *  
 */
package com.atb.web.service;

/**
 * Interface for accessing properties in PROPERTIES
 * @author maria.p.chinnappan
 */
public interface PropertyService
{
    /**
     * Saves property with given string value
     * @param key property name
     * @param value string value
     */
    void saveStringProperty(String key, String value);
    /**
     * Saves property with given boolean value
     * @param key property name
     * @param value boolean value
     */
    void saveBooleanProperty(String key, boolean value);
    /**
     * Saves property with given integer value
     * @param key property name
     * @param value boolean value
     */
    void saveIntegerProperty(String key, int value);
    /**
     * Saves property with given long value
     * @param key property name
     * @param value long value
     */
    void saveLongProperty(String key, long value);
    
    /**
     * Returns string value of the property
     * @param key property name
     * @return string value, null if property not set.
     */
    String getPropertyValueAsString(String key);
    /**
     * Returns Integer value of the property
     * @param key property name
     * @return string value, null if property not set or can't be converted to Integer.
     */
    Integer getPropertyValueAsInteger(String key);
    
    /**
     * Returns Long value of the property
     * @param key property name
     * @return Long, null if property not set or not can't be converted to Long. 
     */
    Long getPropertyValueAsLong(String key);
    /**
     * Returns boolean value of the property
     * @param key property name
     * @return Boolean, null if property not set.
     */
    Boolean getPropertyValueAsBoolean(String key);
}
