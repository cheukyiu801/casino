package blackjack;

import java.util.ArrayList;
import cardGame.*;
import javax.swing.JOptionPane;

public class BlackJackPlayer extends Player
{
	public BlackJackPlayer (int number, ArrayList<Card> hand) 
	{
		super(number, hand);
	}
	
	private int playerSum = 0, dealerSum = 0, playerHaveAce = 0, dealerHaveAce = 0, result = 0;
	private String handCard="";
	private ArrayList<Card> playerHand = super.getHand();
	private ArrayList<Card> dealerHand = new ArrayList<>();
	private int cardIni = super.getNumOfCards();

	Deck game = Deck.getInstance();	
		
	Player dealer = new Player(2, dealerHand);

	@Override
	public ArrayList<Card> getHand()
	{
		return playerHand;
	}
	
	public int getPlayerSum() {
		return playerSum;
	}
	
	public int getDealerSum() {
		return dealerSum;
	}
	
	public int getResult() {
		return result;
	}
	
	private String getCardInfo(ArrayList<Card> hand)
	{
		String allCard="";
		for(int i=1; i<=hand.size(); i++)
			allCard+= i+")" + "   " + hand.get(i-1).toString()+ "\n";
		return allCard;
	}
	
	public String getPlayerCardInfo()
	{
		return getCardInfo(playerHand);
	}
	
	public String getDealerCardInfo()
	{
		return getCardInfo(dealerHand);
	}
	
	private void dealCard(ArrayList<Card> hand) {
		for(int i = hand.size(); i < cardIni; i++) 
			hand.add(game.deal());
	}
	
	public int countSum(ArrayList<Card> hand) {
		int sum = 0;
		for (Card ph : hand) 
			sum += ph.getValueForBJ(ph.getValue());	
		return sum;
	}
	
	private int changeAceValue(int sum) {
		return sum - 10;
	}
	
	private int recountSum(int oldSum, int numOfAce) {
		int newSum = 0;
		
		for (int i = numOfAce; i > 0; i--) {
			newSum = changeAceValue(oldSum);
			numOfAce--;
		}
		
		return newSum;
	}
	
	private int checkAce(ArrayList<Card> hand) {
		int ace = 0;
		for (Card ph : hand) 
			if (ph.getValue() == 0)
				ace++;
		return ace;
	}
	
	private String showDealerInfo() {
		return "Dealer's face-up card: " + dealerHand.get(0)
		+ "\nDealer's number of card " + dealerHand.size();
	}
	
	private int compare(int player, int dealer) {
		if (player > dealer)
			return 1;
		else if (player < dealer)
			return -1;
		else return 0;
	}
	
	public void play() {
		dealCard(playerHand);
		dealCard(dealerHand);
		playerSum = countSum(playerHand);
		dealerSum = countSum(dealerHand);		
		
		super.sort();
		
		while((playerHand.size()>0) && (playerSum<22))
		{
			handCard = getCardInfo(playerHand);
			
			String msg = JOptionPane.showInputDialog("These are the cards in hand\n"
					+ handCard + "Total: " + playerSum + "\n\n"
					+ showDealerInfo() + "\n\n"
					+ "Enter 0 to hit or \n"
					+ "Enter 6 to stand");
			
			int input = Integer.parseInt(msg);
			if (input == 0) {
				
				//check dealer need add card or not
				if (dealerSum < 17) 
					dealerHand.add(game.deal());
				
				playerHand.add(game.deal());
				handCard = getCardInfo(playerHand);
				
				//Recalculate sum & # of A after adding card & result (player)
				playerSum = countSum(playerHand);
				playerHaveAce = checkAce(playerHand);
				if ((playerSum > 21) && (playerHaveAce>0))
					playerSum = recountSum(playerSum, playerHaveAce); //Change A:11->1 if sum>21
				result = compare(playerSum, dealerSum);
				
				//Recalculate sum & # of A after adding card & result (dealer)
				dealerSum = countSum(dealerHand);
				dealerHaveAce = checkAce(dealerHand);
				if ((dealerSum > 21) && (dealerHaveAce>0)) {
					dealerSum = recountSum(dealerSum, dealerHaveAce); //Change A:11->1 if sum>21
				result = compare(playerSum, dealerSum);
				}
				
			} else if (input == 6){
				if (dealerSum < 17) 
					dealerHand.add(game.deal());
				dealerSum = countSum(dealerHand);
				result = compare(playerSum, dealerSum);
				break;
			}				
		}
	}
}