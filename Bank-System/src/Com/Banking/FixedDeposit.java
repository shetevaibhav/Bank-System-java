package Com.Banking;

public class FixedDeposit extends Account {
	
	double Amount;
	double tenure;
	double IntrestEarned;
	
	public FixedDeposit() {
		super();
		// TODO Auto-generated constructor stub
	}

	public FixedDeposit(double amount, double tenure, double intrestEarned) {
		super();
		Amount = amount;
		this.tenure = tenure;
		IntrestEarned = intrestEarned;
	}

	public double getAmount() {
		return Amount;
	}

	public void setAmount(double amount) {
		
		if(amount<1000)
		{
			System.out.println("Enter your greter than thounsand ");
			
		}
		else 
		{
			this.Amount = amount;
		}
		
	}

	public double getTenure() {
		return tenure;
	}

	public void setTenure(double tenure) {//k
		if(tenure>=1&&tenure<8)
		{
			
			this.tenure = tenure;
		}
		else {
			
			System.out.println("Enter your tenure 1 to 7 ");
		}
		
	}

	public double getIntrestEarned() {
		return IntrestEarned;
	}

	public void setIntrestEarned(double intrestEarned) {
		IntrestEarned = intrestEarned;
	}

	@Override
	public String toString() {
		return "FixedDeposit [Amount=" + Amount + ", tenure=" + tenure + ", IntrestEarned=" + IntrestEarned + "]";
	}

	@Override
	public void calculate() {
		
		IntrestEarned = Amount * tenure * 0.08;
        System.out.println("Your Fixed Deposite Intrest is :- " +IntrestEarned);
		
	}
	

}
