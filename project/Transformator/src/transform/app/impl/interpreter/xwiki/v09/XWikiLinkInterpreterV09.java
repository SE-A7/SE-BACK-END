package transform.app.impl.interpreter.xwiki.v09;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import transform.app.enums.KnownDecodingPatterns;
import transform.app.enums.KnownEncodingForm;
import transform.app.impl.abstr.AbstractInterpreter;
import transform.app.impl.interpreter.xwiki.v09.enums.KnownDecodingForm;
import transform.app.impl.interpreter.xwiki.v09.enums.KnownEncodingPatterns;

public class XWikiLinkInterpreterV09 extends AbstractInterpreter 
{
	public XWikiLinkInterpreterV09() 
	{
		super();
		this.encodingTag = KnownEncodingForm.LINK_ENCODING_FORM.getPattern();
		this.decodingTag = KnownDecodingForm.LINK_DECODING_FORM.getPattern();
	}
	
	@Override
	public String encode(String content) 
	{
		Pattern encodingPattern = Pattern.compile(KnownEncodingPatterns.LINK_INTEPRETER_PATTERN.getPattern());
		Matcher encodingMatcher = encodingPattern.matcher(content);
		
		while(encodingMatcher.find())
		{
			String[] linkComponents = encodingMatcher.group(1).split(">");
			
			switch (linkComponents.length) 
			{
				case 1:
					content = content.replace(encodingMatcher.group(0),encodingTag.replace("#NAME#", "").replace("#ALIAS#", "").replace("#TARGET#", "").replace("#TEXT#", linkComponents[0]));
					break;
				case 2:
					if(linkComponents[0].contains(":") || linkComponents[0].contains("."))
					{
						String[] valueAliasList;
						// the first component is the value of the link and the second is the target
						if( linkComponents[0].contains("@") )
						{
							valueAliasList = linkComponents[0].split("@");
							content = content.replace(encodingMatcher.group(0),encodingTag.replace("#NAME#", "").replace("#ALIAS#", valueAliasList[1]).replace("#TARGET#", linkComponents[1]).replace("#TEXT#", valueAliasList[0]));
						}
						else
							content = content.replace(encodingMatcher.group(0),encodingTag.replace("#NAME#", "").replace("#ALIAS#", "").replace("#TARGET#", linkComponents[1]).replace("#TEXT#", linkComponents[0]));
					}
					else 
					{
						String[] valueAliasList;
						// the first component is the name and the second is the value
						if( linkComponents[1].contains("@") )
						{
							valueAliasList = linkComponents[1].split("@");
							content = content.replace(encodingMatcher.group(0), encodingTag.replace("#NAME#", linkComponents[0]).replace("#ALIAS#", valueAliasList[1]).replace("#TARGET#", "").replace("#TEXT#", valueAliasList[0]));
						}
						else
							content = content.replace(encodingMatcher.group(0), encodingTag.replace("#NAME#", linkComponents[0]).replace("#ALIAS#", "").replace("#TARGET#", "").replace("#TEXT#", linkComponents[1]));
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
					System.out.println("Error!");
					break;
			}
		}
		
		return content;

	}

	@Override
	public String decode(String content) 
	{
		Pattern decodingPattern = Pattern.compile(KnownDecodingPatterns.LINK_DECODING_PATTERN.getPattern());
		Matcher decodingMatcher = decodingPattern.matcher(content);
		
		while(decodingMatcher.find())
		{
			content = content.replace(decodingMatcher.group(0), "[" + (decodingMatcher.group(1).equals("") ? "" : decodingMatcher.group(1) + ">") +
					decodingMatcher.group(4) + (decodingMatcher.group(2).equals("") ? "" : "@" + decodingMatcher.group(2)) + 
					(decodingMatcher.group(3).equals("") ? "" : ">" + decodingMatcher.group(3)) + "]");
		}
		
		return content;
	}

}
