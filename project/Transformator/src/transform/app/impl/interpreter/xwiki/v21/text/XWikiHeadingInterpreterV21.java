package transform.app.impl.interpreter.xwiki.v21.text;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.log4j.Logger;

import transform.app.enums.KnownDecodingPatterns;
import transform.app.enums.KnownEncodingForm;
import transform.app.impl.abstr.AbstractInterpreter;
import transform.app.impl.interpreter.xwiki.v21.enums.KnownEncodingPatterns;
import transform.app.util.StringUtils;

/**
 * The interpreter for headings in XWiki 2.1
 * @author Razvan
 *
 */
public class XWikiHeadingInterpreterV21 extends AbstractInterpreter 
{
	/**
	 * The logger for the class {@link XWikiHeadingInterpreterV21}
	 */
	private static final Logger log = Logger.getLogger(XWikiHeadingInterpreterV21.class);
	
	public XWikiHeadingInterpreterV21() 
	{
		super();
		this.encodingTag = KnownEncodingForm.HEADING_ENCODING_FORM.getPattern();
	}
	
	@Override
	public String encode(String content) 
	{
		log.info("Start to encode the headings from XWiki 2.1 ...");
		Pattern encodingHeadingPattern = Pattern.compile(KnownEncodingPatterns.HEADING_INTERPRETER_PATTERN.getPattern());
		Matcher encodingHeadingMatcher = encodingHeadingPattern.matcher(content);
		
		while(encodingHeadingMatcher.find())
		{
			log.info("Heading found. Encoding ...");
			content = content.replace(encodingHeadingMatcher.group(0), encodingTag.replace("#LEVEL#", Integer.toString(StringUtils.getNumberOfCounts("=", encodingHeadingMatcher.group(1).trim())).replace("#TEXT#", encodingHeadingMatcher.group(2).trim())));
		}
		
		log.info("Encoding the headings finished.");
		return content;
	}

	@Override
	public String decode(String content) 
	{
		log.info("Start to decode the headings into XWiki 2.1 syntax ...");
		Pattern decodingHeadingPattern = Pattern.compile(KnownDecodingPatterns.HEADING_DECODING_PATTERN.getPattern());
		Matcher decodingHeadingMatcher = decodingHeadingPattern.matcher(content);
		
		while(decodingHeadingMatcher.find())
		{
			log.info("Heading found. Decoding ...");
			content = content.replace(decodingHeadingMatcher.group(0), StringUtils.getRepeatedString("=", Integer.parseInt(decodingHeadingMatcher.group(1).trim()), "") + " " + decodingHeadingMatcher.group(2).trim() + " " + StringUtils.getRepeatedString("=", Integer.parseInt(decodingHeadingMatcher.group(1).trim()), ""));
		}
		
		log.info("Decoding the headings finished.");
		return content;
	}

}