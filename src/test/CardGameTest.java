package test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import org.junit.Test;

import bank.Account;
import bank.Bank;
import blackjack.BlackJackPlayer;
import cardGame.*;
import common.*;

public class CardGameTest 
{
	@Test
	public void testGetSuit()
	{
		Card temp = new Card(0, 1);
		int result = temp.getSuit();
		
		assertEquals(0, result);
	}
	
	@Test
	public void testGetValue()
	{
		Card temp = new Card(0, 1);
		int result = temp.getValue();
		
		assertEquals(1, result);
	}
	
	@Test
	public void testCardtoString()
	{
		Card temp = new Card(0, 1);
		String result = temp.toString();
		
		assertEquals("2 of Hearts", result);
	}
	
	@Test
	public void testCardGetValueForBJFor11()
	{
		Card temp = new Card(0, 0);
		int result = temp.getValueForBJ(0);
		assertEquals(11, result);
	}
	
	@Test
	public void testCardGetValueForBJFor10()
	{
		Card temp = new Card(0, 11);
		int result = temp.getValueForBJ(11);
		assertEquals(10, result);
	}
	
	@Test
	public void testCardGetValueForBJForOthers()
	{
		Card temp = new Card(0, 3);
		int result = temp.getValueForBJ(3);
		assertEquals(4, result);
	}
	
	@Test
	public void testDeckShuffle()
	{
		Deck temp = Deck.getInstance();
		Deck test = new Deck();
		boolean result = test.equals(temp);
		assertEquals(false, result);
	}
	
	@Test
	public void testDeckDeal()
	{
		Deck temp = Deck.getInstance();
		Boolean result = temp.deal() instanceof Card; 
		assertEquals(true, result);
	}
	
	@Test
	public void testPlayerGetNumOfCards()
	{
		ArrayList<Card> hand = new ArrayList<Card>();
		Player temp = new Player(4, hand);
		int result = temp.getNumOfCards();
		assertEquals(4, result);
	}
	
	@Test
	public void testPlayerGetHand()
	{
		ArrayList<Card> hand = new ArrayList<Card>();
		Card c1 = new Card(0,0);
		hand.add(c1);
		Card c2 = new Card(2,0);
		hand.add(c2);
		
		Player player = new Player(2, hand);
		
		ArrayList<Card> result = player.getHand();
		assertEquals(hand, result);
	}
	
	@Test
	public void testPlayertoString()
	{
		ArrayList<Card> hand = new ArrayList<Card>();
		Card c1 = new Card(0,3);
		hand.add(c1);
		Card c2 = new Card(2,5);
		hand.add(c2);
		
		Player player = new Player(2, hand);
		
		String result = player.toString(1);
		assertEquals("6 of Diamonds", result);
	}
	
	@Test
	public void testPlayerGetCard()
	{
		ArrayList<Card> hand = new ArrayList<Card>();
		Card c1 = new Card(1,7);
		hand.add(c1);
		Card c2 = new Card(2,9);
		hand.add(c2);
		
		Player player = new Player(2, hand);
		
		Card result = player.get(1);
		assertEquals(c2, result);
	}
	
	@Test
	public void testPlayerRemove()
	{
		ArrayList<Card> hand = new ArrayList<Card>();
		Card c1 = new Card(1,7);
		hand.add(c1);
		Card c2 = new Card(2,10);
		hand.add(c2);
		
		Player player = new Player(2, hand);
		
		player.remove(0);
		int result = player.getHand().size();
		assertEquals(1, result);
	}
	
	@Test
	public void testPlayerSize()
	{
		ArrayList<Card> hand = new ArrayList<Card>();
		Card c1 = new Card(1,7);
		hand.add(c1);
		Card c2 = new Card(2,10);
		hand.add(c2);
		Card c3 = new Card(3,10);
		hand.add(c3);
		
		Player player = new Player(3, hand);
		
		int result = player.size();
		assertEquals(3, result);
	}
	
	@Test
	public void testPlayerSort()
	{
		ArrayList<Card> hand = new ArrayList<Card>();
		Card c1 = new Card(1,6);
		hand.add(c1);
		Card c2 = new Card(2,5);
		hand.add(c2);
		Card c3 = new Card(3,10);
		hand.add(c3);
		
		Player player = new Player(3, hand);
		
		player.sort();
		ArrayList<Card> result = player.getHand();
		ArrayList<Card> equal= new ArrayList<Card>();
		equal.add(c2);
		equal.add(c1);
		equal.add(c3);
		assertEquals(equal, result);
	}
	
	@Test
	public void testPlayerDetermineHand()
	{
		ArrayList<Card> hand = new ArrayList<Card>();
		Card c1 = new Card(1,3);
		hand.add(c1);
		
		Player player = new Player(3, hand);
		
		String result = player.determineHand();
		assertEquals("", result);
	}
	
	@Test
	public void testPlayerGetEndResult()
	{
		ArrayList<Card> hand = new ArrayList<Card>();
		Card c1 = new Card(0,2);
		hand.add(c1);
		Card c2 = new Card(1,5);
		hand.add(c2);
		Card c3 = new Card(3,10);
		hand.add(c3);
		
		Player player = new Player(3, hand);
		
		String result = player.getEndResult();
		assertEquals("1)   3 of Hearts\n2)   6 of Spades\n3)   Jack of Clubs\n", result);
	}
	
	@Test
	public void testPlayerRenewGame()
	{
		ArrayList<Card> hand = new ArrayList<Card>();
		Card c1 = new Card(0,5);
		hand.add(c1);
		Card c2 = new Card(1,5);
		hand.add(c2);
		Card c3 = new Card(3,6);
		hand.add(c3);
		
		Player player = new Player(3, hand);
		
		player.renewGame();
		int result = player.size();
		assertEquals(0, result);
	}
}
