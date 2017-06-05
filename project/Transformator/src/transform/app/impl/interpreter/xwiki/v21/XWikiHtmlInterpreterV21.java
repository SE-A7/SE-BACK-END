package transform.app.impl.interpreter.xwiki.v21;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.log4j.Logger;

import transform.app.enums.KnownDecodingPatterns;
import transform.app.enums.KnownEncodingForm;
import transform.app.impl.abstr.AbstractInterpreter;
import transform.app.impl.interpreter.xwiki.v21.enums.KnownDecodingForm;

/** 
 * Intepreter for HTML in XWiki 2.1
 * @author Razvan
 *
 */
public class XWikiHtmlInterpreterV21 extends AbstractInterpreter 
{
	/**
	 *  The logger for the class {@link XWikiHtmlInterpreterV21}
	 *  
	 */
	private static final Logger log = Logger.getLogger(XWikiHtmlInterpreterV21.class);
	
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
		log.info("Start to decode the HTML into XWiki 2.1 syntax ...");
		Pattern decodingHTMLPattern = Pattern.compile(KnownDecodingPatterns.HTML_DECODING_PATTERN.getPattern());
		Matcher decodingHTMLMatcher = decodingHTMLPattern.matcher(content);
		
		while(decodingHTMLMatcher.find())
		{
			log.info("HTML tag found. Decoding ...");
			content = content.replace("<html>","{{html}}").replace("</html>", "{{/html}}");
		}
		
		log.info("Decoding HTML finished.");
		return content;
	}
}