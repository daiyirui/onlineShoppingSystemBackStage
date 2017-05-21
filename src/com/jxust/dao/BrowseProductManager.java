package com.jxust.dao;

import java.util.List;

import com.jxust.entity.BrowseProduct;

/**
 * @author shymain
 *
 */
public interface BrowseProductManager {

	/**
	 * 查找所有浏览产品
	 * @return
	 */
	List<BrowseProduct> findAllBrowseProduct();

	/**
	 * 添加浏览产品
	 * @param browseProduct 
	 */
	void addBrowseProduct(BrowseProduct browseProduct);

	/**
	 * 删除浏览产品
	 * @param parseInt
	 */
	void deleteBrowseProductById(int id);

	/**
	 * 查找浏览产品
	 * @param id
	 * @return
	 */
	BrowseProduct findBrowseProductById(int id);

	/**
	 * 更新浏览产品
	 * @param browseProduct
	 */
	void updateBrowseProduct(BrowseProduct browseProduct);

}
