package transform.app.impl.interpreter.xwiki.v21.text;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import transform.app.impl.abstr.AbstractInterpreter;

public class XWikiMonospaceTextInterpreterV21 extends AbstractInterpreter 
{
	private static final String MONOSPACE_TEXT_PATTERN 		= "<tt>([^\\p{Space}](?:[^<\\/]*+)*?)</tt>";
	private static final String MONOSPACE_DECODE_PATTERN 	= "<monospace>([^\\p{Space}](?:[^<\\/]*+)*?)</monospace>";
	
	private static final String MONOSPACE_ENCODING_FORM 	= "<monospace>#TEXT#</monospace>";
	private static final String MONOSPACE_DECODING_FORM 	= "<tt>#TEXT#</tt>";

	public XWikiMonospaceTextInterpreterV21() 
	{
		super();
		this.encodingTag = MONOSPACE_ENCODING_FORM;
		this.decodingTag = MONOSPACE_DECODING_FORM;
	}
	
	@Override
	public String encode(String content) 
	{
		Pattern pattern = Pattern.compile(MONOSPACE_TEXT_PATTERN);
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
		Pattern pattern = Pattern.compile(MONOSPACE_DECODE_PATTERN);
		Matcher matcher = pattern.matcher(content);
		
		while(matcher.find())
		{
			content = content.replaceAll(matcher.group(0), decodingTag.replace("#TEXT", matcher.group(1)));
		}

		return content;
	}

}
