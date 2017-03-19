/**
 * Enum zawierajacy informacje o przyciskach.
 * 
 * @param text Tablica typu String zawierajaca nazwy przyciskow, ktore maja zostaz przekazane.
 */
package application;

public enum MessageBoxButtons {

	AbortRetryIgnore("Przerwij", "Ponow", "Ignoruj"), 
	OK("OK"), 
	OkCancel("OK", "Anuluj"), 
	RetryCancel("Ponow","Anuluj"),
	YesNo("Tak", "Nie"), 
	YesNoCancel("Tak", "Nie", "Anuluj");

	private String[] text = new String[3];
	private int count;
	
	/**
	 * Konstruktor Enuma, ktory jednoczesnie zlicza ile przyciskow znajduje sie w danym enumie.
	 * @param msg Argument zawierajacy tablice typu String z nazwami przyciskow.
	 */
	MessageBoxButtons(String... msg) 
	{
		for (int i = 0; i < msg.length; ++i)
			text[i] = msg[i];
		
		count = msg.length;
	}

	
	/**
	 * Metoda zwracajaca nazwe przycisku o danym indeksie.
	 * @param i Argument typu int opisujacy jaki element tablicy "text" ma byc zwrocony
	 * @return Element tablicy "text" o podanym indeksie.
	 */
	public String getText(int i)
	{
		return text[i];
	}
	
	/**
	 * Metoda zwracajaca ilosc przyciskow w danym enumie.
	 * @return Ilosc przyciskow w danym enumie.
	 */
	public int getCount() 
	{
		return count;
	}

}
