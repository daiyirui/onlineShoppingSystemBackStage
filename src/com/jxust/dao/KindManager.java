package com.jxust.dao;

import java.util.List;

import com.jxust.entity.Kind;

/**
 * @author shymain
 *
 */
public interface KindManager {

	/**查找所有商品类别
	 * @return
	 */
	List<Kind> findAllKind();

	/**
	 * 删除商品类别
	 * @param parseInt
	 */
	void deleteKindById(int parseInt);

	/**
	 * 添加商品类别
	 * @param kind
	 */
	void addKind(Kind kind);

	/**
	 * 根据id查找商品类别
	 * @param parseInt
	 * @return
	 */
	Kind findKindById(int id);

	/**
	 * 更新商品类型
	 * @param kind
	 */
	void updateKindById(Kind kind);


	
	
}
