package dicePlayer;
import bank.Account;

public class DicePlayer {
	private Account account;
	
	public DicePlayer (Account account) 
	{
		this.account = account;
	}
	
	public void updateAccount(double amount,double payout)
	{
		account.changeBalance(amount,payout);
	}
	
	public double getAccountBalance()
	{
		return account.getBalance();
	}
	
}
