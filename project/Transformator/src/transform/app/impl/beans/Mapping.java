package transform.app.impl.beans;

import javax.xml.bind.annotation.XmlElement;

public class Mapping 
{
	private String encoding;
	private String interpreterClass;
	
	
	
	/*
	 *  GETTERS and SETTERS
	 */
	public String getEncoding() 
	{
		return encoding;
	}
	
	public String getInterpreterClass() 
	{
		return interpreterClass;
	}
	
	@XmlElement(name="Encoding")
	public void setEncoding(String encoding) 
	{
		this.encoding = encoding;
	}
	
	@XmlElement(name="Interpreter")
	public void setInterpreterClass(String interpreterClass) 
	{
		this.interpreterClass = interpreterClass;
	}	
}
