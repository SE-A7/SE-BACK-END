package main;

import java.io.File;
import java.io.FileReader;

import org.apache.commons.io.IOUtils;

import transform.app.impl.TranslatorManager;

public class MainClass {

	public static void main(String[] args) throws Exception 
	{
		TranslatorManager manager = new TranslatorManager();
		manager.addXmlConfigurationFile(new File("resources/test/inputConfig1.xml"));
		File resultFile = manager.translate();
		
		String content = IOUtils.toString(new FileReader(resultFile));

		System.out.println(content);
	}

}
