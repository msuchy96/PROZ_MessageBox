/**
 * 
 * 
 * 
 * 
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
	 * 
	 * @param msg
	 */
	MessageBoxResult(String msg) 
	{
		text = msg;
	}

	
	/**
	 * 
	 * 
	 * override
	 */
	public String toString() 
	{
		return text;
	}
	/**
	 * 
	 * 
	 * @param text
	 * @return
	 */
	public static MessageBoxResult getResult(String text)
	{
		for (MessageBoxResult result : MessageBoxResult.values())
			if (result.toString() == text)
				return result;
		return Cancel;
	}

}
