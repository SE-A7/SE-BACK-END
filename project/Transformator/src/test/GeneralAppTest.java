package test;

import static org.junit.Assert.*;

import java.io.File;

import org.junit.Test;

import transform.app.exceptions.ConfigurationException;
import transform.app.impl.TranslatorManager;

public class GeneralAppTest 
{
	@Test
	public void generalFunctionalityTest()
	{
		TranslatorManager manager = new TranslatorManager();
		File resultFile;
		try 
		{
			manager.addXmlConfigurationFile(new File("resources/test/inputConfig1.xml"));
			resultFile = manager.translate();
		} 
		catch (ConfigurationException e) 
		{
			e.printStackTrace();
			resultFile = null;
		}
		
		
		assertTrue(resultFile != null);
	}
	
	@Test
	public void offerTxtConfigFileTest()
	{
		TranslatorManager manager = new TranslatorManager();
		File resultFile;
		try 
		{
			manager.addTextConfigurationFile(new File("resources/test/inputTxtConfig.txt"));
			resultFile = manager.translate();
		} 
		catch (ConfigurationException e) 
		{
			e.printStackTrace();
			resultFile = null;
		}
		
		
		assertTrue(resultFile != null);
	}
	
	@Test
	public void offerCorruptedXmlFileTest()
	{
		TranslatorManager manager = new TranslatorManager();
		File resultFile;
		try 
		{
			manager.addXmlConfigurationFile(new File("resources/test/inputConfig2.xml"));
			resultFile = manager.translate();
		} 
		catch (ConfigurationException e) 
		{
			e.printStackTrace();
			resultFile = null;
		}
		
		
		assertFalse(resultFile != null);
	}

}
