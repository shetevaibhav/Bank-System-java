package Com.Banking;

import java.util.Scanner;

import bank.Exception.CustomeException;

public class SavingAccount extends Account {

	boolean isSalaryAccount;
	double minimumBalance = 5000;

	public SavingAccount() {
		super();
		// TODO Auto-generated constructor stub
	}

//	public SavingAccount(long accountnumber, String ifsccode, String bankname, double balance, String openingdate,
//			Customer customer) {
//		super(accountnumber, ifsccode, bankname, balance, openingdate, customer);
//		
//	}


//
	public SavingAccount(long accountnumber, String ifsccode, String bankname, double balance, String openingdate,
			Customer customer, boolean isSalaryAccount) {
		super(accountnumber, ifsccode, bankname, balance, openingdate, customer);
		this.isSalaryAccount = isSalaryAccount;
		// this.minimumBalance = minimumBalance;

		try {

			if (isSalaryAccount == false && balance < 5000) {
				throw new CustomeException("Your Account is not created Enter more than 5000 :- ");
			} else {
				System.out.println("created");
			}
		}

		catch (CustomeException e) {

			e.printStackTrace();
		}
	}


	public boolean isSalaryAccount() {
		return isSalaryAccount;
	}

	public void setSalaryAccount(boolean isSalaryAccount) {
		this.isSalaryAccount = isSalaryAccount;
	}

	public double getMinimumBalance() {
		return minimumBalance;
	}

	public void setMinimumBalance(double minimumBalance) {
		this.minimumBalance = minimumBalance;
	}

	@Override
	public String toString() {
		return "SavingAccont [isSalaryAccount=" + isSalaryAccount + ", minimumBalance=" + minimumBalance + "]";
	}

	@Override
	public void calculate() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter your amount:-  ");
		double amount=sc.nextDouble();
		System.out.print("Enter your year :- ");
		double year=sc.nextDouble();
		
		double Intrest=amount*year*0.04;
		System.out.println("Your Saving amount interest is :- " +Intrest);
		
		
		

	}

}
