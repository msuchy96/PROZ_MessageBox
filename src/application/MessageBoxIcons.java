/**
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
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
	 * 
	 * @param msg
	 */
	MessageBoxIcons(String msg) 
	{
		text = msg;
	}

	
	/**
	 * 
	 * override
	 */
	public String toString() 
	{
		return text;
	}

}
