package transform.app.impl.interpreter.xwiki.v21.text;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import transform.app.enums.KnownDecodingPatterns;
import transform.app.enums.KnownEncodingForm;
import transform.app.impl.abstr.AbstractInterpreter;
import transform.app.impl.interpreter.xwiki.v21.enums.KnownDecodingForm;
import transform.app.impl.interpreter.xwiki.v21.enums.KnownEncodingPatterns;

public class XWikiStrikeTextInterpreterV21 extends AbstractInterpreter 
{
	public XWikiStrikeTextInterpreterV21() 
	{
		super();
		this.encodingTag = KnownEncodingForm.STRIKE_ENCODING_FORM.getPattern();
		this.decodingTag = KnownDecodingForm.STRIKE_DECODING_FORM.getPattern();
	}
	
	@Override
	public String encode(String content) 
	{
		Pattern pattern = Pattern.compile(KnownEncodingPatterns.STRIKE_TEXT_INTERPRETER_PATTERN.getPattern());
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
		Pattern pattern = Pattern.compile(KnownDecodingPatterns.STRIKE_DECODING_PATTERN.getPattern());
		Matcher matcher = pattern.matcher(content);
		
		while(matcher.find())
		{
			content = content.replaceAll(matcher.group(0), decodingTag.replace("#TEXT", matcher.group(1)));
		}

		return content;
	}

}
