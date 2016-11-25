package test;

import org.junit.Before;
import org.junit.Test;

import bank.Account;
import poker.PokerPlayer;
import cardGame.Card;

import static org.junit.Assert.*;

import java.util.ArrayList;


public class PokerTest {
	private PokerPlayer poker;
	private ArrayList<Card> hand;
	private Card card1;
	private Card card2;
	private Card card3;
	private Card card4;
	private Card card5;

    /**
     * Sets up the test fixture.
     * 
     * Called before every test case method.
     */
	
    @Before
    public void setUp() 
    { 
    	hand = new ArrayList<Card>();
    }

    /**
     * Tears down the test fixture.
     * 
     * Called after every test case method.
     */
    public void tearDown() 
    {
    	while(hand.size()!=0)
    		hand.remove(0);
    }

    
    // FourOfAKind
    @Test
    public void testIsFourOfAKind() 
    {
    	card1 = new Card(0, 1);
    	hand.add(card1);
    	
    	card2 = new Card(1, 1);
    	hand.add(card2);
    	
    	card3 = new Card(2, 1);
    	hand.add(card3);
    	
    	card4 = new Card(3, 1);
    	hand.add(card4);
    	
    	card5 = new Card(0, 5);
    	hand.add(card5);

    	boolean result;
    	Account account = new Account("Peter");
    	poker = new PokerPlayer(5,hand,account); 
        result = poker.isFourOfAKind();
        assertEquals(true, result);
    }
    
    // Not FourOfAKind
    @Test
    public void testIsNotFourOfAKind() 
    {
    	card1 = new Card(0, 1);
    	hand.add(card1);
    	
    	card2 = new Card(1, 1);
    	hand.add(card2);
    	
    	card3 = new Card(2, 1);
    	hand.add(card3);
    	
    	card4 = new Card(3, 4);
    	hand.add(card4);
    	
    	card5 = new Card(0, 5);
    	hand.add(card5);

    	boolean result;
    	Account account = new Account("Peter");
    	poker = new PokerPlayer(5,hand,account); 
        result = poker.isFourOfAKind();
        assertEquals(false, result);
    }
    
    // Is ThreeOfAKind
    @Test
    public void testIsThreeOfAKind() 
    {
    	card1 = new Card(0, 1);
    	hand.add(card1);
    	
    	card2 = new Card(1, 1);
    	hand.add(card2);
    	
    	card3 = new Card(2, 1);
    	hand.add(card3);
    	
    	card4 = new Card(3, 4);
    	hand.add(card4);
    	
    	card5 = new Card(0, 5);
    	hand.add(card5);

    	boolean result;
    	Account account = new Account("Peter");
    	poker = new PokerPlayer(5,hand,account); 
        result = poker.isThreeOfAKind();
        assertEquals(true, result);
    }

	// Not ThreeOfAKind
	@Test
	public void testNotThreeOfAKind() 
	{
	   	card1 = new Card(0, 1);
	   	hand.add(card1);
	   	
	   	card2 = new Card(1, 1);
	   	hand.add(card2);
	   	
	   	card3 = new Card(2, 4);
	   	hand.add(card3);
	   	
	   	card4 = new Card(3, 4);
	   	hand.add(card4);
	   	
	   	card5 = new Card(0, 5);
	   	hand.add(card5);
	
	   	boolean result;
	   	Account account = new Account("Peter");
	   	poker = new PokerPlayer(5,hand,account); 
	    result = poker.isThreeOfAKind();
	    assertEquals(false, result);
	}

	@Test
	public void testHasPair() 
	{
	   	card1 = new Card(0, 1);
	   	hand.add(card1);
	   	
	   	card2 = new Card(1, 1);
	   	hand.add(card2);
	   	
	   	card3 = new Card(2, 3);
	   	hand.add(card3);
	   	
	   	card4 = new Card(3, 4);
	   	hand.add(card4);
	   	
	   	card5 = new Card(0, 5);
	   	hand.add(card5);
	
	   	boolean result;
	   	Account account = new Account("Peter");
	   	poker = new PokerPlayer(5,hand,account); 
	    result = poker.hasPair();
	    assertEquals(true, result);
	}

