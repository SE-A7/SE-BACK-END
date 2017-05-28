package transform.app.impl.interpreter.xwiki.v09;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import transform.app.enums.KnownEncodingForm;
import transform.app.impl.abstr.AbstractInterpreter;
import transform.app.impl.interpreter.xwiki.v09.enums.KnownDecodingForm;
import transform.app.impl.interpreter.xwiki.v09.enums.KnownEncodingPatterns;

public class XWikiHorizontalLineInterpreterV09 extends AbstractInterpreter 
{
	public XWikiHorizontalLineInterpreterV09() 
	{
		super();
		this.encodingTag = KnownEncodingForm.HORIZONTAL_LINE_ENCODING_FORM.getPattern();
		this.decodingTag = KnownDecodingForm.HORIZONTAL_LINE_DECODING_FORM.getPattern();
	}
	
	@Override
	public String encode(String content) 
	{
		Pattern pattern = Pattern.compile(KnownEncodingPatterns.HORIZONTAL_LINE_TEXT_PATTERN.getPattern());
		Matcher matcher = pattern.matcher(content);
		
		while(matcher.find())
		{
			content = content.replace(matcher.group(0), encodingTag.replace("#TEXT", matcher.group(1)));
		}
		return content;

	}

	@Override
	public String decode(String content) 
	{
		return content.replace(encodingTag, decodingTag);
	}
}
