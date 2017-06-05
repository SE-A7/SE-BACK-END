package transform.app.impl.interpreter.xwiki.v09.text;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.log4j.Logger;

import transform.app.enums.KnownDecodingPatterns;
import transform.app.enums.KnownEncodingForm;
import transform.app.impl.abstr.AbstractInterpreter;
import transform.app.impl.interpreter.xwiki.v09.enums.KnownEncodingPatterns;
import transform.app.util.StringUtils;

/**
 * Interpreter for the headings in XWiki 0.9
 * @author Razvan
 *
 */
public class XWikiHeadingInterpreterV09 extends AbstractInterpreter 
{
	/**
	 *  The logger for the class {@link XWikiHeadingInterpreterV09}
	 */
	private static final Logger log = Logger.getLogger(XWikiHeadingInterpreterV09.class);
	
	public XWikiHeadingInterpreterV09() 
	{
		super();
		this.encodingTag = KnownEncodingForm.HEADING_ENCODING_FORM.getPattern();
	}
	
	@Override
	public String encode(String content) 
	{
		log.info("Start to encode the headings from XWiki 0.9 ...");
		Pattern headingLevelPattern = Pattern.compile(KnownEncodingPatterns.HEADING_LEVEL_PATTERN.getPattern(), Pattern.MULTILINE);
		Matcher headingLevelMatcher = headingLevelPattern.matcher(content);
		
		Pattern headingTextPattern	= Pattern.compile(KnownEncodingPatterns.HEADING_TEXT_PATTERN.getPattern(), Pattern.MULTILINE);
		Matcher headingTextMatcher 	= headingTextPattern.matcher(content);
		
		while(headingLevelMatcher.find() && headingTextMatcher.find())
		{
			log.info("Heading found. Encoding ...");
			content 		= content.replace(headingTextMatcher.group(0), encodingTag.replace("#LEVEL#", Integer.toString(StringUtils.getNumberOfCounts("1", headingLevelMatcher.group(0)))).replace("#TEXT#", headingTextMatcher.group(2).trim()));
		}
		
		log.info("Encoding the headings finished.");
		return content;
	}

	@Override
	public String decode(String content) 
	{
		log.info("Start to decode the headings into XWiki 0.9 syntax ...");
		Pattern decodingPattern = Pattern.compile(KnownDecodingPatterns.HEADING_DECODING_PATTERN.getPattern());
		Matcher decodingMatcher = decodingPattern.matcher(content);
		
		while(decodingMatcher.find())
		{
			log.info("Heading found. Decoding ...");
			content = content.replace(decodingMatcher.group(0), StringUtils.getRepeatedString("1", Integer.parseInt(decodingMatcher.group(1).trim()), ".") + " " + decodingMatcher.group(2).trim());
		}
		
		log.info("Decoding the headings finished.");
		return content;
	}

}