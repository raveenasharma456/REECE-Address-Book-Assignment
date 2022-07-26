package com.example.reeceaddressbook.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="MST_CUSTOMER_DETAILS")
public class MstCustomerDetails implements Serializable{

	private static final long serialVersionUID = 1L;

	public MstCustomerDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public MstCustomerDetails(Long custId, String firstName, String middleName, String lastName, String contactNo,
			boolean isPlumbingCustomer, boolean isTilesCustomer, Date createdDt, Date updatedDt, String createdBy,
			String updatedBy) {
		super();
		this.custId = custId;
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.contactNo = contactNo;
		this.isPlumbingCustomer = isPlumbingCustomer;
		this.isTilesCustomer = isTilesCustomer;
		this.createdDt = createdDt;
		this.updatedDt = updatedDt;
		this.createdBy = createdBy;
		this.updatedBy = updatedBy;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name="CUSTOMER_ID",nullable = false)
	private Long custId;
	@Column(name="FIRST_NAME")
	private String firstName;
	@Column(name="MIDDLE_NAME")
	private String middleName;
	@Column(name="LAST_NAME")
	private String lastName;
	@Column(name="CONTACT_NO")
	private String contactNo;
	@Column(name="IS_PLUMBING_CUSTOMER")
	private boolean isPlumbingCustomer;
	@Column(name="IS_TILES_CUSTOMER")
	private boolean isTilesCustomer;
	@Column(name="CREATED_DT")
	private Date createdDt;
	@Column(name="UPDATED_DT")
	private Date updatedDt;
	@Column(name="CREATED_BY")
	private String createdBy;
	@Column(name="UPDATED_BY")
	private String updatedBy;
	
	public Long getCustId() {
		return custId;
	}
	public void setCustId(Long custId) {
		this.custId = custId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getMiddleName() {
		return middleName;
	}
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getContactNo() {
		return contactNo;
	}
	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}
	public boolean isPlumbingCustomer() {
		return isPlumbingCustomer;
	}
	public void setPlumbingCustomer(boolean isPlumbingCustomer) {
		this.isPlumbingCustomer = isPlumbingCustomer;
	}
	public boolean isTilesCustomer() {
		return isTilesCustomer;
	}
	public void setTilesCustomer(boolean isTilesCustomer) {
		this.isTilesCustomer = isTilesCustomer;
	}
	public Date getCreatedDt() {
		return createdDt;
	}
	public void setCreatedDt(Date createdDt) {
		this.createdDt = createdDt;
	}
	public Date getUpdatedDt() {
		return updatedDt;
	}
	public void setUpdatedDt(Date updatedDt) {
		this.updatedDt = updatedDt;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public String getUpdatedBy() {
		return updatedBy;
	}
	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}
}
