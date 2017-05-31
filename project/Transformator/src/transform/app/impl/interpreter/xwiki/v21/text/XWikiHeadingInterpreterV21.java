package transform.app.impl.interpreter.xwiki.v21.text;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import transform.app.enums.KnownDecodingPatterns;
import transform.app.enums.KnownEncodingForm;
import transform.app.impl.abstr.AbstractInterpreter;
import transform.app.impl.interpreter.xwiki.v21.enums.KnownEncodingPatterns;
import transform.app.util.StringUtils;

public class XWikiHeadingInterpreterV21 extends AbstractInterpreter 
{
	public XWikiHeadingInterpreterV21() 
	{
		super();
		this.encodingTag = KnownEncodingForm.HEADING_ENCODING_FORM.getPattern();
	}
	
	@Override
	public String encode(String content) 
	{
		Pattern encodingHeadingPattern = Pattern.compile(KnownEncodingPatterns.HEADING_INTERPRETER_PATTERN.getPattern());
		Matcher encodingHeadingMatcher = encodingHeadingPattern.matcher(content);
		
		while(encodingHeadingMatcher.find())
		{
			content = content.replace(encodingHeadingMatcher.group(0), encodingTag.replace("#LEVEL#", Integer.toString(StringUtils.getNumberOfCounts("=", encodingHeadingMatcher.group(1).trim())).replace("#TEXT#", encodingHeadingMatcher.group(2).trim())));
		}
		
		return content;
	}

	@Override
	public String decode(String content) 
	{
		Pattern decodingHeadingPattern = Pattern.compile(KnownDecodingPatterns.HEADING_DECODING_PATTERN.getPattern());
		Matcher decodingHeadingMatcher = decodingHeadingPattern.matcher(content);
		
		while(decodingHeadingMatcher.find())
		{
			content = content.replace(decodingHeadingMatcher.group(0), StringUtils.getRepeatedString("=", Integer.parseInt(decodingHeadingMatcher.group(1).trim()), "") + " " + decodingHeadingMatcher.group(2).trim() + " " + StringUtils.getRepeatedString("=", Integer.parseInt(decodingHeadingMatcher.group(1).trim()), ""));
		}
		
		return content;
	}

}