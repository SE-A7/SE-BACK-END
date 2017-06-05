package transform.app.impl.interpreter.xwiki.v21;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.log4j.Logger;

import transform.app.enums.KnownDecodingPatterns;
import transform.app.impl.abstr.AbstractInterpreter;

/**
 * Intepreter for macros in XWiki 2.1
 * @author Razvan
 *
 */
public class XWikiMacroInterpreterV21 extends AbstractInterpreter 
{
	/**
	 *  The logger for the class {@link XWikiMacroInterpreterV21}
	 */
	private static final Logger log = Logger.getLogger(XWikiMacroInterpreterV21.class);
	
	public XWikiMacroInterpreterV21() 
	{
		super();
	}

	@Override
	public String encode(String content) 
	{
		// TODO Implement the encoding of the macros in XWiki 2.1
		return content;
	}

	@Override
	public String decode(String content) 
	{
		log.info("Start to decode the macros into XWiki 2.1 syntax ...");
		// All found macros are commented
		Pattern decodingMacroPattern = Pattern.compile(KnownDecodingPatterns.MACRO_DECODING_PATTERN.getPattern());
		Matcher decodingMacroMatcher = decodingMacroPattern.matcher(content);
		
		while(decodingMacroMatcher.find())
		{
			log.info("Macro found. Decoding ...");
			content = content.replace(decodingMacroMatcher.group(0), decodingMacroMatcher.group(1).trim());
			String[] macroLines = decodingMacroMatcher.group(1).trim().split(System.lineSeparator());
			for (String line : macroLines) 
			{
				content = content.replace(line, "##" + line);
			}
		}
		
		log.info("Decoding the macros finished.");
		return content;
	}

}
