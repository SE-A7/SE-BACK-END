package transform.app.impl.beans;

import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "ul")
public class RawHtmlList 
{
	String style;
	List<String> listItems;
	
	
	public String getStyle() 
	{
		return style;
	}
	
	public List<String> getItems() 
	{
		return listItems;
	}
	
	@XmlAttribute(name = "style")
	public void setStyle(String style) 
	{
		this.style = style;
	}
	
	@XmlElement(name = "li")
	public void setItems(List<String> items) 
	{
		this.listItems = items;
	}
}
