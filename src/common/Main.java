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
		
		String name=UserInput.getUserName();
		Account a = Bank.getInstance().createAccount(name);

		while(!done)
		{
			String result="Your have ";
			Payout payoutcon; 
			double payout = 0;
			double bet =0;
			boolean loop = true;
			
			int menu=UserInput.getUserChoice();
			if(menu==4)
			{
				done=true;
				double endMoney = a.getBalance();
				JOptionPane.showMessageDialog(null, "Your total money is "+endMoney);
			}
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
						bet = UserInput.getBet();
						one.renewGame();
						for(int i=hand.size(); i<one.getNumOfCards(); i++)
							hand.add(game.deal());
						one.initize();
						one.sort();
						JOptionPane.showMessageDialog(null, "This is your hand of cards. \n"+one.getEndResult());
	
						String outcome = one.determineHand();
						result+=outcome;
						System.out.println(outcome);
						payoutcon = Payout.valueOf(outcome);
						payout = payoutcon.getPayout();
						
						one.updateAccount(bet, payout);
						JOptionPane.showMessageDialog(null, result+"\n"+"Your new balance is "+one.getAccountBalance());
						loop = UserInput.chooseContinue();
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
						bet = UserInput.getBet();
						String playerHandCard="", dealerHandCard = "";
						int playerSum = 0, dealerSum = 0;
						int bjResult = 0;
						boolean insurance = false;
						blackJack.play();
	
						playerHandCard = blackJack.getPlayerCardInfo();
						dealerHandCard = blackJack.getDealerCardInfo();
	
						playerSum = blackJack.getPlayerSum();
						dealerSum = blackJack.getDealerSum();
	
						String outcome = blackJack.determineHand(playerSum, blackJack.getHand().size()); 
						insurance = blackJack.getInsurance();
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
						
						loop = UserInput.chooseContinue();
					}
				}
				else if(menu==3)
				{
					DicePlayer player = new DicePlayer(a);
					Game game = new Game();
					Dice dice = new Dice();
					
					while(loop)
					{
						int roundNum = 0;
						bet = UserInput.getBet();
						roundNum++;
						
						int playerBets = UserInput.getPlayerBetType(roundNum);
						BetsAndSpecific betsAndSpecific;
						if(playerBets==3||playerBets==4)
						{
							int specific = UserInput.getSpecific();
							betsAndSpecific = new BetsAndSpecific(playerBets,specific);
						}
						else
						{
							betsAndSpecific = new BetsAndSpecific(playerBets,0);
						}
						JOptionPane.showMessageDialog(null, game.getEndResult(dice, player, betsAndSpecific, bet));
						loop = UserInput.chooseContinue();
					}
				}
			}
		}
	}
}