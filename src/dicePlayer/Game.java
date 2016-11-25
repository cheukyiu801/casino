package dicePlayer;

import common.Payout;

public class Game 
{
	private static String combination;
	private static int comSpecific = 0;
	private static boolean playerWins;
	private static double Odds = 0;

	public static String getResult(Dice dice, DicePlayer player, BetsAndSpecific betsAndSpecific, double bet) {
		String finalResult;
		int playerBets = betsAndSpecific.getPlayerBets();
		int specific = betsAndSpecific.getSpecific();
		
		int[] results = {0,0,0};
		for (int i=0;i<3;i++){
			dice.diceRandomizer();
			results[i] = dice.getDiceNum();
		}
//		diceCombination(5,4,6);
		diceCombination(results[0],results[1],results[2]);
		
		determineWinner(new BetsAndSpecific(playerBets, specific));
		finalResult = "Result: ("+results[0]+","+results[1]+","+results[2]+") "+combination;
		
		if(playerWins){
			player.updateAccount(bet, Odds+1);
			return finalResult += "\nYou win! You won $" + bet*(Odds+1) 
					+"\nYour account balance is $"+ player.getAccountBalance();
		}
		else{
			player.updateAccount(bet, 0);
			return finalResult += "\nYou lose! You lost $" + bet
					+"\nYour account balance is $"+ player.getAccountBalance();
		}
	}
	
	public String getEndResult(Dice dice, DicePlayer player, BetsAndSpecific betsAndSpecific, double bet)
	{
		return getResult(dice, player, betsAndSpecific, bet);
	}

	private static void diceCombination(int d1, int d2, int d3) {
		
//		1=Big
//		2=Small
//	    3=Specific Doubles
//		4=Specific 'Triples'/Alls
//	    5=Any Triple/All 'Alls'

		if(d1==d2||d2==d3||d1==d3){//->3/4/5
			if(d1==d2&&d2==d3){//->4/5
				combination = "All same";
				comSpecific = d1;
			}
			else{
				combination = "Doubles";
				comSpecific = d1==d2?d1:d3;
			}
		}
		else if(d1+d2+d3>=11){
			combination = "Big";
			comSpecific = 0;
		}
		else{
			combination = "Small";
			comSpecific = 0;
		}
	}

	private static boolean determineWinner(BetsAndSpecific betsAndSpecific) 
	{
		Payout payoutcon; 
		switch(betsAndSpecific.getPlayerBets())
		{
		case 1:
			payoutcon = Payout.valueOf("BIG");
			Odds = payoutcon.getPayout();
			return playerWins = combination.equals("Big");
		case 2:
			payoutcon =Payout.valueOf("SMALL");
			Odds = payoutcon.getPayout();
			return playerWins = combination.equals("Small");
		case 3:
			payoutcon =Payout.valueOf("DOUBLES");
			Odds = payoutcon.getPayout();
			return playerWins =(combination.equals("Doubles")&&comSpecific==betsAndSpecific.getSpecific());
		case 4:
			payoutcon =Payout.valueOf("ALL_SAME_SPECIFIC");
			Odds = payoutcon.getPayout();
			return playerWins =(combination.equals("All same")&&comSpecific==betsAndSpecific.getSpecific());
		case 5:
			payoutcon =Payout.valueOf("ALL_SAME");
			Odds = payoutcon.getPayout();
			return playerWins = combination.equals("All same");
		}
		return playerWins;
	}

	public void setDiceCombination(int d1, int d2, int d3) {
		diceCombination(d1,d2,d3);
	}

	public String getCombination() {	return combination;}

	public int getComSpecific() {	return comSpecific;}
	
	public void setDetermineWinner(BetsAndSpecific betsAndSpecific){
		determineWinner( betsAndSpecific);
	}

	public boolean getPlayerWin() {		return playerWins;}

	public double getOdds() {		return  Odds;	}

}
