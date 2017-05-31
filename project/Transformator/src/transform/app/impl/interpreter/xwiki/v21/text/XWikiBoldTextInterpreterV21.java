package transform.app.impl.interpreter.xwiki.v21.text;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import transform.app.enums.KnownDecodingPatterns;
import transform.app.enums.KnownEncodingForm;
import transform.app.impl.abstr.AbstractInterpreter;
import transform.app.impl.interpreter.xwiki.v21.enums.KnownDecodingForm;
import transform.app.impl.interpreter.xwiki.v21.enums.KnownEncodingPatterns;

public class XWikiBoldTextInterpreterV21 extends AbstractInterpreter 
{
	public XWikiBoldTextInterpreterV21() 
	{
		super();
		this.encodingTag = KnownEncodingForm.BOLD_ENCODING_FORM.getPattern();
		this.decodingTag = KnownDecodingForm.BOLD_DECODING_FORM.getPattern();
	}
	
	
	@Override
	public String encode(String content) 
	{
		Pattern pattern = Pattern.compile(KnownEncodingPatterns.BOLD_TEXT_INTERPRETER_PATTERN.getPattern());
		Matcher matcher = pattern.matcher(content);
		
		while(matcher.find())
		{
			content = content.replace(matcher.group(0),encodingTag.replace("#TEXT#", matcher.group(2)));
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