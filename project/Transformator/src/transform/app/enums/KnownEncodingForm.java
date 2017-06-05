package transform.app.enums;

/**
 * This enumeration contains all the encoding forms of the application language
 * @author Razvan
 *
 */
public enum KnownEncodingForm 
{
	// List
	BULLETED_LIST_ENCODING_FORM 		("<bulletList depth=\"#LEVEL#\">#TEXT#</bulletList>"),
	HEBREW_LIST_ENCODING_FORM			("<hebrewList>#TEXT#</hebrewList>"),
	HIRAGANA_IROAH_LIST_ENCODING_FORM	("<hiraganaIroahList>#TEXT#</hiraganaIroahList>"),
	HIRAGANA_LIST_ENCODING_FORM			("<hiraganaList>#TEXT#</hiraganaList>"),
	KATAKANA_IROHA_LIST_ENCODING_FORM	("<katakanaIrohaList>#TEXT#</katakanaIrohaList>"),
	KATAKANA_LIST_ENCODING_FORM			("<katakanaList>#TEXT#</katakanaList>"),
	
	LOWERCASE_ALPHABETICAL_LIST_ENCODING_FORM	("<alphaLowList>#TEXT#</alphaLowList>"),
	LOWERCASE_GREEK_LIST_ENCODING_FORM			("<greekLowList>#TEXT#</greekLowList>"),
	LOWERCASE_ROMAN_LIST_ENCODING_FORM			("<romanLowList>#TEXT#</romanLowList>"),
	UPPERCASE_ALPHABETICAL_LIST_ENCODING_FORM	("<alphaUpList>#TEXT#</alphaUpList>"),
	UPPERCASE_GREEK_LIST_ENCODING_FORM			("<greekUpList>#TEXT#</greekUpList>"),
	UPPERCASE_ROMAN_LIST_ENCODING_FORM			("<romanUpList>#TEXT#</romanUpList>"),
	
	MIXED_LIST_ENCODING_FORM					("<mixedList depth=\"#LEVEL#\">#TEXT#</mixedList>"),
	NUMBERED_LIST_ENCODING_FORM					("<numberList depth=\"#LEVEL#\">#TEXT#</numberList>"),
	SQUARE_LIST_ENCODING_FORM					("<squareList>#TEXT#</squareList>"),
	
	// Text
	BOLD_ENCODING_FORM		("<bold>#TEXT#</bold>"),
	HEADING_ENCODING_FORM	("<heading level=\"#LEVEL#\">#TEXT#</heading>"),
	ITALIC_ENCODING_FORM	("<italic>#TEXT#</italic>"),
	STRIKE_ENCODING_FORM	("<strike>#TEXT#</strike>"),
	UNDERLINE_ENCODING_FORM	("<underline>#TEXT#</underline>"),
	
	// Other
	HORIZONTAL_LINE_ENCODING_FORM	("<horizontalLine>"),
	LINE_BREAK_ENCODING_FORM		("<newline>"),
	LINK_ENCODING_FORM				("<link name=\"#NAME#\" wikiAlias=\"#ALIAS#\" target=\"#TARGET#\">#TEXT#</link>"),
	
	// HTML
	HTML_ENCODING_FORM		("<html>" + System.lineSeparator() + "#TEXT#" + System.lineSeparator() + "</html>"),
	
	// Macro
	MACRO_ENCODING_FORM		("<macro>" + System.lineSeparator() + "#TEXT#" + System.lineSeparator() + "</macro>"),
	
	// Script
	SCRIPT_ENCODING_FORM	("<script type=\"#TYPE#\">" + System.lineSeparator() + "#TEXT#" + System.lineSeparator() + "</script>"),
	;
	
	
	
	private String pattern;
	
	private KnownEncodingForm(String pattern) 
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
