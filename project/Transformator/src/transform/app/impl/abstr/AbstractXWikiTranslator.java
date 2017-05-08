package transform.app.impl.abstr;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.apache.log4j.Logger;

import transform.app.enums.XWikiVersion;
import transform.app.impl.builder.XWikiFactoryBuilder;

public abstract class AbstractXWikiTranslator extends AbstractTranslator 
{
	/**
	 * Represents the version of the <b>XWiki</b> language.
	 */
	protected XWikiVersion version;
	protected Logger log;

	@Override
	protected void initialize() 
	{
		this.interpreterFactory = XWikiFactoryBuilder.getXWikiInterpreterFactory(version);	
	}
	
	
	@Override
	protected void translateIntoGeneralLanguage(File inputFile)
	{
		try 
		{
			BufferedReader fileReader = new BufferedReader(new FileReader(inputFile));
			String line = fileReader.readLine();
			
			log.info("Starting the translation...");
			while(line != null)
			{
				interpreterFactory.interpret(line);
				line = fileReader.readLine();
			}
			
			fileReader.close();
			
			log.info("Translation ended.");
		} 
		catch (FileNotFoundException e) 
		{
			log.error("Error while opening the file: ", e);
		} 
		catch (IOException e) 
		{
			log.error("Error while reading from file", e);
		}
	}
}