package transform.app.impl.interpreter.xwiki.v09.list;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.log4j.Logger;

import transform.app.impl.abstr.AbstractInterpreter;
import transform.app.util.JAXBUtils;

public class XWikiDiscListInterpreterV09 extends AbstractInterpreter 
{
	
	private static final String DISC_LIST_INTERPRETER_PATTERN 	= "<ul style=\"list-style-type: disc\">([\\p{Space}]*<li>[\\p{Graph}\\p{Space}]*?<\\/li>[\\p{Space}]*)+<\\/ul>";
	private static final String DISC_LIST_DECODING_PATTERN		= "<list style=\"list-style-type: disc\">([\\p{Space}]*<listItem>[\\p{Graph}\\p{Space}]*?<\\/listItem>[\\p{Space}]*)+<\\/list>";

	private static final Logger log = Logger.getLogger(XWikiDiscListInterpreterV09.class);
	
	@Override
	public String encode(String content) 
	{
		Pattern encodingPattern = Pattern.compile(DISC_LIST_INTERPRETER_PATTERN);
		Matcher encodingMatcher = encodingPattern.matcher(content);
		
		while(encodingMatcher.find())
		{
			try 
			{
				content = content.replace(encodingMatcher.group(0), JAXBUtils.encodeList(content));
			} 
			catch (Exception e) 
			{
				log.error("Error at encoding the list!", e);
			}
			
		}
		
		return content;
	}

	@Override
	public String decode(String content) 
	{
		Pattern decodingPattern = Pattern.compile(DISC_LIST_DECODING_PATTERN);
		Matcher decodingMatcher = decodingPattern.matcher(content);
		
		while(decodingMatcher.find())
		{
			try 
			{
				content = content.replace(decodingMatcher.group(0), JAXBUtils.decodeList(content));
			} 
			catch (Exception e) 
			{
				log.error("Error at decoding the list!", e);
			}
		}
		
		return content;
	}

}
