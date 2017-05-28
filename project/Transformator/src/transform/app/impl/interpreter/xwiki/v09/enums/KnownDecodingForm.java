package transform.app.impl.interpreter.xwiki.v09.enums;

/**
 * This enumeration contains all the decoding forms of the XWiki 0.9 syntax used by the application 
 * @author Razvan
 *
 */
public enum KnownDecodingForm 
{
	// List
	HEBREW_LIST_DECODING_FORM			("j. #TEXT#"),
	HIRAGANA_IROAH_LIST_DECODING_FORM	("H. #TEXT#"),
	HIRAGANA_LIST_DECODING_FORM			("h. #TEXT#"),
	KATAKANA_IROHA_LIST_DECODING_FORM	("K. #TEXT#"),
	KATAKANA_LIST_DECODING_FORM			("k. #TEXT#"),
	
	LOWERCASE_ALPHABETICAL_LIST_DECODING_FORM	("a. #TEXT#"),
	LOWERCASE_GREEK_LIST_DECODING_FORM			("g. #TEXT#"),
	LOWERCASE_ROMAN_LIST_DECODING_FORM			("i. #TEXT#"),
	UPPERCASE_ALPHABETICAL_LIST_DECODING_FORM	("A. #TEXT#"),
	UPPERCASE_GREEK_LIST_DECODING_FORM			("G. #TEXT#"),
	UPPERCASE_ROMAN_LIST_DECODING_FORM			("I. #TEXT#"),
	
	SQUARE_LIST_DECODING_FORM			("- #TEXT#"),
	
	// Text
	BOLD_DECODING_FORM		("*#TEXT#*"),
	ITALIC_DECODING_FORM	("~~#TEXT#~~"),
	STRIKE_DECODING_FORM	("--#TEXT#--"),
	UNDERLINE_DECODING_FORM	("__#TEXT#___"),
	
	// Other
	HORIZONTAL_LINE_DECODING_FORM	("----"),
	LINE_BREAK_DECODING_FORM		("\\\\"),
	LINK_DECODING_FORM				("[#NAME#>#TEXT#@#ALIAS#>#TARGET#]"),
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
