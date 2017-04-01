package application;

import javafx.application.Application;
import javafx.stage.Stage;

/**
 * Klasa testujaca projekt.
 * 
 * Klasa nie potrzebuje konstruktora poniewaz obiekt nigdy nie jest tworzony.
 *
 * @author Maciej Suchocki / msuchock@stud.elka.pw.edu.pl
 */
public class MessageBoxTests extends Application {

	/**
	 * Metoda wywolujaca glowna metode JavaFx za pomocy metody Launch i
	 * zamykajaca program.
	 * 
	 * @param args
	 *            Argumenty z command_line
	 */
	public static void main(String[] args) {

		launch(args);
		System.exit(0);
	}

	/**
	 * Metoda odpowiadajaca za wywolanie metod tworzacych okno i wypisanie
	 * odpowiedzi uzytkownika.
	 * 
	 * @param arg0
	 *            Obiekt klasy Stage skonstruowany przez platforme JavaFx.
	 */
	@Override
	public void start(Stage arg0) {

		String title = "Lorem ipsum";
		String information = " Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.";
		MessageBoxResult result = MessageBox.show(title, information, MessageBoxButtons.YesNo, MessageBoxIcons.Warning);

		System.out.println("Answer: " + result);

	}
}
