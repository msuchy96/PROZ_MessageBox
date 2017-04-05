package application;

/**
 * Enum which contains all predefined icons.
 * 
 */
public enum MessageBoxIcons {

	Information("StatusInformation_64x.png"), Warning("StatusWarning_64x.png"), 
	Alert("StatusAlert_64x.png"), CriticalError("StatusCriticalError_64x.png");
	private String text;

	/**
	 * Enum's constructor.
	 * 
	 * @param msg 
	 *            String argument which is copied as new icon file name in enum
	 */
	MessageBoxIcons(String msg) {
		text = msg;
	}

	/**
	 * Returns name of icon file.
	 * 
	 * @return Name of icon file.
	 */
	@Override
	public String toString() {
		return text;
	}

}
