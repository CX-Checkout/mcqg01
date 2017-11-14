package befaster.solutions;

public class OrderItem {

	private final char sku;
	private final int unitPrice;
	private int amountOfProducts;
	
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
	
	public void increaseAmountOfProductsByN(int increase) {
		this.amountOfProducts += increase;
	}
	
	public int getAmountOfProducts() {
		return this.amountOfProducts;
	}
}
