package i2.logic;

/*Each line item has an item, item count and net payable amount.*/
public class LineItem {
	private Item item;
	private int itemCount;
	private double netPayableAmount;
	private int cnt;

	public LineItem(Item item, int itemCount) {
		this.item = item;
		this.itemCount = itemCount;
		netPayableAmount = 0;
		cnt = 0;
	}

	public LineItem() {

	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public double getNetPayableAmount() {
		return netPayableAmount;
	}

	public void setNetPayableAmount(double netPayableAmount) {
		this.netPayableAmount = netPayableAmount;
	}

	public int getItemCount() {
		return itemCount;
	}

	public void setItemCount(int itemCount) {
		this.itemCount = itemCount;
	}

	public int getCnt() {
		return cnt;
	}

	public double calculateNetPayableAmount() {
		double totalAmount = this.item.getItemCost() * this.itemCount;
		double discount = this.item.getDiscountPolicy().computeDiscount(this.itemCount, this.item.getItemCost());
		netPayableAmount = totalAmount - (this.itemCount * discount);
		cnt++;
		return netPayableAmount;
	}
}
