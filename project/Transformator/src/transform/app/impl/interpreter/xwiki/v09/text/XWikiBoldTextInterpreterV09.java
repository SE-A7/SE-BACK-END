package transform.app.impl.interpreter.xwiki.v09.text;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import transform.app.impl.abstr.AbstractInterpreter;

public class XWikiBoldTextInterpreterV09 extends AbstractInterpreter 
{
	private static final String BOLD_TEXT_PATTERN 		= "(?<!\\*)\\*([^\\p{Space}\\*](?:[^*]*+)*?)\\*(?!\\*)";
	private static final String BOLD_DECODING_PATTERN	= "<bold>([^\\p{Space}](?:[^<\\/]*+)*?)</bold>";
	
	private static final String BOLD_ENCODING_FORM		= "<bold>#TEXT#</bold>";
	private static final String BOLD_DECODING_FORM		= "*#TEXT#*";
	
	public XWikiBoldTextInterpreterV09() 
	{
		super();
		this.encodingTag = BOLD_ENCODING_FORM;
		this.decodingTag = BOLD_DECODING_FORM;
	}
	
	
	@Override
	public String encode(String content) 
	{
		Pattern pattern = Pattern.compile(BOLD_TEXT_PATTERN);
		Matcher matcher = pattern.matcher(content);
		
		while(matcher.find())
		{
			content = content.replace(matcher.group(0),encodingTag.replace("#TEXT#", matcher.group(1)));
		}
		
		return content;
	}

	@Override
	public String decode(String content) 
	{
		Pattern pattern = Pattern.compile(BOLD_DECODING_PATTERN);
		Matcher matcher = pattern.matcher(content);
		
		while(matcher.find())
		{
			content = content.replace(matcher.group(0), decodingTag.replace("#TEXT#", matcher.group(1)));
		}
		
		return content;
	}

}