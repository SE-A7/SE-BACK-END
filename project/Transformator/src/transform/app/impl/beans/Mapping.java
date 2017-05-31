package transform.app.impl.beans;

import javax.xml.bind.annotation.XmlElement;

public class Mapping 
{
	private String encoding;
	private String interpreterClass;
	private String priority;
	
	
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
	
	public String getPriority()
	{
		return priority;
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
	
	@XmlElement(name="priority")
	public void setPriority(String priority)
	{
		this.priority = priority;
	}
}
