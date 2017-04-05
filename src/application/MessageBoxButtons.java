package application;

/**
 * Enum which contains all predefined Buttons.
 * 
 */
public enum MessageBoxButtons {

	AbortRetryIgnore("Abort", "Retry", "Ignore"), OK("OK"), OkCancel("OK", "Cancel"), RetryCancel("Retry",
			"Cancel"), YesNo("Yes", "No"), YesNoCancel("Yes", "No", "Cancel");

	private String[] text = new String[3];
	private int count;

	/**
	 * Enum's constructor which counting how many buttons are in a specific enum.
	 * 
	 * @param msg
	 *            String array which contains button labels
	 */
	MessageBoxButtons(String... msg) {
		for (int i = 0; i < msg.length; ++i)
			text[i] = msg[i];

		count = msg.length;
	}

	/**
	 * Returns the label of a button with a given index.
	 * @param i
	 *            given index of the array with labels 
	 * @return Element of array with labels
	 */
	public String getText(int i) {
		return text[i];
	}

	/**
	 * Getter number of buttons in enum.
	 * 
	 * @return Number of buttons in enum.
	 */
	public int getCount() {
		return count;
	}

}
