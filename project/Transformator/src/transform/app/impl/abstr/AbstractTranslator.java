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
	 * 
	 * @return the file which contains the code interpreted into application language
	 */
	public File getEncodedFile()
	{
		return interpreterFactory.getInterpretedFile();
	}
	
	/**
	 * 
	 * @return the file which contains the translated code
	 */
	public File getResultFile()
	{
		return interpreterFactory.getResultFile();
	}
	
	
	public void setEncodingFile(File encodedFile)
	{
		interpreterFactory.setInterpretedCodeFile(encodedFile);
	}
}