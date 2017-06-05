package transform.app.util;

/**
 * Class which provides useful methods for XML files
 * @author Razvan
 *
 */
public class XMLUtils 
{
	private static final String DOUBLE_QUOTE_ESCAPE = "&quot;";
	private static final String SINGLE_QUOTE_ESCAPE = "&apos;";
	private static final String LESS_THAN_ESCAPE	= "&lt;";
	private static final String GREATER_THAN_ESCAPE	= "&gt;";
	private static final String AMPERSAND_ESCAPE	= "&amp;";
	
	
	public static String handleEscapeChars(String content)
	{
		return content.replace(DOUBLE_QUOTE_ESCAPE, "\"").replace(SINGLE_QUOTE_ESCAPE, "'").replace(LESS_THAN_ESCAPE, "<").replace(GREATER_THAN_ESCAPE, ">").replace(AMPERSAND_ESCAPE, "&");
	}
}
