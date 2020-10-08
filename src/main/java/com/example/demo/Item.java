package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Item {

	@Id
	private int itemNo;
	private String itemName;
	private int itemQuantity;
	private int stockCode;
	
	public Item() {

	}
	
	public Item(int itemNo, String itemName, int itemQuantity, int stockCode) {
		super();
		this.itemNo = itemNo;
		this.itemName = itemName;
		this.itemQuantity = itemQuantity;
		this.stockCode = stockCode;
	}

	public int getItemNo() {
		return itemNo;
	}
	
	public void setItemNo(int itemNo) {
		this.itemNo = itemNo;
	}
	
	public String getItemName() {
		return itemName;
	}
	
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	
	public int getItemQuantity() {
		return itemQuantity;
	}
	
	public void setItemQuantity(int itemQuantity) {
		this.itemQuantity = itemQuantity;
	}
	
	public int getStockCode() {
		return stockCode;
	}
	
	public void setStockCode(int stockCode) {
		this.stockCode = stockCode;
	}
	
	@Override
	public String toString() {
		return "springBootRestController [itemNo=" + itemNo + ", itemName=" + itemName + ", itemQuantity="
				+ itemQuantity + ", stockCode=" + stockCode + "]";
	}
	
}
