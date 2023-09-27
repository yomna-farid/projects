/**
 * 
 */

/**
 * @author yomna
 *
 */
import java.util.Random;

public abstract class Customer{
	private String firstName;
	private String lastName;
	private String customerID;
	private String customerLevel;

	public Customer(String firstName, String lastName, String customerLevel) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.customerLevel = customerLevel;
		setCustomerID();
		
	}
	
	//generate getters and setters
	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}
	
	public String getCustomerID() {
		return customerID;
	}

	public String getCustomerLevel() {
		return customerLevel;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	private void setCustomerID() {
		String id = lastName.toUpperCase();
			if(id.length() < 4) {
				id += "X".repeat(4 - id.length());
			}
			    id+= "-";
			    	
			Random rndm = new Random();
			for(int j = 0; j < 5; j++) {
				id += rndm.nextInt(10);
			}
		
			this.customerID = id;
		}
	
	public void setCustomerLevel(String customerLevel) {
		this.customerLevel = customerLevel;
	}
	
	public abstract double incentives();

	
	public String toString() {
		return customerID + ", " + firstName + " " + lastName + "\n" + customerLevel + " Customer";
	}
	

}

	
