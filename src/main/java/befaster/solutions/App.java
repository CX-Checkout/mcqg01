package befaster.solutions;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class App {	
	public static int checkout(String str) {
		HashMap<Character, Integer> SKUS = getSKUS();
		HashMap<Character, OrderItem> orderItemHashMap = new HashMap<>();
		HashMap<Character, Offer> offers = getOffers();
		
		int checkoutTotalPrice = 0;
		
		for(int i = 0; i < str.length(); i++) {
			
			char SKU = str.charAt(i);
			if(SKUS.containsKey(SKU)) {
				if(orderItemHashMap.containsKey(SKU)) {
					orderItemHashMap.get(SKU).increaseAmountOfProductsByOne();
				} else {
					orderItemHashMap.put(SKU, new OrderItem(SKU, SKUS.get(SKU), 1));
				}
			} else {
				return -1;
			}
		}
		
		Set keys = orderItemHashMap.keySet();
		
		Iterator<Character> keysIterator = keys.iterator();
		while(keysIterator.hasNext()) {
			char SKUItem = keysIterator.next();
			OrderItem orderItem = orderItemHashMap.get(SKUItem);
			if(offers.containsKey(SKUItem) && offers.get(SKUItem).doesAmountCoversOffer(orderItem.getAmountOfProducts())) {
				Offer offer = offers.get(SKUItem);
				checkoutTotalPrice += offer.getPriceBasedOnOffer(orderItem.getAmountOfProducts()) + offer.getItemsNotOnOffer(orderItem.getAmountOfProducts()) * SKUS.get(SKUItem);
			} else {
				checkoutTotalPrice += orderItem.getAmountOfProducts() * SKUS.get(SKUItem);
			}
		}
		
		return checkoutTotalPrice;
	}
	
	private static HashMap<Character, Integer> getSKUS() {
		HashMap<Character, Integer> SKUS = new HashMap<>();
		SKUS.put('A', 50);
		SKUS.put('B', 30);
		SKUS.put('C', 20);
		SKUS.put('D', 15);
		SKUS.put('E', 40);
		return SKUS;
	}
	
	private static HashMap<Character, Offer> getOffers() {
		HashMap<Character, Offer> offers = new HashMap<>();
		
		offers.put('A', new Offer('A', 3, 130));
		offers.put('B', new Offer('B', 2, 45));
		return offers;
	}
}
