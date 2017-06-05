package transform.app.impl.configuration;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.apache.commons.io.IOUtils;
import org.apache.log4j.Logger;

import transform.app.exceptions.TranslatorInitialisationException;
import transform.app.impl.abstr.AbstractTranslatorConfiguration;
import transform.app.impl.builder.TranslatorBuilder;

/**
 * This class contains the configuration for translating from XWiki 0.9 to XwIki 2.1 syntax the piece of code given in the file 
 * @author Razvan
 *
 */
public class TextTranslatorConfiguration extends AbstractTranslatorConfiguration 
{
	/**
	 *  The logger of the class {@link TextTranslatorConfiguration}
	 */
	private static final Logger log = Logger.getLogger(TextTranslatorConfiguration.class);
	
	private TextTranslatorConfiguration(File textFile) throws TranslatorInitialisationException 
	{
		super();
		this.file = textFile;
		
		build();
	}

	@Override
	public void build() throws TranslatorInitialisationException
	{
		try 
		{
			log.info("Starting to build the configuration ...");
			log.info("Instantiating the translators ...");
			
			fromTranslator 	= TranslatorBuilder.getTranslator("xwiki", "0.9");
			if(fromTranslator == null)
			{
				log.warn("The input translator is not initialized. Please check the configuration file and make sure that is completed accordingly!");
				throw new TranslatorInitialisationException("fromTranslator could not be instantiated!");
			}
			
			toTranslator	= TranslatorBuilder.getTranslator("xwiki", "2.1");
			if(toTranslator == null)
			{
				log.warn("The input translator is not initialized. Please check the configuration file and make sure that is completed accordingly!");
				throw new TranslatorInitialisationException("toTranslator could not be instantiated!");
			}
			
			codeToTranslate	= IOUtils.toString(new FileReader(file));
			
			log.info("Building the configuration completed.");
		} 
		catch (IOException e) 
		{
			log.error("Building the configuration failed.",e);
		}

	}
	
	
	public static TextTranslatorConfiguration newInstance(File textFile) throws TranslatorInitialisationException
	{
		return new TextTranslatorConfiguration(textFile);
	}

}
