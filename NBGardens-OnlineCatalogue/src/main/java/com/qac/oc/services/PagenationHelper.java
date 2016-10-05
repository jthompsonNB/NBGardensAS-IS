package com.qac.oc.services;

import javax.faces.model.DataModel;

public abstract class PagenationHelper {
	private int pageSize;
	private int page;
	
	public PagenationHelper(int pageSize) {
		this.pageSize = pageSize;
	}
	
	public abstract int getItemsCount();
	
	public abstract DataModel createPageDataModel();
	
	public int getPageFirstItem() {
		return page * pageSize;
	}

	protected int getPageSize() {
		return pageSize;
	}

	protected void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
}