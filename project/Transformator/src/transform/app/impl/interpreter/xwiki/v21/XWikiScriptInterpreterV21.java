package transform.app.impl.interpreter.xwiki.v21;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.log4j.Logger;

import transform.app.enums.KnownDecodingPatterns;
import transform.app.impl.abstr.AbstractInterpreter;

public class XWikiScriptInterpreterV21 extends AbstractInterpreter 
{
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
		Pattern decodingScriptPattern = Pattern.compile(KnownDecodingPatterns.SCRIPT_DECODING_PATTERN.getPattern());
		Matcher decodingScriptMatcher = decodingScriptPattern.matcher(content);
		
		while(decodingScriptMatcher.find())
		{
			switch(decodingScriptMatcher.group(1))
			{
				case "velocity":
					content = content.replace(decodingScriptMatcher.group(0), "{{velocity}}" + System.lineSeparator() + decodingScriptMatcher.group(2).trim() + System.lineSeparator() + "{{/velocity}}");
					break;
				case "groovy":
					content = content.replace(decodingScriptMatcher.group(0), "{{groovy}}" + System.lineSeparator() + decodingScriptMatcher.group(2).trim() + System.lineSeparator() + "{{/groovy}}");
					break;
				default:
					log.error("The type of script is not recognized!");
					break;
			}
		}
		return content;
	}

}
