package test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import org.junit.Test;

import bank.Account;
import bank.Bank;
import blackjack.BlackJackPlayer;
import cardGame.Card;
import cardGame.Deck;
import common.Main;

public class bjTest {	
	/**Test for dealCard(ArrayList<Card> hand)*/
	@Test //Loop = 0
	public void dealCardTest_1() {
		ArrayList<Card> ph = new ArrayList<>();
		Account a = Bank.getInstance().createAccount("test");
		BlackJackPlayer bj = new BlackJackPlayer(0, ph, a);
		
		bj.dealCardPB(ph);
		assertEquals(0, bj.getHand().size());
	}
	
	@Test //Loop = 1
	public void dealCardTest_2() {
		ArrayList<Card> ph = new ArrayList<>();
		Account a = Bank.getInstance().createAccount("test");
		BlackJackPlayer bj = new BlackJackPlayer(1, ph, a);
		
		bj.dealCardPB(ph);
		assertEquals(1, bj.getHand().size());
	}
	
	@Test //Loop > 1
	public void dealCardTest_3() {
		ArrayList<Card> ph = new ArrayList<>();
		Account a = Bank.getInstance().createAccount("test");
		BlackJackPlayer bj = new BlackJackPlayer(2, ph, a);
		
		bj.dealCardPB(ph);
		assertEquals(2, bj.getHand().size());
	}
	
	/**Test for getCardInfo(ArrayList<Card> hand)*/
	@Test //Loop = 0
	public void getCardInfoTest_1() {
		ArrayList<Card> ph = new ArrayList<>();
				
		Account a = Bank.getInstance().createAccount("test");
		BlackJackPlayer bj = new BlackJackPlayer(2, ph, a);
		
		String result = bj.getCardInfoPB(bj.getHand());		
		assertEquals("", result);
	}
	
	@Test //Loop = 1
	public void getCardInfoTest_2() {
		ArrayList<Card> ph = new ArrayList<>();
		Card c1 = new Card(0,1);
				
		Account a = Bank.getInstance().createAccount("test");
		BlackJackPlayer bj = new BlackJackPlayer(2, ph, a);
		
		bj.getHand().add(c1);
		
		String result = bj.getCardInfoPB(bj.getHand());		
		assertEquals("1)   2 of Hearts\n", result);
	}
	
	@Test //Loop > 1
	public void getCardInfoTest_3() {
		ArrayList<Card> ph = new ArrayList<>();
		Card c1 = new Card(0,1);
		Card c2 = new Card(2,2);
				
		Account a = Bank.getInstance().createAccount("test");
		BlackJackPlayer bj = new BlackJackPlayer(2, ph, a);
		
		bj.getHand().add(c1);
		bj.getHand().add(c2);
		
		String result = bj.getCardInfoPB(bj.getHand());		
		assertEquals("1)   2 of Hearts\n2)   3 of Diamonds\n", result);
	}
	
	/**Test for getValueForBJ(int card)*/
	@Test //Card value = A
	public void getValueForBJTest_1() {
		ArrayList<Card> ph = new ArrayList<>();
		Card c1 = new Card(0,0);
		
		Account a = Bank.getInstance().createAccount("test");
		BlackJackPlayer bj = new BlackJackPlayer(1, ph, a);
		
		bj.getHand().add(c1);
		
		int result = ph.get(0).getValueForBJ(c1.getValue());		
		assertEquals(11, result);
	}
	
	@Test //Card value = 2
	public void getValueForBJTest_2() {
		ArrayList<Card> ph = new ArrayList<>();
		Card c1 = new Card(0,1);
		
		Account a = Bank.getInstance().createAccount("test");
		BlackJackPlayer bj = new BlackJackPlayer(1, ph, a);
		
		bj.getHand().add(c1);
		
		int result = ph.get(0).getValueForBJ(c1.getValue());
		assertEquals(2, result);
	}
	
	@Test //Card value = J
	public void getValueForBJTest_3() {
		ArrayList<Card> ph = new ArrayList<>();
		Card c1 = new Card(0,10);
		
		Account a = Bank.getInstance().createAccount("test");
		BlackJackPlayer bj = new BlackJackPlayer(1, ph, a);
		
		bj.getHand().add(c1);
		
		int result = ph.get(0).getValueForBJ(c1.getValue());
		assertEquals(10, result);
	}

	/**Test for countSum(ArrayList<Card> hand)*/
	@Test //Loop = 0
	public void countSumTest_1() {
		ArrayList<Card> ph = new ArrayList<>();
		
		Account a = Bank.getInstance().createAccount("test");
		BlackJackPlayer bj = new BlackJackPlayer(2, ph, a);
		
		int result = bj.countSumPB(bj.getHand());
		assertEquals(0, result);
	}
	
