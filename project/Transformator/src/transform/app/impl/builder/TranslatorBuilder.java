package transform.app.impl.builder;

import transform.app.impl.abstr.AbstractTranslator;
import transform.app.impl.translator.XWikiTranslatorV09;
import transform.app.impl.translator.XWikiTranslatorV21;

public class TranslatorBuilder 
{
	public static AbstractTranslator getTranslator(String language, String version)
	{
		switch (language) 
		{
			case "xwiki":
				return getXWikiTranslator(version);

			default:
				return null;
		}
	}

	private static AbstractTranslator getXWikiTranslator(String version) 
	{
		switch (version) 
		{
			case "0.9":
				return new XWikiTranslatorV09();
			case "2.1":
				return new XWikiTranslatorV21();

			default:
				return null;
		}
	}
	
	

}
