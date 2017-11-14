package befaster.solutions;

public class Offer {
	
	private final char sku;
	private final int amountOnOffer;
	private final int price;
	
	public Offer(char sku, int amountOnOffer, int price) {
		this.sku = sku;
		this.amountOnOffer = amountOnOffer;
		this.price = price;
	}
	
	public boolean doesAmountCoversOffer(int amount) {
		return amount >= this.amountOnOffer;
	}
	
	public int getPriceBasedOnOffer(int amountOfSKU) {
		int timesOfTheOffer = amountOfSKU / this.amountOnOffer;
		return this.price * timesOfTheOffer;
	}
	
	public int getItemsNotOnOffer(int amountOfSKU) {
		return amountOfSKU % this.amountOnOffer;
	}
}
