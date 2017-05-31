package transform.app.impl.factory;

import java.io.File;
import org.apache.log4j.Logger;

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
		this.log			= Logger.getLogger(XWikiInterpreterFactoryV09.class);
		this.version 		= XWikiVersion.XWIKI_VERSION_0_9;
		
		this.configuration 	= (Configuration)ConfigurationBuilder.newXmlConfigurationInstance(new File(KnownPaths.CONFIGURATION_RELATIVE_PATH.path() + "/" + KnownFileNames.XWIKI_V09_CONFIG_FILE.getFileName())); 
	}
	
	
	public static XWikiInterpreterFactoryV09 newInstance()
	{
		return new XWikiInterpreterFactoryV09();
	}
	
}