package com.socgen;

/**
 * @author Kaushal Soni
 * This enum keeps all kind of consolidated item categories
 * Later we associate parent child relationship among these
 */
public enum Category {
	MensWear("Men's wear",1L, 0),
	WomensWear("Women's wear", 2L, 50),
	Shirts("Shirts", 3L, 0),
	Trousers("Trousers", 4L, 0),
	Casuals("Casuals", 5L, 30),
	Jeans("Jeans", 6L, 20),
	Dresses("Dresses", 7L, 0),
	FootWear("Footwear", 8L, 0);
	
	String caption;
	long categoryId;
	int discountPct;
	private Category(String caption, long categoryId, int discountPct) {
		this.caption = caption;
		this.categoryId = categoryId;
		this.discountPct = discountPct;
	}
	public int getDiscountPct() {
		return discountPct;
	}
	public void setDiscountPct(int discountPct) {
		this.discountPct = discountPct;
	}
	public long getCategoryId() {
		return categoryId;
	}
	public String getCaption() {
		return caption;
	}
	
	public static Category getCategoryByCaption(String caption) {
		for(Category category : values()) {
			if(category.getCaption().equals(caption)) {
				return category;
			}
		}
		return null;
	}
}
