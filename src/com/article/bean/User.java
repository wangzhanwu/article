package com.article.bean;

import java.util.Objects;

import com.article.annotation.Column;
import com.article.annotation.Table;

/**
 * 用户实体类
 * @author WZW
 * @version 1.0 2018年5月5日 下午2:54:24
 *
 */
@Table(tableName="t_user")
public class User {

	
	/*
	 * id 采用UUID生成
	 */
	@Column(field="id", type="varchar(32)", primaryKey=true, defaultNull=false)
	private String id; 
	
	/*
	 * 用户名
	 */
	@Column(field="username", type="varchar(20)", defaultNull=false)
	private String username;
	
	/*
	 * 密码
	 */
	@Column(field="password", type="varchar(20)", defaultNull=false)
	private String password;
	
	/*
	 * 头像
	 */
	@Column(field="photo", type="varchar(1024)")
	private String photo;
	
	/*
	 * 电子邮件
	 */
	@Column(field="email", type="varchar(60)")
	private String email;
	
	/*
	 * 性别  0：女  1：男  2：保密
	 */
	@Column(field="sex", type="varchar(2)")
	private String sex;
	
	/*
	 * 地址
	 */
	@Column(field="address", type="varchar(100)")
	private String address;
	
	/*
	 * 昵称
	 */
	@Column(field="nickname", type="varchar(30)")
	private String nickname;
	
	/*
	 * 个人描述
	 */
	@Column(field="description", type="varchar(200)")
	private String description;
	
	/*
	 * 年龄
	 */
	@Column(field="age", type="int")
	private Integer age;
	
	/*
	 * 是否删除  0：删除   1：未删除
	 */
	@Column(field="is_delete", type="varchar(1)")
	private String isDelete;
	
	/*
	 * 创建时间
	 */
	@Column(field="create_time", type="timestamp", defaultNull=false)
	private String createTime;
	
	/*
	 * 最后修改时间
	 */
	@Column(field="modify_time", type="datetime")
	private String modifyTime;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getIsDelete() {
		return isDelete;
	}
	public void setIsDelete(String isDelete) {
		this.isDelete = isDelete;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public String getModifyTime() {
		return modifyTime;
	}
	public void setModifyTime(String modifyTime) {
		this.modifyTime = modifyTime;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(id, username, sex, age, address);
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
		User user = (User)obj;
		return Objects.equals(id, user.id) && Objects.equals(username, user.username) && 
				Objects.equals(sex, user.sex) && Objects.equals(address, user.address);
	}
	
	@Override
	public String toString() {
		return getClass().getName()+"[id="+id+", username="+username+", password="+password+", createTime="+createTime+"]";
	}
}
