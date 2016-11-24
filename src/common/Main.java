package common;
import javax.swing.JOptionPane;
import common.*;
import dicePlayer.*;
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
			String result="Your have ";
			Payout payoutcon; 
			double payout = 0;
			double bet =0;
			boolean loop = true;
			
			String choice=JOptionPane.showInputDialog("Enter the number corresponding to what you would like to do. \n1. Play Poker \n2. Play BlackJack \n3. Play Sic Bo \n4. Quit");
			int menu=Integer.parseInt(choice);
			if(menu==4)
				done=true;
			else 
			{	
				if(menu==1)
				{
					Deck game=Deck.getInstance();
					ArrayList<Card> hand=new ArrayList<Card>();
					PokerPlayer one=new PokerPlayer(5, hand, a);
					while(loop)
					{
						result="Your have ";
						String betTemp=JOptionPane.showInputDialog("Enter the amount you want to bet");
						bet=Integer.parseInt(betTemp);
						one.renewGame();
						for(int i=hand.size(); i<one.getNumOfCards(); i++)
							hand.add(game.deal());
						one.sort();
						JOptionPane.showMessageDialog(null, "This is your hand of cards. \n"+one.getEndResult());
	
						String outcome = one.determineHand();
						result+=outcome;
						payoutcon = Payout.valueOf(outcome);
						payout = payoutcon.getPayout();
						
						one.updateAccount(bet, payout);
						JOptionPane.showMessageDialog(null, result+"\n"+"Your new balance is "+one.getAccountBalance());
						Object[] options = {"Yes","No"};
						int n = JOptionPane.showOptionDialog(null,"Continue?", null, JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.DEFAULT_OPTION,  null, options, options[1]);
						loop = n==0;
					}
				}
				else if(menu==2)
				{			
					ArrayList<Card> playerHand = new ArrayList<Card>();
					BlackJackPlayer blackJack = new BlackJackPlayer(2, playerHand, a);
					while(loop)
					{
						blackJack.renewGame();
						
						result="Your have ";
						String betTemp=JOptionPane.showInputDialog("Enter the amount you want to bet");
						bet=Integer.parseInt(betTemp);
						String playerHandCard="", dealerHandCard = "";
						int playerSum = 0, dealerSum = 0;
						int bjResult = 0;
						blackJack.play();
	
						playerHandCard = blackJack.getPlayerCardInfo();
						dealerHandCard = blackJack.getDealerCardInfo();
	
						playerSum = blackJack.getPlayerSum();
						dealerSum = blackJack.getDealerSum();
	
						String outcome = blackJack.determineHand();
						boolean insurance = blackJack.getInsurance();
						String insuranceMsg = "";
	
						if (outcome != "NORMAL") 
						{
							result+=outcome;
							payoutcon = Payout.valueOf(outcome);
							payout = payoutcon.getPayout();
						} 
						else 
						{
							bjResult = blackJack.getResult();
	
							if (bjResult == -1)
							{
								result = "You lose!";
								payout=0;
							}
							else if (bjResult == 1)
							{
								result = "You win!";
								payoutcon = Payout.valueOf(outcome);
								payout = payoutcon.getPayout();
							}
							else 
								{
									result = "Draw!";
									payout=0;
								}
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
					Object[] options = {"Yes","No"};
					int n = JOptionPane.showOptionDialog(null,"Continue?", null, JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.DEFAULT_OPTION,  null, options, options[1]);
					loop = n==0;
				}
				else if(menu==3)
				{
					DicePlayer player = new DicePlayer(a);
					
					while(loop)
					{
						int roundNum = 0;
						int betAmount=0;
						
						String _betAmount = JOptionPane.showInputDialog("Enter the amount you want to bet");
						bet=Integer.parseInt(_betAmount);
						
						roundNum++;
						
						String _playerBets = JOptionPane.showInputDialog("Round :"+roundNum+"\t Please enter your bets!"
								+ "\n 1=Big (1:1) \n 2=Small (1:1) \n 3=Specific Doubles (1:8) \n 4=Specific 'Triples'/Alls (1:150) \n 5=Any Triple/All 'Alls' (1:24)");
						
						int playerBets = Integer.parseInt(_playerBets);
						
						if(playerBets==3||playerBets==4){
							String _specific = JOptionPane.showInputDialog("Please enter the specific number");
							int specific = Integer.parseInt(_specific);
							
							JOptionPane.showMessageDialog(null, Game.getEndResult(player, playerBets,specific, betAmount));
						}
						else{
							JOptionPane.showMessageDialog(null, Game.getEndResult(player, playerBets,0, betAmount));
						}
						
						Object[] options = {"Yes","No"};
						int n = JOptionPane.showOptionDialog(null,"Continue?", null, JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.DEFAULT_OPTION,  null, options, options[1]);
						loop = n==0;
					}
				}
			}
		}
	}
}