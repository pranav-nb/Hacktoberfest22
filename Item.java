package i2.logic;

/*Each item has item name, item cost, a discount policy.*/
public class Item {
	private String itemName;
	private double itemCost;
	private DiscountPolicy d;

	public Item(String itemName, double itemCost) {
		this.itemName = itemName;
		this.itemCost = itemCost;
		this.setDiscountPolicy(d);
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public double getItemCost() {
		return itemCost;
	}

	public void setItemCost(double itemCost) {
		this.itemCost = itemCost;
	}

	public DiscountPolicy getDiscountPolicy() {
		return d;
	}

	public void setDiscountPolicy(DiscountPolicy d) {
		this.d = d;
	}

	public void displayItemDetails() {
		System.out.println("Item Name: " + this.itemName);
		System.out.println("Item Cost: " + this.itemCost);
	}

}
