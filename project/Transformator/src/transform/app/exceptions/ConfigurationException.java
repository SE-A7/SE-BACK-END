package transform.app.exceptions;

/**
 * Exception which gets thrown whenever a configuration fails to build
 * @author Razvan
 *
 */
public class ConfigurationException extends Exception 
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5927464234751124800L;

	public ConfigurationException() 
	{
		super();
	}
	
	public ConfigurationException(String message)
	{
		super(message);
	}
}
