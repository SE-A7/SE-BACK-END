package transform.app.impl.interpreter.xwiki.v09.list;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import transform.app.impl.abstr.AbstractInterpreter;

public class XWikiLowercaseRomanListInterpreterV09 extends AbstractInterpreter 
{
	private static final String LOWERCASE_ROMAN_LIST_INTERPRETER_PATTERN 	= "^i.([\\p{Graph}\\p{Space}]*?)$";
	private static final String LOWERCASE_ROMAN_LIST_DECODING_PATTERN 		= "<romanLowList>([^\\p{Space}](?:[^<\\/]*+)*?)</romanLowList>";
	
	private static final String LOWERCASE_ROMAN_LIST_ENCODING_FORM 			= "<romanLowList>#TEXT#</romanLowList>";
	private static final String LOWERCASE_ROMAN_LIST_DECODING_FORM			= "i. #TEXT#";

	public XWikiLowercaseRomanListInterpreterV09() 
	{
		super();
		this.encodingTag = LOWERCASE_ROMAN_LIST_ENCODING_FORM;
		this.decodingTag = LOWERCASE_ROMAN_LIST_DECODING_FORM;
	}
	
	
	@Override
	public String encode(String content) 
	{
		Pattern encodingPattern	= Pattern.compile(LOWERCASE_ROMAN_LIST_INTERPRETER_PATTERN,Pattern.MULTILINE);
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
		Pattern decodingPattern = Pattern.compile(LOWERCASE_ROMAN_LIST_DECODING_PATTERN);
		Matcher decodingMatcher = decodingPattern.matcher(content);
		
		while(decodingMatcher.find())
		{
			content = content.replace(decodingMatcher.group(0), decodingTag.replace("#TEXT#", decodingMatcher.group(1)));
		}

		return content;
	}

}
