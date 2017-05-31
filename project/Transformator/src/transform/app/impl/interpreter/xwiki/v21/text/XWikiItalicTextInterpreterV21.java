package transform.app.impl.interpreter.xwiki.v21.text;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import transform.app.enums.KnownDecodingPatterns;
import transform.app.enums.KnownEncodingForm;
import transform.app.impl.abstr.AbstractInterpreter;
import transform.app.impl.interpreter.xwiki.v21.enums.KnownDecodingForm;
import transform.app.impl.interpreter.xwiki.v21.enums.KnownEncodingPatterns;

public class XWikiItalicTextInterpreterV21 extends AbstractInterpreter 
{
	public XWikiItalicTextInterpreterV21() 
	{
		super();
		this.encodingTag = KnownEncodingForm.ITALIC_ENCODING_FORM.getPattern();
		this.decodingTag = KnownDecodingForm.ITALIC_DECODING_FORM.getPattern();
	}

	@Override
	public String encode(String content) 
	{
		Pattern pattern = Pattern.compile(KnownEncodingPatterns.ITALIC_TEXT_INTERPRETER_PATTERN.getPattern());
		Matcher matcher = pattern.matcher(content);
		
		while(matcher.find())
		{
			content = content.replaceAll(matcher.group(0), encodingTag.replace("#TEXT", matcher.group(2)));
		}
		
		return content;
	}

	@Override
	public String decode(String content) 
	{
		Pattern pattern = Pattern.compile(KnownDecodingPatterns.ITALIC_DECODING_PATTERN.getPattern());
		Matcher matcher = pattern.matcher(content);
		
		while(matcher.find())
		{
			content = content.replaceAll(matcher.group(0), decodingTag.replace("#TEXT", matcher.group(1)));
		}
		
		return content;
	}

}