package common;

public enum Payout 
{
	STRAIGHT_FLUSH(50),
	FOUR_OF_A_KIND(25),
	FULL_HOUSE(9),
	FLUSH(6),
	STRAIGHT(4),
	THREE_OF_A_KIND(3),
	TWO_PAIR(2),
	ONE_PAIR(1),
	HIGH_CARD(0),
	
	NORMAL(1),
	NATURAL_BLACKJACK(1.5),
	FIVE_CARD_TRICK(2),
	BUSTED(0),
	
	BIG(1),
	SMALL(1),
	DOUBLES(8),
	ALL_SAME(24),
	ALL_SAME_SPECIFIC(150);
	
	private final double value;

    Payout(final double newValue) 
    {
        value = newValue;
    }
	
	public double getPayout() { return value; }
}
