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
import javafx.scene.layout.Region;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class MessageBox extends Application {

	private static String title;
	private static String information;
	private static String[] ButtonLabels;
	private static String Icon;
	private static String result;
	private static int numberOfButtons;
	private Text text;
	Button button1, button2, button3;
	public Button closeButton;
	ImageView imgpic;
	HBox btnbox;

	public static MessageBoxResult show(String givenTitle, String givenInformation, MessageBoxButtons ButtonsPreference,MessageBoxIcons IconPreference, String[] args) {
		
		title = givenTitle;
		information = givenInformation;
		numberOfButtons = ButtonsPreference.getCount();
		ButtonLabels = new String[numberOfButtons];
		Icon = IconPreference.toString();

		for (int i = 0; i < numberOfButtons; i++)
			ButtonLabels[i] = ButtonsPreference.getText(i);

		 launch(args);
		
		return MessageBoxResult.getResult(result);

	}

	@Override
	public void start(Stage primaryStage) {

		BorderPane root = new BorderPane();
		root.setPadding(new Insets(10));
		Scene scene = new Scene(root, 700, 200);
		primaryStage.setTitle(title);

		text = new Text(information);
		text.setWrappingWidth(500);
		root.setCenter(text);
		
		imgpic=new ImageView();

		switch (numberOfButtons) {

		case 1:

			button1 = new Button(ButtonLabels[0]);
			btnbox = new HBox(button1);

			break;
		case 2:

			button1 = new Button(ButtonLabels[0]);
			button2 = new Button(ButtonLabels[1]);
			btnbox = new HBox(button1, button2);

			break;
		case 3:

			button1 = new Button(ButtonLabels[0]);
			button2 = new Button(ButtonLabels[1]);
			button3 = new Button(ButtonLabels[2]);
			btnbox = new HBox(button1, button2, button3);

			break;

		}
		
		
		
		String path = "file:src/images/" + Icon;
		Image img = new Image(path);
		
		imgpic.setImage(img);

		btnbox.setSpacing(20);
		btnbox.setPadding(new Insets(0,0,0,280));

		root.setBottom(btnbox);
		root.setLeft(imgpic);
		BorderPane.setAlignment(btnbox, Pos.CENTER);
		BorderPane.setAlignment(imgpic, Pos.CENTER);
		primaryStage.setScene(scene);
		primaryStage.show();
		
		button1.setOnAction(e->handleButtonAction(e));
	    button2.setOnAction(e->handleButtonAction(e));
	    button3.setOnAction(e->handleButtonAction(e));
	    
	  

	}
	
	private void handleButtonAction(ActionEvent event) {
		 
		  
		   if(event.getSource()==button1) 
		    result = ButtonLabels[0];
		   else if(event.getSource()==button2) 
			   result = ButtonLabels[1];
		   else if(event.getSource()==button3) 
			   result = ButtonLabels[2];
		   
		  
		   

		 }
}
/*	
	public class main
	{
	
	

	

}
*/
