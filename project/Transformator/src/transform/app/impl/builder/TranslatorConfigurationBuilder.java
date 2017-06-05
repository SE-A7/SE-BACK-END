package transform.app.impl.builder;

import java.io.File;

import transform.app.exceptions.TranslatorInitialisationException;
import transform.app.impl.abstr.AbstractTranslatorConfiguration;
import transform.app.impl.configuration.TextTranslatorConfiguration;
import transform.app.impl.configuration.XmlTranslatorConfiguration;

/**
 * Class which takes care of building {@link AbstractTranslatorConfiguration} objects
 * @author Razvan
 *
 */
public class TranslatorConfigurationBuilder 
{

	/**
	 * Build translator configuration objects of the type specified as parameter
	 * 
	 * @param file File which contains the configuration 
	 * @param configurationType The type of translator configuration which will be built
	 * 
	 * @return An {@link AbstractTranslatorConfiguration} object of the type given as parameter
	 * 
	 * @throws TranslatorInitialisationException
	 */
	public static AbstractTranslatorConfiguration getTranslatorConfigurationInstance(File file, String configurationType) throws TranslatorInitialisationException
	{
		switch (configurationType) 
		{
			case "xml":
				return XmlTranslatorConfiguration.newInstance(file);

			case "text":
				return TextTranslatorConfiguration.newInstance(file);
			default:
				return null;
		}
		
	}
}
