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
 * Interpreter for underline text in XWiki 2.1
 * @author Razvan
 *
 */
public class XWikiUnderlineTextInterpreterV21 extends AbstractInterpreter 
{
	/**
	 *  The logger for the class {@link XWikiUnderlineTextInterpreterV21}
	 */
	private static final Logger log = Logger.getLogger(XWikiUnderlineTextInterpreterV21.class);
	
	public XWikiUnderlineTextInterpreterV21() 
	{
		super();
		this.encodingTag = KnownEncodingForm.UNDERLINE_ENCODING_FORM.getPattern();
		this.decodingTag = KnownDecodingForm.UNDERLINE_DECODING_FORM.getPattern();
	}

	@Override
	public String encode(String content) 
	{
		log.info("Start to encode the underline text from XWiki 2.1 ...");
		Pattern pattern = Pattern.compile(KnownEncodingPatterns.UNDERLINE_TEXT_INTERPRETER_PATTERN.getPattern());
		Matcher matcher = pattern.matcher(content);
		
		while(matcher.find())
		{
			log.info("Underline text found. Encoding ...");
			content = content.replaceAll(matcher.group(0), encodingTag.replace("#TEXT", matcher.group(1)));
		}

		log.info("Encoding the underline text finished.");
		return content;
	}

	@Override
	public String decode(String content) 
	{
		log.info("Start to decode the underline text into XWiki 2.1 syntax ...");
		Pattern pattern = Pattern.compile(KnownDecodingPatterns.UNDERLINE_DECODING_PATTERN.getPattern());
		Matcher matcher = pattern.matcher(content);
		
		while(matcher.find())
		{
			log.info("Underline text found. Decoding ...");
			content = content.replaceAll(matcher.group(0), decodingTag.replace("#TEXT", matcher.group(1)));
		}
		
		log.info("Decoding the underline text finished.");
		return content;
	}
	
}