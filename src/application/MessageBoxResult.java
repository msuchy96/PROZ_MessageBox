package application;

/**
 * Enum which contains which button was clicked. 
 * 
 */
public enum MessageBoxResult {

	Abort("Abort"), Retry("Retry"), Ignore("Ignore"), OK("OK"), Cancel("Cancel"), Yes("Yes"), No("No");
	private String text;

	/**
	 * Enum's constructor.
	 * 
	 * @param msg
	 *            String argument which is copied as new possible answer
	 *            
	 */
	MessageBoxResult(String msg) {
		text = msg;
	}

	/**
	 * Returns label of pressed button.
	 * 
	 * @return Label of pressed button
	 */
	@Override
	public String toString() {
		return text;
	}

	/**
	 * Returns enum with result depending on the pressed button.
	 * 
	 * @param text
	 *            String argument which describes which button was pressed.
	 * @return Enum which describes which button was pressed or enum with "Cancel" information if window was closed.
	 */
	public static MessageBoxResult getResult(String text) {
		for (MessageBoxResult result : MessageBoxResult.values())
			if (result.toString() == text)
				return result;
		return Cancel;
	}

}
