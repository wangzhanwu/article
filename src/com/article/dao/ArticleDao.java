package com.article.dao;

import java.util.List;
import java.util.Map;

/**
 * 
 * @author WZW
 * @version 1.0 2018年5月13日 下午8:53:34
 *
 */
public interface ArticleDao {

	/**
	 * 通过类别获取文章列表
	 * @param categoryId
	 * @param start
	 * @param end
	 * @return
	 */
	List<Map<String, Object>> getArticlesByCategoryId(Integer categoryId, Integer start, Integer end);
	
	/**
	 * 根据id查询文章内容
	 * @param id
	 * @return
	 */
	Map<String, Object> getArticleById(String id);
}
