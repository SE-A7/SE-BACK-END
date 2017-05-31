package transform.app.impl.interpreter.xwiki.v21.enums;

/**
 * This enumeration contains all the decoding forms of the XWiki 2.1 syntax used by the application 
 * @author Razvan
 *
 */
public enum KnownDecodingForm 
{
	// Text
	BOLD_DECODING_FORM 		("**#TEXT#**"),
	ITALIC_DECODING_FORM	("//#TEXT#//"),
	STRIKE_DECODING_FORM	("--#TEXT#--"),
	UNDERLINE_DECODING_FORM	("__#TEXT#__"),
	
	// Other
	HORIZONTAL_LINE_DECODING_FORM 	("{{html}}<hr />{{/html}}"),
	HTML_DECODING_FORM				("{{html}}" + System.lineSeparator() + "#TEXT#" + System.lineSeparator() + "{{/html}}"),
	LINK_DECODING_FORM				("[[#NAME#>>#TEXT#@#ALIAS#||#TARGET#]]"),
	;

	private String pattern;
	
	private KnownDecodingForm(String pattern) 
	{
		this.pattern = pattern;
	}

	public void setPath(String pattern) 
	{
		this.pattern = pattern;
	}
	
	public String getPattern() 
	{
		return pattern;
	}
}
