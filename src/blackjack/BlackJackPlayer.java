package blackjack;
import bank.*;
import common.*;
import java.util.ArrayList;
import cardGame.*;
import javax.swing.JOptionPane;
import test.bjTest;

public class BlackJackPlayer extends Player implements Play
{
	private Account account;
	
	public BlackJackPlayer (int number, ArrayList<Card> hand, Account account) 
	{
		super(number, hand);
		super.removeHand();
		this.account = account;
	}
	
	private int playerSum = 0, dealerSum = 0, playerHaveAce = 0, dealerHaveAce = 0, result = 0;
	private String handCard="";
	private ArrayList<Card> playerHand = super.getHand();
	private ArrayList<Card> dealerHand = new ArrayList<>();
	private int cardIni = super.getNumOfCards();
	private boolean insurance = false;

	Deck game = Deck.getInstance();	
		
	Player dealer = new Player(2, dealerHand);

	@Override
	public ArrayList<Card> getHand()
	{
		return playerHand;
	}
	
	public ArrayList<Card> getDealerHand()
	{
		return dealerHand;
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
	
	public boolean getInsurance() {
		return insurance;
	}
	
	public String getPlayerCardInfo()
	{
		return getCardInfo(playerHand);
	}
	
	public String getDealerCardInfo()
	{
		return getCardInfo(dealerHand);
	}
	
	public String msgNormal() {
		return JOptionPane.showInputDialog("These are the cards in hand\n"
				+ handCard + "Total: " + playerSum + "\n\n"
				+ showDealerInfo() + "\n\n"
				+ "Enter 0 to hit or \n"
				+ "Enter 6 to stand");
	}
	
	public String msgInsurance() {
		return JOptionPane.showInputDialog("These are the cards in hand\n"
				+ handCard + "Total: " + playerSum + "\n\n"
				+ showDealerInfo() + "\n\n"
				+ "Enter 0 to hit or \n"
				+ "Enter 6 to stand or \n"
				+ "Enter 8 to bet insurance");
	}
	
	/************/
	
	private String showDealerInfo() {
		return "Dealer's face-up card: " + dealerHand.get(0)
		+ "\nDealer's number of card " + dealerHand.size();
	}
	
	/************/
	
	private void dealCard(ArrayList<Card> hand) {
		for(int i = hand.size(); i < cardIni; i++) 
			hand.add(game.deal());
	}
	
	private String getCardInfo(ArrayList<Card> hand)
	{
		String allCard="";
		for(int i=1; i<=hand.size(); i++)
			allCard+= i+")" + "   " + hand.get(i-1).toString()+ "\n";
		return allCard;
	}
	
	private int countSum(ArrayList<Card> hand) {
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
			oldSum -= 10; // Newly added
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
	
	private int compare(int player, int dealer) {
		if (player > dealer)
			return 1;
		else if (player <= 21 && dealer > 21) //dealer busting
			return 1;
		else if (player < dealer)
			return -1;
		else return 0;
	}
		
	/************/
	//public ver. of private method
	
	public void dealCardPB(ArrayList<Card> hand) {
		dealCard(hand);
	}
	
	public String getCardInfoPB(ArrayList<Card> hand) {
		return getCardInfo(hand);
	}
	
	public int countSumPB(ArrayList<Card> hand) {
		return countSum(hand);
	}
	
	public int changeAceValuePB(int sum) {
		return changeAceValue(sum);
	}
	
	public int recountSumPB(int oldSum, int numOfAce) {
		return recountSum(oldSum, numOfAce);
	}
	
	public int checkAcePB(ArrayList<Card> hand) {
		return checkAce(hand);
	}
	
	public int comparePB(int player, int dealer) {
		return compare(player, dealer);
	}
	
	/************/

	public void renewGame()
	{
		super.renewGame();
		dealer.removeHand();
	}
	
	public void play() 
	{
		dealCard(playerHand);
		dealCard(dealerHand);
		playerSum = countSum(playerHand);
		dealerSum = countSum(dealerHand);		
		insurance = false;
		
		super.sort();
		
		while((playerHand.size()>0) && (playerSum<22))
		{
			handCard = getCardInfo(playerHand);
			
			String msg = "";
			
			if (dealerHand.get(0).getValue() == 0 && (!insurance)) //Dealer's first card = "A" & player have not bet insurance
				msg = msgInsurance();
			else msg = msgNormal();		
			
			int input = Integer.parseInt(msg);

			//Ensure player bet insurance only if dealer's first card = "A"
			if (input == 8 && dealerHand.get(0).getValue() == 0 && (!insurance))
				insurance = true;
			
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
	
	public String determineHand(int sum, int size) //CHANGED
	{
		if(sum <= 21 && size == 5)
			return "FIVE_CARD_TRICK";
		else if (sum == 21)
			return "NATURAL_BLACKJACK";			
		else if (sum > 21)
			return "BUSTED";
		else return "NORMAL";
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
