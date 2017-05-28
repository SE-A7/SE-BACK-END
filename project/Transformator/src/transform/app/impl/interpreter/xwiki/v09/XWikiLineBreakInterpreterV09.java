package transform.app.impl.interpreter.xwiki.v09;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import transform.app.enums.KnownEncodingForm;
import transform.app.impl.abstr.AbstractInterpreter;
import transform.app.impl.interpreter.xwiki.v09.enums.KnownDecodingForm;
import transform.app.impl.interpreter.xwiki.v09.enums.KnownEncodingPatterns;

public class XWikiLineBreakInterpreterV09 extends AbstractInterpreter
{
	public XWikiLineBreakInterpreterV09() 
	{
		super();
		this.encodingTag = KnownEncodingForm.LINE_BREAK_ENCODING_FORM.getPattern();
		this.decodingTag = KnownDecodingForm.LINE_BREAK_DECODING_FORM.getPattern();
	}
	
	@Override
	public String encode(String content) 
	{
		Pattern pattern = Pattern.compile(KnownEncodingPatterns.LINE_BREAK_PATTERN.getPattern(), Pattern.MULTILINE);
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
