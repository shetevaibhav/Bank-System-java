package Com.Banking;

import java.io.Serializable;
import java.sql.Date;

public abstract class Account implements Serializable{
	
	long Accountnumber;
	String Ifsccode;
	String Bankname;
	double Balance;
	String Openingdate;
	Customer customer;
	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Account(long accountnumber, String ifsccode, String bankname, double balance, String openingdate,
			Customer customer) {
		super();
		Accountnumber = accountnumber;
		Ifsccode = ifsccode;
		Bankname = bankname;
		Balance = balance;
		this.Openingdate = openingdate;
		this.customer = customer;
	}
	public long getAccountnumber() {
		return Accountnumber;
	}
	public void setAccountnumber(long accountnumber) {
		Accountnumber = accountnumber;
	}
	public String getIfsccode() {
		return Ifsccode;
	}
	public void setIfsccode(String ifsccode) {
		Ifsccode = ifsccode;
	}
	public String getBankname() {
		return Bankname;
	}
	public void setBankname(String bankname) {
		Bankname = bankname;
	}
	public double getBalance() {
		return Balance;
	}
	public void setBalance(double balance) {
		Balance = balance;
	}
	
	
	public String getOpeningdate() {
		return Openingdate;
	}
	public void setOpeningdate(String openingdate) {
		 boolean validDate = Utility.validDate(openingdate);
	        if(validDate==false)
	        {
	            //enter date again
	            System.out.println("Please Re enter Date of Birth,,,,,");
	        }
	        else
	        {
	        	this.Openingdate = openingdate;
	        }
		
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	@Override
	public String toString() {
		return "Account [Accountnumber=" + Accountnumber + ", Ifsccode=" + Ifsccode + ", Bankname=" + Bankname
				+ ", Balance=" + Balance + ", Openingdate=" + Openingdate + ", customer=" + customer + "]";
	}
	
	public abstract void calculate();
	

}
