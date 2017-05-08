package transform.app.impl.abstr;

import transform.app.interfaces.Interpreter;


public abstract class AbstractInterpreter implements Interpreter 
{
	protected String encodingTag;
	protected String decodingTag;
	
	
	@Override
	public String encode(String text) 
	{
		return encodingTag.replace("#TEXT#", text);
	}
	
	
	@Override
	public String decode(String text) 
	{
		return decodingTag.replace("#TEXT#", text);
	}

}