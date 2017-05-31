package transform.app.impl.interpreter.xwiki.v21;

import transform.app.enums.KnownEncodingForm;
import transform.app.impl.abstr.AbstractInterpreter;
import transform.app.impl.interpreter.xwiki.v21.enums.KnownDecodingForm;

public class XWikiHorizontalLineInterpreterV21 extends AbstractInterpreter 
{
	public XWikiHorizontalLineInterpreterV21() 
	{
		super();
		this.encodingTag = KnownEncodingForm.HORIZONTAL_LINE_ENCODING_FORM.getPattern();
		this.decodingTag = KnownDecodingForm.HORIZONTAL_LINE_DECODING_FORM.getPattern();
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
