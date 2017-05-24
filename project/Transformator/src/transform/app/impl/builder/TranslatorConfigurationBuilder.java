package transform.app.impl.builder;

import java.io.File;

import transform.app.impl.abstr.AbstractTranslatorConfiguration;
import transform.app.impl.configuration.XmlTranslatorConfiguration;

public class TranslatorConfigurationBuilder 
{

	public static AbstractTranslatorConfiguration getXmlTranslatorConfigurationInstance(File xmlFile)
	{
		return XmlTranslatorConfiguration.newInstance(xmlFile);
	}
}
