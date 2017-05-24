package transform.app.impl.builder;

import java.io.File;

import transform.app.impl.configuration.XMLConfiguration;

public class ConfigurationBuilder 
{
	public static XMLConfiguration newXmlConfigurationInstance(File xmlFile) 
	{
		return XMLConfiguration.newInstance(xmlFile);
	}

}