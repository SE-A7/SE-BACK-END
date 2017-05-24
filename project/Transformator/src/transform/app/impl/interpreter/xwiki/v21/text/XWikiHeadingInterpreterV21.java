package transform.app.impl.interpreter.xwiki.v21.text;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import transform.app.impl.abstr.AbstractInterpreter;
import transform.app.util.StringUtils;

public class XWikiHeadingInterpreterV21 extends AbstractInterpreter 
{
	private static final String HEADING_LEVEL_PATTERN 		= "^(1(?:\\.)*)+";
	private static final String HEADING_TEXT_PATTERN		= "^(1(?:\\.)*)+([\\p{Graph}\\p{Space}]*?)$";
	private static final String HEADING_DECODING_PATTERN	= "<heading level=\\\"([1-6])\\\">([^\\p{Space}](?:[^<\\/]*+)*?)</heading>";
	
	private static final String HEADING_ENCODING_FORM		= "<heading level=\"#LEVEL#\">#TEXT#</heading>";

	public XWikiHeadingInterpreterV21() 
	{
		super();
		this.encodingTag = HEADING_ENCODING_FORM;
	}
	
	@Override
	public String encode(String content) 
	{
		Pattern headingLevelPattern = Pattern.compile(HEADING_LEVEL_PATTERN, Pattern.MULTILINE);
		Matcher headingLevelMatcher = headingLevelPattern.matcher(content);
		
		Pattern headingTextPattern	= Pattern.compile(HEADING_TEXT_PATTERN, Pattern.MULTILINE);
		Matcher headingTextMatcher 	= headingTextPattern.matcher(content);
		
		while(headingLevelMatcher.find() && headingTextMatcher.find())
		{
			content 		= content.replace(headingTextMatcher.group(0), encodingTag.replace("#LEVEL#", Integer.toString(StringUtils.getNumberOfCounts("1", headingLevelMatcher.group(0))).replace("#TEXT#", headingTextMatcher.group(2).trim())));
		}
		
		return content;
	}

	@Override
	public String decode(String content) 
	{
		Pattern decodingPattern = Pattern.compile(HEADING_DECODING_PATTERN);
		Matcher decodingMatcher = decodingPattern.matcher(content);
		
		while(decodingMatcher.find())
		{
			content = content.replace(decodingMatcher.group(0), StringUtils.getRepeatedString("1", Integer.parseInt(decodingMatcher.group(1).trim()), ".") + " " + decodingMatcher.group(2).trim());
		}
		
		return content;
	}

}