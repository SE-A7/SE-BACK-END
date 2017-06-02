package transform.app.impl;

import java.io.File;

import org.apache.log4j.Logger;

import transform.app.impl.abstr.AbstractTranslatorConfiguration;
import transform.app.impl.builder.TranslatorConfigurationBuilder;

/**
 * This class describes the translator manager, which is the starting point for the translation process
 * @author Razvan
 *
 */
public class TranslatorManager 
{
	/**
	 *  Contains the actual configuration of the translation process.
	 *  It is initialized by
	 */
	private AbstractTranslatorConfiguration configuration;
	
	private static final Logger log = Logger.getLogger(TranslatorManager.class);
	
	
	// Methods
	/**
	 * Initialize the configuration using an xml file
	 * @param xmlFile - the xml configuration file
	 */
	public void addXmlConfigurationFile(File xmlFile)
	{
		configuration = TranslatorConfigurationBuilder.getTranslatorConfigurationInstance(xmlFile,"xml");
	}
	
	/**
	 * Initialize the configuration using an .txt file
	 * @param textFile - the text configuration file
	 */
	public void addTextConfigurationFile(File textFile)
	{
		configuration = TranslatorConfigurationBuilder.getTranslatorConfigurationInstance(textFile,"text");
	}
	
	/**
	 * This method triggers the translation process
	 */
	public File translate()
	{
		configuration.startTranslationProcess();
		return configuration.getResult();
	}
}
