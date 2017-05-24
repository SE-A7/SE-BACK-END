package transform.app.impl.abstr;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

import org.apache.commons.io.IOUtils;
import org.apache.log4j.Logger;

import transform.app.interfaces.Configuration;
import transform.app.interfaces.Interpreter;


public class AbstractInterpreterFactory 
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
	
	protected Logger log;
  
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
	 * Used for interpretation of the content into the application-level language
	 * 
	 * @param content The content which is being interpreted
	 */
	protected void encode(String content) 
	{
		try 
		{
			log.info("Start to interpret the content into application language...");
			FileWriter writer 	= new FileWriter(interpretedCodeFile);
			for(Interpreter interpreter : configuration.getMap().values())
			{
				content = interpreter.encode(content);
			}
			writer.write(content);
			writer.close();
			
			log.info("Content interpretation done.");
		}
		catch (Exception e) 
		{
			log.error("Error when interpreting the file", e);
		}
	}
	
	
	/**
	 * Used for interpretation of the content from the application-level language into a specific languge
	 * 
	 */
	protected void decode() 
	{
		try 
		{
			log.info("Start to interpret the content from application language...");
			String content		= IOUtils.toString(new FileReader(interpretedCodeFile));
			FileWriter writer 	= new FileWriter(resultFile);
			for(Interpreter interpreter : configuration.getMap().values())
			{
				content = interpreter.decode(content);
			}
			writer.write(content);
			writer.close();
			
			log.info("Content interpretation done.");
		}
		catch (Exception e) 
		{
			log.error("Error when interpreting the file", e);
		}
		
	}
	
	/**
	 * 
	 * @return the file which contains the code interpreted into application language
	 */
	protected File getResultFile()
	{
		return resultFile;
	}
	
	/**
	 * 
	 * @return the file which contains the translated code
	 */
	protected File getInterpretedFile()
	{
		return interpretedCodeFile;
	}

	/**
	 * 
	 * @param interpretedCodeFile
	 */
	public void setInterpretedCodeFile(File interpretedCodeFile) 
	{
		this.interpretedCodeFile = interpretedCodeFile;
	}

}