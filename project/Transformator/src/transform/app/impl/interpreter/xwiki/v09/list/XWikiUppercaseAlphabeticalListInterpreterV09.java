package transform.app.impl.interpreter.xwiki.v09.list;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import transform.app.impl.abstr.AbstractInterpreter;

public class XWikiUppercaseAlphabeticalListInterpreterV09 extends AbstractInterpreter 
{
	private static final String UPPERCASE_ALPHABETICAL_LIST_INTERPRETER_PATTERN = "^A.([\\p{Graph}\\p{Space}]*?)$";
	private static final String UPPERCASE_ALPHABETICAL_LIST_DECODING_PATTERN 	= "<alphaUpList>([^\\p{Space}](?:[^<\\/]*+)*?)</alphaUpList>";
	
	private static final String UPPERCASE_ALPHABETICAL_LIST_ENCODING_FORM 		= "<alphaUpList>#TEXT#</alphaUpList>";
	private static final String UPPERCASE_ALPHABETICAL_LIST_DECODING_FORM		= "A. #TEXT#";
	

	public XWikiUppercaseAlphabeticalListInterpreterV09() 
	{
		super();
		this.encodingTag = UPPERCASE_ALPHABETICAL_LIST_ENCODING_FORM;
		this.decodingTag = UPPERCASE_ALPHABETICAL_LIST_DECODING_FORM;
	}
	
	@Override
	public String encode(String content) 
	{
		Pattern encodingPattern	= Pattern.compile(UPPERCASE_ALPHABETICAL_LIST_INTERPRETER_PATTERN,Pattern.MULTILINE);
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
		Pattern decodingPattern = Pattern.compile(UPPERCASE_ALPHABETICAL_LIST_DECODING_PATTERN);
		Matcher decodingMatcher = decodingPattern.matcher(content);
		
		while(decodingMatcher.find())
		{
			content = content.replace(decodingMatcher.group(0), decodingTag.replace("#TEXT#", decodingMatcher.group(1)));
		}

		return content;
	}

}
