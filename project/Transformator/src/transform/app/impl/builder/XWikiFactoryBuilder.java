package transform.app.impl.builder;

import transform.app.enums.XWikiVersion;
import transform.app.impl.abstr.AbstractInterpreterFactory;
import transform.app.impl.factory.XWikiInterpreterFactoryV09;
import transform.app.impl.factory.XWikiInterpreterFactoryV21;

public class XWikiFactoryBuilder 
{
	public static AbstractInterpreterFactory getXWikiInterpreterFactory(XWikiVersion version)
	{
		switch(version)
		{
			case XWIKI_VERSION_0_9:
				return XWikiInterpreterFactoryV09.newInstance();
		
			case XWIKI_VERSION_2_1:
				return XWikiInterpreterFactoryV21.newInstance();
		
			default:
				return null;
		}
			
	}
}
