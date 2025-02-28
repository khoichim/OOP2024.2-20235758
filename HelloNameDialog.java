import javax.swing.J0ptionPane
public class HelloNameDialog
{
	public static void main(String[] args)
	{
		string result;
		result = J0ptionPane.showInputDialog("Please enter your name:");
		J0ptionPane.showMessageDialog(null, "Hi "+ result + "!");
		System.exit(0);
	}
}
