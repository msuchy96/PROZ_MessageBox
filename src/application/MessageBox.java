package application;

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
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

/**
 * Klasa implementujaca wyswietlanie i obsluge okna komunikatow. Obiekt nigdy
 * nie jest tworzony, wiec konstruktor jest zbedny.
 *
 * 
 * @param boxResult
 *            Wartosc zwracana przez metode. Informuje o tym jaki przycisk
 *            zostal nacisniety.
 * 
 * @autor Maciej Suchocki / msuchock@stud.elka.pw.edu.pl
 */
public class MessageBox {

	private static MessageBoxResult boxResult;

	/**
	 * Metoda ustawiajaca odpowiedz co zostalo klikniete
	 * 
	 * @param result
	 *            Enum z odpowiedzia
	 */
	private static void setBoxResult(MessageBoxResult result) {
		boxResult = result;
	}

	/**
	 * Metoda odpowiadająca za ustawienie najwazniejszych parametrow okna.
	 * 
	 * @param title
	 *            Tytul wyswietlanego okna.
	 * @return Kontener odpowiadajacy za okno.
	 */
	private static Stage setNewStage(String title) {
		Stage newStage = new Stage();
		newStage.setTitle(title);
		newStage.initModality(Modality.WINDOW_MODAL);
		return newStage;
	}

	/**
	 * Metoda odpowiadajaca za opakowanie komunikatu wyswietlanego w oknie.
	 * 
	 * @param givenInformation
	 *            Komunikat wyswietlany w oknie
	 * @return Kontener odpowiadajacy za opakowanie komunikatu wyswietlanego w
	 *         oknie.
	 */
	private static Text setNewText(String givenInformation) {
		Text text = new Text(givenInformation);
		text.setWrappingWidth(400);
		text.setTextAlignment(TextAlignment.CENTER);
		text.setTextAlignment(TextAlignment.JUSTIFY);
		return text;

	}

	/**
	 * Metoda odpowiadajaca za ustawienie wyglady konteneru na dodane przyciski.
	 * 
	 * @param btnBox
	 *            Kontener zawierajacy dodane przyciski.
	 */
	private static void setbtnBoxProperties(HBox btnBox) {
		btnBox.setSpacing(20);
		btnBox.setPadding(new Insets(8, 0, 0, 0));
		btnBox.setAlignment(Pos.CENTER);
	}

	/**
	 * Metoda odpowiadajaca za opakowanie wszystkich przyciskow w kontener i
	 * ustawienia ich jako aktywne.
	 * 
	 * @param buttonsPreference
	 * @param btnBox
	 *            Konteren z przyciskami.
	 * @param currentStage
	 *            Aktualne okno.
	 */
	private static void setAllButtons(MessageBoxButtons buttonsPreference, HBox btnBox, Stage currentStage) {

		Button[] buttons = new Button[buttonsPreference.getCount()];
		for (int i = 0; i < buttonsPreference.getCount(); i++) {
			buttons[i] = new Button();
			buttons[i].setText(buttonsPreference.getText(i));
			btnBox.getChildren().add(buttons[i]);
			buttons[i].setOnAction(e -> handleButtonAction(e, buttons, buttonsPreference, currentStage));
		}

	}

	/**
	 * Metoda odpowiadajaca za ustawienie najwazniejszych parametrow opakowania
	 * zarzadzajacego ukladem w oknie.
	 * 
	 * @param imgPic
	 *            Opakowany obrazek
	 * @param text
	 *            Opakowany komunikat
	 * @param btnBox
	 *            Opakowane przyciski
	 * @return Kontener zarzadzajacy ukladem w oknie.
	 */
	private static BorderPane setNewLayout(ImageView imgPic, Text text, HBox btnBox) {

		BorderPane root = new BorderPane();
		root.setPadding(new Insets(20, 20, 20, 20));
		BorderPane.setAlignment(imgPic, Pos.CENTER);
		root.setCenter(text);
		root.setBottom(btnBox);
		root.setLeft(imgPic);

		return root;
	}

