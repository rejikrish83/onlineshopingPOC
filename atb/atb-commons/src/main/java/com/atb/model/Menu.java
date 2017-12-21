/**
 * Copyright (c) 2017 ATB
 * All rights reserved.
 * 
 * Version: V01
 * Created on: June 07, 2016
 * Created by: Kanimozhi Mahendran
 * Created Reference: ATB
 *  
 */
package com.atb.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "MENUS")
public class Menu
    implements HibernateMappedEntity, Cloneable
{

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "MENU_ID")
    private Long              menuId;

    @Column(name = "MENU_NAME")
    private String            menuName;

    @Column(name = "MENU_LINK")
    private String            menuLink;

    /**
     * @return the menuId
     */
    public Long getMenuId()
    {
        return menuId;
    }

    /**
     * @param menuId the menuId to set
     */
    public void setMenuId(Long menuId)
    {
        this.menuId = menuId;
    }

    /**
     * @return the menuName
     */
    public String getMenuName()
    {
        return menuName;
    }

    /**
     * @param menuName the menuName to set
     */
    public void setMenuName(String menuName)
    {
        this.menuName = menuName;
    }

    /**
     * @return the menuLink
     */
    public String getMenuLink()
    {
        return menuLink;
    }

    /**
     * @param menuLink the menuLink to set
     */
    public void setMenuLink(String menuLink)
    {
        this.menuLink = menuLink;
    }

}
