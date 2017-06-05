package transform.app.enums;

/**
 * This enumeration contains all the patterns required for decoding from the application language into the desired language
 * @author Razvan
 *
 */
public enum KnownDecodingPatterns 
{
	// List
	BULLETED_LIST_DECODING_PATTERN			("<bulletList depth=\\\"([\\d])\\\">([^\\p{Space}]*(?:(?!<\\/bulletList>).)*?)</bulletList>"),
	HEBREW_LIST_DECODING_PATTERN			("<hebrewList>([^\\p{Space}]*(?:(?!<\\/hebrewList>).)*?)</hebrewList>"),
	HIRAGANA_IROAH_LIST_DECODING_PATTERN	("<hiraganaIroahList>([^\\p{Space}]*(?:(?!<\\/hiraganaIroahList>).)*?)</hiraganaIroahList>"),
	HIRAGANA_LIST_DECODING_PATTERN			("<hiraganaList>([^\\p{Space}]*(?:(?!<\\/hiraganaList>).)*?)</hiraganaList>"),
	KATAKANA_IROHA_LIST_DECODING_PATTERN	("<katakanaIrohaList>([^\\p{Space}]*(?:(?!<\\/katakanaIrohaList>).)*?)</katakanaIrohaList>"),
	KATAKANA_LIST_DECODING_PATTERN			("<katakanaList>([^\\p{Space}]*(?:(?!<\\/katakanaList>).)*?)</katakanaList>"),
	
	LOWERCASE_ALPHABETICAL_LIST_DECODING_PATTERN	("<alphaLowList>([^\\p{Space}]*(?:(?!<\\/alphaLowList>).)*?)</alphaLowList>"),
	LOWERCASE_GREEK_LIST_DECODING_PATTERN			("<greekLowList>([^\\p{Space}]*(?:(?!<\\/greekLowList>).)*?)</greekLowList>"),
	LOWERCASE_ROMAN_LIST_DECODING_PATTERN			("<romanLowList>([^\\p{Space}]*(?:(?!<\\/romanLowList>).)*?)</romanLowList>"),
	UPPERCASE_ALPHABETICAL_LIST_DECODING_PATTERN	("<alphaUpList>([^\\p{Space}]*(?:(?!<\\/alphaUpList>).)*?)</alphaUpList>"),
	UPPERCASE_GREEK_LIST_DECODING_PATTERN			("<greekUpList>([^\\p{Space}]*(?:(?!<\\/greekUpList>).)*?)</greekUpList>"),
	UPPERCASE_ROMAN_LIST_DECODING_PATTERN			("<romanUpList>([^\\p{Space}]*(?:(?!<\\/romanUpList>).)*?)</romanUpList>"),
	
	MIXED_LIST_DECODING_PATTERN				("<mixedList depth=\\\"([\\d])\\\">([^\\p{Space}]*(?:(?!<\\/mixedList>).)*?)</mixedList>"),
	NUMBERED_LIST_DECODING_PATTERN			("<numberList depth=\\\"([\\d])\\\">([^\\p{Space}]*(?:(?!<\\/numberList>).)*?)</numberList>"),
	SQUARE_LIST_DECODING_PATTERN			("<squareList>([^\\p{Space}]*(?:[^<\\/]*+)*?)</squareList>"),
	
	// Text
	BOLD_DECODING_PATTERN		("<bold>([^\\p{Space}]*(?:(?!<\\/bold>).)*?)</bold>"),
	HEADING_DECODING_PATTERN	("<heading level=\\\"([1-6])\\\">([^\\p{Space}]*(?:(?!<\\/heading>).)*?)</heading>"),
	ITALIC_DECODING_PATTERN		("<italic>([^\\p{Space}]*(?:(?!<\\/italic>).)*?)</italic>"),
	STRIKE_DECODING_PATTERN		("<strike>([^\\p{Space}]*(?:(?!<\\/strike>).)*?)</strike>"),
	UNDERLINE_DECODING_PATTERN	("<underline>([^\\p{Space}]*(?:(?!<\\/underline>).)*?)</underline>"),
	
	// HTML
	HTML_DECODING_PATTERN		("<html>([\\p{Space}\\p{Graph}]*?)</html>"),
	
	// Other
	LINK_DECODING_PATTERN		("<link name=\"([\\p{Graph}\\p{Space}]*?)\" wikiAlias=\"([\\p{Graph}\\p{Space}]*?)\" target=\"([\\p{Graph}\\p{Space}]*?)\">([\\p{Graph}\\p{Space}]*?)<\\/link>"),
	
	// Script
	SCRIPT_DECODING_PATTERN		("<script type=\"([\\p{Graph}\\p{Space}]*?)\">([\\p{Graph}\\p{Space}]*?)<\\/script>"),
	
	// Macro
	MACRO_DECODING_PATTERN		("<macro>([^\\p{Space}]*(?:(?!<\\/macro>).)*?)</macro>"),
	;
	
	
	private String pattern;
	
	private KnownDecodingPatterns(String pattern) 
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
