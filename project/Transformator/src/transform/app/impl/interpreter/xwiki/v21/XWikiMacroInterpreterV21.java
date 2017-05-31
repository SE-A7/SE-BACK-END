package transform.app.impl.interpreter.xwiki.v21;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import transform.app.enums.KnownDecodingPatterns;
import transform.app.impl.abstr.AbstractInterpreter;

public class XWikiMacroInterpreterV21 extends AbstractInterpreter 
{
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
		// Every found macro is commented
		Pattern decodingMacroPattern = Pattern.compile(KnownDecodingPatterns.MACRO_DECODING_PATTERN.getPattern());
		Matcher decodingMacroMatcher = decodingMacroPattern.matcher(content);
		
		while(decodingMacroMatcher.find())
		{
			String[] macroLines = decodingMacroMatcher.group(1).trim().split(System.lineSeparator());
			for (String line : macroLines) 
			{
				content = content.replace(line, "##" + line);
			}
		}
		
		return content;
	}

}
