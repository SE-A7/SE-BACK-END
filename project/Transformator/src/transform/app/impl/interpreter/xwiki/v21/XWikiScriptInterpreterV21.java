package transform.app.impl.interpreter.xwiki.v21;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.log4j.Logger;

import transform.app.enums.KnownDecodingPatterns;
import transform.app.impl.abstr.AbstractInterpreter;

/**
 * Intepreter for scripts in XWiki 2.1
 * @author Razvan
 *
 */
public class XWikiScriptInterpreterV21 extends AbstractInterpreter 
{
	/**
	 *  The logger for the class {@link XWikiScriptInterpreterV21}
	 */
	private static final Logger log = Logger.getLogger(XWikiScriptInterpreterV21.class);

	@Override
	public String encode(String content) 
	{
		// TODO Implement the encoding of the scripts in XWiki 2.1
		return content;
	}

	@Override
	public String decode(String content) 
	{
		log.info("Start to decode the scripts into XWiki 2.1 syntax ...");
		Pattern decodingScriptPattern = Pattern.compile(KnownDecodingPatterns.SCRIPT_DECODING_PATTERN.getPattern());
		Matcher decodingScriptMatcher = decodingScriptPattern.matcher(content);
		
		while(decodingScriptMatcher.find())
		{
			log.info("Script found. Decoding ...");
			switch(decodingScriptMatcher.group(1))
			{
				case "velocity":
					content = content.replace(decodingScriptMatcher.group(0), "{{velocity}}" + System.lineSeparator() + decodingScriptMatcher.group(2).trim() + System.lineSeparator() + "{{/velocity}}");
					break;
				case "groovy":
					content = content.replace(decodingScriptMatcher.group(0), "{{groovy}}" + System.lineSeparator() + decodingScriptMatcher.group(2).trim() + System.lineSeparator() + "{{/groovy}}");
					break;
				default:
					log.warn("Script type not recognized. Skipping decoding for item: " + decodingScriptMatcher.group(0));
					break;
			}
		}
		
		log.info("Decoding scripts finished.");
		return content;
	}

}
