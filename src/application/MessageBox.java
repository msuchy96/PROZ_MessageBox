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
	private static String[] buttonLabels;
	private static String iconName;
	private static String result;
	private static int numberOfButtons;
	private Text text;
	public Button closeButton;
	ImageView imgpic;
	HBox btnBox;

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

		

		btnBox = new HBox(40);
		Button []buttons = new Button[numberOfButtons];
		for(int i = 0; i < numberOfButtons; i++)
		{
			buttons[i]= new Button();
			buttons[i].setText(buttonLabels[i]);
			btnBox.getChildren().add(buttons[i]);
		}	

		
		
		
		
		String path = "file:src/images/" + iconName;
		Image img = new Image(path);
		
		imgpic.setImage(img);

		btnBox.setSpacing(20);
		btnBox.setPadding(new Insets(0,0,0,280));

		root.setBottom(btnBox);
		root.setLeft(imgpic);
		BorderPane.setAlignment(btnBox, Pos.CENTER);
		BorderPane.setAlignment(imgpic, Pos.CENTER);
		primaryStage.setScene(scene);
		primaryStage.show();
		
		//button1.setOnAction(e->handleButtonAction(e));
	   // button2.setOnAction(e->handleButtonAction(e));
	   // button3.setOnAction(e->handleButtonAction(e));
	    
	    for(int i = 0; i < numberOfButtons; i++)
			buttons[i].setOnAction(e->handleButtonAction(e,buttons));
			
		
	    
	  

	}
	
	private void handleButtonAction(ActionEvent event,Button []buttons) {
		 
		for(int i = 0; i < numberOfButtons; i++)
			if(event.getSource()==buttons[i])
				result = buttonLabels[i];
		
		/*
		  // if(event.getSource()==button1) 
		  result = buttonLabels[0];
		   else if(event.getSource()==button2) 
			   result = buttonLabels[1];
		  else if(event.getSource()==button3) 
			   result = buttonLabels[2];
		   */
	}
}

