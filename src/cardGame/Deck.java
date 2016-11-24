package cardGame;
import java.util.ArrayList;

public class Deck
{
	public Deck()
	{
		gameDeck=new ArrayList<Card>();
		for(int i=0; i<4; i++)
			{
				for(int j=0; j<13; j++)
					{
						gameDeck.add(new Card(i,j));
					}
			}
		shuffle();
	}

	private void shuffle()
	{
		Card temp=null;
		int place=0;
		for(int i=0; i<gameDeck.size(); i++)
		{
			place=(int) (Math.random()*gameDeck.size());
			temp=gameDeck.get(place);
			gameDeck.set(place,gameDeck.get(i));
			gameDeck.set(i,temp);
		}
	}

	public Card deal()
	{
		Card temp= gameDeck.get(0);
		gameDeck.remove(0);
		return temp;
	}

	public static Deck getInstance()
	{
		return deck;
	}

	public String toString(int i)
	{
		return gameDeck.get(i).toString();
	}

	private ArrayList<Card> gameDeck;
	private static Deck deck = new Deck();
}