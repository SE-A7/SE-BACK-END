package transform.app.impl.configuration;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.apache.commons.io.IOUtils;
import org.apache.log4j.Logger;

import transform.app.impl.abstr.AbstractTranslatorConfiguration;
import transform.app.impl.builder.TranslatorBuilder;

/**
 * This class contains the configuration for translating from XWiki 1.0 to XwIki 2.1 syntax the piece of code given in the file 
 * @author Razvan
 *
 */
public class TextTranslatorConfiguration extends AbstractTranslatorConfiguration 
{
	private static final Logger log = Logger.getLogger(TextTranslatorConfiguration.class);
	
	private TextTranslatorConfiguration(File textFile) 
	{
		super();
		this.file = textFile;
		
		build();
	}

	@Override
	public void build() 
	{
		try 
		{
			fromTranslator 	= TranslatorBuilder.getTranslator("xwiki", "0.9");
			toTranslator	= TranslatorBuilder.getTranslator("xwiki", "2.1");
			codeToTranslate	= IOUtils.toString(new FileReader(file));
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}

	}
	
	
	public static TextTranslatorConfiguration newInstance(File textFile)
	{
		return new TextTranslatorConfiguration(textFile);
	}

}
