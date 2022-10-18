package i2.logic;

public class BulkDiscount extends DiscountPolicy {
	private int minimumQuantity;
	private double percentDiscount;

	public BulkDiscount(int minimumQuantity, double percentDiscount) {
		//super(minimumQuantity, percentDiscount);
		this.minimumQuantity = minimumQuantity;
		this.percentDiscount = percentDiscount;

	}

	public double computeDiscount(int noOfItems, double itemCost) {
        if(noOfItems>minimumQuantity) {
        	return (this.percentDiscount*itemCost)/100;
        }
        else{
        	return 0;	
        }
	}
}
