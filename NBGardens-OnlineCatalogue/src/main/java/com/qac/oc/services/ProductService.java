package com.qac.oc.services;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import com.qac.oc.entities.Product;
import com.qac.oc.entities.Stock;
import com.qac.oc.managers.ProductManager;
import com.qac.oc.managers.StockManager;
import com.qac.oc.util.ProductItem;

@Stateless
public class ProductService {
	@Inject
	private ProductManager productManager;
	@Inject
	private StockManager stockManager;

	public Product findProductById(String id) {
		try {
			long longId = Long.parseLong(id);
			return findProductById(longId);
		} catch (Exception e) {
			return null;
		}
	}

	public Product findProductById(long id) {
		return productManager.findById(id);
	}
	
	public List<Product> findAll() {
		return productManager.findAll();
	}

	public ProductItem getProductItem(long id) {
		return getProductItem(productManager.findById(id), stockManager.findById(id));
	}
	
	public ProductItem getProductItem(long id, Stock stock) {
		return getProductItem(productManager.findById(id), stock);
	}
	
	public ProductItem getProductItem(Product product, long id) {
		return  getProductItem(product, stockManager.findById(id));
	}
	
	public ProductItem getProductItem(Product product, Stock stock) {
		ProductItem productItem = new ProductItem(stock.getId());
		if (product!=null)
			productItem.addProductInfo(product.getName(), product.getDescription(), product.getHeight(), product.getWidth(), product.getDepth(), product.getWeight(), product.getCategories(), product.getRatings());
		if(stock!=null)
			productItem.addStockInfo(stock.getStockLevel(), stock.getStatus(), stock.getPrice());
		return productItem;
	}

	public List<ProductItem> findAllActive() {
		List<ProductItem> items = new ArrayList<ProductItem>();
		stockManager.findByActive().forEach(stock->{
			items.add(getProductItem(stock.getId(), stock));
		});;
		return items;
	}
}