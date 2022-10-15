/*Derive a class BuyNItemsGetOneFree from DiscountPolicy as described above. 
 * The class should have a constructor that has a single parameter n.
 *  In addition, the class should define the method computeDiscount 
 *  so that every nth item is free.
 *  For example, the following table gives the discount 
 *  for the purchase of various counts of an item that costs ₹100,
 *   when n is 3 
 *            Count    1 2 3  4  5  6  7  8  9  10 11 12
 *            Discount 0 0 10 10 10 20 20 20 30 30 30 40
 */
package i2.logic;

public class BuyNItemsGetOneFree extends DiscountPolicy {
    int n;
	public BuyNItemsGetOneFree(int n) {
		this.n=n;
	}
	public double computeDiscount(int noOfItems, double itemCost) {
		if((noOfItems/n)>=1) {
			noOfItems=noOfItems/n;
			return 10.0*noOfItems;
		}
		return (10.0*0);
	}

}
