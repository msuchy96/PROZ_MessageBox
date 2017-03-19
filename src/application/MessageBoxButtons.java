/**
 * Enum zawieraj¹cy informacje o przyciskach.
 * 
 * @param text Tablica typu String zawieraj¹ca nazwy przycisków, któe maj¹ zostaæ przekazane.
 */
package application;

public enum MessageBoxButtons {

	AbortRetryIgnore("Przerwij", "Ponów", "Ignoruj"), 
	OK("OK"), 
	OkCancel("OK", "Anuluj"), 
	RetryCancel("Ponów","Anuluj"),
	YesNo("Tak", "Nie"), 
	YesNoCancel("Tak", "Nie", "Anuluj");

	private String[] text = new String[3];
	private int count;
	
	/**
	 * Konstruktor Enuma, który jednoczeœnie zlicza ile przycisków znajdujê siê w danym enumie.
	 * @param msg Argument zawieraj¹cy tablice typu String z nazwami przycisków.
	 */
	MessageBoxButtons(String... msg) 
	{
		for (int i = 0; i < msg.length; ++i)
			text[i] = msg[i];
		
		count = msg.length;
	}

	
	/**
	 * Metoda zwracaj¹ca nazwê przycisku o danym indeksie.
	 * @param i Argument typu int opisuj¹cy jaki element tablicy "text" ma byæ zwrócony
	 * @return Element tablicy "text" o podanym indeksie.
	 */
	public String getText(int i)
	{
		return text[i];
	}
	
	/**
	 * Metoda zwracaj¹ca iloœæ przycisków w danym enumie.
	 * @return Iloœc przycisków w danym enumie.
	 */
	public int getCount() 
	{
		return count;
	}

}
