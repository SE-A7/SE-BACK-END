package test.v09.text;

import static org.junit.Assert.*;

import org.junit.Test;

import transform.app.impl.interpreter.xwiki.v09.text.XWikiUnderlineTextInterpreterV09;



public class UnderlineTextV09Test 
{

	/**
	 *  Test if the interpreter for underline encodes text as expected.
	 */
	@Test
	public void testEncode() 
	{
		XWikiUnderlineTextInterpreterV09 interpreter = new XWikiUnderlineTextInterpreterV09();
		String content = "Not underline, but __this is a underlined text___";
		String encoded = interpreter.encode(content);
		
		assertEquals("Not underline, but <underline>this is a underlined text</underline>", encoded);
	}
	
	/**
	 *  Test if the interpreter for underline decodes as expected
	 */
	@Test
	public void testDecode()
	{
		XWikiUnderlineTextInterpreterV09 interpreter = new XWikiUnderlineTextInterpreterV09();
		String content = "Not underline, but <underline>this is a underlined text</underline>";
		String decoded = interpreter.decode(content);
		
		assertEquals("Not underline, but __this is a underlined text___", decoded);
	}

}