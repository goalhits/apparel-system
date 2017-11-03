package com.socgen;

public enum Brand {
	Wrangler("Wrangler",10), 
	Arrow("Arrow",20), 
	VeroModa("Vero Moda",60), 
	UCB("UCB",0), 
	Adidas("Adidas",5), 
	Provogue("Provogue",20);
	
	private String caption;
	private Integer discountPct;
	private Brand(String caption, Integer discountPct) {
		this.caption = caption;
		this.discountPct = discountPct;
	}
	public Integer getDiscountPct() {
		return discountPct;
	}
	public void setDiscountPct(Integer discountPct) {
		this.discountPct = discountPct;
	}
	public String getCaption() {
		return caption;
	}
	
	public static Brand getBrandByCaption(String caption) {
		for(Brand brand : values()) {
			if(brand.getCaption().equals(caption)) {
				return brand;
			}
		}
		return null;
	}
}
