/**
 * Author: Yomna Farid
 * Purpose: Driver class to tests all the methods.
 * Date: 03/01/2023
 * 
 *
 */
public class CustomerTester {

	public static void main(String[] args) {
		
		//print opening prompt
		System.out.println("Welcome to the Customer tester!\r\n"
				+ "---------------------------------------------------------------------------------------\r\n"
				+ "This program will instantiate objects of the Customer hierarchy and test their methods\r\n"
				+ "---------------------------------------------------------------------------------------\r\n"
				+ "");
		
		//create an array of type Customer 
		Customer[] custArray = new Customer[3];
		
		//create three customer objects
		BusinessCustomer mikeHolmes = new BusinessCustomer("Mike", "Holmes", "Business", "Home Depot", 10, 3105.50);
		RetailCustomer devGelda = new RetailCustomer("Dev", "Gelda", "Retail", 11200.00);
		PreferredCustomer weiPing = new PreferredCustomer("Wei", "Ping", "Preferred", 6456.85, 5);
		
		//assign customer obj to element of customer array
		custArray[0] = mikeHolmes;
		custArray[1] = devGelda;
		custArray[2] = weiPing;
		
		//print objects in array
		for(int j = 0; j < custArray.length; j++) {
			System.out.println(custArray[j].toString() +"\n");
		}
	
		//create loop to print customer name and incentives
		for (int j = 0; j < custArray.length; j++) {
			System.out.println(custArray[j].getFirstName() + " " + custArray[j].getLastName() 
					+ " earns a discount incentive of $" + custArray[j].incentives());
		}
		
		//create three customer objects
		BusinessCustomer tristanLee = new BusinessCustomer("Tristan", "Lee", "Business", "Starbucks", 15, 9875.25);
		RetailCustomer carlosBeltran = new RetailCustomer("Carlos", "Beltran", "Retail", 3100.50);
		PreferredCustomer artiPatel = new PreferredCustomer("Arti", "Patel", "Preferred", 10450.00 , 10);
		
		//print customer objects using toString()
		System.out.println("\n" + tristanLee.toString() + "\n\n" + carlosBeltran.toString()
						 + "\n\n" + artiPatel.toString());
		
		//using setters to change each customer object
		
		//change totalPurchases & discountRate
		tristanLee.setTotalPurchases(8895.00);
		tristanLee.setDiscountRate(12);
		
		//change totalPurchases
		carlosBeltran.setTotalPurchases(100500.00);
	
		//change totalPurchases & LastName & cashbackRate
		artiPatel.setTotalPurchases(14987.24);
		artiPatel.setLastName("Patel-Ruhil");
		artiPatel.setCashbackRate(13);
		
		//print UPDATED customer objects using toString()
		System.out.println("\n" + tristanLee.toString() + "\n\n" + carlosBeltran.toString()
						 + "\n\n" + artiPatel.toString());
		
		
	}
	
}
