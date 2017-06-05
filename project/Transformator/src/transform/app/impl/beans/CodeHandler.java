package transform.app.impl.beans;

import java.io.StringReader;
import java.io.StringWriter;

import javax.xml.bind.ValidationEventHandler;
import javax.xml.bind.annotation.DomHandler;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import transform.app.util.XMLUtils;

public class CodeHandler implements DomHandler<String, StreamResult>
{
	private static final String BIO_START_TAG = "<code>";
	private static final String BIO_END_TAG = "</code>";
	 
    private StringWriter xmlWriter = new StringWriter();
    
    
	@Override
	public StreamResult createUnmarshaller(ValidationEventHandler errorHandler) 
	{
		return new StreamResult(xmlWriter);
	}

	@Override
	public String getElement(StreamResult rt) 
	{
		String xml = rt.getWriter().toString();
        int beginIndex = xml.indexOf(BIO_START_TAG) + BIO_START_TAG.length();
        int endIndex = xml.indexOf(BIO_END_TAG);
        return XMLUtils.handleEscapeChars(xml.substring(beginIndex, endIndex));
	}

	@Override
	public Source marshal(String n, ValidationEventHandler errorHandler) 
	{
		try 
		{
            String xml = BIO_START_TAG + n.trim() + BIO_END_TAG;
            StringReader xmlReader = new StringReader(xml);
            
            return new StreamSource(xmlReader);
        } 
		catch(Exception e) 
		{
            throw new RuntimeException(e);
        }
	}

}
