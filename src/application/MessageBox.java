
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

public class MessageBox{

	
	
	private static MessageBoxResult BoxResult;

	
	private static void handleButtonAction(WindowEvent event, Button[] buttons, MessageBoxButtons boxButtons,Stage currentWindow) 
	{

		BoxResult = MessageBoxResult.Cancel;
		
		currentWindow.close();
		
			
	}
	
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
	private static void handleButtonAction(ActionEvent event, Button[] buttons, MessageBoxButtons boxButtons,Stage currentWindow) {

		for (int i = 0; i < boxButtons.getCount(); i++)
			if (event.getSource() == buttons[i]) 
			{
				BoxResult = MessageBoxResult.getResult(boxButtons.getText(i));
				System.out.println("clicked");
				currentWindow.close();
			}
	}

	private static Stage setNewWindow(String title)
	{
		Stage newStage = new Stage();
		newStage.setTitle(title);
		newStage.initModality(Modality.WINDOW_MODAL);
		return newStage;
	}
	
	private static BorderPane setNewLayout(ImageView imgPic, Text text, HBox btnBox)
	{
		BorderPane root = new BorderPane();
		root.setPadding(new Insets(20, 20, 20, 20));
		BorderPane.setAlignment(imgPic, Pos.CENTER);	
		root.setCenter(text);
		root.setBottom(btnBox);
		root.setLeft(imgPic);
		
		return root;
	}
	
	private static Text setNewText(String givenInformation)
	{
		Text text = new Text(givenInformation);
		text.setWrappingWidth(400);
		text.setTextAlignment(TextAlignment.CENTER);
		text.setTextAlignment(TextAlignment.JUSTIFY);
		return text;
		
	}
	
	private static Button[] setAllButtons(MessageBoxButtons buttonsPreference, HBox btnBox, Stage newWindow) 
	{
		
		Button[] buttons = new Button[buttonsPreference.getCount()];
		for (int i = 0; i < buttonsPreference.getCount(); i++) 
		{
			buttons[i] = new Button();
			buttons[i].setText(buttonsPreference.getText(i));
			btnBox.getChildren().add(buttons[i]);
			buttons[i].setOnAction(e -> handleButtonAction(e, buttons, buttonsPreference, newWindow));
		}
		
		return buttons;
		
	}
	
	private static void setbtnBoxProperties(HBox btnBox)
	{
		btnBox.setSpacing(20);
		btnBox.setPadding(new Insets(8, 0, 0, 0));
		btnBox.setAlignment(Pos.CENTER);
	}
	
	private static ImageView setPic(MessageBoxIcons iconPreference)
	{
		ImageView imgPic = new ImageView();
		// path - stworzenie dokladnej sciezki z nazwa wyswietlanej ikony
		String path = "file:src/images/" + iconPreference.toString(); 
		// img - zawiera wybrana ikone
		Image img = new Image(path); 
		imgPic.setImage(img);
		return imgPic;
	}
	
	private static void windowActions(Stage newWindow,Button[] buttons,MessageBoxButtons buttonsPreference,Scene scene)
	{
		newWindow.setOnCloseRequest(e -> handleButtonAction(e, buttons, buttonsPreference,newWindow));
		newWindow.setScene(scene);
		newWindow.setResizable(false);
		newWindow.showAndWait();
		
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
	public static MessageBoxResult show(String givenTitle, String givenInformation, MessageBoxButtons buttonsPreference, MessageBoxIcons iconPreference) 
	{

		Stage newWindow = setNewWindow(givenTitle);
		
		
		// text - odpowiada za opakowanie komunikatu i jego wyglad
		Text text = setNewText(givenInformation);
		

		// btnBox - odpowiada za opakowanie przyciskow i zarzadzanie ich wygladem
		HBox btnBox = new HBox(40);

		// []buttons - tablica trzymajaca wszystkie stworzone obiekty typu Button
		
		Button[] buttons = setAllButtons(buttonsPreference, btnBox, newWindow);
		
		setbtnBoxProperties(btnBox);


		// imgPic - odpowiada za opakowanie ikony i zarzadzanie nia
		ImageView imgPic = setPic(iconPreference);
				
		BorderPane borderLayout = setNewLayout(imgPic,text,btnBox);									
		
		// scene - "plotno" na ktorym wyswietlany jest zaprojektowany layout.
		Scene scene = new Scene(borderLayout); 
		
		windowActions(newWindow,buttons,buttonsPreference,scene);						
		

		return BoxResult;

	}

	
	
}
	
	
