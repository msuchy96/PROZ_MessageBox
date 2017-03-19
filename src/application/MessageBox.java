/**
 * Klasa MessageBox implementuj¹ca wyœwietlanie i obs³ugê okna komunikatów.
 * 
 * W klasie wystêpuj¹ nastêpuj¹ce parametry:
 * @param title	Parametr typu String odpowiadaj¹cy za przechowanie nazwy tytu³u okna komunikatu.
 * @param information Parametr typu String odpawiadaj¹cy za przechowanie komunikatu podanego przez u¿ytkownika.
 * @param result Parametr typu String odpowiadaj¹cy za przechowanie komunikatu, który znajdowa³ siê na przycisku, który nacisn¹³ u¿ytkownik.
 * @param boxIcon Enum zawieraj¹cy informacje o preferowanej ikonie.
 * @param boxButtons Enum zawieraj¹cy informacje o preferowanych przyciskach.
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
	 *  Metoda show() odpowiada za pobranie od u¿ytkownika w argumentach informacji o wyœwietlanym oknie, zapisanie ich jako argumenty klasy MessageBox ,wywo³anie metody start() poprzez wywo³anie metody Launch().
	 * 
	 * @param givenTitle Otrzymany tytu³
	 * @param givenInformation Otrzymany komunikat
	 * @param buttonsPreference Otrzymane preferencje dotycz¹ce przycisków
	 * @param iconPreference Otrzymane preferencje dotycz¹ce ikony 
	 * @param args Argumenty programu
	 * @return Enum MessageBoxResult, który mówi o tym jaki przycisk zosta³ wciœniêty
	 */
	
	public static MessageBoxResult show(String givenTitle, String givenInformation, MessageBoxButtons buttonsPreference,MessageBoxIcons iconPreference, String[] args) {
		
		title = givenTitle;
		information = givenInformation;
		boxIcon = iconPreference;
		boxButtons = buttonsPreference;

	    launch(args);
		
		return MessageBoxResult.getResult(result);

	}

	
		/** 
		 * Nadpisana metoda (od klasy Application) start(),która odpowiada za tworzenie i wyœwietlanie okna oraz "nas³uchiwanie" czy jakiœ przycisk nie zosta³ naciœniêty. Nadpisana 
		 * 
		 * 
		 * @param primaryStage Obiekt klasy stage skonstruowany przez platforme JavaFx
		 * @param root Obiekt klasy BorderPane. Jest to layout, który posiada 5 obszarów: top,right,bottom,left,center
		 * @param text Obiekt klasy Text, który odpowiada za opakowanie komunikatu i jego wygl¹d.
		 * @param btnbox Obiekt klasy HBox, który odpowiada za opakowanie nszych przycisków i zarz¹dzanie ich wygl¹dem.
		 * @param buttons Tablica typu Button trzymaj¹ca wszystkie stworzone obiekty typu Button.
		 * @param path Parametr typu String odpowiadaj¹cy za stworzenie dok³adnej œcie¿ki z nazw¹ wyœwietlanej ikony.
  		 * @param img Obiekt typu Image, który zawiera wybran¹ ikonê.
		 * @param imgPic Obiekt typu ImageView, który odpowiada za opakowanie ikony i zarz¹dzanie ni¹.
		 * @param scene Obiekt typu Scene, który tworzy scene na której wyœwietlany jest zaprojektowany layout. 
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
		
		Button []buttons = new Button[boxButtons.getCount()];
		for(int i = 0; i < boxButtons.getCount(); i++)
		{
			buttons[i]= new Button();
			buttons[i].setText(boxButtons.getText(i));
			btnBox.getChildren().add(buttons[i]);
		}	

		btnBox.setSpacing(20);
		btnBox.setPadding(new Insets(8,0,0,0));
		btnBox.setAlignment(Pos.CENTER);
		
		
		
		String path = "file:src/images/" + boxIcon.toString();
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
		
 
	    for(int i = 0; i < boxButtons.getCount(); i++)
	    		buttons[i].setOnAction(e->handleButtonAction(e,buttons,primaryStage));
	    	      
			
	}
	
	/**
	 * Metoda odpowiadaj¹ca za obs³ugê event'u.
	 * 
	 * 
	 * @param event Parametr typu Event, odpowiadaj¹cy za przechowanie wykonanej akcji.
	 * @param buttons Tablica typu Buttnos, przechowuj¹ca wszystkie predefiniowane przyciski. 
	 * @param primaryStage Obiekt klasy Stage. Do tej metody przekazany jest w celu zamkniêcia okna, jeœli któryœ z podanych przycisków zosta³ naciœniêty.
	 */
	private void handleButtonAction(ActionEvent event,Button []buttons,Stage primaryStage) {
		 
		for(int i = 0; i < boxButtons.getCount(); i++)
			if(event.getSource()==buttons[i]) {
				result = boxButtons.getText(i);
				primaryStage.close();
			}
		
	}
}

