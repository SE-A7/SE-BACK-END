package transform.app.impl.interpreter.xwiki.v09.list;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import transform.app.impl.abstr.AbstractInterpreter;
import transform.app.util.StringUtils;

public class XWikiNumberedListInterpreterV09 extends AbstractInterpreter 
{
	private static final String NUMBERED_LIST_PATTERN 			= "^(1+\\.)([\\p{Graph}\\p{Space}]*?)$";
	private static final String NUMBERED_LIST_DECODING_PATTERN 	= "<numberList depth=\\\"([\\d])\\\">([^\\p{Space}](?:[^<\\/]*+)*?)</numberList>";
	
	private static final String NUMBERED_LIST_ENCODING_FORM 	= "<numberList depth=\"#LEVEL\">#TEXT#</numberList>";
	
	
	public XWikiNumberedListInterpreterV09() 
	{
		super();
		this.encodingTag = NUMBERED_LIST_ENCODING_FORM;
	}
	
	
	
	@Override
	public String encode(String content) 
	{
		Pattern encodingPattern = Pattern.compile(NUMBERED_LIST_PATTERN,Pattern.MULTILINE);
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
		Pattern decodingPattern = Pattern.compile(NUMBERED_LIST_DECODING_PATTERN,Pattern.MULTILINE);
		Matcher decodingMatcher = decodingPattern.matcher(content);
		
		while(decodingMatcher.find())
		{
			content = content.replace(decodingMatcher.group(0), StringUtils.getRepeatedString("1", Integer.parseInt(decodingMatcher.group(1)), "") + ". " + decodingMatcher.group(2));
		}

		return content;
	}

}
