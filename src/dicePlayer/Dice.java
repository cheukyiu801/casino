package dicePlayer;

public class Dice 
{
	private int diceNum = 0;
	
	public Dice()
	{
		this.diceRandomizer();
	}
	
	public void diceRandomizer() {
		//Min + (int)(Math.random() * ((Max - Min) + 1))
		diceNum = (1 + (int)(Math.random() * ((6 - 1) + 1))); 
	}
	
//	private void setDiceNum(int i) {
//		this.diceNum = i;
//	}
	public int getDiceNum() {
		return diceNum;
	}

}
