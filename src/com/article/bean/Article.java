package com.article.bean;

import java.util.Date;
import java.util.Objects;

import com.article.annotation.Column;
import com.article.annotation.Table;

/**
 * 文章实体类
 * @author WZW
 * @version 1.0 2018年5月13日 上午10:33:01
 *
 */
@Table(tableName = "t_article")
public class Article {
	
	/**
	 * ID主键
	 */
	@Column(field="id", type="varchar(32)", primaryKey=true, defaultNull=false)
	private String id;
	
	/**
	 * 标题
	 */
	@Column(field="title", type="varchar(100)", defaultNull=false)
	private String title;
	
	/**
	 * 文章内容
	 */
	@Column(field="content", type="text")
	private String content;
	
	/**
	 * 作者
	 */
	 @Column(field="author", type="varchar(60)", defaultNull=false)
	private String author;
	 
	/**
	 * 概述
	 */
	 @Column(field="description", type="varchar(200)")
	private String description;
	 
	 /**
	  * 是否发布 0：未发布   1：已发布
	  */
	@Column(field="is_published", type="varchar(1)", defaultNull=false)
	private String isPublished;
	
	/**
	 * 是否删除 0：未删除   1：已删除
	 */
	@Column(field="is_delete", type="varchar(1)", defaultNull=false)
	private String isDelete;
	
	/**
	 * 创建时间
	 */
	@Column(field="create_time", type="datetime", defaultNull=false)
	private Date createTime;
	
	/**
	 * 最后修改时间
	 */
	@Column(field="update_time", type="timestamp")
	private Date updateTime;
	
	/**
	 * 作者ID
	 */
	@Column(field="user_id", type="varchar(32)", defaultNull=false)
	private String userId;
	
	/**
	 * 文章分类
	 */
	@Column(field="category_id", type="int", defaultNull=false)
	private Integer categoryId;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getIsPublished() {
		return isPublished;
	}

	public void setIsPublished(String isPublished) {
		this.isPublished = isPublished;
	}

	public String getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(String isDelete) {
		this.isDelete = isDelete;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Integer getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj == null) {
			return false;
		}
		if(this == obj) {
			return true;
		}
		if(getClass() != obj.getClass()) {
			return false;
		}
		Article article = (Article)obj;
		return Objects.equals(id, article.id) && Objects.equals(title, article.title) && 
				Objects.equals(content, article.content) && Objects.equals(createTime, article.createTime) &&
				Objects.equals(categoryId, article.categoryId) && Objects.equals(userId, article.userId) && 
				Objects.equals(isPublished, article.isPublished) && Objects.equals(isDelete, article.isDelete);
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(id, title, content, createTime, categoryId, userId, isPublished, isDelete);
	}
	
	public String toString() {
		return getClass().getName()+"[title="+title+", author="+author+", content="+content+
				", categoryId="+categoryId+", createTime="+createTime+"]";
	}
}
