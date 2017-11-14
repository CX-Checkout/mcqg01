package befaster.solutions;

public class OrderItem {

	private final char sku;
	private final int unitPrice;
	private int amountOfProducts;
	private int finalPrice;
	
	public OrderItem(char sku, int unitPrice, int amountOfProducts) {
		this.sku = sku;
		this.unitPrice = unitPrice;
		this.amountOfProducts = amountOfProducts;
	}

	public int calculateTotal() {
		return this.amountOfProducts * this.unitPrice;
	}
	
	public void increaseAmountOfProductsByOne() {
		this.amountOfProducts += 1;
	}
	
	public int getAmountOfProducts() {
		return this.amountOfProducts;
	}
	
	public int getUnitPrice() {
		return this.unitPrice;
	}
	
	public char getSku() {
		return this.sku;
	}
	
	public void setFinalPrice(int price) {
		this.finalPrice = (price == 0) ? this.calculateTotal() : price;
	}
	
	public int getFinalPrice() {
		return (this.finalPrice == 0) ? this.calculateTotal() : this.finalPrice;
	}
}
