package transform.app.impl.interpreter.xwiki.v09;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.log4j.Logger;

import transform.app.enums.KnownDecodingPatterns;
import transform.app.enums.KnownEncodingForm;
import transform.app.impl.abstr.AbstractInterpreter;
import transform.app.impl.interpreter.xwiki.v09.enums.KnownDecodingForm;
import transform.app.impl.interpreter.xwiki.v09.enums.KnownEncodingPatterns;

/**
 * Interpreter for the link in XWiki 0.9
 * @author Razvan
 *
 */
public class XWikiLinkInterpreterV09 extends AbstractInterpreter 
{
	/**
	 *  The logger for the class {@link XWikiLinkInterpreterV09}
	 */
	private static final Logger log = Logger.getLogger(XWikiLinkInterpreterV09.class);
	
	public XWikiLinkInterpreterV09() 
	{
		super();
		this.encodingTag = KnownEncodingForm.LINK_ENCODING_FORM.getPattern();
		this.decodingTag = KnownDecodingForm.LINK_DECODING_FORM.getPattern();
	}
	
	@Override
	public String encode(String content) 
	{
		log.info("Start to encode the links from XWiki 0.9 ...");
		Pattern encodingPattern = Pattern.compile(KnownEncodingPatterns.LINK_INTEPRETER_PATTERN.getPattern());
		Matcher encodingMatcher = encodingPattern.matcher(content);
		
		while(encodingMatcher.find())
		{
			log.info("Link found. Encoding ...");
			String[] linkComponents = encodingMatcher.group(1).split(">");
			
			switch (linkComponents.length) 
			{
				case 1:
					content = content.replace(encodingMatcher.group(0),encodingTag.replace("#NAME#", "").replace("#ALIAS#", "").replace("#TARGET#", "").replace("#TEXT#", linkComponents[0]));
					break;
				case 2:
					if(linkComponents[1].contains(":") || linkComponents[1].contains("."))
					{
						// the first component is the name and the second is the value
						String[] valueAliasList;
						if( linkComponents[1].contains("@") )
						{
							valueAliasList = linkComponents[1].split("@");
							content = content.replace(encodingMatcher.group(0), encodingTag.replace("#NAME#", linkComponents[0]).replace("#ALIAS#", valueAliasList[1]).replace("#TARGET#", "").replace("#TEXT#", valueAliasList[0]));
						}
						else
							content = content.replace(encodingMatcher.group(0), encodingTag.replace("#NAME#", linkComponents[0]).replace("#ALIAS#", "").replace("#TARGET#", "").replace("#TEXT#", linkComponents[1]));
					}
					else 
					{
						// the first component is the value of the link and the second is the target
						String[] valueAliasList;
						if( linkComponents[0].contains("@") )
						{
							valueAliasList = linkComponents[0].split("@");
							content = content.replace(encodingMatcher.group(0),encodingTag.replace("#NAME#", "").replace("#ALIAS#", valueAliasList[1]).replace("#TARGET#", linkComponents[1]).replace("#TEXT#", valueAliasList[0]));
						}
						else
							content = content.replace(encodingMatcher.group(0),encodingTag.replace("#NAME#", "").replace("#ALIAS#", "").replace("#TARGET#", linkComponents[1]).replace("#TEXT#", linkComponents[0]));
					}
					break;
					
				case 3:
					if(linkComponents[1].contains("@"))
					{
						String[] valueAliasList;
						valueAliasList = linkComponents[0].split("@");
						content = content.replace(encodingMatcher.group(0),encodingTag.replace("#NAME#", linkComponents[0]).replace("#ALIAS#", valueAliasList[1]).replace("#TARGET#", linkComponents[2]).replace("#TEXT#", valueAliasList[0]));
					}
					else
						content = content.replace(encodingMatcher.group(0),encodingTag.replace("#NAME#", linkComponents[0]).replace("#ALIAS#", "").replace("#TARGET#", linkComponents[2]).replace("#TEXT#", linkComponents[1]));
					
					break;

				default:
					log.warn("No valid XWiki 0.9 link. Skipping the encoding for " + encodingMatcher.group(1));
					break;
			}
		}
		
		log.info("Encoding the links finished.");
		return content;

	}

	@Override
	public String decode(String content) 
	{
		log.info("Start to decode the links into XWiki 0.9 syntax ...");
		Pattern decodingPattern = Pattern.compile(KnownDecodingPatterns.LINK_DECODING_PATTERN.getPattern());
		Matcher decodingMatcher = decodingPattern.matcher(content);
		
		while(decodingMatcher.find())
		{
			log.info("Link found. Decoding ...");
			content = content.replace(decodingMatcher.group(0), "[" + (decodingMatcher.group(1).equals("") ? "" : decodingMatcher.group(1) + ">") +
					decodingMatcher.group(4) + (decodingMatcher.group(2).equals("") ? "" : "@" + decodingMatcher.group(2)) + 
					(decodingMatcher.group(3).equals("") ? "" : ">" + decodingMatcher.group(3)) + "]");
		}
		
		log.info("Decoding the links finished.");
		return content;
	}

}
