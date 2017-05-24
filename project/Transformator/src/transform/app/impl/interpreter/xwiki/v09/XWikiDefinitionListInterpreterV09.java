package transform.app.impl.interpreter.xwiki.v09;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.log4j.Logger;

import transform.app.impl.abstr.AbstractInterpreter;
import transform.app.impl.interpreter.xwiki.v09.list.XWikiDiscListInterpreterV09;
import transform.app.util.JAXBUtils;

public class XWikiDefinitionListInterpreterV09 extends AbstractInterpreter 
{
	private static final String DEFINITION_LIST_INTERPRETER_PATTERN = "<dl( style=\"[\\p{Graph}\\p{Space}]*?\")?>[\\p{Graph}\\p{Space}]*?<\\/dl>";
	private static final String DEFINITION_LIST_DECODING_PATTERN	= "<definitionList( style=\"[\\p{Graph}\\p{Space}]*?\")?>[\\p{Graph}\\p{Space}]*?<\\/definitionList>";
	
	private static final Logger log = Logger.getLogger(XWikiDiscListInterpreterV09.class);
	
	
	@Override
	public String encode(String content) 
	{
		Pattern encodingPattern = Pattern.compile(DEFINITION_LIST_INTERPRETER_PATTERN);
		Matcher encodingMatcher = encodingPattern.matcher(content);
		
		while(encodingMatcher.find())
		{
			try 
			{
				content = content.replace(encodingMatcher.group(0), JAXBUtils.encodeDefinitionList(content));
			} 
			catch (Exception e) 
			{
				log.error("Error at encoding the list!", e);
				return null;
			}
			
		}
		return content;
	}

	@Override
	public String decode(String content) 
	{
		Pattern decodingPattern = Pattern.compile(DEFINITION_LIST_DECODING_PATTERN);
		Matcher decodingMatcher = decodingPattern.matcher(content);
		
		while(decodingMatcher.find())
		{
			try 
			{
				content = content.replace(decodingMatcher.group(0), JAXBUtils.decodeDefinitionList(content));
			} 
			catch (Exception e) 
			{
				log.error("Error at decoding the list!", e);
				return null;
			}
		}
		return content;

	}

}
