package Com.Banking;

import java.io.Serializable;

public class Customer implements Serializable {
	
	int CustomerId;
	String CustomerName;
	int CustomerAge;
	int CustomerMobile;
	String customerAdharcard;
	String CustomerDob;
	//Account account;
	SavingAccount saving;
	
	
	public SavingAccount getSaving() {
		return saving;
	}


	public void setSaving(SavingAccount saving) {
		this.saving = saving;
	}


	public static int id=100;

	public Customer(String customerName, int customerAge, int customerMobile,
			String customerAdharcard,String CustomerDob) {
		super();
		CustomerId = id++;
		CustomerName = customerName;
		CustomerAge = customerAge;
		CustomerMobile = customerMobile;
		this.customerAdharcard = customerAdharcard;
		this.CustomerDob=CustomerDob;
	}

	
//	public Account getAccount() {
//		return account;
//	}
//
//
//	public void setAccount(Account account) {
//		this.account = account;
//	}


	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getCustomerId() {
		return CustomerId;
	}

	public void setCustomerId() {
		CustomerId = id++;
	}

	public String getCustomerName() {
		return CustomerName;
	}

	public void setCustomerName(String customerName) {
		CustomerName = customerName;
	}
	public String getCustomerDob() {
		return CustomerDob;
	}

	public void setCustomerDob(String customerDob) {
	   boolean validDate = Utility.validDate(customerDob);
        if(validDate==false)
        {
            //enter date again
            System.out.println("Please Re enter Date of Birth,,,,,");
        }
        else
        {
        	this.CustomerDob = customerDob;
        }
		
	}
	public int getCustomerAge() {
		return CustomerAge;
	}

	public void setCustomerAge(int customerAge) {
		CustomerAge = customerAge;
	}

	public int getCustomerMobile() {
		return CustomerMobile;
	}

	public void setCustomerMobile(int customerMobile) {
		CustomerMobile = customerMobile;
	}

	public String getCustomerAdharcard() {
		return customerAdharcard;
	}

	public void setCustomerAdharcard(String customerAdharcard) {
		this.customerAdharcard = customerAdharcard;
	}

	public static int getId() {
		return id;
	}

	public static void setId(int id) {
		Customer.id = id;
	}


	@Override
	public String toString() {
		return "Customer [CustomerId=" + CustomerId + ", CustomerName=" + CustomerName + ", CustomerAge=" + CustomerAge
				+ ", CustomerMobile=" + CustomerMobile + ", customerAdharcard=" + customerAdharcard + ", CustomerDob="
				+ CustomerDob +  "]";
	}

		
	
	
	
	

}
