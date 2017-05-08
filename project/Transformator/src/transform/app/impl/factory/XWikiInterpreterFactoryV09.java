package transform.app.impl.factory;

import java.io.File;

import transform.app.enums.KnownFileNames;
import transform.app.enums.KnownPaths;
import transform.app.enums.XWikiVersion;
import transform.app.impl.abstr.AbstractXWikiFactory;
import transform.app.impl.builder.ConfigurationBuilder;
import transform.app.interfaces.Configuration;

public class XWikiInterpreterFactoryV09 extends AbstractXWikiFactory 
{
	private XWikiInterpreterFactoryV09()
	{
		super();
		this.version 		= XWikiVersion.XWIKI_VERSION_0_9;
		
		this.configuration 	= (Configuration)ConfigurationBuilder.newXmlConfigurationInstance(new File(KnownPaths.CONFIGURATION_RELATIVE_PATH.path() + "/" + KnownFileNames.XWIKI_V09_CONFIG_FILE)); 
	}
	
	
	public static XWikiInterpreterFactoryV09 newInstance()
	{
		return new XWikiInterpreterFactoryV09();
	}


	@Override
	protected void interpret(String line) 
	{
		// TODO Interpret the code cases in Xwiki 0.9
	}


	@Override
	protected File getResultFile() {
		// TODO Auto-generated method stub
		return null;
	}
}