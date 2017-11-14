package befaster.solutions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class Offers {

	private HashMap<Character, ArrayList<Offer>> offersPerSKU;
	
	public Offers() {
		offersPerSKU = new HashMap<>();
		ArrayList<Offer> As = new ArrayList<Offer>();
		As.add(0, new Offer('A', 5, 200));
		As.add(1, new Offer('A', 3, 50));
		
		ArrayList<Offer> Bs = new ArrayList<>();
		Bs.add(0, new Offer('B', 2, 45));
		
		ArrayList<Offer> Es = new ArrayList<>();
		Es.add(0, new Offer('B', 2, -30));
		
		offersPerSKU.put('A', As);
		offersPerSKU.put('B', Bs);
		offersPerSKU.put('E', Es);
	}
	
	public HashMap<Character, ArrayList<Offer>> getOffersPerSKU() {
		return offersPerSKU;
	}
	
	public int calculateTotalForItemsBasedOnOffers(HashMap<Character, OrderItem> orderItemHashMap) {
		int checkoutTotalPrice = 0;
		Set keys = orderItemHashMap.keySet();
		Iterator<Character> keysIterator = keys.iterator();
		
		while(keysIterator.hasNext()) {
			char SKUItem = keysIterator.next();
			OrderItem orderItem = orderItemHashMap.get(SKUItem);
			int currentOrderItemsLeft = orderItem.getAmountOfProducts();
			
			if(offersPerSKU.containsKey(SKUItem)) {
				
				ArrayList<Offer> offersForSKU = offersPerSKU.get(SKUItem);
				Iterator<Offer> offerIterator = offersForSKU.iterator();
				
				while(offerIterator.hasNext()) {
					Offer offer = offerIterator.next();
					
					if(offer.getSku() == orderItem.getSku()) {
						if(offer.doesAmountCoversOffer(orderItem.getAmountOfProducts())) {
							checkoutTotalPrice += offer.getPriceBasedOnOffer(orderItem.getAmountOfProducts()) + offer.getItemsNotOnOffer(orderItem.getAmountOfProducts()) * orderItem.getUnitPrice();
							currentOrderItemsLeft -= offer.getItemsOnOffer(orderItem.getAmountOfProducts());
						}
					} 
					 else {
						if(keys.contains(offer.getSku()) && offer.doesAmountCoversOffer(orderItem.getAmountOfProducts())) {
							checkoutTotalPrice = checkoutTotalPrice - offer.getPrice();
						}
					}
				}
				checkoutTotalPrice += currentOrderItemsLeft * orderItem.getUnitPrice();
			} else {
				checkoutTotalPrice += orderItem.calculateTotal();
			}
		}
		return checkoutTotalPrice;
	}
}
