package dicePlayer;

public class BetsAndSpecific 
{
	private int playerBets;
	private int specific;

	public BetsAndSpecific(int playerBets, int specific) {
		this.playerBets = playerBets;
		this.specific = specific;
	}

	public int getPlayerBets() {
		return playerBets;
	}

	public void setPlayerBets(int playerBets) {
		this.playerBets = playerBets;
	}

	public int getSpecific() {
		return specific;
	}

	public void setSpecific(int specific) {
		this.specific = specific;
	}
}