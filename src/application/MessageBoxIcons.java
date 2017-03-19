/**
 * Enum zawieraj�cy informacje o ikonach.
 * 
 * @param text Parametr typu String zawieraj�cy nazw� pliku z ikon�.
 * 
 */
package application;

public enum MessageBoxIcons {

	Information("StatusInformation_64x.png"), 
	Warning("StatusWarning_64x.png"), 
	Alert("StatusAlert_64x.png"), 
	CriticalError("StatusCriticalError_64x.png");
	private String text;

	
	/**
	 * Konstruktor enuma.
	 * @param msg Argument typu String, kt�ry jest kopiowany do nowego jako nowa nazwa pliku z ikon� w enumie.
	 */
	MessageBoxIcons(String msg) 
	{
		text = msg;
	}

	
	/**
	 * Metoda zwracaj�ca nazw� pliku z ikon�.
	 * @return Nazwa pliku z ikon�.
	 */
	@Override
	public String toString() 
	{
		return text;
	}

}
