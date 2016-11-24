package poker;
import java.util.ArrayList;
import java.util.Arrays;

import cardGame.Card;
import cardGame.Player;

public class PokerPlayer extends Player 
{
	private int[] record;
	
	public PokerPlayer(int number, ArrayList<Card> hand)
	{
		super(number, hand);
		record = new int[13];
		initize();
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
	
	public boolean isFourOfAKind()
	{
		System.out.println(Arrays.toString(record));
		for(int i=0; i<record.length; i++)
		{
			if(record[i]==4)
				return true;
		}
		return false;
	}
	
	public boolean hasPair()
	{
		for(int i=0; i<record.length; i++)
		{
			if(record[i]==2)
				return true;
		}
		return false;
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
	
	public boolean isThreeOfAKind()
	{
		for(int i=0; i<record.length; i++)
		{
			if(record[i]==3)
				return true;
		}
		return false;
	}
	
	public boolean isFullHouse()
	{
		return hasPair()&&isThreeOfAKind();
	}
	
	public boolean isFlush()
	{
		ArrayList<Card> hand = super.getHand();
		for(int i=0; i<hand.size(); i++)
		{
			if(hand.get(i).getSuit()!=hand.get(i+1).getSuit())
				return false;
		}
		return true;
	}
	
	public boolean isStraight()
	{
		System.out.println(Arrays.toString(record));
		int starter=0;
		boolean start = false;
		boolean isAce = false;
		for(int i=0; i<record.length; i++)
		{
			if(record[i]==1)
			{
				start = true;
				starter=i;
			}
			if(record[0]==1)
			{
				isAce=true;
				start=false;
			}
			if(isAce&&i==9)
				start = true;
			if(start)
			{
				if(record[i]!=0)
					return false;
			}
			if(starter==(i-4))
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
		initize();
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
}
