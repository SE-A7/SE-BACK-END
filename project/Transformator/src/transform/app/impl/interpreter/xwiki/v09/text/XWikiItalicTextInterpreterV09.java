package transform.app.impl.interpreter.xwiki.v09.text;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import transform.app.impl.abstr.AbstractInterpreter;

public class XWikiItalicTextInterpreterV09 extends AbstractInterpreter 
{
	private static final String ITALIC_TEXT_PATTERN 	= "(?<!~)~{2}([\\p{Space}\\p{Graph}]*?)~{2}(?!~+)";
	private static final String ITALIC_DECODE_PATTERN 	= "<italic>([^\\p{Space}](?:[^<\\/]*+)*?)</italic>";
	
	private static final String ITALIC_ENCODING_FORM 	= "<italic>#TEXT#</italic>";
	private static final String ITALIC_DECODING_FORM 	= "~~#TEXT#~~";
	
	public XWikiItalicTextInterpreterV09() 
	{
		super();
		this.encodingTag = ITALIC_ENCODING_FORM;
		this.decodingTag = ITALIC_DECODING_FORM;
	}

	@Override
	public String encode(String content) 
	{
		Pattern pattern = Pattern.compile(ITALIC_TEXT_PATTERN);
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
		Pattern pattern = Pattern.compile(ITALIC_DECODE_PATTERN);
		Matcher matcher = pattern.matcher(content);
		
		while(matcher.find())
		{
			content = content.replaceAll(matcher.group(0), decodingTag.replace("#TEXT", matcher.group(1)));
		}
		
		return content;
	}

}