	/**
	 * Metoda odpowiadajaca za opakowanie obrazka wyswietlanego w oknie.
	 * 
	 * @param iconPreference
	 *            Enum zawierajacy informacje o obrazku do wyswietlenia
	 * @return Kontener odpowiadajacy za opakowanie obrazka wyswietlanego w
	 *         oknie.
	 */
	private static ImageView setPic(MessageBoxIcons iconPreference) {
		ImageView imgPic = new ImageView();
		String path = "file:src/images/" + iconPreference.toString();
		Image img = new Image(path);
		imgPic.setImage(img);
		return imgPic;
	}

	/**
	 * Metoda odpowiadajaca za akcje ktore podejmuje okno i ustawienie na nim
	 * sceny.
	 * 
	 * @param currentStage
	 *            Aktualne okno.
	 * @param scene
	 *            Kontener na ktorym wyswietlany jest layout.
	 */
	private static void stageActions(Stage currentStage, Scene scene) {

		currentStage.setOnCloseRequest(e -> closeWindow(e, currentStage));
		currentStage.setScene(scene);
		currentStage.setResizable(false);
		currentStage.showAndWait();

	}

	/**
	 * Metoda odpowiadajaca za obsluge event'u i zamykanie okna.
	 * 
	 * @param event
	 *            Parametr odpowiadajacy za przechowanie wykonanej akcji.
	 * @param buttons
	 *            Tablica przechowujaca wszystkie predefiniowane przyciski.
	 * @param boxButtons
	 *            Enum, zawieracjacy predefiniowane przyciski.
	 * @param currentStage
	 *            Aktualne okno.
	 */
	private static void handleButtonAction(ActionEvent event, Button[] buttons, MessageBoxButtons boxButtons,
			Stage currentStage) {

		for (int i = 0; i < boxButtons.getCount(); i++)
			if (event.getSource() == buttons[i]) {
				setBoxResult(MessageBoxResult.getResult(boxButtons.getText(i)));
				currentStage.close();
			}
	}

	/**
	 * Metoda obslugujaca zamykanie okna przyciskiem zamkniecia okna w prawym
	 * gornym rogu.
	 * 
	 * @param event
	 *            Jest to akcja ktora zostala podjeta przez okno.
	 * @param currentStage
	 *            Aktualne okno.
	 */
	private static void closeWindow(WindowEvent event, Stage currentStage) {

		setBoxResult(MessageBoxResult.Cancel);
		currentStage.close();

	}

	/**
	 * Metoda odpowiada za pobranie od uzytkownika w argumentach informacji o
	 * wyswietlanym oknie. Stworzenie i wyswietlenie go oraz jego obsluge.
	 * 
	 * @param givenTitle
	 *            Otrzymany tytul
	 * @param givenInformation
	 *            Otrzymany komunikat
	 * @param buttonsPreference
	 *            Otrzymane preferencje dotyczace przyciskow
	 * @param iconPreference
	 *            Otrzymane preferencje dotyczace ikony
	 * 
	 * @return Enum, ktory mowi o tym jaki przycisk zostal wcisniety
	 */
	public static MessageBoxResult show(String givenTitle, String givenInformation, MessageBoxButtons buttonsPreference,
			MessageBoxIcons iconPreference) {

		Stage newStage = setNewStage(givenTitle);

		Text text = setNewText(givenInformation);

		HBox btnBox = new HBox(40);

		setAllButtons(buttonsPreference, btnBox, newStage);

		setbtnBoxProperties(btnBox);

		ImageView imgPic = setPic(iconPreference);

		BorderPane borderLayout = setNewLayout(imgPic, text, btnBox);

		Scene scene = new Scene(borderLayout);

		stageActions(newStage, scene);

		return boxResult;

	}

}
