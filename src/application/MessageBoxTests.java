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
	 * Metoda wywolujaca glowna metode JavaFx za pomocy metody Launch i
	 * zamykajaca program.
	 * 
	 * @param args
	 *            Argumenty z command_line
	 */
	public static void main(String[] args) {

		launch(args);
		System.exit(0);
	}

	/**
	 * Metoda odpowiadajaca za wywolanie metod tworzacych okno i wypisanie
	 * odpowiedzi uzytkownika.
	 * 
	 * @param arg0
	 *            Obiekt klasy Stage skonstruowany przez platforme JavaFx.
	 */
	@Override
	public void start(Stage arg0) {

		String title = "Tytul";
		String information = " Competitiveness is a set of skills that help people achieve their goals successfully and are usually very specific for each person however I believe there are some common skills such as managing responsibilities or asking other people for help if we are unable to manage to complete the task by ourselves. Those come quite natural to anyone, I believe.      Like I mentioned in the beginning competitiveness is dependant on person’s character and in my opinion mostly on our self assurance and awareness of our skills and personal qualities. I personally am not as confident about my strong sides as some of my peers, which is a disadvantage because such feature is really helpful in pursuing an aim. Nevertheless my not so high self-confidence is not a thing that pulls me down. It is commonly believed that challenging ourselves is critical so as to achieve an aim. Therefore I usually set myself challenging targets and do my best to get the job done. Moreover I easily find solutions to problems, which i think is my selling point. Many people struggle to get through tough tasks while I do it without much an effort. It may be associated with my adopting abilities according to what is needed and expected from me. That skill definitely helps me looking at problems from different perspective.        Focusing now a little bit on a different range of skills that have an impact on our competitiveness than those created by our character I would like to mention organization. Most people claim it is very important to be a perfect planner in order to successfully reach our goals and I believe so too.Well-organization and what is even more important ability to plan ahead are surely things that help people to stick to the schedule and meet deadlines as well and consequently become more and more succes";

		MessageBoxResult result = MessageBox.show(title, information, MessageBoxButtons.YesNo, MessageBoxIcons.Warning);

		System.out.println("Odpowiedz: " + result);

	}
}
