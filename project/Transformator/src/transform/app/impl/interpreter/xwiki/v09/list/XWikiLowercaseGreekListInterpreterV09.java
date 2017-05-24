package transform.app.impl.interpreter.xwiki.v09.list;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import transform.app.impl.abstr.AbstractInterpreter;

public class XWikiLowercaseGreekListInterpreterV09 extends AbstractInterpreter 
{
	private static final String LOWERCASE_GREEK_LIST_INTERPRETER_PATTERN 	= "^g.([\\p{Graph}\\p{Space}]*?)$";
	private static final String LOWERCASE_GREEK_LIST_DECODING_PATTERN 		= "<greekLowList>([^\\p{Space}](?:[^<\\/]*+)*?)</greekLowList>";
	
	private static final String LOWERCASE_GREEK_LIST_ENCODING_FORM 			= "<greekLowList>#TEXT#</greekLowList>";
	private static final String LOWERCASE_GREEK_LIST_DECODING_FORM			= "g. #TEXT#";

	public XWikiLowercaseGreekListInterpreterV09() 
	{
		super();
		this.encodingTag = LOWERCASE_GREEK_LIST_ENCODING_FORM;
		this.decodingTag = LOWERCASE_GREEK_LIST_DECODING_FORM;
	}
	
	@Override
	public String encode(String content) 
	{
		Pattern encodingPattern	= Pattern.compile(LOWERCASE_GREEK_LIST_INTERPRETER_PATTERN,Pattern.MULTILINE);
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
		Pattern decodingPattern = Pattern.compile(LOWERCASE_GREEK_LIST_DECODING_PATTERN);
		Matcher decodingMatcher = decodingPattern.matcher(content);
		
		while(decodingMatcher.find())
		{
			content = content.replace(decodingMatcher.group(0), decodingTag.replace("#TEXT#", decodingMatcher.group(1)));
		}

		return content;
	}

}
