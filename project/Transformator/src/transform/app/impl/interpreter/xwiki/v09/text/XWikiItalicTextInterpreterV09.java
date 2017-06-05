package transform.app.impl.interpreter.xwiki.v09.text;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.log4j.Logger;

import transform.app.enums.KnownDecodingPatterns;
import transform.app.enums.KnownEncodingForm;
import transform.app.impl.abstr.AbstractInterpreter;
import transform.app.impl.interpreter.xwiki.v09.enums.KnownDecodingForm;
import transform.app.impl.interpreter.xwiki.v09.enums.KnownEncodingPatterns;

/**
 * Interpreter for the italic text in XWiki 0.9
 * @author Razvan
 *
 */
public class XWikiItalicTextInterpreterV09 extends AbstractInterpreter 
{
	/**
	 *  The logger for the class {@link XWikiItalicTextInterpreterV09}
	 */
	private static final Logger log = Logger.getLogger(XWikiItalicTextInterpreterV09.class);
	
	public XWikiItalicTextInterpreterV09() 
	{
		super();
		this.encodingTag = KnownEncodingForm.ITALIC_ENCODING_FORM.getPattern();
		this.decodingTag = KnownDecodingForm.ITALIC_DECODING_FORM.getPattern();
	}

	@Override
	public String encode(String content) 
	{
		log.info("Start to encode the italic text from XWiki 0.9 ...");
		Pattern pattern = Pattern.compile(KnownEncodingPatterns.ITALIC_TEXT_PATTERN.getPattern());
		Matcher matcher = pattern.matcher(content);
		
		while(matcher.find())
		{
			log.info("Italic text found. Encoding ...");
			content = content.replaceAll(matcher.group(0), encodingTag.replace("#TEXT#", matcher.group(1)));
		}
		
		log.info("Encoding the italic text finished.");
		return content;
	}

	@Override
	public String decode(String content) 
	{
		log.info("Start to decode the italic text into XWiki 0.9 syntax ...");
		Pattern pattern = Pattern.compile(KnownDecodingPatterns.ITALIC_DECODING_PATTERN.getPattern());
		Matcher matcher = pattern.matcher(content);
		
		while(matcher.find())
		{
			log.info("Italic text found. Decoding ...");
			content = content.replaceAll(matcher.group(0), decodingTag.replace("#TEXT#", matcher.group(1)));
		}
		
		log.info("Decoding the italic text finished.");
		return content;
	}

}