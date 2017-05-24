package transform.app.impl.interpreter.xwiki.v09;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import transform.app.impl.abstr.AbstractInterpreter;

public class XWikiLineBreakInterpreterV09 extends AbstractInterpreter
{
	private static final String LINE_BREAK_PATTERN = "\\\\\\\\$";
	
	private static final String LINE_BREAK_ENCODING_FORM = "<newline>";
	private static final String LINE_BREAK_DECODING_FORM = "\\\\";
	
	
	public XWikiLineBreakInterpreterV09() 
	{
		super();
		this.encodingTag = LINE_BREAK_ENCODING_FORM;
		this.decodingTag = LINE_BREAK_DECODING_FORM;
	}
	
	@Override
	public String encode(String content) 
	{
		Pattern pattern = Pattern.compile(LINE_BREAK_PATTERN, Pattern.MULTILINE);
		Matcher matcher = pattern.matcher(content);
		
		while(matcher.find())
		{
			content = content.replace(matcher.group(0), encodingTag);
		}
		
		return content;
	}


	@Override
	public String decode(String content) 
	{
		return content.replaceAll(encodingTag, decodingTag);
	}
}