	@Test
	public void testNotHasPair() 
	{
	   	card1 = new Card(0, 1);
	   	hand.add(card1);
	   	
	   	card2 = new Card(1, 2);
	   	hand.add(card2);
	   	
	   	card3 = new Card(2, 3);
	   	hand.add(card3);
	   	
	   	card4 = new Card(3, 4);
	   	hand.add(card4);
	   	
	   	card5 = new Card(0, 5);
	   	hand.add(card5);
	
	   	boolean result;
	   	Account account = new Account("Peter");
	   	poker = new PokerPlayer(5,hand,account); 
	    result = poker.hasPair();
	    assertEquals(false, result);
	}

	@Test
	public void testCalPair2() 
	{
	   	card1 = new Card(0, 1);
	   	hand.add(card1);
	   	
	   	card2 = new Card(1, 1);
	   	hand.add(card2);
	   	
	   	card3 = new Card(2, 3);
	   	hand.add(card3);
	   	
	   	card4 = new Card(3, 3);
	   	hand.add(card4);
	   	
	   	card5 = new Card(0, 5);
	   	hand.add(card5);

	   	int count;
	   	Account account = new Account("Peter");
	   	poker = new PokerPlayer(5,hand,account); 
	   	count = poker.calPair();
	    assertEquals(2, count);
	}

	@Test
	public void testCalPair1() 
	{
	   	card1 = new Card(0, 1);
	   	hand.add(card1);
	   	
	   	card2 = new Card(1, 1);
	   	hand.add(card2);
	   	
	   	card3 = new Card(2, 3);
	   	hand.add(card3);
	   	
	   	card4 = new Card(3, 4);
	   	hand.add(card4);
	   	
	   	card5 = new Card(0, 5);
	   	hand.add(card5);

	   	int count;
	   	Account account = new Account("Peter");
	   	poker = new PokerPlayer(5,hand,account); 
	   	count = poker.calPair();
	    assertEquals(1, count);
	}
	
	@Test
	public void testCalPair0() 
	{
	   	card1 = new Card(0, 1);
	   	hand.add(card1);
	   	
	   	card2 = new Card(1, 2);
	   	hand.add(card2);
	   	
	   	card3 = new Card(2, 3);
	   	hand.add(card3);
	   	
	   	card4 = new Card(3, 4);
	   	hand.add(card4);
	   	
	   	card5 = new Card(0, 5);
	   	hand.add(card5);

	   	int count;
	   	Account account = new Account("Peter");
	   	poker = new PokerPlayer(5,hand,account); 
	   	count = poker.calPair();
	    assertEquals(0, count);
	}
	
	// 11144 is full house (T,T)
	@Test
	public void testIsFullHouse1() 
	{
	   	card1 = new Card(0, 1);
	   	hand.add(card1);
	   	
	   	card2 = new Card(1, 1);
	   	hand.add(card2);
	   	
	   	card3 = new Card(2, 1);
	   	hand.add(card3);
	   	
	   	card4 = new Card(3, 4);
	   	hand.add(card4);
	   	
	   	card5 = new Card(0, 4);
	   	hand.add(card5);

	   	boolean result;
	   	Account account = new Account("Peter");
	   	poker = new PokerPlayer(5,hand,account); 
	   	result = poker.isFullHouse();
	    assertEquals(true, result);
	}

	// 11442 is not full house (T,F)
	@Test
	public void testIsFullHouse2() 
	{
	   	card1 = new Card(0, 1);
	   	hand.add(card1);
	   	
	   	card2 = new Card(1, 1);
	   	hand.add(card2);
	   	
	   	card3 = new Card(2, 4);
	   	hand.add(card3);
	   	
	   	card4 = new Card(3, 4);
	   	hand.add(card4);
	   	
	   	card5 = new Card(0, 2);
	   	hand.add(card5);

	   	boolean result;
	   	Account account = new Account("Peter");
	   	poker = new PokerPlayer(5,hand,account); 
	   	result = poker.isFullHouse();
	    assertEquals(false, result);
	}
	

