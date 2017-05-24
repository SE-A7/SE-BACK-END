package transform.app.impl.interpreter.xwiki.v09.text;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import transform.app.impl.abstr.AbstractInterpreter;

public class XWikiStrikeTextInterpreterV09 extends AbstractInterpreter 
{
	private static final String STRIKE_TEXT_PATTERN 	= "(?<!-)-{2}([\\p{Space}\\p{Graph}]*?)-{2}(?!-+)";
	private static final String STRIKE_DECODE_PATTERN 	= "<strike>([^\\p{Space}](?:[^<\\/]*+)*?)</strike>";
	
	private static final String STRIKE_ENCODING_FORM 	= "<strike>#TEXT#</strike>";
	private static final String STRIKE_DECODING_FORM 	= "--#TEXT#--";

	public XWikiStrikeTextInterpreterV09() 
	{
		super();
		this.encodingTag = STRIKE_ENCODING_FORM;
		this.decodingTag = STRIKE_DECODING_FORM;
	}
	
	@Override
	public String encode(String content) 
	{
		Pattern pattern = Pattern.compile(STRIKE_TEXT_PATTERN);
		Matcher matcher = pattern.matcher(content);
		
		while(matcher.find())
		{
			content = content.replaceAll(matcher.group(0), encodingTag.replace("#TEXT", matcher.group(1)));
		}

		return content;
	}

	@Override
	public String decode(String content) 
	{
		Pattern pattern = Pattern.compile(STRIKE_DECODE_PATTERN);
		Matcher matcher = pattern.matcher(content);
		
		while(matcher.find())
		{
			content = content.replaceAll(matcher.group(0), decodingTag.replace("#TEXT", matcher.group(1)));
		}

		return content;
	}

}
