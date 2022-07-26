package com.example.reeceaddressbook.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="TILES_ADDRESS_BOOK")
public class TilesAddressBook implements Serializable {

	private static final long serialVersionUID = 1L;

	public TilesAddressBook() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name="TILES_ADDRESS_BOOK_ID",nullable=false)
	private Long tilesAddBookId;
	@Column(name="ORDER_AMOUNT")
	private String orderAmt;
	@Column(name="CREATED_DT")
	private Date createdDate;
	@Column(name="CREATED_BY")
	private String createdBy;
	@OneToOne
	@MapsId
	@JoinColumn(name="CUSTOMER_ID")
	private MstCustomerDetails custDetails;

	public Long getTilesAddBookId() {
		return tilesAddBookId;
	}
	public void setTilesAddBookId(Long tilesAddBookId) {
		this.tilesAddBookId = tilesAddBookId;
	}
	public String getOrderAmt() {
		return orderAmt;
	}
	public void setOrderAmt(String orderAmt) {
		this.orderAmt = orderAmt;
	}
	public Date getCreatedDate() {
		return createdDate;
	}                                                                       
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public MstCustomerDetails getCustDetails() {
		return custDetails;
	}
	public void setCustDetails(MstCustomerDetails custDetails) {
		this.custDetails = custDetails;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
}
