package transform.app.impl.interpreter.xwiki.v21;

import org.apache.log4j.Logger;

import transform.app.enums.KnownEncodingForm;
import transform.app.impl.abstr.AbstractInterpreter;
import transform.app.impl.interpreter.xwiki.v21.enums.KnownDecodingForm;

/**
 * Interpreter for horizontal line in XWiki 2.1
 * @author Razvan
 *
 */
public class XWikiHorizontalLineInterpreterV21 extends AbstractInterpreter 
{
	/**
	 *  The logger for the class {@link XWikiHorizontalLineInterpreterV21}
	 */
	private static final Logger log = Logger.getLogger(XWikiHorizontalLineInterpreterV21.class);
	
	public XWikiHorizontalLineInterpreterV21() 
	{
		super();
		this.encodingTag = KnownEncodingForm.HORIZONTAL_LINE_ENCODING_FORM.getPattern();
		this.decodingTag = KnownDecodingForm.HORIZONTAL_LINE_DECODING_FORM.getPattern();
	}
	
	@Override
	public String encode(String content) 
	{
		return content;
	}

	@Override
	public String decode(String content) 
	{
		log.info("Start to decode the horizontal lines into XWiki 2.1 syntax ...");
		content = content.replace(encodingTag, decodingTag);
		log.info("Decoding the horizontal lines finished.");
		return content;
	}
}
