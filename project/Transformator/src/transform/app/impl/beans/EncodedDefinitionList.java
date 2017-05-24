package transform.app.impl.beans;

import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "definitionList")
public class EncodedDefinitionList 
{
	String style;
	List<String> definitionTermsList;
	List<String> definitionList;
	
	public String getStyle() {
		return style;
	}
	
	public List<String> getDefinitionTermsList() {
		return definitionTermsList;
	}
	
	public List<String> getDefinitionList() {
		return definitionList;
	}
	
	@XmlAttribute(name = "style")
	public void setStyle(String style) 
	{
		this.style = style;
	}
	
	@XmlElement(name = "definitionTerm")
	public void setDefinitionTermsList(List<String> definitionTermsList) {
		this.definitionTermsList = definitionTermsList;
	}
	
	@XmlElement(name = "definition")
	public void setDefinitionList(List<String> definitionList) {
		this.definitionList = definitionList;
	}

}
