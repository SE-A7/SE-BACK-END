package transform.app.impl.beans;

import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "dl")
public class RawHTMLDefinitionList 
{
	String style;
	List<String> termList;
	List<String> defintionList;
	
	public String getStyle() 
	{
		return style;
	}
	
	public List<String> getTermList() 
	{
		return termList;
	}
	
	public List<String> getDefintionList() 
	{
		return defintionList;
	}
	
	@XmlAttribute(name = "style")
	public void setStyle(String style) 
	{
		this.style = style;
	}
	
	@XmlElement(name = "dt")
	public void setTermList(List<String> termList) 
	{
		this.termList = termList;
	}
	
	@XmlElement(name = "dd")
	public void setDefintionList(List<String> defintionList) 
	{
		this.defintionList = defintionList;
	}
}
