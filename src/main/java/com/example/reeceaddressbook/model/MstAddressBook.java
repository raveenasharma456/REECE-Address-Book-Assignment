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
@Table(name="MST_ADDRESS_BOOK")
public class MstAddressBook implements Serializable {

	private static final long serialVersionUID = 1L;

	public MstAddressBook() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name="ADDRESS_BOOK_TYPE",nullable=false)
	private Integer addressBookType;
	@Column(name="ADDRESS_BOOK_TYPE_NAME")
	private String addressBookTypeName;
	@Column(name="CREATED_DT")
	private Date createdDt;
	@Column(name="CREATED_BY")
	private String createdBy;
	
	public MstAddressBook(Integer addressBookType, String addressBookTypeName, Date createdDt, String createdBy,
			PlumbingAddressBook plumbAddressBook, TilesAddressBook tilesAddressBookId) {
		super();
		this.addressBookType = addressBookType;
		this.addressBookTypeName = addressBookTypeName;
		this.createdDt = createdDt;
		this.createdBy = createdBy;
	}
	
	@Override
	public String toString() {
		return "MstAddressBook [addressBookType=" + addressBookType + ", addressBookTypeName=" + addressBookTypeName
				+ ", createdDt=" + createdDt + ", createdBy=" + createdBy + "]";
	}	
	public Date getCreatedDt() {
		return createdDt;
	}
	public Integer getAddressBookType() {
		return addressBookType;
	}

	public void setAddressBookType(Integer addressBookType) {
		this.addressBookType = addressBookType;
	}

	public String getAddressBookTypeName() {
		return addressBookTypeName;
	}

	public void setAddressBookTypeName(String addressBookTypeName) {
		this.addressBookTypeName = addressBookTypeName;
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
	
}
