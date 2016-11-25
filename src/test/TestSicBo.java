package test;

import static org.junit.Assert.*;

import org.junit.Test;

import bank.Account;
import dicePlayer.BetsAndSpecific;
import dicePlayer.Dice;
import dicePlayer.DicePlayer;
import dicePlayer.Game;

public class TestSicBo {//Unit testing: diceCombination + determineWinner

	@Test
	public void test_diceCombination_01() throws Exception{
		Game game = new Game();
		game.setDiceCombination(1,1,1);
		assertEquals("All same", game.getCombination());
		assertEquals(1, game.getComSpecific());
	}

	@Test
	public void test_diceCombination_02() throws Exception{
		Game game = new Game();
		game.setDiceCombination(1,2,2);
		assertEquals("Doubles", game.getCombination());
		assertEquals(2, game.getComSpecific());
	}
	
	@Test
	public void test_diceCombination_03() throws Exception{
		Game game = new Game();
		game.setDiceCombination(1,2,1);
		assertEquals("Doubles", game.getCombination());
		assertEquals(1, game.getComSpecific());
	}
	
	@Test
	public void test_diceCombination_04() throws Exception{
		Game game = new Game();
		game.setDiceCombination(1,1,2);
		assertEquals("Doubles", game.getCombination());
		assertEquals(1, game.getComSpecific());
	}
	
	@Test
	public void test_diceCombination_05() throws Exception{
		Game game = new Game();
		game.setDiceCombination(3,4,6);
		assertEquals("Big", game.getCombination());
		assertEquals(0, game.getComSpecific());
	}
	
	@Test
	public void test_diceCombination_06() throws Exception{
		Game game = new Game();
		game.setDiceCombination(1,2,3);
		assertEquals("Small", game.getCombination());
		assertEquals(0, game.getComSpecific());
	}
	
	////////////////////////////////
	@Test
	public void test_determineWinner_01() throws Exception{
		Game game = new Game();
		BetsAndSpecific betsAndSpecific = new BetsAndSpecific(1,0);
		game.setDiceCombination(3,4,6);
		game.setDetermineWinner(betsAndSpecific);
		boolean playerWins = game.getPlayerWin();
		double odds = game.getOdds();
		assertEquals(true, playerWins);
		assertEquals(1,odds, 0.001);
	}
	
	@Test
	public void test_determineWinner_02() throws Exception{
		Game game = new Game();
		BetsAndSpecific betsAndSpecific = new BetsAndSpecific(1,0);
		game.setDiceCombination(1,1,1);
		game.setDetermineWinner(betsAndSpecific);
		boolean playerWins = game.getPlayerWin();
		double odds = game.getOdds();
		System.out.println(odds);
		assertEquals(false, playerWins);
	}
	
	@Test
	public void test_determineWinner_03() throws Exception{
		Game game = new Game();
		BetsAndSpecific betsAndSpecific = new BetsAndSpecific(2,0);
		game.setDiceCombination(1,2,3);
		game.setDetermineWinner(betsAndSpecific);
		boolean playerWins = game.getPlayerWin();
		double odds = game.getOdds();
		assertEquals(true, playerWins);
		assertEquals(1,odds, 0.001);
	}
	
	@Test
	public void test_determineWinner_04() throws Exception{
		Game game = new Game();
		BetsAndSpecific betsAndSpecific = new BetsAndSpecific(2,0);
		game.setDiceCombination(1,1,1);
		game.setDetermineWinner(betsAndSpecific);
		boolean playerWins = game.getPlayerWin();
		assertEquals(false, playerWins);
	}
	
	@Test
	public void test_determineWinner_05() throws Exception{
		Game game = new Game();
		BetsAndSpecific betsAndSpecific = new BetsAndSpecific(3,1);
		game.setDiceCombination(1,1,2);
		game.setDetermineWinner(betsAndSpecific);
		boolean playerWins = game.getPlayerWin();
		double odds = game.getOdds();
		assertEquals(true, playerWins);
		assertEquals(8,odds, 0.001);
	}
	
	@Test
	public void test_determineWinner_06() throws Exception{
		Game game = new Game();
		BetsAndSpecific betsAndSpecific = new BetsAndSpecific(3,2);
		game.setDiceCombination(1,1,2);
		game.setDetermineWinner(betsAndSpecific);
		boolean playerWins = game.getPlayerWin();
		assertEquals(false, playerWins);
	}
	
