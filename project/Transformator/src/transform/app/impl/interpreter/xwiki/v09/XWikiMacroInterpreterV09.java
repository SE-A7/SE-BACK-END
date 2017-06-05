package transform.app.impl.interpreter.xwiki.v09;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.log4j.Logger;

import transform.app.enums.KnownDecodingPatterns;
import transform.app.enums.KnownEncodingForm;
import transform.app.impl.abstr.AbstractInterpreter;
import transform.app.impl.interpreter.xwiki.v09.enums.KnownEncodingPatterns;

/**
 * Interpreter for the macro in XWiki 0.9
 * @author Razvan
 *
 */
public class XWikiMacroInterpreterV09 extends AbstractInterpreter 
{
	/**
	 *  The logger for the class {@link XWikiMacroInterpreterV09}
	 */
	private static final Logger log = Logger.getLogger(XWikiMacroInterpreterV09.class);
	
	public XWikiMacroInterpreterV09() 
	{
		super();
		this.encodingTag = KnownEncodingForm.MACRO_ENCODING_FORM.getPattern();
	}
	
	@Override
	public String encode(String content) 
	{
		log.info("Start to encode the macros from XWiki 0.9 ...");
		Pattern encodingVelocityMacroPattern = Pattern.compile(KnownEncodingPatterns.VELOCITY_MACRO_INTERPRETER_PATTERN.getPattern(),Pattern.MULTILINE);
		Matcher encodingVelocityMacroMatcher = encodingVelocityMacroPattern.matcher(content);
		
		Pattern encodingRadeoxMacroPattern	= Pattern.compile(KnownEncodingPatterns.RADEOX_MACRO_INTERPRETER_PATTERN.getPattern());
		Matcher encodingRadeoxMacroMatcher	= encodingRadeoxMacroPattern.matcher(content);
		
		while(encodingVelocityMacroMatcher.find())
		{
			log.info("Velocity macro found. Encoding ...");
			content = content.replace(encodingVelocityMacroMatcher.group(0), encodingTag.replace("#TEXT#", encodingVelocityMacroMatcher.group(0)));
		}
		
		while(encodingRadeoxMacroMatcher.find())
		{
			log.info("Radeox macro found. Encoding ...");
			content = content.replace(encodingRadeoxMacroMatcher.group(0), encodingTag.replace("#TEXT#", encodingRadeoxMacroMatcher.group(0)));
		}
		
		log.info("Encoding the macros finished.");
		return content;
	}

	@Override
	public String decode(String content) 
	{
		log.info("Start to decode the macros into XWiki 0.9 syntax ...");
		// All found macros are commented
		Pattern decodingMacroPattern = Pattern.compile(KnownDecodingPatterns.MACRO_DECODING_PATTERN.getPattern());
		Matcher decodingMacroMatcher = decodingMacroPattern.matcher(content);
		
		while(decodingMacroMatcher.find())
		{
			log.info("Macro found. Decoding ...");
			content = content.replace(decodingMacroMatcher.group(0), decodingMacroMatcher.group(1).trim());
			String[] macroLines = decodingMacroMatcher.group(1).trim().split(System.lineSeparator());
			for (String line : macroLines) 
			{
				content = content.replace(line, "##" + line);
			}
		}
		
		log.info("Decoding the macros finished.");
		return content;
	}

}
