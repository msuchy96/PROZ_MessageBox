package application;

/**
 * Enum zawierajacy informacje o tym jaki przycisk zostal nacisniety.
 * 
 */
public enum MessageBoxResult {

	Abort("Abort"), Retry("Retry"), Ignore("Ignore"), OK("OK"), Cancel("Cancel"), Yes("Yes"), No("No");
	private String text;

	/**
	 * Konstruktor enuma.
	 * 
	 * @param msg
	 *            Argument typu String, ktory jest kopiowany jako nowy mozliwy
	 *            wybor komunikatu.
	 */
	MessageBoxResult(String msg) {
		text = msg;
	}

	/**
	 * Metoda zwracajaca nazwe nacisnietego przycisku.
	 * 
	 * @return Nazwa nacisnietego przycisku.
	 */
	@Override
	public String toString() {
		return text;
	}

	/**
	 * Metoda zwracajaca enum w zaleznosci od nacisnietego przycisku.
	 * 
	 * @param text
	 *            Argument typu Strng, ktory opisuje jaki przycisk zostal
	 *            nacisniety.
	 * @return Enum komunikatu jaki zostal nacisniety, lub enum "Cancel" w
	 *         przypadku zamkniecia okna.
	 */
	public static MessageBoxResult getResult(String text) {
		for (MessageBoxResult result : MessageBoxResult.values())
			if (result.toString() == text)
				return result;
		return Cancel;
	}

}
