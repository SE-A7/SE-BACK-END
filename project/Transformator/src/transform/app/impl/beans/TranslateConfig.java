package transform.app.impl.beans;

import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "translate")
public class TranslateConfig 
{
	TranslateInput inputLanguage;
	TranslateOutput outputLanguage;
	String code;
	
	
	public TranslateInput getInputLanguage() 
	{
		return inputLanguage;
	}
	
	
	public TranslateOutput getOutputLanguage() 
	{
		return outputLanguage;
	}
	
	public String getCode() 
	{
		return code;
	}

	@XmlElement(name = "input")
	public void setInputLanguage(TranslateInput inputLanguage) 
	{
		this.inputLanguage = inputLanguage;
	}
	
	@XmlElement(name = "output")
	public void setOutputLanguage(TranslateOutput outputLanguage) 
	{
		this.outputLanguage = outputLanguage;
	}
	
	@XmlAnyElement(CodeHandler.class)
	public void setCode(String code) 
	{
		this.code = code;
	}
}