	@Test //Loop > 1
	public void countSumTest_2() {
		ArrayList<Card> ph = new ArrayList<>();
		Card c1 = new Card(0,0);
		
		Account a = Bank.getInstance().createAccount("test");
		BlackJackPlayer bj = new BlackJackPlayer(2, ph, a);
		
		bj.getHand().add(c1);
		
		int result = bj.countSumPB(bj.getHand());
		assertEquals(11, result);
	}
	
	@Test //Loop > 1
	public void countSumTest_3() {
		ArrayList<Card> ph = new ArrayList<>();
		Card c1 = new Card(0,0);
		Card c2 = new Card(2,0);
		
		Account a = Bank.getInstance().createAccount("test");
		BlackJackPlayer bj = new BlackJackPlayer(2, ph, a);
		
		bj.getHand().add(c1);
		bj.getHand().add(c2);
		
		int result = bj.countSumPB(bj.getHand());
		assertEquals(22, result);
	}
	
	/**Test for changeAceValue(int sum)*/
	@Test //Card value = A,A; sum = 22>12
	public void changeAceValueTest_1() {
		ArrayList<Card> ph = new ArrayList<>();
		
		Account a = Bank.getInstance().createAccount("test");
		BlackJackPlayer bj = new BlackJackPlayer(2, ph, a);
		
		int result = bj.changeAceValuePB(22);
		assertEquals(12, result);
	}

	/**Test for checkAce(ArrayList<Card> hand)*/
	@Test //Loop = 0
	public void checkAceTest_1() {
		ArrayList<Card> ph = new ArrayList<>();
		
		Account a = Bank.getInstance().createAccount("test");
		BlackJackPlayer bj = new BlackJackPlayer(2, ph, a);
		
		int result = bj.checkAcePB(ph);
		assertEquals(0, result);
	}
	
	@Test //Loop = 1
	public void checkAceTest_2() {
		ArrayList<Card> ph = new ArrayList<>();
		Card c1 = new Card(0,0);
		
		Account a = Bank.getInstance().createAccount("test");
		BlackJackPlayer bj = new BlackJackPlayer(2, ph, a);
		
		bj.getHand().add(c1);
		
		int result = bj.checkAcePB(ph);
		assertEquals(1, result);
	}
	
	@Test //Loop > 1
	public void checkAceTest_3() {
		ArrayList<Card> ph = new ArrayList<>();
		Card c1 = new Card(0,1);
		Card c2 = new Card(2,1);
		
		Account a = Bank.getInstance().createAccount("test");
		BlackJackPlayer bj = new BlackJackPlayer(2, ph, a);
		
		bj.getHand().add(c1);
		bj.getHand().add(c2);
		
		int result = bj.checkAcePB(ph);
		assertEquals(0, result);
	}
	
	/**Test for recountSum(int oldSum, int numOfAce)*/
	@Test //Loop = 0
	public void recountSumTest_1() {
		ArrayList<Card> ph = new ArrayList<>();
		
		Account a = Bank.getInstance().createAccount("test");
		BlackJackPlayer bj = new BlackJackPlayer(2, ph, a);
		
		int result = bj.recountSumPB(22, 0);
		assertEquals(0, result);
	}
	
	@Test//Loop = 1
	public void recountSumTest_2() {
		ArrayList<Card> ph = new ArrayList<>();
		
		Account a = Bank.getInstance().createAccount("test");
		BlackJackPlayer bj = new BlackJackPlayer(2, ph, a);

		int result = bj.recountSumPB(22, 1);
		assertEquals(12, result);
	}
	
	@Test//Loop > 1
	public void recountSumTest_3() {
		ArrayList<Card> ph = new ArrayList<>();
		
		Account a = Bank.getInstance().createAccount("test");
		BlackJackPlayer bj = new BlackJackPlayer(2, ph, a);
		
		int result = bj.recountSumPB(32, 2);
		assertEquals(12, result);
	}
	
	/**Test for compare(int player, int dealer)*/
	@Test //P>D
	public void compareTest_1() {
		ArrayList<Card> ph = new ArrayList<>();
		
		Account a = Bank.getInstance().createAccount("test");
		BlackJackPlayer bj = new BlackJackPlayer(2, ph, a);

		int playSum = 21;
		int dealSum = 20;
		
		int result = bj.comparePB(playSum, dealSum);
		assertEquals(1, result);
	}
	
