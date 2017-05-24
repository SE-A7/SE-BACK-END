package transform.app.impl.interpreter.xwiki.v09.list;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import transform.app.impl.abstr.AbstractInterpreter;

public class XWikiHebrewListInterpreterV09 extends AbstractInterpreter 
{
	private static final String HEBREW_LIST_PATTERN 			= "^j.([\\p{Graph}\\p{Space}]*?)$";
	private static final String HEBREW_LIST_DECODING_PATTERN 	= "<hebrewList>([^\\p{Space}](?:[^<\\/]*+)*?)</hebrewList>";
	
	private static final String HEBREW_LIST_ENCODING_FORM 		= "<hebrewList>#TEXT#</hebrewList>";
	private static final String HEBREW_LIST_DECODING_FORM		= "j. #TEXT";
	
	public XWikiHebrewListInterpreterV09() 
	{
		super();
		this.encodingTag = HEBREW_LIST_ENCODING_FORM;
		this.decodingTag = HEBREW_LIST_DECODING_FORM;
	}

	@Override
	public String encode(String content) 
	{
		Pattern encodingPattern	= Pattern.compile(HEBREW_LIST_PATTERN,Pattern.MULTILINE);
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
		Pattern decodingPattern = Pattern.compile(HEBREW_LIST_DECODING_PATTERN);
		Matcher decodingMatcher = decodingPattern.matcher(content);
		
		while(decodingMatcher.find())
		{
			content = content.replace(decodingMatcher.group(0), decodingTag.replace("#TEXT#", decodingMatcher.group(1)));
		}

		return content;
	}

}