	// 13568 is not full house (F,)
	@Test
	public void testIsFullHouse3() 
	{
	   	card1 = new Card(0, 1);
	   	hand.add(card1);
	   	
	   	card2 = new Card(1, 3);
	   	hand.add(card2);
	   	
	   	card3 = new Card(2, 5);
	   	hand.add(card3);
	   	
	   	card4 = new Card(3, 6);
	   	hand.add(card4);
	   	
	   	card5 = new Card(0, 8);
	   	hand.add(card5);

	   	boolean result;
	   	Account account = new Account("Peter");
	   	poker = new PokerPlayer(5,hand,account); 
	   	result = poker.isFullHouse();
	    assertEquals(false, result);
	}
	
// 13468 is not Flush  (loop 0)
	@Test
	public void testIsFlush0() 
	{
	   	card1 = new Card(0, 1);
	   	hand.add(card1);
	   	
	   	card2 = new Card(1, 3);
	   	hand.add(card2);
	   	
	   	card3 = new Card(2, 4);
	   	hand.add(card3);
	   	
	   	card4 = new Card(3, 6);
	   	hand.add(card4);
	   	
	   	card5 = new Card(0, 8);
	   	hand.add(card5);

	   	boolean result;
	   	Account account = new Account("Peter");
	   	poker = new PokerPlayer(5,hand,account); 
	   	result = poker.isFlush();
	    assertEquals(false, result);
	}


// 12468 is not Flush  (loop 1)
	@Test
	public void testIsFlush1() 
	{
	   	card1 = new Card(0, 1);
	   	hand.add(card1);
	   	
	   	card2 = new Card(0, 2);
	   	hand.add(card2);
	   	
	   	card3 = new Card(2, 4);
	   	hand.add(card3);
	   	
	   	card4 = new Card(3, 6);
	   	hand.add(card4);
	   	
	   	card5 = new Card(0, 8);
	   	hand.add(card5);

	   	boolean result;
	   	Account account = new Account("Peter");
	   	poker = new PokerPlayer(5,hand,account); 
	   	result = poker.isFlush();
	    assertEquals(false, result);
	}
		

// 12345 is not Flush  (loop 4)
	@Test
	public void testIsFlush4() 
	{
	   	card1 = new Card(1, 2);
	   	hand.add(card1);
	   	
	   	card2 = new Card(1, 3);
	   	hand.add(card2);
	   	
	   	card3 = new Card(1, 4);
	   	hand.add(card3);
	   	
	   	card4 = new Card(1, 5);
	   	hand.add(card4);
	   	
	   	card5 = new Card(1, 7);
	   	hand.add(card5);

	   	boolean result;
	   	Account account = new Account("Peter");
	   	poker = new PokerPlayer(5,hand,account); 
	   	result = poker.isFlush();
	    assertEquals(true, result);
	}
	

    // Test case 0: n = 1, cards = { 0, 0, 2, 3, 4 }
    @Test
    public void testIsStraight0() 
    {
    	card1 = new Card(0, 0);
    	hand.add(card1);
    	card2 = new Card(1, 0);
    	hand.add(card2);
    	card3 = new Card(2, 2);
    	hand.add(card3);
    	card4 = new Card(3, 3);
    	hand.add(card4);
    	card5 = new Card(0, 4);
    	hand.add(card5);
    	
    	boolean result;
    	Account account = new Account("Peter");
    	poker = new PokerPlayer(5,hand,account); 
        result = poker.isStraight();
        assertEquals(false, result);
    }    
    
    // Test case 1: n = 5, cards = { 0, 1, 2, 3, 4 }
    @Test
    public void testIsStraight1() 
    {
    	card1 = new Card(0, 0);
    	hand.add(card1);
    	card2 = new Card(1, 1);
    	hand.add(card2);
    	card3 = new Card(2, 2);
    	hand.add(card3);
    	card4 = new Card(3, 3);
    	hand.add(card4);
    	card5 = new Card(0, 4);
    	hand.add(card5);
    	
    	boolean result;
    	Account account = new Account("Peter");
    	poker = new PokerPlayer(5,hand,account); 
        result = poker.isStraight();
        assertEquals(true, result);
    }
    
	// Test case 2: n = 5, cards = { 0, 9, 10, 11, 12 }
    @Test
    public void testIsStraight2() 
    {
    	card1 = new Card(0, 0);
    	hand.add(card1);
    	card2 = new Card(1, 9);
    	hand.add(card2);
    	card3 = new Card(2, 10);
    	hand.add(card3);
    	card4 = new Card(3, 11);
    	hand.add(card4);
    	card5 = new Card(0, 12);
    	hand.add(card5);
    	
    	boolean result;
    	Account account = new Account("Peter");
    	poker = new PokerPlayer(5,hand,account); 
        result = poker.isStraight();
        assertEquals(true, result);
    }
    

