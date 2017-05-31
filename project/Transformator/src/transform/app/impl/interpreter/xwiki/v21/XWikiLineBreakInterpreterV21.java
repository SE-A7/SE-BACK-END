package transform.app.impl.interpreter.xwiki.v21;

import transform.app.enums.KnownEncodingForm;
import transform.app.impl.abstr.AbstractInterpreter;

public class XWikiLineBreakInterpreterV21 extends AbstractInterpreter
{
	public XWikiLineBreakInterpreterV21() 
	{
		super();
		this.encodingTag = KnownEncodingForm.LINE_BREAK_ENCODING_FORM.getPattern();
		this.decodingTag = System.lineSeparator();
	}
	
	@Override
	public String encode(String content) 
	{
		return content;
	}


	@Override
	public String decode(String content) 
	{
		return content.replaceAll(encodingTag, decodingTag);
	}
}
