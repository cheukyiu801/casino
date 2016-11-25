package bank;
import java.io.*;
import java.util.*;

public class Bank {

	private ArrayList<Account> allAccounts;
	
	private static Bank instance = new Bank();
	private Bank(){
		allAccounts = new ArrayList<>();
	}
	public static Bank getInstance(){return instance;}
	
	public Account createAccount(String name){
		Account a = new Account(name);
		allAccounts.add(a);
		return a;
	}
	
	public void removeAccount(int accountNo){
		allAccounts.remove(accountNo);
	}
	
	

}
