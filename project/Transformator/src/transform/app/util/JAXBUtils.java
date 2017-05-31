package transform.app.util;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import transform.app.impl.beans.TranslateConfig;

public class JAXBUtils 
{
	public static TranslateConfig getTranslateConfig(File xmlFile) throws JAXBException 
	{
		JAXBContext jaxbContext 	= JAXBContext.newInstance(TranslateConfig.class);
		Unmarshaller unmarshaller	= jaxbContext.createUnmarshaller();
		TranslateConfig config		= (TranslateConfig) unmarshaller.unmarshal(xmlFile);
		
		return config;
	}

}
