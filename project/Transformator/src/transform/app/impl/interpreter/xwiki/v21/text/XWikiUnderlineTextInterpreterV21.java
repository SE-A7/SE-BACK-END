package transform.app.impl.interpreter.xwiki.v21.text;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import transform.app.impl.abstr.AbstractInterpreter;

public class XWikiUnderlineTextInterpreterV21 extends AbstractInterpreter 
{
	private static final String UNDERLINE_TEXT_PATTERN 		= "(?<!_)_{2}([\\p{Space}\\p{Graph}]*?)_{3}(?!_+)";
	private static final String UNDERLINE_DECODE_PATTERN 	= "<underline>([^\\p{Space}](?:[^<\\/]*+)*?)</underline>"; 
	
	private static final String UNDERLINE_ENCODING_FORM		= "<underline>#TEXT#</underline>";
	private static final String UNDERLINE_DECODING_FORM		= "__#TEXT#___";
	
	public XWikiUnderlineTextInterpreterV21() 
	{
		super();
		this.encodingTag = UNDERLINE_ENCODING_FORM;
		this.decodingTag = UNDERLINE_DECODING_FORM;
	}

	@Override
	public String encode(String content) 
	{
		Pattern pattern = Pattern.compile(UNDERLINE_TEXT_PATTERN);
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
		Pattern pattern = Pattern.compile(UNDERLINE_DECODE_PATTERN);
		Matcher matcher = pattern.matcher(content);
		
		while(matcher.find())
		{
			content = content.replaceAll(matcher.group(0), decodingTag.replace("#TEXT", matcher.group(1)));
		}
		
		return content;
	}
	
}