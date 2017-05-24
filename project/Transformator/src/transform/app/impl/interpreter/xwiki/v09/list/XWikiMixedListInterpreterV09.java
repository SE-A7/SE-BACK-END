package transform.app.impl.interpreter.xwiki.v09.list;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import transform.app.impl.abstr.AbstractInterpreter;
import transform.app.util.StringUtils;

public class XWikiMixedListInterpreterV09 extends AbstractInterpreter 
{
	private static final String MIXED_LIST_PATTERN 				= "^1(\\*?)\\.([\\p{Graph}\\p{Space}]*?)$";
	private static final String MIXED_LIST_DECODING_PATTERN 	= "<mixedList depth=\\\"([\\d])\\\">([^\\p{Space}](?:[^<\\/]*+)*?)</mixedList>";
	
	private static final String MIXED_LIST_ENCODING_FORM 		= "<mixedList depth=\"#LEVEL#\">#TEXT#</mixedList>";
	
	
	public XWikiMixedListInterpreterV09() 
	{
		super();
		this.encodingTag = MIXED_LIST_ENCODING_FORM;
	}

	@Override
	public String encode(String content) 
	{
		Pattern encodingPattern = Pattern.compile(MIXED_LIST_PATTERN,Pattern.MULTILINE);
		Matcher encodingMatcher = encodingPattern.matcher(content);
		
		while(encodingMatcher.find())
		{
			content = content.replace(encodingMatcher.group(0),encodingTag.replace("#LEVEL#",Integer.toString(StringUtils.getNumberOfCounts("*", encodingMatcher.group(1)) + 1)).replace("#TEXT#", encodingMatcher.group(2).trim()));
		}

		return content;
	}

	@Override
	public String decode(String content) 
	{
		Pattern decodingPattern = Pattern.compile(MIXED_LIST_DECODING_PATTERN,Pattern.MULTILINE);
		Matcher decodingMatcher = decodingPattern.matcher(content);
		
		while(decodingMatcher.find())
		{
			content = content.replace(decodingMatcher.group(0), "1" + StringUtils.getRepeatedString("*", Integer.parseInt(decodingMatcher.group(1)) - 1, "") + ". " + decodingMatcher.group(2));
		}

		return content;
	}

}
