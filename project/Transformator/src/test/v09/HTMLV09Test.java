package test.v09;

import static org.junit.Assert.*;
import org.junit.Test;

import transform.app.impl.interpreter.xwiki.v09.XWikiHtmlInterpreterV09;

public class HTMLV09Test 
{
	@Test
	public void testEncode()
	{
		testEncode_SingleTagHTML();
		testEncode_MultiTagHTML();
		testEncode_MixedContent();
	}
	
	

	@Test
	public void testDecode()
	{
		testDecode_SingleTagHTML();
		testDecode_MultiTagHTML();
		testDecode_MixedContent();
	}

	
	// testing methods
	private void testEncode_MixedContent() 
	{
		XWikiHtmlInterpreterV09 interpreter = new XWikiHtmlInterpreterV09();
        String content = "<div style=\"color:red\"><h1 align=\"left\">bold header</h1><p>bold paragraph</p></div>" + 
        				System.lineSeparator() + 
        				"This is a normal paragraph" +
        				System.lineSeparator() +
        				"<p>This is a second paragraph</p>";
        String encoded = interpreter.encode(content);
        assertEquals("<html>"+ System.lineSeparator() + "<div style=\"color:red\"><h1 align=\"left\">bold header</h1><p>bold paragraph</p></div>" + System.lineSeparator() + "</html>"
        			+ System.lineSeparator() + "This is a normal paragraph" + System.lineSeparator() + 
        			"<html>" + System.lineSeparator() + "<p>This is a second paragraph</p>" + System.lineSeparator() + "</html>", encoded);
	}

	private void testEncode_MultiTagHTML() 
	{
		XWikiHtmlInterpreterV09 interpreter = new XWikiHtmlInterpreterV09();
        String content = "<div style=\"color:red\"><h1 align=\"left\">bold header</h1><p>bold paragraph</p></div>";
        String encoded = interpreter.encode(content);
        assertEquals("<html>"+ System.lineSeparator() + "<div style=\"color:red\"><h1 align=\"left\">bold header</h1><p>bold paragraph</p></div>" + System.lineSeparator() + "</html>", encoded);
		
	}

	private void testEncode_SingleTagHTML() 
	{
		XWikiHtmlInterpreterV09 interpreter = new XWikiHtmlInterpreterV09();
        String content = "<br /> <hr />";
        String encoded = interpreter.encode(content);
        assertEquals("<html>"+ System.lineSeparator() + "<br />" + System.lineSeparator() + "</html>" + " " + 
        		"<html>"+ System.lineSeparator() + "<hr />" + System.lineSeparator() + "</html>", encoded);
		
	}
	
	private void testDecode_MixedContent() 
	{
		XWikiHtmlInterpreterV09 interpreter = new XWikiHtmlInterpreterV09();
        String content = "<html>"+ System.lineSeparator() + "<div style=\"color:red\"><h1 align=\"left\">bold header</h1><p>bold paragraph</p></div>" + System.lineSeparator() + "</html>"
    			+ System.lineSeparator() + "This is a normal paragraph" + System.lineSeparator() + 
    			"<html>" + System.lineSeparator() + "<p>This is a second paragraph</p>" + System.lineSeparator() + "</html>";
        String decoded = interpreter.decode(content);
        assertEquals("<div style=\"color:red\"><h1 align=\"left\">bold header</h1><p>bold paragraph</p></div>" + 
				System.lineSeparator() + 
				"This is a normal paragraph" +
				System.lineSeparator() +
				"<p>This is a second paragraph</p>", decoded);
		
	}

	private void testDecode_MultiTagHTML() 
	{
		XWikiHtmlInterpreterV09 interpreter = new XWikiHtmlInterpreterV09();
        String content = "<html>"+ System.lineSeparator() + "<div style=\"color:red\"><h1 align=\"left\">bold header</h1><p>bold paragraph</p></div>" + System.lineSeparator() + "</html>";
        String decoded = interpreter.decode(content);
        assertEquals("<div style=\"color:red\"><h1 align=\"left\">bold header</h1><p>bold paragraph</p></div>", decoded);
		
	}

	private void testDecode_SingleTagHTML() 
	{
		XWikiHtmlInterpreterV09 interpreter = new XWikiHtmlInterpreterV09();
        String content = "<html>"+ System.lineSeparator() + "<br /> <hr />" + System.lineSeparator() + "</html>";
        String decoded = interpreter.decode(content);
        assertEquals("<br /> <hr />", decoded);
		
	}
}
