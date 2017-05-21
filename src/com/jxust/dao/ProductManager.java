package com.jxust.dao;

import java.util.List;

import com.jxust.entity.Product;

public interface ProductManager {
	public List<Product> findAllProduct();
		
	public void addProduct(Product product);
	
	public Product findProductById(int productid);
	
	public void deleteProductById(int productid);
	
	public void updateProduct(Product product);

	/**
	 * 根据产品类型删除产品
	 * @param id
	 */
	public void deleteProductByKindId(String id);
}
