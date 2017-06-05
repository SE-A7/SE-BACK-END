package transform.app.exceptions;

import transform.app.interfaces.Translator;

/**
 * Exception which gets thrown whenever the instantiation of a {@link Translator} object.
 * @author Razvan
 *
 */
public class TranslatorInitialisationException extends Exception 
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 978310654693311169L;

	public TranslatorInitialisationException(String message)
	{
		super(message);
	}
	
	public TranslatorInitialisationException() 
	{
		super();
	}
}
