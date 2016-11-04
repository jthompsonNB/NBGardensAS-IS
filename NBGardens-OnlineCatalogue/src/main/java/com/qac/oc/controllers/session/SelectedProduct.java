package com.qac.oc.controllers.session;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import com.qac.oc.util.ProductItem;

@SessionScoped
@Named("selected")
public class SelectedProduct implements Serializable {
	private static final long serialVersionUID = -1891410328473605505L;
	private ProductItem product;

	public ProductItem getProduct() { return product; }
	public void setProduct(ProductItem product) { this.product = product; }
}