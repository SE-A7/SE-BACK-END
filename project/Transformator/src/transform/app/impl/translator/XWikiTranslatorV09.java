package transform.app.impl.translator;

import org.apache.log4j.Logger;

import transform.app.enums.XWikiVersion;
import transform.app.impl.abstr.AbstractXWikiTranslator;

public class XWikiTranslatorV09 extends AbstractXWikiTranslator 
{

	public XWikiTranslatorV09() 
	{
		super();
		this.version = XWikiVersion.XWIKI_VERSION_0_9;
		this.log = Logger.getLogger(XWikiTranslatorV09.class);
		
		initialize();
	}
}