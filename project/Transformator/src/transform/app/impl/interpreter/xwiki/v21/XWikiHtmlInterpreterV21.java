package transform.app.impl.interpreter.xwiki.v21;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import transform.app.enums.KnownDecodingPatterns;
import transform.app.enums.KnownEncodingForm;
import transform.app.impl.abstr.AbstractInterpreter;
import transform.app.impl.interpreter.xwiki.v21.enums.KnownDecodingForm;

public class XWikiHtmlInterpreterV21 extends AbstractInterpreter 
{
	public XWikiHtmlInterpreterV21() 
	{
		super();
		this.encodingTag = KnownEncodingForm.HTML_ENCODING_FORM.getPattern();
		this.decodingTag = KnownDecodingForm.HTML_DECODING_FORM.getPattern();
	}

	@Override
	public String encode(String content) 
	{
		// TODO Implement the html encoding in XWiki 2.1
		return content;		
	}

	@Override
	public String decode(String content) 
	{
		Pattern decodingHTMLPattern = Pattern.compile(KnownDecodingPatterns.HTML_DECODING_PATTERN.getPattern());
		Matcher decodingHTMLMatcher = decodingHTMLPattern.matcher(content);
		
		while(decodingHTMLMatcher.find())
		{
			content = content.replace(decodingHTMLMatcher.group(0), decodingTag.replace("#TEXT#", decodingHTMLMatcher.group(1)));
		}
		return content;
	}
}