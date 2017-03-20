
/**
 * Klasa MessageBox implementujaca wyswietlanie i obsluge okna komunikatow.
 * Obiekt nigdy nie jest tworzony, wiec konstruktor jest zbedny.
 * W klasie wystepuja nastepujace parametry:
 * @param title	Parametr typu String odpowiadajacy za przechowanie nazwy tytulu okna komunikatu.
 * @param information Parametr typu String odpawiadajacy za przechowanie komunikatu podanego przez uzytkownika.
 * @param result Parametr typu String odpowiadajacy za przechowanie komunikatu, ktory znajdowal sie na przycisku, ktory nacisnal uzytkownik.
 * @param boxIcon Enum zawierajacy informacje o preferowanej ikonie.
 * @param boxButtons Enum zawierajacy informacje o preferowanych przyciskach.
 * 
 * @autor Maciej Suchocki / msuchock@stud.elka.pw.edu.pl
 * @version 1.7
 */

package application;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

public class MessageBox extends Application {

	private static String title;
	private static String information;
	private static String result;
	private static MessageBoxIcons boxIcon;
	private static MessageBoxButtons boxButtons;

	/**
	 * Metoda odpowiadajaca za obsluge event'u i zamykanie sceny.
	 * 
	 * @param event
	 *            Parametr typu Event, odpowiadajacy za przechowanie wykonanej
	 *            akcji.
	 * @param buttons
	 *            Tablica typu Buttnos, przechowujaca wszystkie predefiniowane
	 *            przyciski.
	 * @param primaryStage
	 *            Obiekt klasy Stage. Do tej metody przekazany jest w celu
	 *            zamkniecia okna, jesli ktorys z podanych przyciskow zostal
	 *            nacisniety.
	 */
	private void handleButtonAction(ActionEvent event, Button[] buttons, Stage primaryStage) {

		for (int i = 0; i < boxButtons.getCount(); i++)
			if (event.getSource() == buttons[i]) {
				result = boxButtons.getText(i);
				primaryStage.close();
			}

	}

	/**
	 * Metoda ustawiajaca wszystkie najwazniejsze parametry okna
	 * 
	 * @param givenTitle
	 *            Otrzymany tytul
	 * @param givenInformation
	 *            Otrzymany komunikat
	 * @param buttonsPreference
	 *            Otrzymane preferencje dotyczace przyciskow
	 * @param iconPreference
	 *            Otrzymane preferencje dotyczace ikony
	 */
	private static void setMessageBox(String givenTitle, String givenInformation, MessageBoxIcons iconPreference,
			MessageBoxButtons buttonsPreference) {
		title = givenTitle;
		information = givenInformation;
		boxIcon = iconPreference;
		boxButtons = buttonsPreference;

	}

	/**
	 * Metoda show() odpowiada za pobranie od uzytkownika w argumentach
	 * informacji o wyswietlanym oknie, wywolanie glownego settera MessageBox
	 * oraz wywolanie metody start() poprzez wywolanie metody Launch().
	 * 
	 * @param givenTitle
	 *            Otrzymany tytul
	 * @param givenInformation
	 *            Otrzymany komunikat
	 * @param buttonsPreference
	 *            Otrzymane preferencje dotyczace przyciskow
	 * @param iconPreference
	 *            Otrzymane preferencje dotyczace ikony
	 * @param args
	 *            Argumenty programu
	 * @return Enum MessageBoxResult, ktory mowi o tym jaki przycisk zostal
	 *         wcisniety
	 */
	public static MessageBoxResult show(String givenTitle, String givenInformation, MessageBoxButtons buttonsPreference,
			MessageBoxIcons iconPreference, String[] args) {

		setMessageBox(givenTitle, givenInformation, iconPreference, buttonsPreference);

		launch(args);

		return MessageBoxResult.getResult(result);

	}

	/**
	 * Metoda start() ,ktora odpowiada za tworzenie i wyswietlanie okna oraz
	 * "nasluchiwanie" czy jakis przycisk nie zostal nacisniety.
	 * 
	 * @param primaryStage
	 *            Obiekt klasy stage skonstruowany przez platforme JavaFx.
	 */
	@Override
	public void start(Stage primaryStage) {

		// root - jest to layout, ktory posiada 5 obszarow top, right, bottom, left, center
		BorderPane root = new BorderPane();
		root.setPadding(new Insets(20, 20, 20, 20));
		primaryStage.setTitle(title);

		// text - odpowiada za opakowanie komunikatu i jego wyglad
		Text text = new Text(information);
		text.setWrappingWidth(400);
		text.setTextAlignment(TextAlignment.CENTER);
		text.setTextAlignment(TextAlignment.JUSTIFY);
		root.setCenter(text);

		// btnBox - odpowiada za opakowanie przyciskow i zarzadzanie ich wygladem
		HBox btnBox = new HBox(40);

		// []buttons - trzymajaca wszystkie stworzone obiekty typu Button
		Button[] buttons = new Button[boxButtons.getCount()];
		for (int i = 0; i < boxButtons.getCount(); i++) {
			buttons[i] = new Button();
			buttons[i].setText(boxButtons.getText(i));
			btnBox.getChildren().add(buttons[i]);
		}

		btnBox.setSpacing(20);
		btnBox.setPadding(new Insets(8, 0, 0, 0));
		btnBox.setAlignment(Pos.CENTER);
		
		// path - stworzenie dokladnej sciezki z nazwa wyswietlanej ikony
		String path = "file:src/images/" + boxIcon.toString(); 
		// img - zawiera wybrana ikone
		Image img = new Image(path); 

		// imgPic - odpowiada za opakowanie ikony i zarzadzanie nia
		ImageView imgPic = new ImageView(); 
											
		imgPic.setImage(img);

		BorderPane.setAlignment(imgPic, Pos.CENTER);

		root.setBottom(btnBox);
		root.setLeft(imgPic);

		// scene - "plotno" na ktorym wyswietlany jest zaprojektowany layout.
		Scene scene = new Scene(root); 
									
		primaryStage.setScene(scene);
		primaryStage.setResizable(false);
		primaryStage.show();

		for (int i = 0; i < boxButtons.getCount(); i++)
			buttons[i].setOnAction(e -> handleButtonAction(e, buttons, primaryStage));

	}

}
