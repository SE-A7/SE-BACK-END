package transform.app.impl.interpreter.xwiki.v21.list;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import transform.app.impl.abstr.AbstractInterpreter;
import transform.app.util.StringUtils;

public class XWikiBulletedListInterpreterV21 extends AbstractInterpreter 
{
	private static final String BULLETED_LIST_PATTERN 	= "^(\\*+)([\\p{Graph}\\p{Space}]*?)$";
	private static final String DECODING_PATTERN		= "<bulletList depth=\\\"([\\d])\\\">([^\\p{Space}](?:[^<\\/]*+)*?)</bulletList>";
	
	private static final String BULLETED_LIST_ENCODING_FORM = "<bulletList depth=\"#LEVEL#\">#TEXT#</bulletList>";
	
	public XWikiBulletedListInterpreterV21() 
	{
		super();
		this.encodingTag = BULLETED_LIST_ENCODING_FORM;
	}

	@Override
	public String encode(String content) 
	{
		Pattern encodingPattern = Pattern.compile(BULLETED_LIST_PATTERN);
		Matcher encodingMatcher = encodingPattern.matcher(content);
		
		while(encodingMatcher.find())
		{
			content = content.replace(encodingMatcher.group(0),encodingTag.replace("#LEVEL#",Integer.toString(StringUtils.getNumberOfCounts("*", encodingMatcher.group(1)))).replace("#TEXT#", encodingMatcher.group(2).trim()));
		}

		return content;
	}

	@Override
	public String decode(String content) 
	{
		Pattern decodingPattern = Pattern.compile(DECODING_PATTERN);
		Matcher decodingMatcher = decodingPattern.matcher(content);
		
		while(decodingMatcher.find())
		{
			content = content.replace(decodingMatcher.group(0), StringUtils.getRepeatedString("*", Integer.parseInt(decodingMatcher.group(1)), "") + " " + decodingMatcher.group(2));
		}
		
		return content;
	}

}
