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
 * Interpreter for mixed list in XWiki 2.1
 * @author Razvan
 *
 */
public class XWikiMixedListInterpreterV21 extends AbstractInterpreter 
{
	/**
	 *  The logger for the class {@link XWikiMixedListInterpreterV21}
	 */
	private static final Logger log = Logger.getLogger(XWikiMixedListInterpreterV21.class);
	
	public XWikiMixedListInterpreterV21() 
	{
		super();
		this.encodingTag = KnownEncodingForm.MIXED_LIST_ENCODING_FORM.getPattern();
	}
	
	@Override
	public String encode(String content) 
	{
		log.info("Start to encode the mixed lists from XWiki 2.1 ...");
		Pattern encodingPattern = Pattern.compile(KnownEncodingPatterns.MIXED_LIST_PATTERN.getPattern(),Pattern.MULTILINE);
		Matcher encodingMatcher = encodingPattern.matcher(content);
		
		while(encodingMatcher.find())
		{
			log.info("Mixed list item found. Encoding ...");
			content = content.replace(encodingMatcher.group(0),encodingTag.replace("#LEVEL#",Integer.toString(StringUtils.getNumberOfCounts("*", encodingMatcher.group(1)) + 1)).replace("#TEXT#", encodingMatcher.group(2).trim()));
		}

		log.info("Encoding the mixed lists finished.");
		return content;
	}

	@Override
	public String decode(String content) 
	{
		log.info("Start to decode the mixed lists into XWiki 2.1 syntax ...");
		Pattern decodingPattern = Pattern.compile(KnownDecodingPatterns.MIXED_LIST_DECODING_PATTERN.getPattern(),Pattern.MULTILINE);
		Matcher decodingMatcher = decodingPattern.matcher(content);
		
		while(decodingMatcher.find())
		{
			log.info("Mixed list item found. Decoding ...");
			content = content.replace(decodingMatcher.group(0), "1" + StringUtils.getRepeatedString("*", Integer.parseInt(decodingMatcher.group(1)) - 1, "") + ". " + decodingMatcher.group(2));
		}

		log.info("Decoding the mixed lists finished.");
		return content;
	}

}