	@Test //P<D
	public void compareTest_2() {
		ArrayList<Card> ph = new ArrayList<>();
		
		Account a = Bank.getInstance().createAccount("test");
		BlackJackPlayer bj = new BlackJackPlayer(2, ph, a);

		int playSum = 20;
		int dealSum = 22;
		
		int result = bj.comparePB(playSum, dealSum);
		assertEquals(1, result);
	}
	
	@Test //P=D
	public void compareTest_3() {
		ArrayList<Card> ph = new ArrayList<>();
		
		Account a = Bank.getInstance().createAccount("test");
		BlackJackPlayer bj = new BlackJackPlayer(2, ph, a);

		int playSum = 20;
		int dealSum = 21;
		
		int result = bj.comparePB(playSum, dealSum);
		assertEquals(-1, result);
	}
	
	@Test //P<D; D>21
	public void compareTest_4() {
		ArrayList<Card> ph = new ArrayList<>();
		
		Account a = Bank.getInstance().createAccount("test");
		BlackJackPlayer bj = new BlackJackPlayer(2, ph, a);

		int playSum = 18;
		int dealSum = 18;
		
		int result = bj.comparePB(playSum, dealSum);
		assertEquals(0, result);
	}

	/**Test for determineHand()*/
	@Test
	public void determineHandTest_1() {
		ArrayList<Card> ph = new ArrayList<>();
		
		Account a = Bank.getInstance().createAccount("test");
		BlackJackPlayer bj = new BlackJackPlayer(2, ph, a);
		
		String result = bj.determineHand(21,2);
		assertEquals("NATURAL_BLACKJACK", result);
	}
	
	@Test
	public void determineHandTest_2() {
		ArrayList<Card> ph = new ArrayList<>();
		
		Account a = Bank.getInstance().createAccount("test");
		BlackJackPlayer bj = new BlackJackPlayer(2, ph, a);
		
		String result = bj.determineHand(22,2);
		assertEquals("BUSTED", result);
	}
	
	@Test
	public void determineHandTest_3() {
		ArrayList<Card> ph = new ArrayList<>();
		
		Account a = Bank.getInstance().createAccount("test");
		BlackJackPlayer bj = new BlackJackPlayer(2, ph, a);
		
		String result = bj.determineHand(20,2);
		assertEquals("NORMAL", result);
	}
	
	@Test
	public void determineHandTest_4() {
		ArrayList<Card> ph = new ArrayList<>();
		
		Account a = Bank.getInstance().createAccount("test");
		BlackJackPlayer bj = new BlackJackPlayer(2, ph, a);
		String result = bj.determineHand(21, 5);
		assertEquals("FIVE_CARD_TRICK", result);
	}
	
	
	@Test //HIT //NO ACE //DEALER HIT
	public void playTest_1() {
		class StubBlackJack extends BlackJackPlayer {
			public StubBlackJack(int number, ArrayList<Card> hand, Account account) {
				super(number, hand, account);
			}
			private void dealCardStub(ArrayList<Card> hand) {
			}
			public String msgNormal() {
				return "0";
			}
		}
		ArrayList<Card> ph = new ArrayList<>();
		
		Account a = Bank.getInstance().createAccount("test");
		StubBlackJack bj = new StubBlackJack(2, ph, a);
		bj.dealCardStub(bj.getHand());

		Card c1 = new Card(0,10); //J
		Card c2 = new Card(0,10); //J
		Card c3 = new Card(0,3); //4
		bj.getHand().add(c1);
		bj.getHand().add(c2); //PH = J,J = 20
		bj.getDealerHand().add(c2);
		bj.getDealerHand().add(c3); //DH = J,4 = 14
		
		bj.play();	
	}
	
	@Test //HIT //NO ACE //DEALER NO HIT
	public void playTest_2() {
		class StubBlackJack extends BlackJackPlayer {
			public StubBlackJack(int number, ArrayList<Card> hand, Account account) {
				super(number, hand, account);
			}
			private void dealCardStub(ArrayList<Card> hand) {
			}
			public String msgNormal() {
				return "0";
			}
		}
		ArrayList<Card> ph = new ArrayList<>();
		
		Account a = Bank.getInstance().createAccount("test");
		StubBlackJack bj = new StubBlackJack(2, ph, a);
		bj.dealCardStub(bj.getHand());

		Card c1 = new Card(0,10); //J
		Card c2 = new Card(0,10); //J
		bj.getHand().add(c1);
		bj.getHand().add(c2); //PH = J,J = 20
		bj.getDealerHand().add(c1);
		bj.getDealerHand().add(c2); //DH = J,4 = 20
		
		bj.play();	
	}
	
