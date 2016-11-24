package common;
import javax.swing.JOptionPane;

import cardGame.Card;
import cardGame.Deck;
import poker.PokerPlayer;
import blackjack.*;

import java.util.ArrayList;

public class Main
{
	public static void main(String[] args)
	{
		boolean done=false;

		while(!done)
		{
			String handCard="";
			String result="Your have ";
			Payout payoutcon; 
			double payout = 0;

			String choice=JOptionPane.showInputDialog("Enter the number corresponding to what you would like to do. \n1. Play Poker \n2. Play BlackJack \n3. Quit");
			int menu=Integer.parseInt(choice);
			if(menu==3)
				done=true;
			else if(menu==1)
			{
				Deck game=Deck.getInstance();
				ArrayList<Card> hand=new ArrayList<Card>();
				PokerPlayer one=new PokerPlayer(5, hand);
				boolean move = false;
				for(int i=hand.size(); i<one.getNumOfCards(); i++)
					hand.add(game.deal());
				one.sort();

				while((hand.size()>0)&&!move)
				{
					handCard="";
					for(int i=1; i<=hand.size(); i++)
						handCard+= i+")" + "   " + hand.get(i-1).toString()+ "\n";
					String reMove=JOptionPane.showInputDialog("Enter the number corresponding to the card you would like to get rid of or enter 6 if you do not want to remove any \n"+handCard+"6)   done");
					int getRid=Integer.parseInt(reMove);
					if(getRid==6)
						move=true;
					else
						hand.remove(getRid-1);
				}

				for(int i=hand.size()+1; i<=one.getNumOfCards(); i++)
					hand.add(game.deal());
				one.sort();
				handCard="";
				for(int i=1; i<=hand.size(); i++)
					handCard+= i+")" + "   " + hand.get(i-1).toString()+ "\n";
				
				JOptionPane.showMessageDialog(null, "This is your hand of cards. \n"+handCard);
				
				String outcome = one.determineHand();
				result+=outcome;
				payoutcon = Payout.valueOf(outcome);
				payout = payoutcon.getPayout();

				JOptionPane.showMessageDialog(null, result+"\n"+payout);
			}
			else if(menu==2)
			{			
				String playerHandCard="", dealerHandCard = "";
				int playerSum = 0, dealerSum = 0;
				int bjResult = 0;
				ArrayList<Card> playerHand = new ArrayList<Card>();
				
				BlackJackPlayer blackJack = new BlackJackPlayer(2, playerHand);
				blackJack.play();
				
				playerHandCard = blackJack.getPlayerCardInfo();
				dealerHandCard = blackJack.getDealerCardInfo();
				
				playerSum = blackJack.getPlayerSum();
				dealerSum = blackJack.getDealerSum();
				
				//New parts
				String outcome = blackJack.determineHand();
				
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
				
				//Show result
				JOptionPane.showMessageDialog(null, result
						+ "\n\nYour cards: \n" + playerHandCard
						+ "Total: " + playerSum
						+ "\n\nDealer's cards: \n" + dealerHandCard
						+ "Total: " + dealerSum
						+ "\n\nPayout: "+payout);
				//
			}
		}
	}
}