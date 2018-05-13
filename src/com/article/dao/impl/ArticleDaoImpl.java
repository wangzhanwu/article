package com.article.dao.impl;

import java.util.List;
import java.util.Map;

import com.article.dao.ArticleDao;
import com.article.util.DBUtils;

public class ArticleDaoImpl implements ArticleDao{

	public List<Map<String, Object>> getArticlesByCategoryId(Integer categoryId, Integer start, Integer end) {
		String sql = "select id, title, author, description, create_time, update_time from t_article "
					+ "where is_delete = 0 and is_published = 1 and category_id = ? "
					+ "order by update_time desc limit ?, ?";
		return DBUtils.queryForList(sql, categoryId, start, end);
	}
	
	public Map<String, Object> getArticleById(String id) {
		String sql = "select content from t_article where id = ?";
		return DBUtils.queryForMap(sql, id);
	}
	
	public static void main(String[] args) {
		ArticleDaoImpl ad = new ArticleDaoImpl();
		if(ad.getArticlesByCategoryId(1, 0, 10).size() == 0) {
			System.out.println("q123");
		}
	}
}