	@Test //HIT //BOTH HAVE ACE //D1 NOT ACE //D>17
	public void playTest_3() {
		class StubBlackJack extends BlackJackPlayer {
			public StubBlackJack(int number, ArrayList<Card> hand, Account account) {
				super(number, hand, account);
			}
			private void dealCardStub(ArrayList<Card> hand) {
				Card c4 = new Card(2,0); //9
				getHand().add(c4);
			}
			public String msgNormal() {
				return "0";
			}
		}
		ArrayList<Card> ph = new ArrayList<>();
		
		Account a = Bank.getInstance().createAccount("test");
		StubBlackJack bj = new StubBlackJack(2, ph, a);
		bj.dealCardStub(bj.getHand());

		Card c1 = new Card(0,0); //A
		Card c2 = new Card(0,8); //9
		Card c3 = new Card(1,8); //9
		
		bj.getHand().add(c3);
		bj.getHand().add(c2); //PH = 9,9
		bj.getDealerHand().add(c2);
		bj.getDealerHand().add(c1); //DH = 9 = 19
		
		bj.play();	
	}
	
	@Test //HIT //BOTH HAVE ACE //D1 NOT ACE //D < 17
	public void playTest_4() {
		class StubBlackJack extends BlackJackPlayer {
			public StubBlackJack(int number, ArrayList<Card> hand, Account account) {
				super(number, hand, account);
			}
			private void dealCardStub(ArrayList<Card> hand) {
			}
			public String msgNormal() {
				return "0";
			}
		}
		ArrayList<Card> ph = new ArrayList<>();
		
		Account a = Bank.getInstance().createAccount("test");
		StubBlackJack bj = new StubBlackJack(2, ph, a);
		

		Card c1 = new Card(0,10); //J
		Card c2 = new Card(0,11); //Q
		Card c3 = new Card(1,3); //4
		
		bj.getHand().add(c1);
		bj.getHand().add(c2); //PH = J,Q = 20
		bj.dealCardStub(bj.getHand());
		bj.getDealerHand().add(c3); //DH = 4
		bj.getDealerHand().add(c1); //DH = 4,J = 14
		
		bj.play();
	}
	
	@Test //INS //BOTH HAVE ACE //STAND //DH > 17 //DH1 = ACE
	public void playTest_5() {
		class StubBlackJack extends BlackJackPlayer {
			public StubBlackJack(int number, ArrayList<Card> hand, Account account) {
				super(number, hand, account);
			}
			private void dealCardStub(ArrayList<Card> hand) {
			}
			public String msgInsurance() {
				return "8";
			}
			public String msgNormal() {
				return "6";
			}
		}
		ArrayList<Card> ph = new ArrayList<>();
		
		Account a = Bank.getInstance().createAccount("test");
		StubBlackJack bj = new StubBlackJack(2, ph, a);
		bj.dealCardStub(bj.getHand());

		Card c1 = new Card(0,10); //J
		Card c2 = new Card(0,0); //A
		bj.getHand().add(c1);
		bj.getHand().add(c2); //PH = J,A = 20
		bj.getDealerHand().add(c2);
		bj.getDealerHand().add(c1); //DH = A,J = 20
		
		bj.play();	
	}
	
	@Test //NO INS //BOTH HAVE ACE //STAND //DH < 17 //DH1 = ACE
	public void playTest_6() {
		class StubBlackJack extends BlackJackPlayer {
			public StubBlackJack(int number, ArrayList<Card> hand, Account account) {
				super(number, hand, account);
			}
			private void dealCardStub(ArrayList<Card> hand) {
			}
			public String msgInsurance() {
				return "6";
			}
		}
		ArrayList<Card> ph = new ArrayList<>();
		
		Account a = Bank.getInstance().createAccount("test");
		StubBlackJack bj = new StubBlackJack(2, ph, a);
		bj.dealCardStub(bj.getHand());

		Card c1 = new Card(0,10); //J
		Card c2 = new Card(0,0); //A
		Card c3 = new Card(0,3); //4
		bj.getHand().add(c1);
		bj.getHand().add(c2); //PH = J,J = 20
		bj.getDealerHand().add(c2);
		bj.getDealerHand().add(c3); //DH = A,4 = 15
		
		bj.play();	
	}
	
