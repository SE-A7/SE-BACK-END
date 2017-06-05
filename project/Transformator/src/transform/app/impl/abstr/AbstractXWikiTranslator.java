package transform.app.impl.abstr;

import org.apache.log4j.Logger;

import transform.app.enums.XWikiVersion;
import transform.app.impl.builder.XWikiFactoryBuilder;

public abstract class AbstractXWikiTranslator extends AbstractTranslator 
{
	/**
	 * Represents the version of the <b>XWiki</b> language.
	 */
	protected XWikiVersion version;
	protected Logger log;

	@Override
	protected void initialize() 
	{
		this.interpreterFactory = XWikiFactoryBuilder.getXWikiInterpreterFactory(version);	
	}
	
	
	@Override
	public void translateIntoGeneralLanguage(String content)
	{
		log.info("Translation into application language started...");
		
		interpreterFactory.encode(content);
		log.info("Translation into application language ended.");	
	}
	
	@Override
	public void translateIntoFinalVersion() 
	{
		log.info("Translation from application language started...");
		interpreterFactory.decode();
		log.info("Translation from application language ended.");
	}
}