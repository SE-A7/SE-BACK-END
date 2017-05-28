package transform.app.impl.interpreter.xwiki.v09.list;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import transform.app.enums.KnownDecodingPatterns;
import transform.app.enums.KnownEncodingForm;
import transform.app.impl.abstr.AbstractInterpreter;
import transform.app.impl.interpreter.xwiki.v09.enums.KnownDecodingForm;
import transform.app.impl.interpreter.xwiki.v09.enums.KnownEncodingPatterns;

public class XWikiSquareListInterpreterV09 extends AbstractInterpreter 
{
	public XWikiSquareListInterpreterV09() 
	{
		super();
		this.encodingTag = KnownEncodingForm.SQUARE_LIST_ENCODING_FORM.getPattern();
		this.decodingTag = KnownDecodingForm.SQUARE_LIST_DECODING_FORM.getPattern();
	}
	
	@Override
	public String encode(String content) 
	{
		Pattern encodingPattern	= Pattern.compile(KnownEncodingPatterns.SQUARE_LIST_PATTERN.getPattern(),Pattern.MULTILINE);
		Matcher encodingMatcher = encodingPattern.matcher(content);
		
		while(encodingMatcher.find())
		{
			content = content.replace(encodingMatcher.group(0),encodingTag.replace("#TEXT#", encodingMatcher.group(1).trim()));
		}

		return content;
	}

	@Override
	public String decode(String content) 
	{
		Pattern decodingPattern = Pattern.compile(KnownDecodingPatterns.SQUARE_LIST_DECODING_PATTERN.getPattern());
		Matcher decodingMatcher = decodingPattern.matcher(content);
		
		while(decodingMatcher.find())
		{
			content = content.replace(decodingMatcher.group(0), decodingTag.replace("#TEXT#", decodingMatcher.group(1)));
		}
		
		return content;
	}

}
