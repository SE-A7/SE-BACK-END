package transform.app.impl.interpreter.xwiki.v09;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import transform.app.enums.KnownDecodingPatterns;
import transform.app.enums.KnownEncodingForm;
import transform.app.impl.abstr.AbstractInterpreter;
import transform.app.impl.interpreter.xwiki.v09.enums.KnownEncodingPatterns;

public class XWikiHtmlInterpreterV09 extends AbstractInterpreter 
{
	public XWikiHtmlInterpreterV09() 
	{
		super();
		this.encodingTag = KnownEncodingForm.HTML_ENCODING_FORM.getPattern();
	}
	
	@Override
	public String encode(String content) 
	{
		Pattern encodingHTMLMultilinePattern = Pattern.compile(KnownEncodingPatterns.HTML_MULTILINE_INTERPRETER_PATTERN.getPattern());
		Matcher encodingHTMLMultilineMatcher = encodingHTMLMultilinePattern.matcher(content);
		
		Pattern encodingHTMLSinglelinePattern = Pattern.compile(KnownEncodingPatterns.HTML_SINGLELINE_INTERPRETER_PATTERN.getPattern());
		Matcher encodingHTMLSinglelineMatcher = encodingHTMLSinglelinePattern.matcher(content);
		
		while(encodingHTMLMultilineMatcher.find())
		{
			content = content.replace(encodingHTMLMultilineMatcher.group(0), encodingTag.replace("#TEXT#", encodingHTMLMultilineMatcher.group(0)));
		}
		
		while(encodingHTMLSinglelineMatcher.find())
		{
			content = content.replace(encodingHTMLSinglelineMatcher.group(0), encodingTag.replace("#TEXT#", encodingHTMLSinglelineMatcher.group(0)));
		}
		
		return content;
	}

	@Override
	public String decode(String content) 
	{
		Pattern decodingHTMLPattern = Pattern.compile(KnownDecodingPatterns.HTML_DECODING_PATTERN.getPattern());
		Matcher decodingHTMLMatcher = decodingHTMLPattern.matcher(content);
		
		while(decodingHTMLMatcher.find())
		{
			content = content.replace(decodingHTMLMatcher.group(0), decodingHTMLMatcher.group(1));
		}
		return content;
	}
}