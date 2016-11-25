package common;
import javax.swing.JOptionPane;

public class UserInput 
{
	public static String getUserName()
	{
		return JOptionPane.showInputDialog("Please enter the name for your account");
	}
	
	public static int getUserChoice()
	{
		String temp = JOptionPane.showInputDialog("Enter the number corresponding to what you would like to do. \n1. Play Poker \n2. Play BlackJack \n3. Play Sic Bo \n4. Quit");
		return Integer.parseInt(temp);
	}
	
	public static int getBet()
	{
		String temp = JOptionPane.showInputDialog("Enter the amount you want to bet");
		return Integer.parseInt(temp);
	}
	
	public static int getPlayerBetType(int r)
	{
		String temp = JOptionPane.showInputDialog("Round :"+r+"\t Please enter your bets!"
				+ "\n 1=Big (1:1) \n 2=Small (1:1) \n 3=Specific Doubles (1:8) \n 4=Specific 'Triples'/Alls (1:150) \n 5=Any Triple/All 'Alls' (1:24)");
		return Integer.parseInt(temp);
	}
	
	public static int getSpecific()
	{
		String temp = JOptionPane.showInputDialog("Please enter the specific number");
		return Integer.parseInt(temp);
	}
	
	public static boolean chooseContinue() 
	{
		Object[] options = {"Yes","No"};
		int n = JOptionPane.showOptionDialog(null,"Continue?", null, JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.DEFAULT_OPTION,  null, options, options[1]);
		return n==0;
	}
}
