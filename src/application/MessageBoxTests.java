/**
 * 
 * 
 * 
 * 
 * 
 */

package application;
import java.util.Scanner;

public class MessageBoxTests {
	/**
	 * 
	 * 
	 * @param args
	 */
	public static void main(String[] args) 
	{
		String title;
		String information;
		Scanner input = new Scanner(System.in);
		System.out.println("Give Title:");
		title = input.nextLine();
		
		System.out.println("Give Information: ");
		information = input.nextLine();
		
		MessageBoxResult result = MessageBox.show(title,information,MessageBoxButtons.YesNo,MessageBoxIcons.Warning,args);
		
		System.out.println("Odpowiedü: " + result);
		
		System.exit(0);
	}
}
