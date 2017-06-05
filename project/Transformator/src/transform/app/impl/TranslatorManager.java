package transform.app.impl;

import java.io.File;

import org.apache.log4j.Logger;

import transform.app.exceptions.ConfigurationException;
import transform.app.exceptions.TranslatorInitialisationException;
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
	 *  It is initialized by one of the following methods:<br>
	 *  {@link #addTextConfigurationFile(File) addTextConfiguration(File txtFile)} <br>
	 *  {@link #addXmlConfigurationFile(File) addXmlConfiguration(File xmlFile)}
	 */
	private AbstractTranslatorConfiguration configuration;
	
	/**
	 * Logger of the class {@link TranslatorManager}
	 */
	private static final Logger log = Logger.getLogger(TranslatorManager.class);
	
	
	// Methods
	/**
	 * Initialize the configuration using an xml file
	 * @param xmlFile - the xml configuration file
	 * @throws ConfigurationException 
	 */
	public void addXmlConfigurationFile(File xmlFile) throws ConfigurationException
	{
		try 
		{
			log.info("Attaching the xml file configuration ...");
			configuration = TranslatorConfigurationBuilder.getTranslatorConfigurationInstance(xmlFile,"xml");
		} 
		catch (TranslatorInitialisationException e) 
		{
			log.error("Error when creating the configuration", e);
			throw new ConfigurationException("The configuration build failed!");
		}
	}
	
	/**
	 * Initialize the configuration using an .txt file
	 * @param textFile - the text configuration file
	 * @throws ConfigurationException 
	 */
	public void addTextConfigurationFile(File textFile) throws ConfigurationException
	{
		try 
		{
			log.info("Attaching the text file configuration ...");
			configuration = TranslatorConfigurationBuilder.getTranslatorConfigurationInstance(textFile,"text");
		} 
		catch (TranslatorInitialisationException e)
		{
			log.error("Error when creating the configuration", e);
			throw new ConfigurationException("The configuration build failed!");
		}
	}
	
	/**
	 * This method triggers the translation process
	 */
	public File translate()
	{
		log.info("Translation process triggered ...");
		configuration.startTranslationProcess();
		
		log.info("Providing the result file ...");
		return configuration.getResult();
	}
}
