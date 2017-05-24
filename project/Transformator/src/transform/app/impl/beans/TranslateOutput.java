package transform.app.impl.beans;

import javax.xml.bind.annotation.XmlAttribute;

public class TranslateOutput 
{
	String language;
	String version;
	
	
	public String getLanguage() 
	{
		return language;
	}
	
	public String getVersion() 
	{
		return version;
	}
	
	@XmlAttribute(name = "language")
	public void setLanguage(String language) 
	{
		this.language = language;
	}
	
	@XmlAttribute(name = "version")
	public void setVersion(String version) 
	{
		this.version = version;
	}
}
