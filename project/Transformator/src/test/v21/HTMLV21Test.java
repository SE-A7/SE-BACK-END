package test.v21;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import transform.app.impl.interpreter.xwiki.v21.XWikiHtmlInterpreterV21;

public class HTMLV21Test 
{
	@Test
	public void testDecode()
	{
		testDecode_SingleTagHTML();
		testDecode_MultiTagHTML();
		testDecode_MixedContent();
	}
	
	private void testDecode_MixedContent() 
	{
		XWikiHtmlInterpreterV21 interpreter = new XWikiHtmlInterpreterV21();
        String content = "<html>"+ System.lineSeparator() + "<div style=\"color:red\"><h1 align=\"left\">bold header</h1><p>bold paragraph</p></div>" + System.lineSeparator() + "</html>"
    			+ System.lineSeparator() + "This is a normal paragraph" + System.lineSeparator() + 
    			"<html>" + System.lineSeparator() + "<p>This is a second paragraph</p>" + System.lineSeparator() + "</html>";
        String decoded = interpreter.decode(content);
        assertEquals("{{html}}"+ System.lineSeparator() + "<div style=\"color:red\"><h1 align=\"left\">bold header</h1><p>bold paragraph</p></div>" + System.lineSeparator() + "{{/html}}"
    			+ System.lineSeparator() + "This is a normal paragraph" + System.lineSeparator() + 
    			"{{html}}" + System.lineSeparator() + "<p>This is a second paragraph</p>" + System.lineSeparator() + "{{/html}}", decoded);
		
	}

	private void testDecode_MultiTagHTML() 
	{
		XWikiHtmlInterpreterV21 interpreter = new XWikiHtmlInterpreterV21();
        String content = "<html>"+ System.lineSeparator() + "<div style=\"color:red\"><h1 align=\"left\">bold header</h1><p>bold paragraph</p></div>" + System.lineSeparator() + "</html>";
        String decoded = interpreter.decode(content);
        assertEquals("{{html}}"+ System.lineSeparator() + "<div style=\"color:red\"><h1 align=\"left\">bold header</h1><p>bold paragraph</p></div>" + System.lineSeparator() + "{{/html}}", decoded);
		
	}

	private void testDecode_SingleTagHTML() 
	{
		XWikiHtmlInterpreterV21 interpreter = new XWikiHtmlInterpreterV21();
        String content = "<html>"+ System.lineSeparator() + "<br/> <hr />" + System.lineSeparator() + "</html>";
        String decoded = interpreter.decode(content);
        assertEquals("{{html}}"+ System.lineSeparator() + "<br/> <hr />" + System.lineSeparator() + "{{/html}}", decoded);
		
	}

}
