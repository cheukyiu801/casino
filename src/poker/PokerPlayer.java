package poker;
import bank.*;
import common.*;
import java.util.ArrayList;

import cardGame.Card;
import cardGame.Player;

public class PokerPlayer extends Player implements Play
{
	private int[] record;
	private Account account;
	
	public PokerPlayer(int number, ArrayList<Card> hand, Account account)
	{
		super(number, hand);
		this.account = account;
		record = new int[13];
		initize();
	}
	
	public void renewGame()
	{
		super.removeHand();
		reset();
	}
	
	public void reset()
	{
		for(int i=0; i<record.length; i++)
		{
			record[i]=0;
		}
	}
	
	public void initize()
	{
		ArrayList<Card> hand = super.getHand();
		for(int i=0; i<hand.size(); i++)
		{
			for(int j=0; j<record.length; j++)
			{
				if(hand.get(i).getValue()==j)
					record[j]++;
			}
		}
	}
	
	public boolean findNumber(int n)
	{
		for(int i=0; i<record.length; i++)
		{
			if(record[i]==n)
				return true;
		}
		return false;
	}
	
	public boolean isFourOfAKind()
	{
		return findNumber(4);
	}
	
	public boolean isThreeOfAKind()
	{
		return findNumber(3);
	}
	
	public boolean hasPair()
	{
		return findNumber(2);
	}
	
	public int calPair()
	{
		int counter = 0;
		for(int i=0; i<record.length; i++)
		{
			if(record[i]==2)
				counter++;
		}
		return counter;
	}
	
	public boolean isFullHouse()
	{
		return hasPair()&&isThreeOfAKind();
	}
	
	public boolean isFlush()
	{
		ArrayList<Card> hand = super.getHand();
		for(int i=0; i<hand.size()-1; i++)
		{
			if(hand.get(i).getSuit()!=hand.get(i+1).getSuit())
				return false;
		}
		return true;
	}
	
	public boolean isStraight()
	{	
		boolean start = false;
		boolean isAce = false;
		int counter=0;
		int starter=0;
		for(int i=0; i<record.length; i++)
		{
			if(record[i]==1)
			{
				if(i==0)
					isAce=true;
				else if(isAce&&i==9)
				{
					start = true;
					starter=9;
				}
				else if (!start)
				{
					start=true;
					starter=i;
				}
				counter++;
			}
			else if(record[i]>1)
				return false;
			
			if((starter==(i-4)&&start&&counter==5)||(starter==(i-3)&&start&&isAce&&counter==5))
				return true;
		}
		return false;
	}
	
	public boolean isStraightFlush()
	{
		return isStraight()&&isFlush();
	}
	
	public String determineHand()
	{
		if(isFourOfAKind())
			return "FOUR_OF_A_KIND";
		else if(isFullHouse())
			return "FULL_HOUSE";
		else if(isThreeOfAKind())
			return "THREE_OF_A_KIND";
		else if(hasPair())
		{
			if(calPair()==2)
				return "TWO_PAIR";
			else
				return "ONE_PAIR";
		}
		else if(isStraightFlush())
			return "STRAIGHT_FLUSH";
		else if(isStraight())
			return "STRAIGHT";
		else if(isFlush())
			return "FLUSH";
		else 
			return "HIGH_CARD";
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
