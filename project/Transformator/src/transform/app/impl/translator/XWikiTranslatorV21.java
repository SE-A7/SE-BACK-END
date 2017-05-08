package transform.app.impl.translator;

import org.apache.log4j.Logger;

import transform.app.enums.XWikiVersion;
import transform.app.impl.abstr.AbstractXWikiTranslator;

public class XWikiTranslatorV21 extends AbstractXWikiTranslator 
{
	
	public XWikiTranslatorV21() 
	{
		super();
		this.version = XWikiVersion.XWIKI_VERSION_2_1;
		this.log = Logger.getLogger(XWikiTranslatorV21.class);
		
		initialize();
	}
}