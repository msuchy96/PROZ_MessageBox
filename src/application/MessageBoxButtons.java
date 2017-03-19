/**
 * Enum zawieraj�cy informacje o przyciskach.
 * 
 * @param text Tablica typu String zawieraj�ca nazwy przycisk�w, kt�e maj� zosta� przekazane.
 */
package application;

public enum MessageBoxButtons {

	AbortRetryIgnore("Przerwij", "Pon�w", "Ignoruj"), 
	OK("OK"), 
	OkCancel("OK", "Anuluj"), 
	RetryCancel("Pon�w","Anuluj"),
	YesNo("Tak", "Nie"), 
	YesNoCancel("Tak", "Nie", "Anuluj");

	private String[] text = new String[3];
	private int count;
	
	/**
	 * Konstruktor Enuma, kt�ry jednocze�nie zlicza ile przycisk�w znajduj� si� w danym enumie.
	 * @param msg Argument zawieraj�cy tablice typu String z nazwami przycisk�w.
	 */
	MessageBoxButtons(String... msg) 
	{
		for (int i = 0; i < msg.length; ++i)
			text[i] = msg[i];
		
		count = msg.length;
	}

	
	/**
	 * Metoda zwracaj�ca nazw� przycisku o danym indeksie.
	 * @param i Argument typu int opisuj�cy jaki element tablicy "text" ma by� zwr�cony
	 * @return Element tablicy "text" o podanym indeksie.
	 */
	public String getText(int i)
	{
		return text[i];
	}
	
	/**
	 * Metoda zwracaj�ca ilo�� przycisk�w w danym enumie.
	 * @return Ilo�c przycisk�w w danym enumie.
	 */
	public int getCount() 
	{
		return count;
	}

}
