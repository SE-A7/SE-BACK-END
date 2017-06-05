package transform.app.impl.interpreter.xwiki.v21;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.log4j.Logger;

import transform.app.enums.KnownDecodingPatterns;
import transform.app.impl.abstr.AbstractInterpreter;
import transform.app.impl.interpreter.xwiki.v21.enums.KnownDecodingForm;

/**
 * Interpreter for links in XWiki 2.1
 * @author Razvan
 *
 */
public class XWikiLinkInterpreterV21 extends AbstractInterpreter 
{
	/**
	 *  The logger for the class {@link XWikiLinkInterpreterV21}
	 */
	private static final Logger log = Logger.getLogger(XWikiLinkInterpreterV21.class);
	
	public XWikiLinkInterpreterV21() 
	{
		super();
		this.decodingTag = KnownDecodingForm.LINK_DECODING_FORM.getPattern();
	}
	
	@Override
	public String encode(String content) 
	{
		// TODO Implement the encoding of the links in XWiki 2.1
		return content;
	}

	@Override
	public String decode(String content) 
	{
		log.info("Start to decode the links into XWiki 2.1 syntax ...");
		Pattern decodingPattern = Pattern.compile(KnownDecodingPatterns.LINK_DECODING_PATTERN.getPattern());
		Matcher decodingMatcher = decodingPattern.matcher(content);
		
		String decodedLink = new String(decodingTag);
		while(decodingMatcher.find())
		{
			log.info("Link found. Decoding ...");
			decodedLink = (decodingMatcher.group(1).equals("")) ? decodedLink.replace("#NAME#>>", "") : decodedLink.replace("#NAME#", decodingMatcher.group(1));	// verify if #NAME# is not completed		
			decodedLink = (decodingMatcher.group(2).equals(""))	? decodedLink.replace("@#ALIAS#", "") : decodedLink.replace("#ALIAS#", decodingMatcher.group(2));	// verify if #ALIAS# is not completed
			decodedLink = (decodingMatcher.group(3).equals(""))	? decodedLink.replace("||#TARGET#", "") : decodedLink.replace("#TARGET#", decodingMatcher.group(3));// verify if #TARGET# is not completed
			
			content = content.replace(decodingMatcher.group(0), decodedLink.replace("#TEXT#", decodingMatcher.group(4)));
		}
		
		log.info("Decoding links finished.");
		return content;
	}

}
