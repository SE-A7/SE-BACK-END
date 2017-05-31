package transform.app.impl.interpreter.xwiki.v21.enums;

/**
 * This enumeration contains all the specific regular expressions which matches XWiki 2.1 syntax
 * @author Razvan
 *
 */
public enum KnownEncodingPatterns 
{
	// Text
	BOLD_TEXT_INTERPRETER_PATTERN		("(?<!\\*)(\\*{2})([\\p{Graph}\\p{Space}]*?)\\1(?!\\*+)"),
	ITALIC_TEXT_INTERPRETER_PATTERN		("(?<!\\/)(\\/{2})([\\p{Space}\\p{Graph}]*?)\\1(?!\\/+)"),
	STRIKE_TEXT_INTERPRETER_PATTERN		("(?<!-)-{2}([\\p{Space}\\p{Graph}]*?)-{2}(?!-+)"),
	UNDERLINE_TEXT_INTERPRETER_PATTERN	("(?<!_)_{2}([\\p{Space}\\p{Graph}]*?)_{2}(?!_+)"),
	HEADING_INTERPRETER_PATTERN			("^(=*)([\\p{Space}\\p{Graph}]*?)\\1"),
	
	// List
	BULLETED_LIST_PATTERN		("^(\\*+)([\\p{Graph}\\p{Space}]*?)$"),
	MIXED_LIST_PATTERN			("^1(\\*?)\\.([\\p{Graph}\\p{Space}]*?)$"),
	NUMBERED_LIST_PATTERN		("^(1+\\.)([\\p{Graph}\\p{Space}]*?)$"),
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
