package transform.app.impl.configuration;

import java.io.File;

import javax.xml.bind.JAXBException;

import org.apache.log4j.Logger;

import transform.app.exceptions.TranslatorInitialisationException;
import transform.app.impl.abstr.AbstractTranslatorConfiguration;
import transform.app.impl.beans.TranslateConfig;
import transform.app.impl.builder.TranslatorBuilder;
import transform.app.util.JAXBUtils;

public class XmlTranslatorConfiguration extends AbstractTranslatorConfiguration
{
	/**
	 *  Logger of the class {@link XmlTranslatorConfiguration}
	 */
	private static final Logger log = Logger.getLogger(XmlTranslatorConfiguration.class);
	
	private XmlTranslatorConfiguration(File xmlFile) throws TranslatorInitialisationException 
	{
		this.file = xmlFile;
		
		build();
	} 
	
	@Override
	public void build() throws TranslatorInitialisationException
	{
		try 
		{
			log.info("Starting to build the configuration ...");
			log.info("Parsing the xml file ...");
			TranslateConfig config 	= JAXBUtils.getTranslateConfig(file);
			
			log.info("File parsing completed. Starting to initialize the translators ...");
			
			fromTranslator 		   	= TranslatorBuilder.getTranslator(config.getInputLanguage().getLanguage(), config.getInputLanguage().getVersion());
			if(fromTranslator == null)
			{
				log.warn("The input translator is not initialized. Please check the configuration file and make sure that is completed accordingly!");
				throw new TranslatorInitialisationException("fromTranslator could not be instantiated!");
			}
			
			toTranslator			= TranslatorBuilder.getTranslator(config.getOutputLanguage().getLanguage(), config.getOutputLanguage().getVersion());
			if(toTranslator == null)
			{
				log.warn("The input translator is not initialized. Please check the configuration file and make sure that is completed accordingly!");
				throw new TranslatorInitialisationException("toTranslator could not be instantiated!");
			}
			
			log.info("Translators initialization completed.");
			
			codeToTranslate			= config.getCode().trim();
			log.info("Building the xml configuration completed.");
		} 
		catch (JAXBException e) 
		{
			log.error("Error at parsing the configuration file", e);
		}
		
		
	}
	
	/**
	 * Return a new instance of {@link XmlTranslatorConfiguration}, with the parameter config file 
	 * @param xmlFile - the xml configuration file
	 * @return an instance of {@link XmlTranslatorConfiguration}
	 * @throws TranslatorInitialisationException 
	 */
	public static XmlTranslatorConfiguration newInstance(File xmlFile) throws TranslatorInitialisationException
	{
		return new XmlTranslatorConfiguration(xmlFile);
	}
}
