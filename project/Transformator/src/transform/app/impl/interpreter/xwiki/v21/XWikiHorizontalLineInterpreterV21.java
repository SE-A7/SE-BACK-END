package transform.app.impl.interpreter.xwiki.v21;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import transform.app.impl.abstr.AbstractInterpreter;

public class XWikiHorizontalLineInterpreterV21 extends AbstractInterpreter 
{
	private static final String HORIZONTAL_LINE_TEXT_PATTERN 		= "([-]){4,}";
	
	private static final String HORIZONTAL_LINE_ENCODING_FORM 	= "<horizontalLine>";
	private static final String HORIZONTAL_LINE_DECODING_FORM 	= "----";

	public XWikiHorizontalLineInterpreterV21() 
	{
		super();
		this.encodingTag = HORIZONTAL_LINE_ENCODING_FORM;
		this.decodingTag = HORIZONTAL_LINE_DECODING_FORM;
	}
	
	@Override
	public String encode(String content) 
	{
		Pattern pattern = Pattern.compile(HORIZONTAL_LINE_TEXT_PATTERN);
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
		return content.replaceAll(encodingTag, decodingTag);
	}
}
