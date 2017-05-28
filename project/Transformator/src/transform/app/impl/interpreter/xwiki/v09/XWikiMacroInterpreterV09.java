package transform.app.impl.interpreter.xwiki.v09;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import transform.app.enums.KnownDecodingPatterns;
import transform.app.enums.KnownEncodingForm;
import transform.app.impl.abstr.AbstractInterpreter;
import transform.app.impl.interpreter.xwiki.v09.enums.KnownEncodingPatterns;

public class XWikiMacroInterpreterV09 extends AbstractInterpreter 
{
	public XWikiMacroInterpreterV09() 
	{
		super();
		this.encodingTag = KnownEncodingForm.MACRO_ENCODING_FORM.getPattern();
	}
	
	@Override
	public String encode(String content) 
	{
		Pattern encodingVelocityMacroPattern = Pattern.compile(KnownEncodingPatterns.VELOCITY_MACRO_INTERPRETER_PATTERN.getPattern(),Pattern.MULTILINE);
		Matcher encodingVelocityMacroMatcher = encodingVelocityMacroPattern.matcher(content);
		
		Pattern encodingRadeoxMacroPattern	= Pattern.compile(KnownEncodingPatterns.RADEOX_MACRO_INTERPRETER_PATTERN.getPattern());
		Matcher encodingRadeoxMacroMatcher	= encodingRadeoxMacroPattern.matcher(content);
		
		while(encodingVelocityMacroMatcher.find())
		{
			content = content.replace(encodingVelocityMacroMatcher.group(0), encodingTag.replace("#TEXT#", encodingVelocityMacroMatcher.group(0)));
		}
		
		while(encodingRadeoxMacroMatcher.find())
		{
			content = content.replace(encodingRadeoxMacroMatcher.group(0), encodingTag.replace("#TEXT#", encodingRadeoxMacroMatcher.group(0)));
		}
		
		return content;
	}

	@Override
	public String decode(String content) 
	{
		// Every found macro is commented
		Pattern decodingMacroPattern = Pattern.compile(KnownDecodingPatterns.MACRO_DECODING_PATTERN.getPattern());
		Matcher decodingMacroMatcher = decodingMacroPattern.matcher(content);
		
		while(decodingMacroMatcher.find())
		{
			String[] macroLines = decodingMacroMatcher.group(1).trim().split(System.lineSeparator());
			for (String line : macroLines) 
			{
				content = content.replace(line, "##" + line);
			}
		}
		
		return content;
	}

}
