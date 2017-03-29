package edu.puxianxingyuan.jgsd.base.service;

import java.util.List;
import java.util.Map;
import java.io.Serializable;

/**
 * Description:
 * <br/>网站: <a href="http://www.crazyit.org">疯狂Java联盟</a>
 * <br/>Copyright (C), 2001-2016, Yeeku.H.Lee
 * <br/>This program is protected by copyright laws.
 * <br/>Program Name:
 * <br/>Date:
 * @author Yeeku.H.Lee kongyeeku@163.com
 * @version 1.0
 */
public interface BaseService<T>
{
	// 根据ID加载实体
	T getById(Serializable id);
	// 根据IDs加载多个实体
	List<T> getByIds(Serializable[] ids);
	// 保存实体
	Serializable save(T entity);
	// 更新实体,entity为持久态
	void update(T entity);
	// 更新实体,dto为瞬态传值对象,该方法依据标识属性获得持久态对象并更新对应属性
	void updateByDTO(T dto);
	//依据传入对象的@id属性是否有值判定是否新建还是更新
	void saveAndUpdate(T dto);  
	// 删除实体
	void delete(T entity);
	// 根据ID删除实体
	void deleteById(Serializable id);
	//删除多个实体
	void deleteByIds(Serializable[] ids);
	// 获取所有实体
	List<T> findAll();
	// 获取所有实体，分页返回
	List<T> findAllByPage(int pageNo, int pageSize);
	// 获取实体总数
	long findCount();
	//获取符合条件实体总数，参数用于构造String =: Object的hql语句
	int getCount(Map<String, Object> buildWhere);
	

}
