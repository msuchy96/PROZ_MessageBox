/**
 * Klasa testuj�ca projekt.
 * 
 */

package application;
import java.util.Scanner;

public class MessageBoxTests {
	
	/**
	 * Metoda pobieraj�ca od u�ytkownika informacje, wywo�uj�ca metody tworz�ce okno i wypisuj�ca wyniki.
	 * 
	 * @param args Argumenty z command_line
	 * @param title Argument typu String, do kt�rego przypisywany jest tytu� napisany przez u�ytkownika.
	 * @param infromation Argument typu String, do kt�rego przypisywany jest komunikat napisany przez u�ytkownika.
	 * @param input Argument typu Scanner pobieraj�cy z konsoli od u�ytkownika tytu� i komunikat.
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
		
		System.out.println("Odpowied�: " + result);
		
		System.exit(0);
	}
}
