package transform.app.impl.interpreter.xwiki.v21.list;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import transform.app.enums.KnownDecodingPatterns;
import transform.app.enums.KnownEncodingForm;
import transform.app.impl.abstr.AbstractInterpreter;
import transform.app.impl.interpreter.xwiki.v21.enums.KnownEncodingPatterns;
import transform.app.util.StringUtils;

public class XWikiNumberedListInterpreterV21 extends AbstractInterpreter 
{
	public XWikiNumberedListInterpreterV21() 
	{
		super();
		this.encodingTag = KnownEncodingForm.NUMBERED_LIST_ENCODING_FORM.getPattern();
	}

	@Override
	public String encode(String content) 
	{
		Pattern encodingPattern = Pattern.compile(KnownEncodingPatterns.NUMBERED_LIST_PATTERN.getPattern(),Pattern.MULTILINE);
		Matcher encodingMatcher = encodingPattern.matcher(content);
		
		while(encodingMatcher.find())
		{
			content = content.replace(encodingMatcher.group(0),encodingTag.replace("#LEVEL#",Integer.toString(StringUtils.getNumberOfCounts("1", encodingMatcher.group(1)))).replace("#TEXT#", encodingMatcher.group(2).trim()));
		}

		return content;
	}

	@Override
	public String decode(String content) 
	{
		Pattern decodingPattern = Pattern.compile(KnownDecodingPatterns.NUMBERED_LIST_DECODING_PATTERN.getPattern(),Pattern.MULTILINE);
		Matcher decodingMatcher = decodingPattern.matcher(content);
		
		while(decodingMatcher.find())
		{
			content = content.replace(decodingMatcher.group(0), StringUtils.getRepeatedString("1", Integer.parseInt(decodingMatcher.group(1)), "") + ". " + decodingMatcher.group(2));
		}

		return content;
	}

}
