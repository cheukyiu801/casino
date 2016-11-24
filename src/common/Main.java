package common;
import javax.swing.JOptionPane;

import cardGame.Card;
import cardGame.Deck;
import poker.PokerPlayer;
import blackjack.*;

import java.util.ArrayList;
import bank.*;

public class Main
{
	public static void main(String[] args)
	{
		boolean done=false;
		
		String name=JOptionPane.showInputDialog("Please enter the name for your account");
		Account a = Bank.getInstance().createAccount(name);

		while(!done)
		{
			String handCard="";
			String result="Your have ";
			Payout payoutcon; 
			double payout = 0;
			double bet =0;
			
			String choice=JOptionPane.showInputDialog("Enter the number corresponding to what you would like to do. \n1. Play Poker \n2. Play BlackJack \n3. Quit");
			int menu=Integer.parseInt(choice);
			if(menu==3)
				done=true;
			else 
			{	
				if(menu==1)
				{
					String betTemp=JOptionPane.showInputDialog("Enter the amount you want to bet");
					bet=Integer.parseInt(betTemp);
					
					Deck game=Deck.getInstance();
					ArrayList<Card> hand=new ArrayList<Card>();
					PokerPlayer one=new PokerPlayer(5, hand, a);
					boolean move = false;
					for(int i=hand.size(); i<one.getNumOfCards(); i++)
						hand.add(game.deal());
					one.sort();

					for(int i=1; i<=hand.size(); i++)
						handCard+= i+")" + "   " + hand.get(i-1).toString()+ "\n";

					JOptionPane.showMessageDialog(null, "This is your hand of cards. \n"+handCard);

					String outcome = one.determineHand();
					result+=outcome;
					payoutcon = Payout.valueOf(outcome);
					payout = payoutcon.getPayout();
					
					one.updateAccount(bet, payout);

					JOptionPane.showMessageDialog(null, result+"\n"+"Your new balance is "+one.getAccountBalance());
				}
				else if(menu==2)
				{			
					String betTemp=JOptionPane.showInputDialog("Enter the amount you want to bet");
					bet=Integer.parseInt(betTemp);
					
					String playerHandCard="", dealerHandCard = "";
					int playerSum = 0, dealerSum = 0;
					int bjResult = 0;
					ArrayList<Card> playerHand = new ArrayList<Card>();

					BlackJackPlayer blackJack = new BlackJackPlayer(2, playerHand, a);
					blackJack.play();

					playerHandCard = blackJack.getPlayerCardInfo();
					dealerHandCard = blackJack.getDealerCardInfo();

					playerSum = blackJack.getPlayerSum();
					dealerSum = blackJack.getDealerSum();

					String outcome = blackJack.determineHand();
					boolean insurance = blackJack.getInsurance();
					String insuranceMsg = "";

					if (outcome != "NORMAL") {
						result+=outcome;
						payoutcon = Payout.valueOf(outcome);
						payout = payoutcon.getPayout();
					} else {
						bjResult = blackJack.getResult();

						if (bjResult == -1)
							result = "You lose!";
						else if (bjResult == 1)
							result = "You win!";
						else result = "Draw!";
					}

					if (insurance)
					{
						insuranceMsg += "\n\n[Insurance bet]";
						if (dealerSum == 21)
							payout += 0.5;
						else payout -= 0.5;
					}

					blackJack.updateAccount(bet, payout);
					//Show result
					JOptionPane.showMessageDialog(null, result
							+ "\n\nYour cards: \n" + playerHandCard
							+ "Total: " + playerSum
							+ "\n\nDealer's cards: \n" + dealerHandCard
							+ "Total: " + dealerSum
							+ insuranceMsg
							+ "\nPayout: "+payout
							+ "\nNew Amount is: "+blackJack.getAccountBalance());
				}
			}
		}
	}
}