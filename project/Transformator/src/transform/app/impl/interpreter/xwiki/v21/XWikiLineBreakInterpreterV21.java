package transform.app.impl.interpreter.xwiki.v21;

import org.apache.log4j.Logger;

import transform.app.enums.KnownEncodingForm;
import transform.app.impl.abstr.AbstractInterpreter;

/**
 * Intepreter for line breaks in XWiki 2.1
 * @author Razvan
 *
 */
public class XWikiLineBreakInterpreterV21 extends AbstractInterpreter
{
	/**
	 *  The logger for the class {@link XWikiLineBreakInterpreterV21}
	 */
	private static final Logger log = Logger.getLogger(XWikiLineBreakInterpreterV21.class);
	
	public XWikiLineBreakInterpreterV21() 
	{
		super();
		this.encodingTag = KnownEncodingForm.LINE_BREAK_ENCODING_FORM.getPattern();
		this.decodingTag = System.lineSeparator();
	}
	
	@Override
	public String encode(String content) 
	{
		return content;
	}


	@Override
	public String decode(String content) 
	{
		log.info("Start to decode the line breaks into XWiki 2.1 syntax ...");
		content = content.replace(encodingTag, decodingTag);
		log.info("Decoding line breaks finished.");
		return content;
	}
}
