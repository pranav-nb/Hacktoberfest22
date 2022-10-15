/*A bill has many line items.
 You should be able to calculate the net payable amount for the bill.
  */
package i2.logic;

public class Bill {
	private LineItem[] NoOfLineItem;
	private double BillnetPayableAmount;

	public Bill() {
		BillnetPayableAmount = 0;
	}

	public double calculateBillNetPayableAmount(int noOfLineItem) {
		for(int i=0;i<noOfLineItem;i++) {
			NoOfLineItem[i]=new LineItem();
			BillnetPayableAmount=BillnetPayableAmount+NoOfLineItem[i].getNetPayableAmount();
		}
		return BillnetPayableAmount;
	}
}
