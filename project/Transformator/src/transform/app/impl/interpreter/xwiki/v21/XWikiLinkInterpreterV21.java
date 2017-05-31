package transform.app.impl.interpreter.xwiki.v21;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import transform.app.enums.KnownDecodingPatterns;
import transform.app.impl.abstr.AbstractInterpreter;
import transform.app.impl.interpreter.xwiki.v21.enums.KnownDecodingForm;

public class XWikiLinkInterpreterV21 extends AbstractInterpreter 
{
	public XWikiLinkInterpreterV21() 
	{
		super();
		this.decodingTag = KnownDecodingForm.LINK_DECODING_FORM.getPattern();
	}
	
	@Override
	public String encode(String content) 
	{
		// TODO Implement the encoding of the links in XWiki 2.1
		return content;
	}

	@Override
	public String decode(String content) 
	{
		Pattern decodingPattern = Pattern.compile(KnownDecodingPatterns.LINK_DECODING_PATTERN.getPattern());
		Matcher decodingMatcher = decodingPattern.matcher(content);
		
		while(decodingMatcher.find())
		{
			content = content.replace(decodingMatcher.group(0), "[[" + (decodingMatcher.group(1).equals("") ? "" : decodingMatcher.group(1) + ">>") +
					decodingMatcher.group(4) + (decodingMatcher.group(2).equals("") ? "" : "@" + decodingMatcher.group(2)) + 
					(decodingMatcher.group(3).equals("") ? "" : "||" + decodingMatcher.group(3)) + "]]");
		}
		
		return content;
	}

}
