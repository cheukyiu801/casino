package bank;

import membership.*;
public class Account {

	private static int accountNo=10000;
	private String name;
	private double balance=1000;
	private Membership membership;
	
	public Account(String name)
	{
		accountNo++;
		this.name=name;
		this.membership = new Green();
	}
	
	public boolean checkBalance(double amount)
	{
		if(balance>=amount){
			return true;
		}else{
			return false;
		}
	}
	
	public void changeBalance(double amount,double payout)
	{
		double odds = membership.getOdds()*payout;
		if(payout!=0)
		{
			balance+=amount*odds;
		}else{
			balance-=amount*1;
		}
		upGrade(balance);	
	}
	
	public void upGrade(double balance){
			if(balance>5000)
				membership = new Gold();
	}
	
	public int getAccountNo(){
		return accountNo;
	}
	
	public String getName(){
		return name;
	}
	
	public double getBalance(){
		return balance;
	}
	
	public String getMembership(){
		return membership.getType();
	}
	
	public void getAccountInfo(){
		System.out.println("Name: "+name);
		System.out.println("Account No.: "+accountNo);
		System.out.println("Balance: "+balance);
		System.out.println("Membership: "+membership.getType());
	}
}
