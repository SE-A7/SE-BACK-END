package transform.app.impl.builder;

import java.io.File;

import transform.app.impl.abstr.AbstractTranslatorConfiguration;
import transform.app.impl.configuration.TextTranslatorConfiguration;
import transform.app.impl.configuration.XmlTranslatorConfiguration;

public class TranslatorConfigurationBuilder 
{

	public static AbstractTranslatorConfiguration getTranslatorConfigurationInstance(File file, String configurationType)
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
