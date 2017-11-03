package com.socgen;

import java.util.Collection;

/**
 * @author Kaushal Soni
 * This is actuall class which aplies business logic
 * as per problem descirption
 */
public class ItemPriceCalculator {
	public Integer calculateDiscountedPrice(Collection<Item> items) {
		int discountedPrice = 0;
		for(Item obj : items) {
			// Calcualte best discount percentage
			Integer discountedPct = findDiscountedPct(obj);
			discountedPrice += (obj.getMaxRetailPrice() * (100-discountedPct))/100;
		}
		return discountedPrice;
	}

	private Integer findDiscountedPct(Item item) {
		ItemCategory itemCategory = item.getItemCategory();
		int maxPct = 0;
		do {
			maxPct = Math.max(maxPct, itemCategory.getCategory().getDiscountPct());
			itemCategory = itemCategory.getParent();
		} while(itemCategory != null);
		
		maxPct = Math.max(maxPct, item.getBrand().getDiscountPct());
		return maxPct;
	}
}
