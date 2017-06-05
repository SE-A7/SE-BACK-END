package transform.app.util;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import transform.app.impl.TranslatorManager;
import transform.app.impl.beans.TranslateConfig;

/**
 * Class which contains useful methods regarding the JAXB utilization.
 * @author Razvan
 *
 */
public class JAXBUtils 
{
	/**
	 * Create a {@link TranslateConfig} object from the given xml file.<br>
	 * This method is used when the user calls {@link TranslatorManager}'s {@link TranslatorManager#addXmlConfigurationFile(File) addXmlConfigurationFile(File xmlFile)}
	 * 
	 * 
	 * @param xmlFile The xml file which contains the configuration
	 * 
	 * @return A {@link TranslateConfig} object with the mapped file's information.
	 * 
	 * @throws JAXBException 
	 */
	public static TranslateConfig getTranslateConfig(File xmlFile) throws JAXBException 
	{
		JAXBContext jaxbContext 	= JAXBContext.newInstance(TranslateConfig.class);
		Unmarshaller unmarshaller	= jaxbContext.createUnmarshaller();
		TranslateConfig config		= (TranslateConfig) unmarshaller.unmarshal(xmlFile);
		
		return config;
	}

}
