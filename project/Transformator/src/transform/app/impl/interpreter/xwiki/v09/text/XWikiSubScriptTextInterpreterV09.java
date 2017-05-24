package transform.app.impl.interpreter.xwiki.v09.text;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import transform.app.impl.abstr.AbstractInterpreter;

public class XWikiSubScriptTextInterpreterV09 extends AbstractInterpreter
{
	private static final String SUBSCRIPT_TEXT_PATTERN 		= "<sub>([^\\p{Space}](?:[^<\\/]*+)*?)</sub>";
	private static final String SUBSCRIPT_DECODE_PATTERN 	= "<subscript>([^\\p{Space}](?:[^<\\/]*+)*?)</subscript>";
	
	private static final String SUBSCRIPT_ENCODING_FORM 	= "<subscript>#TEXT#</subscript>";
	private static final String SUBSCRIPT_DECODING_FORM 	= "<sub>#TEXT#</sub>";

	public XWikiSubScriptTextInterpreterV09() 
	{
		super();
		this.encodingTag = SUBSCRIPT_ENCODING_FORM;
		this.decodingTag = SUBSCRIPT_DECODING_FORM;
	}
	
	@Override
	public String encode(String content) 
	{
		Pattern pattern = Pattern.compile(SUBSCRIPT_TEXT_PATTERN);
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
		Pattern pattern = Pattern.compile(SUBSCRIPT_DECODE_PATTERN);
		Matcher matcher = pattern.matcher(content);
		
		while(matcher.find())
		{
			content = content.replaceAll(matcher.group(0), decodingTag.replace("#TEXT", matcher.group(1)));
		}

		return content;
	}

}
