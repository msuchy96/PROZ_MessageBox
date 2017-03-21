/**
 * Klasa testujaca projekt.
 * 
 * Klasa nie potrzebuje konstruktora poniewaz obiekt nigdy nie jest tworzony.
 */

package application;



import javafx.application.Application;
import javafx.stage.Stage;

public class MessageBoxTests extends Application {

	
	/**
	 * Metoda pobierajaca od uaytkownika informacje, wywolujaca metody tworzace
	 * okno i wypisujaca wyniki.
	 * 
	 * @param args
	 *            Argumenty z command_line
	 */
	public static void main(String[] args) {
		
		launch(args);
		System.exit(0);
	}

	/**
	 * Metoda start() ,ktora odpowiada za tworzenie i wyswietlanie okna oraz
	 * "nasluchiwanie" czy jakis przycisk nie zostal nacisniety.
	 * 
	 * @param arg0
	 *            Obiekt klasy stage skonstruowany przez platforme JavaFx.
	 */
	@Override
	public void start(Stage arg0)  {
		
		String title = "Tytul";
		String information = " Wszystkie informacje ";
	
		
		MessageBoxResult result = MessageBox.show(title, information, MessageBoxButtons.YesNo, MessageBoxIcons.Warning);

		System.out.println("Odpowiedz: " + result);
		
		
	}
}
