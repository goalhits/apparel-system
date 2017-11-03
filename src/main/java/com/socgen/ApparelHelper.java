package com.socgen;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Kaushal Soni
 * This is helper class which bridge inputs provided through
 * command line
 */
public class ApparelHelper {
	private Scanner scanner;
	private PrintStream printStream;
	private Map<String, ItemCategory> mapOfCategory;
	private List<Integer> results;
	
	
	public ApparelHelper(Scanner scanner,
      PrintStream printStream) {
		this.scanner = scanner;
		this.printStream = printStream;
	}
	
	public void associateItemCategories() {
		Category[]  categories = Category.values();
		//prepare map for different categories, key as caption and value as ItemCategory for each.
		this.mapOfCategory = Stream.of(categories).collect(Collectors.toMap(Category::getCaption, category -> new ItemCategory(category)));
		//Set parent for corresponding category
		Stream.of(categories).forEach(category -> populateParentValue(category));
		
		this.results = new ArrayList<>();
	}

	private void populateParentValue(Category category) {
		ItemCategory itemCategory = mapOfCategory.get(category.getCaption());
		if(category.equals(Category.Shirts)) {
			itemCategory.setParent(mapOfCategory.get(Category.MensWear.getCaption()));
		} else if(category.equals(Category.Trousers)) {
			itemCategory.setParent(mapOfCategory.get(Category.MensWear.getCaption()));
		} else if(category.equals(Category.Casuals)) {
			itemCategory.setParent(mapOfCategory.get(Category.Trousers.getCaption()));
		} else if(category.equals(Category.Jeans)) {
			itemCategory.setParent(mapOfCategory.get(Category.Trousers.getCaption()));
		} else if(category.equals(Category.Dresses)) {
			itemCategory.setParent(mapOfCategory.get(Category.WomensWear.getCaption()));
		} else if(category.equals(Category.FootWear)) {
			itemCategory.setParent(mapOfCategory.get(Category.WomensWear.getCaption()));
		}
	}

	public Map<Integer, Item> prepareListItem() throws Exception {
		
		Map<Integer, Item> map = new HashMap<Integer, Item>();
		String input = ApparelUtil.readNextLine(scanner);
			
		Integer numOfItem = Integer.parseInt(input);
	    for(int i = 0; i < numOfItem; i++) {
	    	input = ApparelUtil.readNextLine(scanner);
	        Item item = parseUserInput(input);
	        map.put(item.getId(), item);
	    }	    	
	     return map;
	  }
	
	  private Item parseUserInput(String input) throws Exception {
		    String[] posInput = input.split(",");
		    if (posInput.length != 4) {
		      throw new Exception("Not proper input");
		    }
		    int itemId;
		    int price;
		    ItemCategory itemCategory = null;
		    Brand brand = null;
		    try {
		      itemId = Integer.parseInt(posInput[0]);
		      brand = Brand.getBrandByCaption(posInput[1].trim());
		      if(brand == null) {
		    	  throw new Exception("Brand doesn't exist, pleaes pass correct brand name");
		      }
		      
		      Category category = Category.getCategoryByCaption(posInput[2].trim());
		      if(category == null) {
		    	  throw new Exception("Category doesn't exist, please pass correct category");
		      }
		      itemCategory = mapOfCategory.get(category.getCaption());
		      price = Integer.parseInt(posInput[3]);
		    } catch (NumberFormatException e) {
		    	throw new Exception("Exceptiond occured converting string to number"); 
		    }
		    
		    Item item = new Item(itemId, brand, itemCategory, price);
		    return item;
		  }

	public void runQueries(Map<Integer, Item> map) {
		String input = ApparelUtil.readNextLine(scanner);
		Integer totalQueries = Integer.parseInt(input);
		for (int i = 0; i < totalQueries; i++) {
			List<Item> itemList = new ArrayList<Item>();
			input = ApparelUtil.readNextLine(scanner);
			String[] allItemIds = input.split(",");
			for (String eachItem : allItemIds) {
				itemList.add(map.get(Integer.parseInt(eachItem)));
			}
			ItemPriceCalculator calculator = new ItemPriceCalculator();
			Integer sum = calculator.calculateDiscountedPrice(itemList);
			results.add(sum);
		}
	}
	
	public void printResults() {
		ResultsPrinter resultsPrinter = new ResultsPrinter(printStream);
		results.forEach((sum -> resultsPrinter.printResult(sum)));
	}

	public void execute() throws Exception {
		associateItemCategories();
		Map<Integer, Item> map = prepareListItem();
		runQueries(map);
		printResults();
	}

}
