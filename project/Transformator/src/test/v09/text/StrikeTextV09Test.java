package test.v09.text;

import static org.junit.Assert.*;

import org.junit.Test;

import transform.app.impl.interpreter.xwiki.v09.text.XWikiStrikeTextInterpreterV09;

public class StrikeTextV09Test 
{

	/**
	 *  Test if the interpreter for strike encodes text as expected.
	 */
	@Test
	public void testEncode() 
	{
		XWikiStrikeTextInterpreterV09 interpreter = new XWikiStrikeTextInterpreterV09();
		String content = "Not strike, but --this is a strike text--";
		String encoded = interpreter.encode(content);
		
		assertEquals("Not strike, but <strike>this is a strike text</strike>", encoded);
	}
	
	/**
	 *  Test if the interpreter for strike decodes as expected
	 */
	@Test
	public void testDecode()
	{
		XWikiStrikeTextInterpreterV09 interpreter = new XWikiStrikeTextInterpreterV09();
		String content = "Not strike, but <strike>this is a strike text</strike>";
		String decoded = interpreter.decode(content);
		
		assertEquals("Not strike, but --this is a strike text--", decoded);
	}

}