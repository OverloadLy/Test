package model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(catalog = "usermanager",name = "user")
public class User {

	private Integer userId;
	private String userName;
	private String userEmail;
	private String userSex;
	private Date createDate;
	private Date updateDate;

	public User() {
	}

	public User(String userName, String userEmail, String userSex, Date createDate, Date updateDate) {
		this.userName = userName;
		this.userEmail = userEmail;
		this.userSex = userSex;
		this.createDate = createDate;
		this.updateDate = updateDate;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "userId", unique = true, nullable = false)
	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	@Column(name = "userName", length = 50)
	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Column(name = "userEmail", length = 100)
	public String getUserEmail() {
		return this.userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	@Column(name = "userSex", length = 30)
	public String getUserSex() {
		return this.userSex;
	}

	public void setUserSex(String userSex) {
		this.userSex = userSex;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "createDate", length = 10)
	public Date getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "updateDate", length = 10)
	public Date getUpdateDate() {
		return this.updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", userEmail=" + userEmail + ", userSex=" + userSex
				+ ", createDate=" + createDate + ", updateDate=" + updateDate + "]";
	}
	

}
