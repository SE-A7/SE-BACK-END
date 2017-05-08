package transform.app.impl.configuration;

import java.io.File;
import java.util.Map;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.apache.log4j.Logger;

import transform.app.impl.beans.Mapping;
import transform.app.impl.beans.Mappings;
import transform.app.interfaces.Configuration;
import transform.app.interfaces.Interpreter;

public class XMLConfiguration implements Configuration 
{
	/**
	 *  The xml file which contains the configuration
	 */
	private File xmlFile;

	/**
	 *  The map which contains the mappings between the encoding and the interpreter
	 */
	private Map<String,Interpreter> stringToClassMap;
  
	/**
	 * 	The logger of the class
	 */
	private Logger log;
  
	/**
	 *  Constructor
	 */
	private XMLConfiguration(File xmlFile) 
	{
		this.xmlFile 	= xmlFile;
		this.log		= Logger.getLogger(XMLConfiguration.class);
	}
  
  
  
	/**
	 * Creates an instance of {@link XMLConfiguration}
	 * 
	 * @param xmlFile - the input file for the new instance of {@link XMLConfiguration}
	 * 
	 * @return A new instance of {@link XMLConfiguration}, with the input file given as a parameter
	 */
	public static XMLConfiguration newInstance(File xmlFile)
	{
		return new XMLConfiguration(xmlFile);
	}

	public void build()
	{
		try 
		{
			log.info("Starting building the map ....");
		  
			JAXBContext jaxbContext 	= JAXBContext.newInstance(Mappings.class);
			Unmarshaller unmarshaller	= jaxbContext.createUnmarshaller();
			Mappings mappings			= (Mappings) unmarshaller.unmarshal(xmlFile);
			
			
			for (Mapping mapping : mappings.getMappings()) 
			{
				stringToClassMap.put(mapping.getEncoding(), (Interpreter)Class.forName(mapping.getInterpreterClass()).newInstance());
			}
		  
		  
			log.info("Map builded successfully.");
		} 
		catch (JAXBException e) 
		{
			log.error("Error when reading the condfiguration file",e);
		} 
		catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) 
		{
			log.error("Error when inserting into map", e);
		}
	}

	public Map<String,Interpreter> getMap() 
	{
		return stringToClassMap;
	}

}