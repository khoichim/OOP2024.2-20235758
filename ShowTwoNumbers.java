import javax.swing.J0ptionPane;
public class ShowTwoNumbers
{
	public static void main(String[] args)
	{
		String strNum1, strNum2;
		String strNotification = "You've just enter: ";
		strNUm1 = J0ptionPane.showInputDialog(null, "Please input the first number: ","Input the first number", J0ptionPane.INFORMATION_MESSAGE);
		strNotification += strNum1 + " and ";

		strNum2 = J0ptionPane.showInputDialog(null, "Please input the second number: ","Input the second number", J0ptionPane.INFORMATION_MESSAGE);
		strNotification += strNum2;
		J0ptionPane.showMessageDialog(null,strNotification,"Show two numbers", J0ptionPane.INFORMATION>MESSAGE);
		System.exit(0);
	}
}
