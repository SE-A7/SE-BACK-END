package transform.app.interfaces;

import transform.app.exceptions.TranslatorInitialisationException;

/**
 * This interface presents the methods which needs to be implemented by an translator configuration object
 * @author Razvan
 *
 */
public interface TranslatorConfiguration
{
	/**
	 *  Build the configuration
	 */
	public void build() throws TranslatorInitialisationException;
	
	/**
	 *  Initialize the translationProcess
	 */
	public void startTranslationProcess();
}
