package com.his.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.UpdateTimestamp;


@Entity
@Table(name="user_detail")
public class UserEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="userid")
	private Integer userId;
	@Column(name="first_name")
	private String userFristName;;
	@Column(name="last_name")
	private String userLastName;
	@Column(name="email")
	private String userEmail;
	@Column(name="enabled", nullable = false)            
	@Type(type = "org.hibernate.type.NumericBooleanType")
	private boolean enable=true;
	@Column(name="contact_number")
	private String userPhoneNo;
	@Column(name="pazzword")
	private String userPazzword;
	@Column(name="acc_status")
    private String accstatus;
	@Column(name="gender")
    private String gender;
    @Column(name = "role_id")
    private  Integer roleId;
	@Column(name="create_date",updatable = false)
	@CreationTimestamp
	@Temporal(TemporalType.DATE)
    private Date createDate;
	@Column(name="update_date",insertable = false)
	@UpdateTimestamp
	@Temporal(TemporalType.DATE)
    private Date updateDate;
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public Date getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getUserFristName() {
		return userFristName;
	}
	public void setUserFristName(String userFristName) {
		this.userFristName = userFristName;
	}
	public String getUserLastName() {
		return userLastName;
	}
	public void setUserLastName(String userLastName) {
		this.userLastName = userLastName;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getUserPhoneNo() {
		return userPhoneNo;
	}
	public void setUserPhoneNo(String userPhoneNo) {
		this.userPhoneNo = userPhoneNo;
	}
	public String getUserPazzword() {
		return userPazzword;
	}
	public void setUserPazzword(String userPazzword) {
		this.userPazzword = userPazzword;
	}
	public String getAccstatus() {
		return accstatus;
	}
	public void setAccstatus(String accstatus) {
		this.accstatus = accstatus;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}

	public Integer getRoleId() {
		return roleId;
	}
	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}
	public boolean isEnable() {
		return enable;
	}
	public void setEnable(boolean enable) {
		this.enable = enable;
	}
	 
    
    
}
