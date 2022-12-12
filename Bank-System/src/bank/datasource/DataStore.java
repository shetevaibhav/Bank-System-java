package bank.datasource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import Com.Banking.Customer;

public class DataStore {

	public void SaveAllCustomer(List<Customer> custm) {
		Connection conn = Connect.getConnection();

		try {
			for (Customer c : custm) {

				PreparedStatement ps = conn.prepareStatement("insert into customer values (" + c.getCustomerId() + ",'"
						+ c.getCustomerName() + "'," + c.getCustomerAge() + ",'" + c.getCustomerMobile() + "',"
						+ c.getCustomerAdharcard() + ",'" + c.getCustomerDob() + "'," + c.getSaving().getAccountnumber()
						+ ",'" + c.getSaving().getIfsccode() + "','" + c.getSaving().getBankname() + "',"
						+ c.getSaving().getBalance() + ",'" + c.getSaving().getOpeningdate() + "',"+c.getSaving().isSalaryAccount()+")");
				int i = ps.executeUpdate();
				if (i == 1) {
					System.out.println("Your data is saved succefully :");
				}

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally
		{
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
	
	

	public void retriveAllCustomer() {
		Connection conn = Connect.getConnection();
		PreparedStatement p = null;
		ResultSet rs = null;

		String sql = "select * from customer";
		try {
			p = conn.prepareStatement(sql);
			rs = p.executeQuery();

			while (rs.next()) {

				int id = rs.getInt("customerId");
				String name = rs.getString("customername");
				int age = rs.getInt("customerage");
				String mobile = rs.getString("customermobile");
				int adharcard = rs.getInt("customeradharcard");
				String Dob = rs.getString("Dob");
				String Accountnumber = rs.getString("accountNo");
				String ifsccode = rs.getString("ifscCode");
				String bankname = rs.getString("BankName");
				double balance = rs.getDouble("balance");
				String opendate = rs.getString("OpenDate");

				System.out.println("customerId : - " + id + "\t\t" + "CustomerName : -" + name + " " + "\t\t"
						+ "Customerage : -" + age + "\t\t" + "customermobile: - " + mobile + "\t\t"
						+ "Customeradharcard : - " + adharcard + "\t\t" + "CustomerDoB : - " + Dob + "\t\t"
						+ "CustomerAccontnumber : - " + Accountnumber + "\t\t" + "Customerifsc : -" + ifsccode + "\t\t"
						+ "Customerbankname : -" + bankname + "\t\t" + "Customerbalance : -" + balance + "\t\t"
						+ "CustomerOpeningdate : -" + opendate);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		finally
		{
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void retriveByName(String cname) {
		Connection conn = Connect.getConnection();
		PreparedStatement p = null;
		ResultSet rs = null;

		String sql = "select * from customer where customername='" + cname + "'";
		try {
			p = conn.prepareStatement(sql);
			rs = p.executeQuery();

			while (rs.next()) {

				int id = rs.getInt("customerId");
				String name = rs.getString("customername");
				int age = rs.getInt("customerage");
				String mobile = rs.getString("customermobile");
				int adharcard = rs.getInt("customeradharcard");
				String Dob = rs.getString("Dob");
				String Accountnumber = rs.getString("accountNo");
				String ifsccode = rs.getString("ifscCode");
				String bankname = rs.getString("BankName");
				double balance = rs.getDouble("balance");
				String opendate = rs.getString("OpenDate");

				System.out.println("customerId : - " + id + "\t\t" + "CustomerName : -" + name + " " + "\t\t"
						+ "Customerage : -" + age + "\t\t" + "customermobile: - " + mobile + "\t\t"
						+ "Customeradharcard : - " + adharcard + "\t\t" + "CustomerDoB : - " + Dob + "\t\t"
						+ "CustomerAccontnumber : - " + Accountnumber + "\t\t" + "Customerifsc : -" + ifsccode + "\t\t"
						+ "Customerbankname : -" + bankname + "\t\t" + "Customerbalance : -" + balance + "\t\t"
						+ "CustomerOpeningdate : -" + opendate);

				// System.out.println("CustomerAccountNo : - "+Accountnumber +
				// "\t\t"+"CustomerName : -" + name +" "+"Customerbalance : -" + balance);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		finally
		{
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public double showbalance(int accno) {
		Connection conn = Connect.getConnection();
		PreparedStatement p = null;
		ResultSet rs = null;

		String sql = "select * from customer where accountNo='" + accno + "'";
		try {
			p = conn.prepareStatement(sql);
			rs = p.executeQuery();

			while (rs.next()) {

				int id = rs.getInt("customerId");
				double balance = rs.getDouble("balance");
			
				return balance;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
		
		
	}
	
	//issalary column fetching
	
	
	public boolean issalary(int accno) {
		Connection conn = Connect.getConnection();
		PreparedStatement p = null;
		ResultSet rs = null;

		String sql = "select * from customer where accountNo='" + accno + "'";
		try {
			p = conn.prepareStatement(sql);
			rs = p.executeQuery();

			while (rs.next()) {

				
				boolean issal=rs.getBoolean("issalary");
				
				return issal;
					
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;

	}
	
	//issalry column fetching end

	public void DepositeAmount(int accno, double amount) 
	{
		Connection conn = Connect.getConnection();
		double oldbal = showbalance(accno); //1 
		double total = amount + oldbal;

		try {

			PreparedStatement ps = conn.prepareStatement("update customer set balance=" + total + " where accountNo=" + accno + "");
			int i = ps.executeUpdate();
			if (i == 1) {
				System.out.println("Your amount deposite... :");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		finally
		{
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	
		public void withdrawAmount(int accno, double amount) 
		{
			Connection conn = Connect.getConnection();
			double oldbal = showbalance(accno);
			boolean sal = issalary(accno); //1 
			double total ;
			
     
			try {
				if(sal==false && oldbal<=(amount+5000))
				{
					System.out.print("Account has insufficient Balance !!!");
				}

				else {
					    
					    if(oldbal>0) {
					    	total = oldbal-amount;
					    	PreparedStatement ps = conn
									.prepareStatement("update customer set balance=" + total + " where accountNo=" + accno + "");
							int i = ps.executeUpdate();
							if (i == 1) {
								System.out.println("Your amount withdraw :");
							}
					    	
					    }
					    else {
					    	    System.out.println("isufficient Balance !");
					    }
						
						
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}

			finally
			{
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
	}
}
