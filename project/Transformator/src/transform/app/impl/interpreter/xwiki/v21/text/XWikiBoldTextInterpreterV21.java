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
 * Interpreter for the bold text in XWiki 2.1
 * @author Razvan
 *
 */
public class XWikiBoldTextInterpreterV21 extends AbstractInterpreter 
{
	/**
	 *  The logger class for the class {@link XWikiBoldTextInterpreterV21}
	 */
	private static final Logger log = Logger.getLogger(XWikiBoldTextInterpreterV21.class);
	
	public XWikiBoldTextInterpreterV21() 
	{
		super();
		this.encodingTag = KnownEncodingForm.BOLD_ENCODING_FORM.getPattern();
		this.decodingTag = KnownDecodingForm.BOLD_DECODING_FORM.getPattern();
	}
	
	
	@Override
	public String encode(String content) 
	{
		log.info("Start to encode the bold text from XWiki 2.1 ...");
		Pattern pattern = Pattern.compile(KnownEncodingPatterns.BOLD_TEXT_INTERPRETER_PATTERN.getPattern());
		Matcher matcher = pattern.matcher(content);
		
		while(matcher.find())
		{
			log.info("Bold text found. Encoding ...");
			content = content.replace(matcher.group(0),encodingTag.replace("#TEXT#", matcher.group(2)));
		}
		
		log.info("Encoding bold text finished.");
		return content;
	}

	@Override
	public String decode(String content) 
	{
		log.info("Start to decode the bold text into XWiki 2.1 syntax ...");
		Pattern pattern = Pattern.compile(KnownDecodingPatterns.BOLD_DECODING_PATTERN.getPattern());
		Matcher matcher = pattern.matcher(content);
		
		while(matcher.find())
		{
			log.info("Bold text found. Decoding ...");
			content = content.replace(matcher.group(0), decodingTag.replace("#TEXT#", matcher.group(1)));
		}
		
		log.info("Decoding bold text finished.");
		return content;
	}

}