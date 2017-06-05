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
 * Interpreter for the numbered list in XWiki 0.9
 * @author Razvan
 *
 */
public class XWikiNumberedListInterpreterV09 extends AbstractInterpreter 
{
	/**
	 *  The logger of the class {@link XWikiNumberedListInterpreterV09}
	 */
	private static final Logger log = Logger.getLogger(XWikiNumberedListInterpreterV09.class);
	
	public XWikiNumberedListInterpreterV09() 
	{
		super();
		this.encodingTag = KnownEncodingForm.NUMBERED_LIST_ENCODING_FORM.getPattern();
	}
	
	
	
	@Override
	public String encode(String content) 
	{
		log.info("Starting to encode the numbered list from XWiki 0.9 ...");
		Pattern encodingPattern = Pattern.compile(KnownEncodingPatterns.NUMBERED_LIST_PATTERN.getPattern(),Pattern.MULTILINE);
		Matcher encodingMatcher = encodingPattern.matcher(content);
		
		while(encodingMatcher.find())
		{
			log.info("Numbered list item found. Encoding ...");
			content = content.replace(encodingMatcher.group(0),encodingTag.replace("#LEVEL#",Integer.toString(StringUtils.getNumberOfCounts("1", encodingMatcher.group(1)))).replace("#TEXT#", encodingMatcher.group(2).trim()));
		}

		log.info("Encoding the numbered list finished.");
		return content;
	}

	@Override
	public String decode(String content) 
	{
		log.info("Starting to decode the numbered list into XWiki 0.9 syntax ...");
		Pattern decodingPattern = Pattern.compile(KnownDecodingPatterns.NUMBERED_LIST_DECODING_PATTERN.getPattern(),Pattern.MULTILINE);
		Matcher decodingMatcher = decodingPattern.matcher(content);
		
		while(decodingMatcher.find())
		{
			log.info("Numbered list item found. Decoding ...");
			content = content.replace(decodingMatcher.group(0), StringUtils.getRepeatedString("1", Integer.parseInt(decodingMatcher.group(1)), "") + ". " + decodingMatcher.group(2));
		}

		log.info("Decoding the numbered list finished.");
		return content;
	}

}
