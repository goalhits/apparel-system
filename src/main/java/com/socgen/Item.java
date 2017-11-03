package com.socgen;

/**
 * @author Kaushal Soni
 * This is the class which is instantiated after reading inputs
 * from command line.
 */
public class Item {
	private Integer id;
	private Brand brand;
	private ItemCategory itemCategory;
	private Integer maxRetailPrice;
	
	public Item(Integer id, Brand brand, ItemCategory itemCategory, Integer price) {
		this.id = id;
		this.brand = brand;
		this.itemCategory = itemCategory;
		this.maxRetailPrice = price;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer itemId) {
		this.id = itemId;
	}
	public Brand getBrand() {
		return brand;
	}
	public void setBrand(Brand brand) {
		this.brand = brand;
	}
	public ItemCategory getItemCategory() {
		return itemCategory;
	}
	public void setItemCategory(ItemCategory itemCategory) {
		this.itemCategory = itemCategory;
	}
	public Integer getMaxRetailPrice() {
		return maxRetailPrice;
	}
	public void setMaxRetailPrice(Integer maxRetailPrice) {
		this.maxRetailPrice = maxRetailPrice;
	}
	
}
