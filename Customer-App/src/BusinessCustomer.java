/**
 * Creating BusinessCustomer a subclass of Customer 
 */
import java.text.DecimalFormat;

public class BusinessCustomer extends Customer{
	private String companyName;
	private int discountRate;
	private double totalPurchases;
	
	public BusinessCustomer(String firstName, String lastName, String customerLevel, 
			String companyName, int discountRate, double totalPurchases) {
		super(firstName, lastName, customerLevel);
		this.companyName = companyName;
		this.discountRate = discountRate;
		this.totalPurchases = totalPurchases;
		
	}
	
	//creating format for decimals
	DecimalFormat df = new DecimalFormat(",###.00");
	
	//generate getters and setters
	public String getCompanyName() {
		return companyName;
	}

	public int getDiscountRate() {
		return discountRate;
	}

	public double getTotalPurchases() {
		return totalPurchases;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public void setDiscountRate(int discountRate) {
		this.discountRate = discountRate;
	}

	public void setTotalPurchases(double totalPurchases) {
		this.totalPurchases = totalPurchases;
	}
	
	
	@Override
	public double incentives() {
		return totalPurchases * (discountRate/100.0);
	}

	@Override
	public String toString() {
		return super.toString() + " for " + companyName + "\nTotal Purchases:     $"
				+ df.format(totalPurchases) + "\nDiscount Rate:       " + discountRate + 
				"%\nDiscount Incentive:  $" + df.format(incentives()) + "\nNet Purchases:       $" + df.format((getTotalPurchases() - incentives()));
	}
}