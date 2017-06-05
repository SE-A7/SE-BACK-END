package transform.app.impl.interpreter.xwiki.v09.list;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.log4j.Logger;

import transform.app.enums.KnownDecodingPatterns;
import transform.app.enums.KnownEncodingForm;
import transform.app.impl.abstr.AbstractInterpreter;
import transform.app.impl.interpreter.xwiki.v09.enums.KnownEncodingPatterns;
import transform.app.util.StringUtils;

/**
 * Interpreter for bullet lists in XWiki 0.9
 * @author Razvan
 *
 */
public class XWikiBulletListInterpreterV09 extends AbstractInterpreter 
{
	private static final Logger log = Logger.getLogger(XWikiBulletListInterpreterV09.class);
	
	public XWikiBulletListInterpreterV09() 
	{
		super();
		this.encodingTag = KnownEncodingForm.BULLETED_LIST_ENCODING_FORM.getPattern();
	}

	@Override
	public String encode(String content) 
	{
		log.info("Starting to encode the bulleted list from XWiki 0.9 ...");
		Pattern encodingPattern = Pattern.compile(KnownEncodingPatterns.BULLETED_LIST_PATTERN.getPattern(),Pattern.MULTILINE);
		Matcher encodingMatcher = encodingPattern.matcher(content);
		
		while(encodingMatcher.find())
		{
			log.info("Bulleted list item found. Encoding ...");
			content = content.replace(encodingMatcher.group(0),encodingTag.replace("#LEVEL#",Integer.toString(StringUtils.getNumberOfCounts("*", encodingMatcher.group(1)))).replace("#TEXT#", encodingMatcher.group(2).trim()));
		}

		log.info("Encoding the bulleted list finished.");
		return content;
	}

	@Override
	public String decode(String content) 
	{
		log.info("Starting to decode the bulleted list into XWiki 0.9 syntax ...");
		Pattern decodingPattern = Pattern.compile(KnownDecodingPatterns.BULLETED_LIST_DECODING_PATTERN.getPattern(),Pattern.MULTILINE);
		Matcher decodingMatcher = decodingPattern.matcher(content);
		
		while(decodingMatcher.find())
		{
			log.info("Bulleted list item found. Decoding ...");
			content = content.replace(decodingMatcher.group(0), StringUtils.getRepeatedString("*", Integer.parseInt(decodingMatcher.group(1)), "") + " " + decodingMatcher.group(2));
		}
		
		log.info("Decoding the bulleted list finished.");
		return content;
	}

}
