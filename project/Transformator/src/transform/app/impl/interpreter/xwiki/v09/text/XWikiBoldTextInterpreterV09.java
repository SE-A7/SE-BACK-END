package transform.app.impl.interpreter.xwiki.v09.text;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import transform.app.enums.KnownDecodingPatterns;
import transform.app.enums.KnownEncodingForm;
import transform.app.impl.abstr.AbstractInterpreter;
import transform.app.impl.interpreter.xwiki.v09.enums.KnownDecodingForm;
import transform.app.impl.interpreter.xwiki.v09.enums.KnownEncodingPatterns;

public class XWikiBoldTextInterpreterV09 extends AbstractInterpreter 
{
	public XWikiBoldTextInterpreterV09() 
	{
		super();
		this.encodingTag = KnownEncodingForm.BOLD_ENCODING_FORM.getPattern();
		this.decodingTag = KnownDecodingForm.BOLD_DECODING_FORM.getPattern();
	}
	
	
	@Override
	public String encode(String content) 
	{
		Pattern pattern = Pattern.compile(KnownEncodingPatterns.BOLD_TEXT_PATTERN.getPattern());
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
		Pattern pattern = Pattern.compile(KnownDecodingPatterns.BOLD_DECODING_PATTERN.getPattern());
		Matcher matcher = pattern.matcher(content);
		
		while(matcher.find())
		{
			content = content.replace(matcher.group(0), decodingTag.replace("#TEXT#", matcher.group(1)));
		}
		
		return content;
	}

}