	// Test case 3: n = 5, cards = { 3, 4, 5, 6, 7 }
    @Test
    public void testIsStraight3() 
    {
    	card1 = new Card(0, 3);
    	hand.add(card1);
    	card2 = new Card(1, 4);
    	hand.add(card2);
    	card3 = new Card(2, 5);
    	hand.add(card3);
    	card4 = new Card(3, 6);
    	hand.add(card4);
    	card5 = new Card(0, 7);
    	hand.add(card5);
    	
    	boolean result;
    	Account account = new Account("Peter");
    	poker = new PokerPlayer(5,hand,account); 
        result = poker.isStraight();
        assertEquals(true, result);
    }


	// Test case 3: n = 5, cards = { 0, 1, 2, 3, 7 }
    @Test
    public void testIsStraight4() 
    {
    	card1 = new Card(0, 0);
    	hand.add(card1);
    	card2 = new Card(1, 1);
    	hand.add(card2);
    	card3 = new Card(2, 2);
    	hand.add(card3);
    	card4 = new Card(3, 3);
    	hand.add(card4);
    	card5 = new Card(0, 7);
    	hand.add(card5);
    	
    	boolean result;
    	Account account = new Account("Peter");
    	poker = new PokerPlayer(5,hand,account); 
        result = poker.isStraight();
        assertEquals(false, result);
    }
        

	// Test case 3: n = 5, cards = { 0, 3, 4, 5, 6 }
    @Test
    public void testIsStraight5() 
    {
    	card1 = new Card(0, 0);
    	hand.add(card1);
    	card2 = new Card(1, 3);
    	hand.add(card2);
    	card3 = new Card(2, 4);
    	hand.add(card3);
    	card4 = new Card(3, 5);
    	hand.add(card4);
    	card5 = new Card(0, 6);
    	hand.add(card5);
    	
    	boolean result;
    	Account account = new Account("Peter");
    	poker = new PokerPlayer(5,hand,account); 
        result = poker.isStraight();
        assertEquals(false, result);
    }
    
    // Test case 1: n = 5, cards = { }
    @Test
    public void testIsStraight6() 
    {
    	card1 = new Card(0, 1);
    	hand.add(card1);
    	card2 = new Card(1, 2);
    	hand.add(card2);
    	card3 = new Card(2, 3);
    	hand.add(card3);
    	card4 = new Card(3, 4);
    	hand.add(card4);
    	card5 = new Card(0, 9);
    	hand.add(card5);
    	
    	boolean result;
    	Account account = new Account("Peter");
    	poker = new PokerPlayer(5,hand,account); 
        result = poker.isStraight();
        assertEquals(false, result);
    }
	
	// Test case 1: isStraight()==T, isFlush()==T  ->true
    @Test
    public void testIsStraightFlush1() 
    {
    	card1 = new Card(0, 1);
    	hand.add(card1);
    	card2 = new Card(0, 2);
    	hand.add(card2);
    	card3 = new Card(0, 3);
    	hand.add(card3);
    	card4 = new Card(0, 4);
    	hand.add(card4);
    	card5 = new Card(0, 5);
    	hand.add(card5);
    	
    	boolean result;
    	Account account = new Account("Peter");
    	poker = new PokerPlayer(5,hand,account); 
        result = poker.isStraightFlush();
        assertEquals(true, result);
    }
    
	
	// Test case 2: isStraight()==T, isFlush()==F  -> false
    @Test
    public void testIsStraightFlush2() 
    {
    	card1 = new Card(0, 1);
    	hand.add(card1);
    	card2 = new Card(0, 2);
    	hand.add(card2);
    	card3 = new Card(0, 3);
    	hand.add(card3);
    	card4 = new Card(1, 4);
    	hand.add(card4);
    	card5 = new Card(0, 5);
    	hand.add(card5);
    	
    	boolean result;
    	Account account = new Account("Peter");
    	poker = new PokerPlayer(5,hand,account); 
        result = poker.isStraightFlush();
        assertEquals(false, result);
    }
    

