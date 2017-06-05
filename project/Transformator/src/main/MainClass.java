package main;

import java.io.File;
import java.io.FileReader;

import org.apache.commons.io.IOUtils;
import org.apache.log4j.BasicConfigurator;

import transform.app.impl.TranslatorManager;

public class MainClass {

	public static void main(String[] args) throws Exception 
	{
		// Configure the log4j
		BasicConfigurator.configure();
		
		TranslatorManager manager = new TranslatorManager();
		manager.addXmlConfigurationFile(new File("resources/test/inputConfig1.xml"));
		File resultFile = manager.translate();
		
		String content = IOUtils.toString(new FileReader(resultFile));

		System.out.println("The result is:");
		System.out.println("###############################");
		System.out.println(content);
	}

}
