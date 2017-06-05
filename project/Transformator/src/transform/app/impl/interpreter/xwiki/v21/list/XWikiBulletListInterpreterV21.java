package transform.app.impl.interpreter.xwiki.v21.list;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.log4j.Logger;

import transform.app.enums.KnownDecodingPatterns;
import transform.app.enums.KnownEncodingForm;
import transform.app.impl.abstr.AbstractInterpreter;
import transform.app.impl.interpreter.xwiki.v21.enums.KnownEncodingPatterns;
import transform.app.util.StringUtils;

/**
 * Interpreter for the bullet lists in XWiki 2.1
 * @author Razvan
 *
 */
public class XWikiBulletListInterpreterV21 extends AbstractInterpreter 
{
	/**
	 *  The logger for the class {@link XWikiBulletListInterpreterV21}
	 */
	private static final Logger log = Logger.getLogger(XWikiBulletListInterpreterV21.class);
	
	public XWikiBulletListInterpreterV21() 
	{
		super();
		this.encodingTag = KnownEncodingForm.BULLETED_LIST_ENCODING_FORM.getPattern();
	}

	@Override
	public String encode(String content) 
	{
		log.info("Start to encode the bullet lists from XWiki 2.1 ...");
		Pattern encodingPattern = Pattern.compile(KnownEncodingPatterns.BULLETED_LIST_PATTERN.getPattern(),Pattern.MULTILINE);
		Matcher encodingMatcher = encodingPattern.matcher(content);
		
		while(encodingMatcher.find())
		{
			log.info("Bullet list item found. Encoding ...");
			content = content.replace(encodingMatcher.group(0),encodingTag.replace("#LEVEL#",Integer.toString(StringUtils.getNumberOfCounts("*", encodingMatcher.group(1)))).replace("#TEXT#", encodingMatcher.group(2).trim()));
		}

		log.info("Encoding the bullet lists finished.");
		return content;
	}

	@Override
	public String decode(String content) 
	{
		log.info("Start to decode the bullet lists into XWiki 2.1 syntax ...");
		Pattern decodingPattern = Pattern.compile(KnownDecodingPatterns.BULLETED_LIST_DECODING_PATTERN.getPattern());
		Matcher decodingMatcher = decodingPattern.matcher(content);
		
		while(decodingMatcher.find())
		{
			log.info("Bullet list item found. Decoding ...");
			content = content.replace(decodingMatcher.group(0), StringUtils.getRepeatedString("*", Integer.parseInt(decodingMatcher.group(1)), "") + " " + decodingMatcher.group(2));
		}
		
		log.info("Decoding the bullet lists finished.");
		return content;
	}

}
