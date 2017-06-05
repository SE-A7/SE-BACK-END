package transform.app.impl.interpreter.xwiki.v09;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.log4j.Logger;

import transform.app.enums.KnownEncodingForm;
import transform.app.impl.abstr.AbstractInterpreter;
import transform.app.impl.interpreter.xwiki.v09.enums.KnownDecodingForm;
import transform.app.impl.interpreter.xwiki.v09.enums.KnownEncodingPatterns;

/**
 * Interpreter for the line break in XWiki 0.9
 * @author Razvan
 *
 */
public class XWikiLineBreakInterpreterV09 extends AbstractInterpreter
{
	/**
	 *  The logger for the class {@link XWikiLineBreakInterpreterV09}
	 */
	private static final Logger log = Logger.getLogger(XWikiLineBreakInterpreterV09.class);
	
	public XWikiLineBreakInterpreterV09() 
	{
		super();
		this.encodingTag = KnownEncodingForm.LINE_BREAK_ENCODING_FORM.getPattern();
		this.decodingTag = KnownDecodingForm.LINE_BREAK_DECODING_FORM.getPattern();
	}
	
	@Override
	public String encode(String content) 
	{
		log.info("Start to encode the line breaks from XWiki 0.9 ...");
		Pattern pattern = Pattern.compile(KnownEncodingPatterns.LINE_BREAK_PATTERN.getPattern(), Pattern.MULTILINE);
		Matcher matcher = pattern.matcher(content);
		
		while(matcher.find())
		{
			log.info("Line break found. Encoding ...");
			content = content.replace(matcher.group(0), encodingTag);
		}
		
		log.info("Encoding the line breaks finished.");
		return content;
	}


	@Override
	public String decode(String content) 
	{
		log.info("Start to decode the line breaks into XWiki 0.9 syntax ...");
		content = content.replace(encodingTag, decodingTag);
		log.info("Decoding the line breaks finished.");
		return content;
	}
}
