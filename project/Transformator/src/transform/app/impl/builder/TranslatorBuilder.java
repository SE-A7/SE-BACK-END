package transform.app.impl.builder;

import transform.app.impl.abstr.AbstractTranslator;
import transform.app.impl.translator.XWikiTranslatorV09;
import transform.app.impl.translator.XWikiTranslatorV21;

/**
 * Class which takes care of building {@link AbstractTranslator} objects
 * @author Razvan
 *
 */
public class TranslatorBuilder 
{
	/**
	 * Build an {@link AbstractTranslator} object, for the language and version given as parameters
	 * 
	 * @param language The language of the translator
	 * @param version The version of the translator's language
	 * 
	 * @return An {@link AbstractTranslator} object for the language and version provided. 
	 */
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

	/**
	 * Build an XWiki {@link AbstractTranslator} object, for the version provided.
	 * 
	 * @param version - the version of the XWiki language
	 * 
	 * @return An {@link AbstractTranslator} object for XWiki's version given as parameter
	 */
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
