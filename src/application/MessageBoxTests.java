/**
 * Klasa testujaca projekt.
 * 
 * Klasa nie potrzebuje konstruktora poniewaz obiekt nigdy nie jest tworzony.
 */

package application;

import java.util.Scanner;

public class MessageBoxTests {

	
	/**
	 * Metoda pobierajaca od uaytkownika informacje, wywolujaca metody tworzace
	 * okno i wypisujaca wyniki.
	 * 
	 * @param args
	 *            Argumenty z command_line
	 */
	public static void main(String[] args) {
		String title;
		String information;
		Scanner input = new Scanner(System.in);

		System.out.println("Podaj tytul:");
		title = input.nextLine(); // uzytkownik wprowadza tytul

		System.out.println("Podaj komunikat: ");
		information = input.nextLine(); // uzytkownik wprowadza komunikat

		MessageBoxResult result = MessageBox.show(title, information, MessageBoxButtons.YesNo, MessageBoxIcons.Warning,
				args);

		System.out.println("Odpowiedz: " + result);

		System.exit(0);
	}
}
