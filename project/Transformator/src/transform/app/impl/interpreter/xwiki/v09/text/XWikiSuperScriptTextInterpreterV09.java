package transform.app.impl.interpreter.xwiki.v09.text;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import transform.app.impl.abstr.AbstractInterpreter;

public class XWikiSuperScriptTextInterpreterV09 extends AbstractInterpreter 
{
	private static final String SUPERSCRIPT_TEXT_PATTERN 		= "<sup>([^\\p{Space}](?:[^<\\/]*+)*?)</sup>";
	private static final String SUPERSCRIPT_DECODE_PATTERN 		= "<superscript>([^\\p{Space}](?:[^<\\/]*+)*?)</superscript>";
	
	private static final String SUPERSCRIPT_ENCODING_FORM 	= "<superscript>#TEXT#</superscript>";
	private static final String SUPERSCRIPT_DECODING_FORM 	= "<sup>#TEXT#</sup>";

	public XWikiSuperScriptTextInterpreterV09() 
	{
		super();
		this.encodingTag = SUPERSCRIPT_ENCODING_FORM;
		this.decodingTag = SUPERSCRIPT_DECODING_FORM;
	}
	
	@Override
	public String encode(String content) 
	{
		Pattern pattern = Pattern.compile(SUPERSCRIPT_TEXT_PATTERN);
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
		Pattern pattern = Pattern.compile(SUPERSCRIPT_DECODE_PATTERN);
		Matcher matcher = pattern.matcher(content);
		
		while(matcher.find())
		{
			content = content.replaceAll(matcher.group(0), decodingTag.replace("#TEXT", matcher.group(1)));
		}

		return content;
	}


}
