package test.v09.text;

import static org.junit.Assert.*;

import org.junit.Test;

import transform.app.impl.interpreter.xwiki.v09.text.XWikiItalicTextInterpreterV09;

public class ItalicTextV09Test 
{

	/**
	 *  Test if the interpreter for italic encodes text as expected.
	 */
	@Test
	public void testEncode() 
	{
		XWikiItalicTextInterpreterV09 interpreter = new XWikiItalicTextInterpreterV09();
		String content = "Not italic, but ~~this is a italic text~~";
		String encoded = interpreter.encode(content);
		
		assertEquals("Not italic, but <italic>this is a italic text</italic>", encoded);
	}
	
	/**
	 *  Test if the interpreter for italic decodes as expected
	 */
	@Test
	public void testDecode()
	{
		XWikiItalicTextInterpreterV09 interpreter = new XWikiItalicTextInterpreterV09();
		String content = "Not italic, but <italic>this is a italic text</italic>";
		String decoded = interpreter.decode(content);
		
		assertEquals("Not italic, but ~~this is a italic text~~", decoded);
	}

}