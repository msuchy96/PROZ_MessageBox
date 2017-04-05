package application;

import javafx.application.Application;
import javafx.stage.Stage;

/**
 * Testing class.
 * 
 * Class do not need constructor because object is never created.
 *
 * @author Maciej Suchocki / msuchock@stud.elka.pw.edu.pl
 */
public class MessageBoxTests extends Application {

	/**
	 * Calls main JavaFx method and closes program.
	 * 
	 * @param args
	 *            commandLine arguments
	 */
	public static void main(String[] args) {

		launch(args);
		System.exit(0);
	}

	/**
	 * Calls method which creates window with specific information, title and buttons and displays user response.
	 * 
	 * @param arg0
	 *            Instance of Stage which was automatically created by JavaFX.
	 */
	@Override
	public void start(Stage arg0) {

		String title = "Lorem ipsum";
		String information = " Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.";
		MessageBoxResult result = MessageBox.show(title, information, MessageBoxButtons.YesNo, MessageBoxIcons.Warning);

		System.out.println("Answer: " + result);

	}
}
