package transform.app.impl.abstr;

import transform.app.enums.XWikiVersion;

public abstract class AbstractXWikiFactory extends AbstractInterpreterFactory 
{
	/**
	 *  The version of <b>XWiki</b> language for which the factory must generate interpreters
	 */
	public XWikiVersion version;
}