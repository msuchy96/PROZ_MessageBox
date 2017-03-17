/**
 * 
 * 
 * 
 * 
 * 
 */
package application;

public enum MessageBoxButtons {

	AbortRetryIgnore("Przerwij", "Pon�w", "Ignoruj"), 
	OK("OK"), 
	OkCancel("OK", "Anuluj"), 
	RetryCancel("Pon�w","Anuluj"),
	YesNo("Tak", "Nie"), 
	YesNoCancel("Tak", "Nie", "Anuluj");

	private String[] text = new String[3];
	private int count;
	/**
	 * 
	 * @param msg
	 */
	MessageBoxButtons(String... msg) 
	{
		for (int i = 0; i < msg.length; ++i)
			text[i] = msg[i];
		
		count = msg.length;
	}

	
	/**
	 * 
	 * override
	 */
	public String toString()
	{
		return text[0];
	}
	/**
	 * 
	 * @param i
	 * @return
	 */
	public String getText(int i)
	{
		return text[i];
	}
	/**
	 * 
	 * @return
	 */
	public int getCount() 
	{
		return count;
	}

}
