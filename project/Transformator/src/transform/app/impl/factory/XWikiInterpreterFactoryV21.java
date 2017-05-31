package transform.app.impl.factory;

import java.io.File;

import transform.app.enums.KnownFileNames;
import transform.app.enums.KnownPaths;
import transform.app.enums.XWikiVersion;
import transform.app.impl.abstr.AbstractXWikiFactory;
import transform.app.impl.builder.ConfigurationBuilder;
import transform.app.interfaces.Configuration;

public class XWikiInterpreterFactoryV21 extends AbstractXWikiFactory 
{
	private XWikiInterpreterFactoryV21()
	{
		super();
		this.version 		= XWikiVersion.XWIKI_VERSION_2_1;
		this.configuration	= (Configuration) ConfigurationBuilder.newXmlConfigurationInstance(new File(KnownPaths.CONFIGURATION_RELATIVE_PATH.path() + "/" + KnownFileNames.XWIKI_V21_CONFIG_FILE.getFileName()));
	}
	
	
	public static XWikiInterpreterFactoryV21 newInstance()
	{
		return new XWikiInterpreterFactoryV21();
	}
}