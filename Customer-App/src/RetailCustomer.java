/**
 * Creating RetailCustomer a subclass of Customer
 */

import java.text.DecimalFormat;

public class RetailCustomer extends Customer{
	private double totalPurchases;
	
	public RetailCustomer(String firstName, String lastName, String customerLevel, double totalPurchases) {
		super(firstName, lastName, customerLevel);
		this.totalPurchases = totalPurchases;
	}
	
	//creating format for decimals
	DecimalFormat df = new DecimalFormat(",###.00");
	
	//generate getters and setters
	public double getTotalPurchases() {
		return totalPurchases;
	}

	public void setTotalPurchases(double totalPurchases) {
		this.totalPurchases = totalPurchases;
	}
	
	public int findDiscountRate() {
		if(totalPurchases > 10000) {
			return 15;
		}
		else if (totalPurchases > 5000) {
			return 10;
		}
		else if(totalPurchases > 1000) {
			return 5;
		}
		else {
			return 0;
		}
		
	}

	@Override
	public double incentives() {
		int discountRate = findDiscountRate();
		return totalPurchases * (discountRate/100.0);
	}

	@Override
	public String toString() {
		
		return super.toString() + "\nTotal Purchases:     $" +  df.format(totalPurchases)
				+ "\nDiscount Rate:       " + findDiscountRate() + "%\n" + "Discount Incentives: $" + df.format(incentives())
				+ "\nNet Purchases:       $" + df.format((getTotalPurchases() - incentives()));
	}
	
}

		

