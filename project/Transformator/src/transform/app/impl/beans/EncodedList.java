package transform.app.impl.beans;

import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "list")
public class EncodedList 
{
	String style;
	List<String> listItems;
	
	
	public String getStyle() 
	{
		return style;
	}
	
	public List<String> getListItems() 
	{
		return listItems;
	}
	
	@XmlAttribute(name = "style")
	public void setStyle(String style) 
	{
		this.style = style;
	}
	
	@XmlElement(name = "listItem")
	public void setListItems(List<String> listItems) 
	{
		this.listItems = listItems;
	}

}