	// Test case 3: isStraight()==F, isFlush()== ?  -> false
    @Test
    public void testIsStraightFlush3() 
    {
    	card1 = new Card(0, 1);
    	hand.add(card1);
    	card2 = new Card(0, 2);
    	hand.add(card2);
    	card3 = new Card(0, 3);
    	hand.add(card3);
    	card4 = new Card(0, 4);
    	hand.add(card4);
    	card5 = new Card(0, 9);
    	hand.add(card5);
    	
    	boolean result;
    	Account account = new Account("Peter");
    	poker = new PokerPlayer(5,hand,account); 
        result = poker.isStraightFlush();
        assertEquals(false, result);
    }
    
// Test case 1: isFourOfAKind()
    @Test
    public void testDetermineHand1() 
    {
    	card1 = new Card(0, 1);
    	hand.add(card1);
    	card2 = new Card(1, 1);
    	hand.add(card2);
    	card3 = new Card(3, 1);
    	hand.add(card3);
    	card4 = new Card(1, 1);
    	hand.add(card4);
    	card5 = new Card(0, 4);
    	hand.add(card5);
    	
    	String result;
    	Account account = new Account("Peter");
    	poker = new PokerPlayer(5,hand,account); 
        result = poker.determineHand();
        assertEquals("FOUR_OF_A_KIND", result);
    }

// Test case 2: isFullHouse()
   @Test
   public void testDetermineHand2() 
   {
   	card1 = new Card(0, 1);
   	hand.add(card1);
   	card2 = new Card(1, 1);
   	hand.add(card2);
   	card3 = new Card(3, 1);
   	hand.add(card3);
   	card4 = new Card(1, 4);
   	hand.add(card4);
   	card5 = new Card(0, 4);
   	hand.add(card5);
   	
   	String result;
   	Account account = new Account("Peter");
   	poker = new PokerPlayer(5,hand,account); 
    result = poker.determineHand();
    assertEquals("FULL_HOUSE", result);
   }

// Test case 3: isThreeOfAKind()
   @Test
   public void testDetermineHand3() 
   {
   	card1 = new Card(0, 1);
   	hand.add(card1);
   	card2 = new Card(1, 1);
   	hand.add(card2);
   	card3 = new Card(3, 1);
   	hand.add(card3);
   	card4 = new Card(1, 3);
   	hand.add(card4);
   	card5 = new Card(0, 4);
   	hand.add(card5);
   	
   	String result;
   	Account account = new Account("Peter");
   	poker = new PokerPlayer(5,hand,account); 
    result = poker.determineHand();
    assertEquals("THREE_OF_A_KIND", result);
   }

// Test case 4: hasPair() && calPair()==2
   @Test
   public void testDetermineHand4() 
   {
   	card1 = new Card(0, 1);
   	hand.add(card1);
   	card2 = new Card(1, 1);
   	hand.add(card2);
   	card3 = new Card(3, 3);
   	hand.add(card3);
   	card4 = new Card(1, 3);
   	hand.add(card4);
   	card5 = new Card(0, 4);
   	hand.add(card5);
   	
   	String result;
   	Account account = new Account("Peter");
   	poker = new PokerPlayer(5,hand,account); 
    result = poker.determineHand();
    assertEquals("TWO_PAIR", result);
   }

// Test case 5: hasPair() && calPair()!=2
   @Test
   public void testDetermineHand5() 
   {
   	card1 = new Card(0, 1);
   	hand.add(card1);
   	card2 = new Card(1, 1);
   	hand.add(card2);
   	card3 = new Card(3, 2);
   	hand.add(card3);
   	card4 = new Card(1, 3);
   	hand.add(card4);
   	card5 = new Card(0, 4);
   	hand.add(card5);
   	
   	String result;
   	Account account = new Account("Peter");
   	poker = new PokerPlayer(5,hand,account); 
    result = poker.determineHand();
    assertEquals("ONE_PAIR", result);
   }

// Test case 6: isStraightFlush()
   @Test
   public void testDetermineHand6() 
   {
   	card1 = new Card(0, 1);
   	hand.add(card1);
   	card2 = new Card(0, 2);
   	hand.add(card2);
   	card3 = new Card(0, 3);
   	hand.add(card3);
   	card4 = new Card(0, 4);
   	hand.add(card4);
   	card5 = new Card(0, 5);
   	hand.add(card5);
   	
   	String result;
   	Account account = new Account("Peter");
   	poker = new PokerPlayer(5,hand,account); 
    result = poker.determineHand();
    assertEquals("STRAIGHT_FLUSH", result);
   }
   

// Test case 7: isStraight()
   @Test
   public void testDetermineHand7() 
   {
   	card1 = new Card(0, 1);
   	hand.add(card1);
   	card2 = new Card(1, 2);
   	hand.add(card2);
   	card3 = new Card(3, 3);
   	hand.add(card3);
   	card4 = new Card(1, 4);
   	hand.add(card4);
   	card5 = new Card(0, 5);
   	hand.add(card5);
   	
   	String result;
   	Account account = new Account("Peter");
   	poker = new PokerPlayer(5,hand,account); 
    result = poker.determineHand();
    assertEquals("STRAIGHT", result);
   }

// Test case 8: isFlush()
   @Test
   public void testDetermineHand8() 
   {
   	card1 = new Card(0, 1);
   	hand.add(card1);
   	card2 = new Card(0, 3);
   	hand.add(card2);
   	card3 = new Card(0, 5);
   	hand.add(card3);
   	card4 = new Card(0, 7);
   	hand.add(card4);
   	card5 = new Card(0, 4);
   	hand.add(card5);
   	
   	String result;
   	Account account = new Account("Peter");
   	poker = new PokerPlayer(5,hand,account); 
    result = poker.determineHand();
    assertEquals("FLUSH", result);
   }

// Test case 9: else  "HIGH_CARD" 
   @Test
   public void testDetermineHand9() 
   {
   	card1 = new Card(0, 1);
   	hand.add(card1);
   	card2 = new Card(1, 4);
   	hand.add(card2);
   	card3 = new Card(3, 6);
   	hand.add(card3);
   	card4 = new Card(1, 8);
   	hand.add(card4);
   	card5 = new Card(0, 10);
   	hand.add(card5);
   	
   	String result;
   	Account account = new Account("Peter");
   	poker = new PokerPlayer(5,hand,account); 
    result = poker.determineHand();
    assertEquals("HIGH_CARD", result);
   }
   
// Test case : updateAccount()   payout=1, return=2000
   @Test
   public void testUpdateAccount1() 
   {
   	card1 = new Card(0, 1);
   	hand.add(card1);
   	card2 = new Card(1, 4);
   	hand.add(card2);
   	card3 = new Card(3, 6);
   	hand.add(card3);
   	card4 = new Card(1, 8);
   	hand.add(card4);
   	card5 = new Card(0, 10);
   	hand.add(card5);
   	
   	Account account = new Account("Peter");
   	poker = new PokerPlayer(5,hand,account); 
    poker.updateAccount(poker.getAccountBalance(),1);
    int result = (int) poker.getAccountBalance();
    assertEquals(2000, result);
   }
   
// Test case : updateAccount()   payout=0, return=0
   @Test
   public void testUpdateAccount2() 
   {
   	card1 = new Card(0, 1);
   	hand.add(card1);
   	card2 = new Card(1, 4);
   	hand.add(card2);
   	card3 = new Card(3, 6);
   	hand.add(card3);
   	card4 = new Card(1, 8);
   	hand.add(card4);
   	card5 = new Card(0, 10);
   	hand.add(card5);
   	
   	Account account = new Account("Peter");
   	poker = new PokerPlayer(5,hand,account); 
    poker.updateAccount(poker.getAccountBalance(),0);
    int result = (int) poker.getAccountBalance();
    assertEquals(0, result);
   }
   
// Test case : GetAccountBalance()
   @Test
   public void testGetAccountBalance() 
   {
   	card1 = new Card(0, 1);
   	hand.add(card1);
   	card2 = new Card(1, 4);
   	hand.add(card2);
   	card3 = new Card(3, 6);
   	hand.add(card3);
   	card4 = new Card(1, 8);
   	hand.add(card4);
   	card5 = new Card(0, 10);
   	hand.add(card5);
   	
   	int result;
   	Account account = new Account("Peter");
   	poker = new PokerPlayer(5,hand,account); 
    result = (int) poker.getAccountBalance();
    assertEquals(1000, result);
   }
   
}

