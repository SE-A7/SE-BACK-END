package transform.app.impl.configuration;

import java.io.File;

import javax.xml.bind.JAXBException;

import org.apache.log4j.Logger;

import transform.app.impl.abstr.AbstractTranslatorConfiguration;
import transform.app.impl.beans.TranslateConfig;
import transform.app.impl.builder.TranslatorBuilder;
import transform.app.util.JAXBUtils;

public class XmlTranslatorConfiguration extends AbstractTranslatorConfiguration
{
	private static final Logger log = Logger.getLogger(XmlTranslatorConfiguration.class);
	
	private XmlTranslatorConfiguration(File xmlFile) 
	{
		this.file = xmlFile;
		
		build();
	} 
	
	@Override
	public void build() 
	{
		try 
		{
			TranslateConfig config 	= JAXBUtils.getTranslateConfig(file);
			fromTranslator 		   	= TranslatorBuilder.getTranslator(config.getInputLanguage().getLanguage(), config.getInputLanguage().getVersion());
			toTranslator			= TranslatorBuilder.getTranslator(config.getOutputLanguage().getLanguage(), config.getOutputLanguage().getVersion());
			codeToTranslate			= config.getCode();
			
			if(fromTranslator == null)
			{
				log.error("The input translator is not initialized. Please check the configuration file and make sure that is completed accordingly!");
				return;
			}
			
			if(toTranslator == null)
			{
				log.error("The input translator is not initialized. Please check the configuration file and make sure that is completed accordingly!");
				return;
			}
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
	 */
	public static XmlTranslatorConfiguration newInstance(File xmlFile)
	{
		return new XmlTranslatorConfiguration(xmlFile);
	}
}
