package transform.app.impl.interpreter.xwiki.v09;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.log4j.Logger;

import transform.app.enums.KnownEncodingForm;
import transform.app.impl.abstr.AbstractInterpreter;
import transform.app.impl.interpreter.xwiki.v09.enums.KnownDecodingForm;
import transform.app.impl.interpreter.xwiki.v09.enums.KnownEncodingPatterns;

/**
 * Interpreter for the horizontal line in XWiki 0.9
 * @author Razvan
 *
 */
public class XWikiHorizontalLineInterpreterV09 extends AbstractInterpreter 
{
	/**
	 *  The logger for the class {@link XWikiHorizontalLineInterpreterV09}
	 */
	private static final Logger log = Logger.getLogger(XWikiHorizontalLineInterpreterV09.class);
	
	public XWikiHorizontalLineInterpreterV09() 
	{
		super();
		this.encodingTag = KnownEncodingForm.HORIZONTAL_LINE_ENCODING_FORM.getPattern();
		this.decodingTag = KnownDecodingForm.HORIZONTAL_LINE_DECODING_FORM.getPattern();
	}
	
	@Override
	public String encode(String content) 
	{
		log.info("Start to encode the horizontal lines from XWiki 0.9 ...");
		Pattern pattern = Pattern.compile(KnownEncodingPatterns.HORIZONTAL_LINE_TEXT_PATTERN.getPattern());
		Matcher matcher = pattern.matcher(content);
		
		while(matcher.find())
		{
			log.info("Horizontal line found. Encoding ...");
			content = content.replace(matcher.group(0), encodingTag.replace("#TEXT", matcher.group(1)));
		}
		
		log.info("Encoding the horizontal lines finished");
		return content;

	}

	@Override
	public String decode(String content) 
	{
		log.info("Start to decode the horizontal lines into XWiki 0.9 syntax ...");
		content = content.replace(encodingTag, decodingTag);
		log.info("Decoding horizontal lines finished.");
		return content;
	}
}
