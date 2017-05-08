package transform.app.impl.abstr;

import java.io.File;

import transform.app.interfaces.Translator;

/*
 */
public abstract class AbstractTranslator implements Translator 
{
	/**
	 * Represents the factory instance which will be used to retrieve interpreters.
	 */
	protected AbstractInterpreterFactory interpreterFactory;
	
	/**
	 * Initialize an instance of <b>AbstractTranslator</b>
	 */
	protected abstract void initialize();
	
	/**
	 * This method acquires the first step of the translation process.
	 * @param inputFile - the input file which is desired to be translated
	 */
	protected abstract void translateIntoGeneralLanguage(File inputFile);
	
	/**
	 * This method acquires the second step of the translation process.
	 * 
	 * @return The final translated file
	 */
	protected File translateIntoFinalVersion()
	{
		return interpreterFactory.getResultFile();
	}
	
	@Override
	public File translate(File inputFile)
	{
		translateIntoGeneralLanguage(inputFile);	
		
		return translateIntoFinalVersion();
	}
}