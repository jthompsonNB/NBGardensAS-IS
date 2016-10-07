package com.qac.oc.controllers;

import java.io.Serializable;

import javax.faces.bean.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.inject.Inject;
import javax.inject.Named;

import com.qac.oc.entities.mongo.Product;
import com.qac.oc.repositories.ProductRepository;
import com.qac.oc.services.PagenationHelper;

@Named("products")
@SessionScoped
public class ProductController implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1995906091201060046L;
	@Inject
	private ProductRepository productRepository;
	private Product product;
	private PagenationHelper pagenationHelper;
	private int selectedItemIndex;
	private DataModel<Product> dataModel = null;
	
	public String view(long id) {
		dataModel.forEach(prod -> {
			if(prod.getProductId()==id) {
				product = prod;
			}
		});
		return "details";
	}
	
	public PagenationHelper getPagination() {
		if (pagenationHelper == null) {
			pagenationHelper = new PagenationHelper(10) {
				
				@Override
				public int getItemsCount() {
					return productRepository.findAll().size();
				}
				
				@Override
				public DataModel<Product> createPageDataModel() {
					return new ListDataModel<Product>(productRepository.findAll().subList(getPageFirstItem(), getPageFirstItem() + getPageSize()));
				}
			};
		}
		return pagenationHelper;
	}

	private void recreateModel() {
		dataModel = null;
	}
	
	private void updateCurrentItem() {
		int count = productRepository.findAll().size();
		if (selectedItemIndex >= count) {
			selectedItemIndex = count-1;
			if (pagenationHelper.getPageFirstItem() >= count)
				pagenationHelper.previousPage();
		}
		if (selectedItemIndex >= 0)
			setProduct(productRepository.findAll().subList(selectedItemIndex, selectedItemIndex + 1).get(0));
	}
	
	public String next() {
		getPagination().nextPage();
		recreateModel();
		return "browse";
	}
	
	public String previous() {
		getPagination().previousPage();
		recreateModel();
		return "browse";
	}
	
	public DataModel<Product> getDataModel() {
		if (dataModel == null)
			dataModel = getPagination().createPageDataModel();
		return dataModel;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
}