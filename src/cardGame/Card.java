package cardGame;
public class Card
{
	public Card()
	{}

	public Card(int s, int v)
	{
		suit=s;
		value=v;
	}

	public int getSuit()
	{
		return suit;
	}

	public int getValue()
	{
		return value;
	}

	public String toString()
	{
		return values[value]+" of "+suits[suit];
	}
	
	public int getValueForBJ(int card)
	{
		switch (card) {
		case 0: //A
			return 11;
		case 10: case 11: case 12: //J, Q, K
			return 10;
		default: 
			return card+1;
		}
	}

	private static String[]	suits={"Hearts", "Spades", "Diamonds", "Clubs"};

	private static String[]	values={"Ace", "2", "3", "4", "5", "6", "7", "8", "9","10","Jack", "Queen", "King"};

	public int suit;
	public int value;
}