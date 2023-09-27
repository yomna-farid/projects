/**
 * Creating PreferredCustomer a subclass of RetailCustomer
 */

public class PreferredCustomer extends RetailCustomer {
	private int cashbackRate;
	
	//
	public PreferredCustomer (String firstName, String lastName, String customerLevel, double totalPurchases, int cashbackRate) {
		super(firstName, lastName, customerLevel, totalPurchases);
		this.cashbackRate = cashbackRate;
	}
	
	//generate getters and setters
	public int getCashbackRate() {
		return cashbackRate;
	}

	public void setCashbackRate(int cashbackRate) {
		this.cashbackRate = cashbackRate;
	}

	@Override
	public double incentives() {
		return (super.incentives() * (cashbackRate/100.0)) + super.incentives();
	}

	@Override
	public String toString() {
		return super.toString() + "\nCashback Rate:       " + cashbackRate + "%";
	}

	
	
	
	
}
