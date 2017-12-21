/**
 * Copyright (c) 2017 ATB
 * All rights reserved.
 * 
 * Version: V01
 * Created on: June 10, 2016
 * Created by: Maria Prakash
 * Created Reference: ATB
 *  
 */
package com.atb.common;

import java.io.Serializable;
import java.util.Date;

/**
 * A DTO used to perform General Search. Encapsulates the search criteria
 */
public class GenericSearchCriteria
    implements Serializable
{

    private static final long serialVersionUID = 1L;

    /**
     * The keyed-in search criteria to find results.
     */
    private String            searchString;

    /**
     * The maximum page size of the result list
     */
    private int               pageSize;

    /**
     * The current page of the result list.
     */
    private int               page;

    /**
     * The Sorting Order.
     * 
     * Values can be either asc / desc
     */
    private String            sortingOrder     = "asc";

    /**
     * The Sorting Column.
     * 
     * Values can be respective column names
     */
    private String            sortingColumn    = "";

    /**
     * 
     * Values to be searched from date .
     */
    private Date              fromDate;

    /**
     * 
     * Values to searched upto date
     */
    private Date              toDate;

    /**
     * 
     * Values to search string searchObjString1
     */
    private String            searchObjString1;
    /**
     * 
     * Values to search string searchObjString2
     */
    private String            searchObjString2;
    /**
     * 
     * Values to search string searchObjString3
     */
    private String            searchObjString3;
    /**
     * 
     * Values to search string searchObjString4
     */
    private String            searchObjString4;

    /**
     * 
     * Values to search parameter searchObjParameter1
     */
    private String            searchObjParameter1;
    /**
     * 
     * Values to search parameter searchObjParameter2
     */
    private String            searchObjParameter2;
    /**
     * 
     * Values to search parameter searchObjParameter3
     */
    private String            searchObjParameter3;
    /**
     * 
     * Values to search parameter searchObjParameter4
     */
    private String            searchObjParameter4;

    private String            searchObjParameter5;

    private Long              loggedInUser;

    public String getSearchObjParameter5()
    {
        return searchObjParameter5;
    }

    public void setSearchObjParameter5(String searchObjParameter5)
    {
        this.searchObjParameter5 = searchObjParameter5;
    }

    /**
     * This Product Id is used as search criteria in the search test process documentation and
     * search test system compatibility.
     */
    private Long productId;

    private Long viewStatusId;

    /**
     * @return the searchString
     */
    public String getSearchString()
    {
        return searchString;
    }

    public Date getFromDate()
    {
        return fromDate;
    }

    public void setFromDate(Date fromDate)
    {
        this.fromDate = fromDate;
    }

    public Date getToDate()
    {
        return toDate;
    }

    public void setToDate(Date toDate)
    {
        this.toDate = toDate;
    }

    /**
     * @param searchString the searchString to set
     */
    public void setSearchString(String searchString)
    {
        this.searchString = searchString;
    }

    /**
     * @return the pageSize
     */
    public int getPageSize()
    {
        return pageSize;
    }

    /**
     * @param pageSize the pageSize to set
     */
    public void setPageSize(int pageSize)
    {
        this.pageSize = pageSize;
    }

    /**
     * @return the page
     */
    public int getPage()
    {
        return page;
    }

    /**
     * @param page the page to set
     */
    public void setPage(int page)
    {
        this.page = page;
    }

    /**
     * @return the sortingOrder
     */
    public String getSortingOrder()
    {
        return sortingOrder;
    }

    /**
     * @param sortingOrder the sortingOrder to set
     */
    public void setSortingOrder(String sortingOrder)
    {
        this.sortingOrder = sortingOrder;
    }

    /**
     * @return the sortingColumn
     */
    public String getSortingColumn()
    {
        return sortingColumn;
    }

    /**
     * @param sortingColumn the sortingColumn to set
     */
    public void setSortingColumn(String sortingColumn)
    {
        this.sortingColumn = sortingColumn;
    }

    /**
     * @return the searchObjString1
     */
    public String getSearchObjString1()
    {
        return searchObjString1;
    }

    /**
     * @param searchObjString1 the searchObjString1 to set
     */
    public void setSearchObjString1(String searchObjString1)
    {
        this.searchObjString1 = searchObjString1;
    }

    /**
     * @return the searchObjString2
     */
    public String getSearchObjString2()
    {
        return searchObjString2;
    }

    /**
     * @param searchObjString2 the searchObjString2 to set
     */
    public void setSearchObjString2(String searchObjString2)
    {
        this.searchObjString2 = searchObjString2;
    }

    /**
     * @return the searchObjString3
     */
    public String getSearchObjString3()
    {
        return searchObjString3;
    }

    /**
     * @param searchObjString3 the searchObjString3 to set
     */
    public void setSearchObjString3(String searchObjString3)
    {
        this.searchObjString3 = searchObjString3;
    }

    /**
     * @return the searchObjString4
     */
    public String getSearchObjString4()
    {
        return searchObjString4;
    }

    /**
     * @param searchObjString4 the searchObjString4 to set
     */
    public void setSearchObjString4(String searchObjString4)
    {
        this.searchObjString4 = searchObjString4;
    }

    /**
     * @return the searchObjParameter1
     */
    public String getSearchObjParameter1()
    {
        return searchObjParameter1;
    }

    /**
     * @param searchObjParameter1 the searchObjParameter1 to set
     */
    public void setSearchObjParameter1(String searchObjParameter1)
    {
        this.searchObjParameter1 = searchObjParameter1;
    }

    /**
     * @return the searchObjParameter2
     */
    public String getSearchObjParameter2()
    {
        return searchObjParameter2;
    }

    /**
     * @param searchObjParameter2 the searchObjParameter2 to set
     */
    public void setSearchObjParameter2(String searchObjParameter2)
    {
        this.searchObjParameter2 = searchObjParameter2;
    }

    /**
     * @return the searchObjParameter3
     */
    public String getSearchObjParameter3()
    {
        return searchObjParameter3;
    }

    /**
     * @param searchObjParameter3 the searchObjParameter3 to set
     */
    public void setSearchObjParameter3(String searchObjParameter3)
    {
        this.searchObjParameter3 = searchObjParameter3;
    }

    /**
     * @return the searchObjParameter4
     */
    public String getSearchObjParameter4()
    {
        return searchObjParameter4;
    }

    /**
     * @param searchObjParameter4 the searchObjParameter4 to set
     */
    public void setSearchObjParameter4(String searchObjParameter4)
    {
        this.searchObjParameter4 = searchObjParameter4;
    }

    public Long getProductId()
    {
        return productId;
    }

    public void setProductId(Long productId)
    {
        this.productId = productId;
    }

    /**
     * @return the loggedInUser
     */
    public Long getLoggedInUser()
    {
        return loggedInUser;
    }

    /**
     * @param loggedInUser the loggedInUser to set
     */
    public void setLoggedInUser(Long loggedInUser)
    {
        this.loggedInUser = loggedInUser;
    }

    public Long getViewStatusId()
    {
        return viewStatusId;
    }

    public void setViewStatusId(Long viewStatusId)
    {
        this.viewStatusId = viewStatusId;
    }
}
