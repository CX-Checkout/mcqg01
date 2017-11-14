package befaster.solutions;

import java.util.HashMap;

public class App {	
	public static int checkout(String str) {
		Offers offers = new Offers();
		HashMap<Character, Integer> SKUS = getSKUS();		
		HashMap<Character, OrderItem> orderItemHashMap = new HashMap<>();
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
		return offers.calculateTotalForItemsBasedOnOffers(orderItemHashMap);
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
}
