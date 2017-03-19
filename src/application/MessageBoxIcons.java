/**
 * Enum zawieraj¹cy informacje o ikonach.
 * 
 * @param text Parametr typu String zawieraj¹cy nazwê pliku z ikon¹.
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
	 * @param msg Argument typu String, który jest kopiowany do nowego jako nowa nazwa pliku z ikon¹ w enumie.
	 */
	MessageBoxIcons(String msg) 
	{
		text = msg;
	}

	
	/**
	 * Metoda zwracaj¹ca nazwê pliku z ikon¹.
	 * @return Nazwa pliku z ikon¹.
	 */
	@Override
	public String toString() 
	{
		return text;
	}

}
