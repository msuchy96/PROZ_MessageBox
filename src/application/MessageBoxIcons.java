package application;

/**
 * Enum zawierajacy informacje o ikonach.
 * 
 * @param text
 *            Parametr typu String zawierajacy nazwe pliku z ikona.
 * 
 */
public enum MessageBoxIcons {

	Information("StatusInformation_64x.png"), Warning("StatusWarning_64x.png"), 
	Alert("StatusAlert_64x.png"), CriticalError("StatusCriticalError_64x.png");
	private String text;

	/**
	 * Konstruktor enuma.
	 * 
	 * @param msg
	 *            Argument typu String, ktory jest kopiowany do nowego jako nowa
	 *            nazwa pliku z ikona w enumie.
	 */
	MessageBoxIcons(String msg) {
		text = msg;
	}

	/**
	 * Metoda zwracajaca nazwe pliku z ikona.
	 * 
	 * @return Nazwa pliku z ikona.
	 */
	@Override
	public String toString() {
		return text;
	}

}
