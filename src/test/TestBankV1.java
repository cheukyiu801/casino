package test;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

import bank.Account;
import bank.Bank;

public class TestBankV1 
{
    
	@Test
	public void testCreateAccount_1() { 
		Bank bankV1 = Bank.getInstance();
		Account accountV1 = bankV1.createAccount("Peter");
		assertEquals("Peter", accountV1.getName());
	}
	
	@Test
	public void testCreateAccount_2() { 
		Bank bankV1 = Bank.getInstance();
		Account accountV1 = bankV1.createAccount("");
		assertEquals("", accountV1.getName());
	}
	
	@Test
	public void testCreateAccount_3() { 
		Bank bankV1 = Bank.getInstance();
		Account accountV1 = bankV1.createAccount(";'.");
		assertEquals(";'.", accountV1.getName());
	}
	
	@Test
	public void testCheckBalance_1() { 
		Bank bankV1 = Bank.getInstance();
		Account accountV1 = bankV1.createAccount("Peter");
		boolean checkBalanceV1 = accountV1.checkBalance(500);
		assertEquals(true,checkBalanceV1);
		
	}
	
	@Test
	public void testCheckBalance_2() { 
		Bank bankV1 = Bank.getInstance();
		Account accountV1 = bankV1.createAccount("Peter");
		boolean checkBalanceV1 = accountV1.checkBalance(20000);
		assertEquals(false,checkBalanceV1);
		
	}
	
	@Test
	public void accountGetBalance()
	{
		Bank bankV1 = Bank.getInstance();
		Account accountV1 = bankV1.createAccount("Peter");
		String result = Double.toString(accountV1.getBalance());
		assertEquals("1000.0",result);
	}
	
	@Test
	public void accountGetChangeBalanceWin()
	{
		Bank bankV1 = Bank.getInstance();
		Account accountV1 = bankV1.createAccount("Peter");
		accountV1.changeBalance(100, 1);
		String result = Double.toString(accountV1.getBalance());
		assertEquals("1100.0",result);
	}
	
	@Test
	public void accountGetChangeBalanceLose()
	{
		Bank bankV1 = Bank.getInstance();
		Account accountV1 = bankV1.createAccount("Peter");
		accountV1.changeBalance(100, 0);
		String result = Double.toString(accountV1.getBalance());
		assertEquals("900.0",result);
	}
	
	@Test
	public void accountGetChangeBalanceUpgrade()
	{
		Bank bankV1 = Bank.getInstance();
		Account accountV1 = bankV1.createAccount("Peter");
		accountV1.changeBalance(100, 60);
		String result = accountV1.getMembership();
		assertEquals("Gold",result);
	}
	
	@Test
	public void accountGetType()
	{
		Bank bankV1 = Bank.getInstance();
		Account accountV1 = bankV1.createAccount("Peter");
		String result = accountV1.getMembership();
		assertEquals("Green",result);
	}
	
	@Test
	public void accountGetGoldOdds()
	{
		Bank bankV1 = Bank.getInstance();
		Account accountV1 = bankV1.createAccount("Peter");
		accountV1.changeBalance(100, 60);
		accountV1.changeBalance(100, 5);
		String result = Double.toString(accountV1.getBalance());
		assertEquals("8000.0",result);
	}
}
