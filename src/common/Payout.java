package common;

public enum Payout 
{
	STRAIGHT_FLUSH(50),
	FOUR_OF_A_KIND(25),
	FULL_HOUSE(6),
	FLUSH(5),
	STRAIGHT(4),
	THREE_OF_A_KIND(3),
	TWO_PAIR(2),
	ONE_PAIR(1),
	HIGH_CARD(0);
	
	private final int value;

    Payout(final int newValue) 
    {
        value = newValue;
    }
	
	public int getPayout() { return value; }
}
