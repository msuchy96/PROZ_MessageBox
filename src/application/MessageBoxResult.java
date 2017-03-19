/**
 * Enum zawieraj¹cy informacje o tym jaki przycisk zosta³ naciœniêty.
 * 
 */
package application;

public enum MessageBoxResult {

	Abort("Przerwij"), 
	Retry("Ponów"), 
	Ignore("Ignoruj"), 
	OK("OK"), 
	Cancel("Anuluj"), 
	Yes("Tak"),
	No("Nie");
	private String text;
	
	/**
	 * Konstruktor enuma.
	 * 
	 * @param msg Argument typu String, który jest kopiowany jako nowy mo¿liwy wybór komunikatu.
	 */
	MessageBoxResult(String msg) 
	{
		text = msg;
	}

	
	/**
	 * Metoda zwracaj¹ca nazwê naciœniêtego przycisku.
	 * 
	 * @return Nazwa naciœniêtego przycisku.
	 */
	@Override
	public String toString() 
	{
		return text;
	}
	
	/**
	 * Metoda zwracaj¹ca enum w zale¿noœci od naciœniêtego przycisku. 
	 * 
	 * @param text Argument typu Strng, który opisuje jaki przycisk zosta³ naciœniêty.
	 * @return Enum komunikatu jaki zosta³ naciœniêty, lub enum "Cancel" w przypadku zamkniêcia okna.
	 */
	public static MessageBoxResult getResult(String text)
	{
		for (MessageBoxResult result : MessageBoxResult.values())
			if (result.toString() == text)
				return result;
		return Cancel;
	}

}
