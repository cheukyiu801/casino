package cardGame;
import java.util.ArrayList;
import common.*;

public class Player implements Play
{
	public Player(int number, ArrayList<Card> hand)
	{
		this.number=number;
		this.hand=hand;
	}

	public int getNumOfCards()
	{
		return number;
	}

	public ArrayList<Card> getHand()
	{
		return hand;
	}

	public String toString(int i)
	{
		return hand.get(i).toString();
	}

	public Card get(int i)
	{
		return hand.get(i);
	}

	public void remove(int i)
	{
		hand.remove(i);
	}

	public int size()
	{
		return hand.size();
	}
	
	public void sort()
	{
		for(int i=1; i<hand.size(); i++)
		{
			Card temp=hand.get(i);
			int j=i;
			while((j>0)&&(temp.getValue()<=hand.get(j-1).getValue()))
			{
				hand.set(j,hand.get(j-1));
				j--;
			}
			hand.set(j,temp);
		}
	}
	
	public String determineHand()
	{
		return "";
	}
	
	public String getEndResult()
	{
		String handCard="";
		for(int i=1; i<=hand.size(); i++)
			handCard+= i+")" + "   " + hand.get(i-1).toString()+ "\n";
		return handCard;
	}
	
	public void renewGame()
	{
		removeHand();
	}
	
	public void removeHand()
	{
		while(hand.size()!=0)
			hand.remove(0);
	}
	
	private ArrayList<Card> hand;
	private int number;
}