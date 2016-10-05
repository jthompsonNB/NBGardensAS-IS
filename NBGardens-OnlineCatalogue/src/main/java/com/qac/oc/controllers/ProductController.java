package com.qac.oc.controllers;

import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

import com.qac.oc.services.PagenationHelper;

public class ProductController {
	private PagenationHelper pagenationHelper;
	private int selectedItemIndex;
	private DataModel dataModel = null;
	
	public PagenationHelper getPagination() {
		if (pagenationHelper == null) {
			pagenationHelper = new PagenationHelper(10) {
				
				@Override
				public int getItemsCount() {
					return itemBean.cont();
				}
				
				@Override
				public DataModel createPageDataModel() {
					return new ListDataModel(itemBean.findRange(new int[]{getPageFirstItem(), getPageFirstItem() + getPageSize()}));
				}
			};
		}
		return pagenationHelper;
	}
}