	@Test
	public void test_determineWinner_07() throws Exception{
		Game game = new Game();
		BetsAndSpecific betsAndSpecific = new BetsAndSpecific(3,2);
		game.setDiceCombination(1,2,3);
		game.setDetermineWinner(betsAndSpecific);
		boolean playerWins = game.getPlayerWin();
		assertEquals(false, playerWins);
	}
	
	@Test
	public void test_determineWinner_08() throws Exception{
		Game game = new Game();
		BetsAndSpecific betsAndSpecific = new BetsAndSpecific(4,1);
		game.setDiceCombination(1,1,1);
		game.setDetermineWinner(betsAndSpecific);
		boolean playerWins = game.getPlayerWin();
		double odds = game.getOdds();
		assertEquals(true, playerWins);
		assertEquals(150,odds, 0.001);
	}
	
	@Test
	public void test_determineWinner_09() throws Exception{
		Game game = new Game();
		BetsAndSpecific betsAndSpecific = new BetsAndSpecific(4,2);
		game.setDiceCombination(1,1,1);
		game.setDetermineWinner(betsAndSpecific);
		boolean playerWins = game.getPlayerWin();
		assertEquals(false, playerWins);
	}
	
	@Test
	public void test_determineWinner_10() throws Exception{
		Game game = new Game();
		BetsAndSpecific betsAndSpecific = new BetsAndSpecific(4,1);
		game.setDiceCombination(1,2,3);
		game.setDetermineWinner(betsAndSpecific);
		boolean playerWins = game.getPlayerWin();
		assertEquals(false, playerWins);
	}
	
	@Test
	public void test_determineWinner_11() throws Exception{
		Game game = new Game();
		BetsAndSpecific betsAndSpecific = new BetsAndSpecific(5,0);
		game.setDiceCombination(1,1,1);
		game.setDetermineWinner(betsAndSpecific);
		boolean playerWins = game.getPlayerWin();
		double odds = game.getOdds();
		assertEquals(true, playerWins);
		assertEquals(24,odds, 0.001);
	}
	
	@Test
	public void test_determineWinner_12() throws Exception{
		Game game = new Game();
		BetsAndSpecific betsAndSpecific = new BetsAndSpecific(5,0);
		game.setDiceCombination(1,2,3);
		game.setDetermineWinner(betsAndSpecific);
		boolean playerWins = game.getPlayerWin();
		assertEquals(false, playerWins);
	}
	
	@Test
	public void test_determineWinner_13() throws Exception{
		Game game = new Game();
		BetsAndSpecific betsAndSpecific = new BetsAndSpecific(6,0);
		game.setDiceCombination(1,2,3);
		game.setDetermineWinner(betsAndSpecific);
		boolean playerWins = game.getPlayerWin();
		assertEquals(false, playerWins);
	}
	
	@Test
	public void test_getResult_01() throws Exception{
		class StubDice extends Dice{
			private int diceNum = 0;
			public void diceRandomizer() {
				diceNum = 1; 
			}
			public int getDiceNum() {
				return diceNum;
			}
		}
		StubDice stubDice = new StubDice();
		Game game = new Game();
		Account a = new Account("hi");
		DicePlayer player = new DicePlayer(a);
		BetsAndSpecific betsAndSpecific = new BetsAndSpecific(5,0);
		String result = game.getEndResult(stubDice, player, betsAndSpecific, 10);
		assertEquals("Result: (1,1,1) All same\nYou win! You won $250.0\nYour account balance is $1250.0",result);
	}
	
	@Test
	public void test_getResult_02() throws Exception{
		class StubDice extends Dice{
			private int diceNum = 0;
			public void diceRandomizer() {
				diceNum = 1; 
			}
			public int getDiceNum() {
				return diceNum;
			}
		}
		StubDice stubDice = new StubDice();
		Game game = new Game();
		Account a = new Account("hi");
		DicePlayer player = new DicePlayer(a);
		BetsAndSpecific betsAndSpecific = new BetsAndSpecific(1,0);
		String result = game.getEndResult(stubDice, player, betsAndSpecific, 10);
		assertEquals("Result: (1,1,1) All same\nYou lose! You lost $10.0\nYour account balance is $990.0",result);
	}
}