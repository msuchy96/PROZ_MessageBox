/**
 * Klasa testuj¹ca projekt.
 * 
 */

package application;
import java.util.Scanner;

public class MessageBoxTests {
	
	/**
	 * Metoda pobieraj¹ca od u¿ytkownika informacje, wywo³uj¹ca metody tworz¹ce okno i wypisuj¹ca wyniki.
	 * 
	 * @param args Argumenty z command_line
	 * @param title Argument typu String, do którego przypisywany jest tytu³ napisany przez u¿ytkownika.
	 * @param infromation Argument typu String, do którego przypisywany jest komunikat napisany przez u¿ytkownika.
	 * @param input Argument typu Scanner pobieraj¹cy z konsoli od u¿ytkownika tytu³ i komunikat.
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
		
		System.out.println("OdpowiedŸ: " + result);
		
		System.exit(0);
	}
}
