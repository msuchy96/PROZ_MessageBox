package application;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) 
	{
		String title;
		String information;
		Scanner input= new Scanner(System.in);
		System.out.println("Give Title:");
		title = input.nextLine();
		
		System.out.println("Give Information: ");
		information = input.nextLine();
		
		MessageBoxResult result = MessageBox.show(title,information,MessageBoxButtons.OK,MessageBoxIcons.Alert,args);
		
		System.out.println("Odpowiedü: " + result);
		
		System.exit(0);
	}
}
