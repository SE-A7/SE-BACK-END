package transform.app.impl.interpreter.xwiki.v21.text;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.log4j.Logger;

import transform.app.enums.KnownDecodingPatterns;
import transform.app.enums.KnownEncodingForm;
import transform.app.impl.abstr.AbstractInterpreter;
import transform.app.impl.interpreter.xwiki.v21.enums.KnownDecodingForm;
import transform.app.impl.interpreter.xwiki.v21.enums.KnownEncodingPatterns;

/**
 * Intepreter for strike text in XWiki 2.1
 * @author Razvan
 *
 */
public class XWikiStrikeTextInterpreterV21 extends AbstractInterpreter 
{
	/**
	 *  The logger for the class {@link XWikiStrikeTextInterpreterV21}
	 */
	private static final Logger log = Logger.getLogger(XWikiStrikeTextInterpreterV21.class);
	
	public XWikiStrikeTextInterpreterV21() 
	{
		super();
		this.encodingTag = KnownEncodingForm.STRIKE_ENCODING_FORM.getPattern();
		this.decodingTag = KnownDecodingForm.STRIKE_DECODING_FORM.getPattern();
	}
	
	@Override
	public String encode(String content) 
	{
		log.info("Start to encode the strike text from XWiki 2.1 ...");
		Pattern pattern = Pattern.compile(KnownEncodingPatterns.STRIKE_TEXT_INTERPRETER_PATTERN.getPattern());
		Matcher matcher = pattern.matcher(content);
		
		while(matcher.find())
		{
			log.info("Strike text found. Encoding ...");
			content = content.replaceAll(matcher.group(0), encodingTag.replace("#TEXT", matcher.group(1)));
		}

		log.info("Encoding the strike text finished.");
		return content;
	}

	@Override
	public String decode(String content) 
	{
		log.info("Start to decode the strike text into XWiki 2.1 syntax ...");
		Pattern pattern = Pattern.compile(KnownDecodingPatterns.STRIKE_DECODING_PATTERN.getPattern());
		Matcher matcher = pattern.matcher(content);
		
		while(matcher.find())
		{
			log.info("Strike text found. Decoding ...");
			content = content.replaceAll(matcher.group(0), decodingTag.replace("#TEXT", matcher.group(1)));
		}

		log.info("Decoding the strike text finished.");
		return content;
	}

}