	@Test //STAND //NO ACE //D HAVE ACE
	public void playTest_7() {
		class StubBlackJack extends BlackJackPlayer {
			public StubBlackJack(int number, ArrayList<Card> hand, Account account) {
				super(number, hand, account);
			}
			private void dealCard(ArrayList<Card> hand) {
			}
			public String msgNormal() {
				return "6";
			}
		}
		ArrayList<Card> ph = new ArrayList<>();
		
		Account a = Bank.getInstance().createAccount("test");
		StubBlackJack bj = new StubBlackJack(2, ph, a);
		bj.dealCard(bj.getHand());

		Card c1 = new Card(0,0); //A
		Card c2 = new Card(0,10); //J
		Card c3 = new Card(0,8); //9
		bj.getHand().add(c2);
		bj.getHand().add(c3); //PH = J,9 = 19
		bj.getDealerHand().add(c3);
		bj.getDealerHand().add(c1); //DH = 9,A = 20
		
		bj.play();
	}
	
	@Test //STAND //PLAYER HAVE ACE
	//(dealerSum > 21)=F && (dealerHaveAce>0)=F
	public void playTest_8() {
		class StubBlackJack extends BlackJackPlayer {
			public StubBlackJack(int number, ArrayList<Card> hand, Account account) {
				super(number, hand, account);
			}
			private void dealCardStub(ArrayList<Card> hand) {
			}
			public String msgNormal() {
				return "6";
			}
		}
		ArrayList<Card> ph = new ArrayList<>();
		
		Account a = Bank.getInstance().createAccount("test");
		StubBlackJack bj = new StubBlackJack(2, ph, a);
		bj.dealCardStub(bj.getHand());

		Card c1 = new Card(0,0); //A
		Card c2 = new Card(0,10); //J
		Card c3 = new Card(0,3); //4
		bj.getHand().add(c1);
		bj.getHand().add(c2); //PH = A,J = 21
		bj.getDealerHand().add(c2);
		bj.getDealerHand().add(c3); //DH = J,4 = 14
		
		bj.play();	
	}
	
	@Test //NO CARD
	public void playTest_9() {
		class StubBlackJack extends BlackJackPlayer {
			public StubBlackJack(int number, ArrayList<Card> hand, Account account) {
				super(number, hand, account);
			}
			private void dealCardStub(ArrayList<Card> hand) {
			}
		}
		ArrayList<Card> ph = new ArrayList<>();
		
		Account a = Bank.getInstance().createAccount("test");
		StubBlackJack bj = new StubBlackJack(0, ph, a);
		bj.dealCardStub(bj.getHand());

		
		bj.play();	
	}
	
	@Test //D HAVE ACE //HIT //INSURANCE //D1 != ACE
	//(dealerSum > 21)=T && (dealerHaveAce>0)=T
	public void playTest_10() {
		class StubBlackJack extends BlackJackPlayer {
			public StubBlackJack(int number, ArrayList<Card> hand, Account account) {
				super(number, hand, account);
			}
			private void dealCardStub(ArrayList<Card> hand) {
				Card c3 = new Card(0,0); //A
				getDealerHand().add(c3);
			}
			public String msgInsurance() {
				return "8";
			}
			public String msgNormal() {
				return "0";
			}
		}
		
		ArrayList<Card> ph = new ArrayList<>();
		
		Account a = Bank.getInstance().createAccount("test");
		StubBlackJack bj = new StubBlackJack(2, ph, a);
		bj.dealCardStub(bj.getHand());

		Card c1 = new Card(0,10); //J
		Card c2 = new Card(0,10); //J
		Card c3 = new Card(0,3); //4
		
		bj.getHand().add(c1);
		bj.getHand().add(c2); //PH = J,J = 20

		bj.getDealerHand().add(c2);
		bj.getDealerHand().add(c3); //DH = J,4 = 14
		bj.play();
	}
	
	@Test //(dealerSum > 21)=T && (dealerHaveAce>0)=F
	public void playTest_11() {
		class StubBlackJack extends BlackJackPlayer {
			public StubBlackJack(int number, ArrayList<Card> hand, Account account) {
				super(number, hand, account);
			}
			private void dealCardStub(ArrayList<Card> hand) {
				Card c3 = new Card(1,10); //J
				getDealerHand().add(c3);
			}
			public String msgNormal() {
				return "0";
			}
		}
		
		ArrayList<Card> ph = new ArrayList<>();
		
		Account a = Bank.getInstance().createAccount("test");
		StubBlackJack bj = new StubBlackJack(2, ph, a);
		bj.dealCardStub(bj.getHand());

		Card c1 = new Card(0,10); //J
		Card c2 = new Card(0,10); //J
		Card c3 = new Card(0,3); //4
		
		bj.getHand().add(c1);
		bj.getHand().add(c2); //PH = J,J = 20

		bj.getDealerHand().add(c2);
		bj.getDealerHand().add(c3); //DH = J,4 = 14
		bj.play();
	}
	
//	@Test //??????
//	public void mainTest() {
//		Main.main(null);
//	}
}
