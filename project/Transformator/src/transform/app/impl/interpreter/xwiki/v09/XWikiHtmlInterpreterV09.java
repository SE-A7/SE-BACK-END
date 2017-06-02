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
		Pattern encodingHTMLMultiTagPattern = Pattern.compile(KnownEncodingPatterns.HTML_MULTITAG_INTERPRETER_PATTERN.getPattern());
		Matcher encodingHTMLMultiTagMatcher = encodingHTMLMultiTagPattern.matcher(content);
		
		Pattern encodingHTMLSingleTagPattern = Pattern.compile(KnownEncodingPatterns.HTML_SINGLETAG_INTERPRETER_PATTERN.getPattern());
		Matcher encodingHTMLSingleTagMatcher = encodingHTMLSingleTagPattern.matcher(content);
		
		while(encodingHTMLMultiTagMatcher.find())
		{
			content = content.replace(encodingHTMLMultiTagMatcher.group(0), encodingTag.replace("#TEXT#", encodingHTMLMultiTagMatcher.group(0)));
		}
		
		while(encodingHTMLSingleTagMatcher.find())
		{
			content = content.replace(encodingHTMLSingleTagMatcher.group(0), encodingTag.replace("#TEXT#", encodingHTMLSingleTagMatcher.group(0)));
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