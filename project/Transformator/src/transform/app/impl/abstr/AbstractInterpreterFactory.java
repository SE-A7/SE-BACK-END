package transform.app.impl.abstr;

import java.io.File;

import transform.app.interfaces.Configuration;
import transform.app.interfaces.Interpreter;


public abstract class AbstractInterpreterFactory 
{

	/**
	 *  Represents the configuration of the factory.
	 *  It will contain all the necessary informations about the interpreters which it can return.
	 */
	protected Configuration configuration;

	
	/**
	 * File which contains the code interpreted by the factory
	 */
	protected File interpretedCodeFile;
	
	/**
	 * 	File which contains the final version of the interpreted code
	 */
	protected File resultFile;
  
	/**
	 * This method return an <b>Interpreter</b> instance described by the tag parameter
	 * 
	 * @param tag - The tag parameter
	 * 
	 * @return An <b>Interpreter</b> described by the tag.
	 */
	protected Interpreter getInterpreterFor(String tag)
	{
		return configuration.getMap().get(tag);
	}
	
	
	/**
	 * Build the configuration of the object.
	 */
	protected void build()
	{
		configuration.build();
	}
	
	/**
	 * Used for interpretation of a line of code
	 * 
	 * @param line - The line of code which needs to be interpretated
	 */
	protected abstract void interpret(String line);
	
	
	/**
	 * Used for interpretation of the <b>interpretedCodeFile</b>
	 * 
	 * @return a File which contains the code written in the language defined for the factory. 
	 */
	protected File getResultFile()
	{
		return resultFile;
	}

}