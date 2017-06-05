package transform.app.impl.interpreter.xwiki.v09;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.log4j.Logger;

import transform.app.enums.KnownDecodingPatterns;
import transform.app.enums.KnownEncodingForm;
import transform.app.impl.abstr.AbstractInterpreter;
import transform.app.impl.interpreter.xwiki.v09.enums.KnownEncodingPatterns;

/**
 * Interpreter for the HTML in XWiki 0.9
 * @author Razvan
 *
 */
public class XWikiHtmlInterpreterV09 extends AbstractInterpreter 
{
	/**
	 *  The logger for the class {@link XWikiHtmlInterpreterV09}
	 */
	private static final Logger log = Logger.getLogger(XWikiHtmlInterpreterV09.class);
	
	public XWikiHtmlInterpreterV09() 
	{
		super();
		this.encodingTag = KnownEncodingForm.HTML_ENCODING_FORM.getPattern();
	}
	
	@Override
	public String encode(String content) 
	{
		log.info("Start to encode the HTML from XWiki 0.9 ...");
		Pattern encodingHTMLMultiTagPattern = Pattern.compile(KnownEncodingPatterns.HTML_MULTITAG_INTERPRETER_PATTERN.getPattern());
		Matcher encodingHTMLMultiTagMatcher = encodingHTMLMultiTagPattern.matcher(content);
		
		Pattern encodingHTMLSingleTagPattern = Pattern.compile(KnownEncodingPatterns.HTML_SINGLETAG_INTERPRETER_PATTERN.getPattern());
		Matcher encodingHTMLSingleTagMatcher = encodingHTMLSingleTagPattern.matcher(content);
		
		while(encodingHTMLMultiTagMatcher.find())
		{
			log.info("HTML multi-tag found. Encoding ...");
			content = content.replace(encodingHTMLMultiTagMatcher.group(0), encodingTag.replace("#TEXT#", encodingHTMLMultiTagMatcher.group(0)));
		}
		
		while(encodingHTMLSingleTagMatcher.find())
		{
			log.info("HTML single-tag found. Encoding ...");
			content = content.replace(encodingHTMLSingleTagMatcher.group(0), encodingTag.replace("#TEXT#", encodingHTMLSingleTagMatcher.group(0)));
		}
		
		log.info("Encoding the HTML finished.");
		return content;
	}

	@Override
	public String decode(String content) 
	{
		log.info("Start to decode the HTML into XWiki 0.9 syntax ...");
		Pattern decodingHTMLPattern = Pattern.compile(KnownDecodingPatterns.HTML_DECODING_PATTERN.getPattern());
		Matcher decodingHTMLMatcher = decodingHTMLPattern.matcher(content);
		
		while(decodingHTMLMatcher.find())
		{
			log.info("HTML found. Decoding ...");
			content = content.replace(decodingHTMLMatcher.group(0), decodingHTMLMatcher.group(1).trim());
		}
		
		log.info("Decoding the HTML finished.");
		return content;
	}
}