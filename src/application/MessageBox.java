/**
 * Klasa MessageBox implementuj�ca wy�wietlanie i obs�ug� okna komunikat�w.
 * 
 * W klasie wyst�puj� nast�puj�ce parametry:
 * @param title	Parametr typu String odpowiadaj�cy za przechowanie nazwy tytu�u okna komunikatu.
 * @param information Parametr typu String odpawiadaj�cy za przechowanie komunikatu podanego przez u�ytkownika.
 * @param buttonLabels Tablica typu String odpowiadaj�ca za przechowanie wszystkich komunikat�w wy�wietlanych na przyciskach okna komunikatu.
 * @param iconName Parametr typu String odpowiadaj�cy za przechowanie nazwy pliku zawieraj�cego obrazek wy�wietlany w oknie komunikatu.
 * @param result Parametr typu String odpowiadaj�cy za przechowanie komunikatu, kt�ry znajdowa� si� na przycisku, kt�ry nacisn�� u�ytkownik.
 * @param numberOfButtons Paramtr typu int oddpowiadaj�cy za przechowanie liczby predefiniowanych przycisk�w.
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
	private static String[] buttonLabels;
	private static String iconName;
	private static String result;
	private static int numberOfButtons;
	
	
	
	
	
	/**
	 *  Metoda show() odpowiada za pobranie od u�ytkownika w argumentach informacji o wy�wietlanym oknie, zapisanie ich jako argumenty klasy MessageBox
	 *  ,wywo�anie metody start() poprzez wywo�anie metody Launch() i zwr�cenie wyniku.
	 * 
	 * 
	 * @param givenTitle Otrzymany tytu�
	 * @param givenInformation Otrzymany komunikat
	 * @param ButtonsPreference Otrzymane preferencje dotycz�ce przycisk�w
	 * @param IconPreference Otrzymane preferencje dotycz�ce ikony 
	 * @param args Argumenty programu
	 * @return Gotowy enum MessageBoxResult, kt�ry m�wi o tym jaki przycisk zosta� wci�ni�ty
	 */
	
	public static MessageBoxResult show(String givenTitle, String givenInformation, MessageBoxButtons ButtonsPreference,MessageBoxIcons IconPreference, String[] args) {
		
		title = givenTitle;
		information = givenInformation;
		numberOfButtons = ButtonsPreference.getCount();
		buttonLabels = new String[numberOfButtons];
		iconName = IconPreference.toString();

		for (int i = 0; i < numberOfButtons; i++)
			buttonLabels[i] = ButtonsPreference.getText(i);

		 launch(args);
		
		return MessageBoxResult.getResult(result);

	}

	
		/** 
		 * Metoda start() odpowiada za wy�wietlanie tworzenie i wy�wietlanie okna oraz "nas�uchiwanie" czy jaki� przycisk nie zosta� naci�ni�ty.
		 * 
		 * 
		 * @param primaryStage Obiekt klasy stage skonstruowany przez platforme JavaFx
		 * @param root Obiekt klasy BorderPane. Jest to layout, kt�ry posiada 5 obszar�w: top,right,bottom,left,center
		 * @param text Obiekt klasy Text, kt�ry odpowiada za opakowanie komunikatu i jego wygl�d.
		 * @param btnbox Obiekt klasy HBox, kt�ry odpowiada za opakowanie nszych przycisk�w i zarz�dzanie ich wygl�dem.
		 * @param []buttons Tablica typu Button trzymaj�ca wszystkie stworzone obiekty typu Button.
		 * @param path Parametr typu String odpowiadaj�cy za stworzenie dok�adnej �cie�ki z nazw� wy�wietlanej ikony.
  		 * @param img Obiekt typu Image, kt�ry zawiera wybran� ikon�.
		 * @param imgPic Obiekt typu ImageView, kt�ry odpowiada za opakowanie ikony i zarz�dzanie ni�.
		 * @param scene Obiekt typu Scene, kt�ry tworzy scene na kt�rej wy�wietlany jest zaprojektowany layout. 
		 * 
		 */
	
		public void start(Stage primaryStage) {
		
		
		BorderPane root = new BorderPane();
		root.setPadding(new Insets(20,20,20,20));
		primaryStage.setTitle(title);
		
		Text text = new Text(information);
		text.setWrappingWidth(400);
		text.setTextAlignment(TextAlignment.CENTER);
		text.setTextAlignment(TextAlignment.JUSTIFY);
		root.setCenter(text);
		
		
		HBox btnBox = new HBox(40);
		
		Button []buttons = new Button[numberOfButtons];
		for(int i = 0; i < numberOfButtons; i++)
		{
			buttons[i]= new Button();
			buttons[i].setText(buttonLabels[i]);
			btnBox.getChildren().add(buttons[i]);
		}	

		btnBox.setSpacing(20);
		btnBox.setPadding(new Insets(8,0,0,0));
		btnBox.setAlignment(Pos.CENTER);
		
		
		
		String path = "file:src/images/" + iconName;
		Image img = new Image(path);
		
		ImageView imgPic = new ImageView();
		imgPic.setImage(img);
		
		BorderPane.setAlignment(imgPic, Pos.CENTER);

		root.setBottom(btnBox);
		root.setLeft(imgPic);
		
		
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.setResizable(false);
		primaryStage.show();
		
 
	    for(int i = 0; i < numberOfButtons; i++)
	    		buttons[i].setOnAction(e->handleButtonAction(e,buttons,primaryStage));
	    	      
			
	}
	
	/**
	 * 
	 * 
	 * @param event
	 * @param buttons
	 * @param primaryStage
	 */
	private void handleButtonAction(ActionEvent event,Button []buttons,Stage primaryStage) {
		 
		for(int i = 0; i < numberOfButtons; i++)
			if(event.getSource()==buttons[i]) {
				result = buttonLabels[i];
				primaryStage.close();
			}
		
	}
}

