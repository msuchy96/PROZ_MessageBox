/**
 * Klasa MessageBox implementująca wyświetlanie i obsługę okna komunikatów.
 * 
 * W klasie występują następujące parametry:
 * @param title	Parametr typu String odpowiadający za przechowanie nazwy tytułu okna komunikatu.
 * @param information Parametr typu String odpawiadający za przechowanie komunikatu podanego przez użytkownika.
 * @param buttonLabels Tablica typu String odpowiadająca za przechowanie wszystkich komunikatów wyświetlanych na przyciskach okna komunikatu.
 * @param iconName Parametr typu String odpowiadający za przechowanie nazwy pliku zawierającego obrazek wyświetlany w oknie komunikatu.
 * @param result Parametr typu String odpowiadający za przechowanie komunikatu, który znajdował się na przycisku, który nacisnął użytkownik.
 * @param numberOfButtons Paramtr typu int oddpowiadający za przechowanie liczby predefiniowanych przycisków.
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
	 * 
	 * 
	 * 
	 * @param givenTitle
	 * @param givenInformation
	 * @param ButtonsPreference
	 * @param IconPreference
	 * @param args
	 * @return
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
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * override
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

