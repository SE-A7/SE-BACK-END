package test;

import java.io.File;

import org.junit.Test;

import transform.app.impl.TranslatorManager;

public class GeneralAppTest 
{
	@Test
	public void generalFunctionalityTest()
	{
		TranslatorManager manager = new TranslatorManager();
		manager.addXmlConfigurationFile(new File("resources/test/inputConfig1.xml"));
		File resultFile = manager.translate();
		
		assert(resultFile != null);
	}
	
	@Test
	public void offerTxtConfigFileTest()
	{
		TranslatorManager manager = new TranslatorManager();
		manager.addXmlConfigurationFile(new File("resources/test/inputTxtConfig.txt"));
		File resultFile = manager.translate();
		
		assert(resultFile != null);
	}
	
	@Test
	public void offerCorruptedXmlFileTest()
	{
		TranslatorManager manager = new TranslatorManager();
		manager.addXmlConfigurationFile(new File("resources/test/inputConfig2.xml"));
		File resultFile = manager.translate();
		
		assert(resultFile != null);
	}

}
