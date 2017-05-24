package transform.app.util;

import java.io.File;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.ArrayList;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import transform.app.impl.beans.EncodedList;
import transform.app.impl.beans.RawHtmlList;
import transform.app.impl.beans.TranslateConfig;

public class JAXBUtils 
{
	public static String encodeList(String content) throws Exception
	{
		JAXBContext jaxbContext 	= JAXBContext.newInstance(RawHtmlList.class);
		Unmarshaller unmarshaller	= jaxbContext.createUnmarshaller();
		RawHtmlList list			= (RawHtmlList) unmarshaller.unmarshal(new StringReader(content));
	
		
		StringWriter sw = new StringWriter(100);
		EncodedList encodedList = new EncodedList();
		encodedList.setStyle(list.getStyle());
		encodedList.setListItems(new ArrayList<>());
		
		for(String listItem : list.getItems())
		{
			encodedList.getListItems().add(listItem);
		}
		
		jaxbContext = JAXBContext.newInstance(EncodedList.class);
		Marshaller marshaller = jaxbContext.createMarshaller();
		marshaller.marshal(encodedList, sw);
		
		return sw.toString().replace("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>", "");
	}
	
	public static String encodeDefinitionList(String content) throws Exception
	{
		JAXBContext jaxbContext 	= JAXBContext.newInstance(RawHtmlList.class);
		Unmarshaller unmarshaller	= jaxbContext.createUnmarshaller();
		RawHtmlList list			= (RawHtmlList) unmarshaller.unmarshal(new StringReader(content));
	
		
		StringWriter sw = new StringWriter(100);
		EncodedList encodedList = new EncodedList();
		encodedList.setStyle(list.getStyle());
		encodedList.setListItems(new ArrayList<>());
		
		for(String listItem : list.getItems())
		{
			encodedList.getListItems().add(listItem);
		}
		
		jaxbContext = JAXBContext.newInstance(EncodedList.class);
		Marshaller marshaller = jaxbContext.createMarshaller();
		marshaller.marshal(encodedList, sw);
		
		return sw.toString().replace("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>", "");
	}
	
	
	public static String decodeList(String content) throws Exception
	{
		JAXBContext jaxbContext 	= JAXBContext.newInstance(EncodedList.class);
		Unmarshaller unmarshaller	= jaxbContext.createUnmarshaller();
		EncodedList list			= (EncodedList) unmarshaller.unmarshal(new StringReader(content));
	
		
		StringWriter sw = new StringWriter(100);
		RawHtmlList decodedList = new RawHtmlList();
		
		decodedList.setStyle(list.getStyle());
		decodedList.setItems(new ArrayList<>());
		
		for(String listItem : list.getListItems())
		{
			decodedList.getItems().add(listItem);
		}
		
		jaxbContext = JAXBContext.newInstance(RawHtmlList.class);
		Marshaller marshaller = jaxbContext.createMarshaller();
		marshaller.marshal(decodedList, sw);
		
		return sw.toString().replace("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>", "");
	}
	
	public static String decodeDefinitionList(String content) throws Exception
	{
		JAXBContext jaxbContext 	= JAXBContext.newInstance(EncodedList.class);
		Unmarshaller unmarshaller	= jaxbContext.createUnmarshaller();
		EncodedList list			= (EncodedList) unmarshaller.unmarshal(new StringReader(content));
	
		
		StringWriter sw = new StringWriter(100);
		RawHtmlList decodedList = new RawHtmlList();
		
		decodedList.setStyle(list.getStyle());
		decodedList.setItems(new ArrayList<>());
		
		for(String listItem : list.getListItems())
		{
			decodedList.getItems().add(listItem);
		}
		
		jaxbContext = JAXBContext.newInstance(RawHtmlList.class);
		Marshaller marshaller = jaxbContext.createMarshaller();
		marshaller.marshal(decodedList, sw);
		
		return sw.toString().replace("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>", "");
	}

	public static TranslateConfig getTranslateConfig(File xmlFile) throws JAXBException 
	{
		JAXBContext jaxbContext 	= JAXBContext.newInstance(TranslateConfig.class);
		Unmarshaller unmarshaller	= jaxbContext.createUnmarshaller();
		TranslateConfig config		= (TranslateConfig) unmarshaller.unmarshal(xmlFile);
		
		return config;
	}

}
