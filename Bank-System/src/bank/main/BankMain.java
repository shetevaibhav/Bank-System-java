package bank.main;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Com.Banking.Account;
import Com.Banking.Customer;
import Com.Banking.FixedDeposit;
import Com.Banking.SavingAccount;
import bank.datasource.DataStore;

public class BankMain {

	public static void main(String[] args) {
		
		Scanner sc= new Scanner(System.in);
		int choice;
		Customer cs = new Customer();
		FixedDeposit fx= new FixedDeposit();
		SavingAccount sav= new SavingAccount();
		DataStore data= new DataStore();
		
		
		List<Customer> custm= new ArrayList<Customer>();
		List<Account> acct= new ArrayList<Account>();
		
		
		while(true)
		{
			System.out.println("Enter your Choice : - ");
			System.out.println("\n 1.Create New Customer: "
					+ "\n 2.Create New Account:" + "\n 3.Display Customer Balance or Intrest : "
							+ "\n 4.Show Sorted Customer :"+"\n 5.Persist Customer :"+"\n 6.Show all customer data "
									+ "\n 7.Search By Name Customer data "+"\n 8.Exit");
			choice=sc.nextInt();
			
			switch(choice)
			{
			  case 1:
				  System.out.println("Enter your details  "+" "
				  		+ " "+"\n Name"+" "+ "age"+" "+"mobile"+" "+ "adharcard");
				  System.out.println("Add Name: - ");
				  String name=sc.next();//nextLine giving the error
				  System.out.println("Add Age:- ");
				  int age= sc.nextInt();
				  System.out.println("Add MobileNumber:- ");
				  int mobile=(int) sc.nextLong();
				  System.out.println("Add AdharNumber :- ");
				  String adharcard=sc.next();
				  System.out.println("Add DoB :- ");
				  String d=sc.next();
				  cs.setCustomerDob(d);
				  cs= new Customer(name,age,mobile,adharcard,d);
				  custm.add(cs);
				  System.out.println("Choose Option 2 for Create Acccont:");
				  break;
			  case 2:
				  
				  System.out.println("Enter your details  "
					  		+ " Account Number"+ " IFSC code"+" Add Bank Name"+ "Add Balance" +"opening date");
				  
//				  System.out.println("Add Account Number :- ");
//				  long Accnum=sc.nextLong();
//				  System.out.println("Add Ifsc code :- ");
//				  String ifsccode=sc.next();
//				  System.out.println("Add BankName :- ");
//				  String bankname=sc.next();
//				  System.out.println("Add Balance");
//				  double balance=sc.nextDouble();
//				  System.out.println("Add date");
//				  String date=sc.next();
				  
				  System.out.println("Add Account Number :- ");
				  long Accnum=sc.nextLong();
				  System.out.println("Add Ifsc code :- ");
				  String ifsccode=sc.next();
				  System.out.println("Add BankName :- ");
				  String bankname=sc.next();
				  System.out.println("Enter true or false for salary Account :");
				  boolean isac=sc.nextBoolean();
				  System.out.println("Add Balance");
				  double balance=sc.nextDouble();
				  System.out.println("Add date");
				  String date=sc.next();
				  
				  sav=new SavingAccount(Accnum, ifsccode, bankname, balance, date, cs, isac);
				  cs.setSaving(sav);
				
//				  ac=new Account(Accnum,ifsccode,bankname,balance,date, cs);
//				  acct.add(ac);
//				  cs.setAccount(ac);
//				  System.out.println(ac.getCustomer().getCustomerName()+" "+ac.getOpeningdate()+" "+ac.getAccountnumber()+"Account is created: ");
				  break;
				  
			  case 3:
				  System.out.print("\n Enter your choice :- \n 1.display balance \n 2.deposite balance \n 3.withdraw balance "
				  		+ "\n 4.fixed deposite Interest calculator \n 5.saving Account Interest calculate ");
				  int c = sc.nextInt();
				  int accno;
				  double amount;
				  
				  switch(c)
				  {
				  case 1:
					  System.out.println("Enter your Account Number:- ");
				      accno=sc.nextInt();
				      double showbalance = data.showbalance(accno);
				      System.out.println("Your Account Number :- "+accno+" "+"Your balance is :- "+showbalance);
					  break;
					  
				  case 2:
					  System.out.println("Enter your Account Number:- ");
					  accno=sc.nextInt();
					  System.out.println("Enter your Amount for deposite :-");
					  amount=sc.nextInt();
					  data.DepositeAmount(accno, amount);
					  break;
					  
				  case 3 :
					  System.out.println("Enter your Account Number:- ");
					  accno=sc.nextInt();
					  System.out.println("Enter your Amount for deposite :-");
					  amount=sc.nextInt();
					  data.withdrawAmount(accno, amount);
					  break;
					  
				  case 4:
					  
					    System.out.println("Enter you deposite amound :-");				        
				        double amt = sc.nextDouble();
				        System.out.println("Enter your tenure :-");
				        double tenure =sc.nextDouble();
				        fx.setAmount(amt);
				        fx.setTenure(tenure);
				        fx.calculate();
					    break;
					    
				  case 5:

					  sav.calculate();
					    break;
					 
					  
				  }
	 
			  case 4:
				 
				  custm.sort((o1, o2)->o1.getCustomerName().compareTo(o2.getCustomerName()));
	                for(Customer w :custm)
	                {
	                	System.out.println("Name: - "+w.getCustomerName()+"  "+"CustomerId : - " +w.getCustomerId());
	                }
				  break;
				  
				  
			  case 5:
				  System.out.print("Enter your choice:-\n 1.Data Storing  \n 2.File Storing");
				  
				  int w=sc.nextInt();
				  switch(w)
				  {
				     case 1:
				    	
					     data.SaveAllCustomer(custm);
				    	 break;
				    	 
				     case 2:
				    	try {
				    		 FileOutputStream f=new FileOutputStream("data.txt");    //Save file system
					         ObjectOutputStream out=new ObjectOutputStream(f); 
					         out.writeObject(cs);
					         out.flush();    
					          out.close();    
					          f.close();    
					          System.out.println(" File created success!!!!!");
					         
						}
				    	catch (Exception e)
				    	{
							
				    		e.printStackTrace();
						}
				    	 break;
				  }

			  case 6:
				 
			      data.retriveAllCustomer();
			      System.out.println();
				  break;
				  
				  
			  case 7:
				  System.out.println("Enter your name for search :-");
				  String cname=sc.next();
				  DataStore dm= new DataStore();
			      dm.retriveByName(cname);
				  break;
				  
				  
			  case 8:
				  System.exit(0);
				  break;
			}
			
		}

	}

}
