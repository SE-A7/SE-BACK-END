package transform.app.impl.interpreter.xwiki.v09.enums;

public enum KnownEncodingPatterns 
{
	// Lists
	BULLETED_LIST_PATTERN		("^(\\*+)([\\p{Graph}\\p{Space}]*?)$"),
	HEBREW_LIST_PATTERN			("^j.([\\p{Graph}\\p{Space}]*?)$"),
	HIRAGANA_IROAH_LIST_PATTERN	("^H.([\\p{Graph}\\p{Space}]*?)$"),
	HIRAGANA_LIST_PATTERN		("^h.([\\p{Graph}\\p{Space}]*?)$"),
	KATAKANA_IROHA_LIST_PATTERN	("^K.([\\p{Graph}\\p{Space}]*?)$"),
	KATAKANA_LIST_PATTERN		("^k.([\\p{Graph}\\p{Space}]*?)$"),
	
	LOWERCASE_ALPHABETICAL_LIST_INTERPRETER_PATTERN	("^a.([\\p{Graph}\\p{Space}]*?)$"),
	LOWERCASE_GREEK_LIST_INTERPRETER_PATTERN		("^g.([\\p{Graph}\\p{Space}]*?)$"),
	LOWERCASE_ROMAN_LIST_INTERPRETER_PATTERN		("^i.([\\p{Graph}\\p{Space}]*?)$"),
	MIXED_LIST_PATTERN								("^1(\\*?)\\.([\\p{Graph}\\p{Space}]*?)$"),
	NUMBERED_LIST_PATTERN							("^(1+\\.)([\\p{Graph}\\p{Space}]*?)$"),
	SQUARE_LIST_PATTERN								("^-([\\p{Graph}\\p{Space}]*?)$"),
	UPPERCASE_ALPHABETICAL_LIST_INTERPRETER_PATTERN	("^A.([\\p{Graph}\\p{Space}]*?)$"),
	UPPERCASE_GREEK_LIST_INTERPRETER_PATTERN		("^G.([\\p{Graph}\\p{Space}]*?)$"),
	UPPERCASE_ROMAN_LIST_INTERPRETER_PATTERN		("^I.([\\p{Graph}\\p{Space}]*?)$"),
	
	
	// Text
	BOLD_TEXT_PATTERN		("(?<!\\*)\\*([^\\p{Space}\\*](?:[^*]*+)*?)\\*(?!\\*)"),
	HEADING_LEVEL_PATTERN	("^(1(?:\\.)*)+"),
	HEADING_TEXT_PATTERN	("^(1(?:\\.)*)+([\\p{Graph}\\p{Space}]*?)$"),
	ITALIC_TEXT_PATTERN		("(?<!~)~{2}([\\p{Space}\\p{Graph}]*?)~{2}(?!~+)"),
	STRIKE_TEXT_PATTERN		("(?<!-)-{2}([\\p{Space}\\p{Graph}]*?)-{2}(?!-+)"),
	UNDERLINE_TEXT_PATTERN	("(?<!_)_{2}([\\p{Space}\\p{Graph}]*?)_{3}(?!_+)"),
	
	// Others
	HORIZONTAL_LINE_TEXT_PATTERN		("([-]){4,}"),
	LINE_BREAK_PATTERN					("\\\\\\\\$"),
	LINK_INTEPRETER_PATTERN				("\\[(.+?)\\]"),
	
	// HTML
	HTML_MULTILINE_INTERPRETER_PATTERN	("<([\\p{Alnum}]*)[^>]*>(?:[\\p{Graph}\\p{Space}]*?)<\\/\\1>"),
	HTML_SINGLELINE_INTERPRETER_PATTERN	("<([\\p{Alnum}]*)[^>]*\\/>"),
	
	// Macros
	VELOCITY_MACRO_INTERPRETER_PATTERN	("^#([\\p{Alnum}]*)\\((.*?)\\)$"),
	RADEOX_MACRO_INTERPRETER_PATTERN	("\\{([\\p{Alnum}]*):?([\\p{Alnum}]*(=[\\p{Alnum}]*)?(\\|[\\p{Alnum}]*=[\\p{Alnum}]*)*)?\\}([\\p{Graph}\\p{Space}]*)\\{\\1\\}"),
	
	// Scripts
	VELOCITY_SCRIPT_INTERPRETER_PATTERN	("^#([\\p{Alnum}]*) \\((.*?)\\)$"),
	GROOVY_SCRIPT_INTERPRETER_PATTERN	("<%([^%]*)%>")
	;
	
	
	private String pattern;
	
	private KnownEncodingPatterns(String pattern) 
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
