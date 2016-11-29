package com.qac.oc.util;

import javax.faces.model.DataModel;

/**
 * Used to allow Controllers to provide Pagination functionality.
 * 
 * @author James Thompson
 */
public abstract class PaginationHelper {
	private int pageSize;
	private int page;
	
	/**
	 * Sets up the paginator do display the provided number of products per page
	 * 
	 * @param pageSize
	 */
	public PaginationHelper(int pageSize) {
		this.pageSize = pageSize;
	}
	
	/**
	 * Get the total number of item in the search.
	 * 
	 * @return
	 */
	public abstract int getItemsCount();

	/**
	 * Creates the Data Model to be used by the Paginator
	 * 
	 * @return
	 */
	public abstract DataModel<?> createPageDataModel();
	
	/**
	 * Gets the Index of the first item to display
	 * 
	 * @return
	 */
	public int getPageFirstItem() {
		return page * pageSize;
	}
	
	/**
	 * Calculates the index of the last Item to display on a page.
	 * 
	 * @return
	 */
	public int getPageLastItem() {
		int i = getPageFirstItem() + pageSize - 1;
        int count = getItemsCount() - 1;
        if (i > count)
            i = count;
        if (i < 0)
            i = 0;
        return i;
	}
	
	/**
	 * Checks to see if there is a next page
	 * 
	 * @return
	 */
	public boolean isHasNextPage() {
        return (page + 1) * pageSize + 1 <= getItemsCount();
	}
	
	/**
	 * sets the page counter to the next page.
	 */
	public void nextPage() {
		if (isHasNextPage())
            page++;
    }

	/**
	 * Checks to see if there is a previous page
	 * 
	 * @return
	 */
    public boolean isHasPreviousPage() {
        return page > 0;
    }
    
    /**
     * sets the page counter to the previous page
     */
    public void previousPage() {
        if (isHasPreviousPage())
            page--;
    }

    /**
     * Gets the number of items to be displayed on a page.
     * 
     * @return
     */
	public int getPageSize() {
		return pageSize;
	}

	/**
	 * Set the number of items to be displayed on a page.
	 * 
	 * @param pageSize
	 */
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
}