package transform.app.impl.beans;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="Mappings")
public class Mappings 
{
	private List<Mapping> mappings;
	
	
	/*
	 *  GETTER and SETTER
	 */
	public List<Mapping> getMappings() {
		return mappings;
	}

	@XmlElement(name="Mapping")
	public void setMappings(List<Mapping> mappings) 
	{
		this.mappings = mappings;
	}
}
