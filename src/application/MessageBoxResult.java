/**
 * Enum zawieraj�cy informacje o tym jaki przycisk zosta� naci�ni�ty.
 * 
 */
package application;

public enum MessageBoxResult {

	Abort("Przerwij"), 
	Retry("Pon�w"), 
	Ignore("Ignoruj"), 
	OK("OK"), 
	Cancel("Anuluj"), 
	Yes("Tak"),
	No("Nie");
	private String text;
	
	/**
	 * Konstruktor enuma.
	 * 
	 * @param msg Argument typu String, kt�ry jest kopiowany jako nowy mo�liwy wyb�r komunikatu.
	 */
	MessageBoxResult(String msg) 
	{
		text = msg;
	}

	
	/**
	 * Metoda zwracaj�ca nazw� naci�ni�tego przycisku.
	 * 
	 * @return Nazwa naci�ni�tego przycisku.
	 */
	@Override
	public String toString() 
	{
		return text;
	}
	
	/**
	 * Metoda zwracaj�ca enum w zale�no�ci od naci�ni�tego przycisku. 
	 * 
	 * @param text Argument typu Strng, kt�ry opisuje jaki przycisk zosta� naci�ni�ty.
	 * @return Enum komunikatu jaki zosta� naci�ni�ty, lub enum "Cancel" w przypadku zamkni�cia okna.
	 */
	public static MessageBoxResult getResult(String text)
	{
		for (MessageBoxResult result : MessageBoxResult.values())
			if (result.toString() == text)
				return result;
		return Cancel;
	}

}
