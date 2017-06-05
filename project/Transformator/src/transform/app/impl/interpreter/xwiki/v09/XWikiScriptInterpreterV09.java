package transform.app.impl.interpreter.xwiki.v09;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.log4j.Logger;

import transform.app.enums.KnownDecodingPatterns;
import transform.app.enums.KnownEncodingForm;
import transform.app.impl.abstr.AbstractInterpreter;
import transform.app.impl.interpreter.xwiki.v09.enums.KnownEncodingPatterns;

/**
 * Interpreter for the script in XWiki 0.9
 * @author Razvan
 *
 */
public class XWikiScriptInterpreterV09 extends AbstractInterpreter 
{
	/**
	 *  The logger for the class {@link XWikiScriptInterpreterV09}
	 */
	private static final Logger log = Logger.getLogger(XWikiScriptInterpreterV09.class);
	
	public XWikiScriptInterpreterV09() 
	{
		super();
		this.encodingTag = KnownEncodingForm.SCRIPT_ENCODING_FORM.getPattern();
	}
	
	
	@Override
	public String encode(String content) 
	{
		log.info("Start to encode the scripts from XWiki 0.9 ...");
		Pattern encodingVelocityScriptPattern = Pattern.compile(KnownEncodingPatterns.VELOCITY_SCRIPT_INTERPRETER_PATTERN.getPattern());
		Matcher encodingVelocityScriptMatcher = encodingVelocityScriptPattern.matcher(content);
		
		Pattern encodingGroovyScriptPattern = Pattern.compile(KnownEncodingPatterns.GROOVY_SCRIPT_INTERPRETER_PATTERN.getPattern());
		Matcher encodingGroovyScriptMatcher = encodingGroovyScriptPattern.matcher(content);
		
		while(encodingVelocityScriptMatcher.find())
		{
			log.info("Velocity script found. Encoding ...");
			content = content.replace(encodingVelocityScriptMatcher.group(0), encodingTag.replace("#TYPE#", "velocity").replace("#TEXT#", encodingVelocityScriptMatcher.group(0).trim()));
		}
		
		while(encodingGroovyScriptMatcher.find())
		{
			log.info("Groovy script found. Encoding ...");
			content = content.replace(encodingGroovyScriptMatcher.group(0), encodingTag.replace("#TYPE#", "groovy").replace("#TEXT#", encodingGroovyScriptMatcher.group(1).trim()));
		}
		
		log.info("Encoding the scripts finished.");
		return content;

	}

	@Override
	public String decode(String content) 
	{
		log.info("Start to decode the scripts into XWiki 0.9 syntax ...");
		Pattern decodingScriptPattern = Pattern.compile(KnownDecodingPatterns.SCRIPT_DECODING_PATTERN.getPattern());
		Matcher decodingScriptMatcher = decodingScriptPattern.matcher(content);
		
		while(decodingScriptMatcher.find())
		{
			log.info("Script found. Decoding ...");
			switch(decodingScriptMatcher.group(1))
			{
				case "velocity":
					content = content.replace(decodingScriptMatcher.group(0), decodingScriptMatcher.group(2).trim());
					break;
				case "groovy":
					content = content.replace(decodingScriptMatcher.group(0), "<%" + System.lineSeparator() + decodingScriptMatcher.group(2).trim() + System.lineSeparator() + "%>");
					break;
				default:
					log.error("The type of script is not recognized!");
					break;
			}
		}
		
		log.info("Decoding the scripts finished.");
		return content;
	}

}
