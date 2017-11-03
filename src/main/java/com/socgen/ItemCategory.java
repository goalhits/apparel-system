package com.socgen;

/**
 * @author Kaushal Soni
 * Item category which has reference to it's parent category
 * to check for maximum discount.
 */
public class ItemCategory {
	private Category category;
	private ItemCategory parent;

	public ItemCategory(Category category) {
		this.category = category;
	}

	public ItemCategory(Category category, ItemCategory parent) {
		this.category = category;
		this.parent = parent;
	}
	
	public ItemCategory getParent() {
		return parent;
	}
	public void setParent(ItemCategory parent) {
		this.parent = parent;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
}
