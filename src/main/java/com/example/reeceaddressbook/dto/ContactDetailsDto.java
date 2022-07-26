package com.example.reeceaddressbook.dto;

import java.util.Date;

public class ContactDetailsDto {

	private String firstName;
	private String middleName;
	private String lastName;
	private String contactNo;
	private boolean isPlumbingCustomer;
	private boolean isTilesCustomer;
	private Date createdDt;
	private String createdBy;
	
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
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	
	public ContactDetailsDto(String firstName, String middleName, String lastName, String contactNo,
			boolean isPlumbingCustomer, boolean isTilesCustomer, Date createdDt, String createdBy) {
		super();
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.contactNo = contactNo;
		this.isPlumbingCustomer = isPlumbingCustomer;
		this.isTilesCustomer = isTilesCustomer;
		this.createdDt = createdDt;
		this.createdBy = createdBy;
	}
}