package test.v21.text;

import static org.junit.Assert.*;

import org.junit.Test;

import transform.app.impl.interpreter.xwiki.v21.text.XWikiStrikeTextInterpreterV21;

public class StrikeTextV21Test 
{

	/**
	 *  Test if the interpreter for strike out encodes text as expected.
	 */
	@Test
	public void testEncode() 
	{
		XWikiStrikeTextInterpreterV21 interpreter = new XWikiStrikeTextInterpreterV21();
		String content = "--striked text--";
		String encoded = interpreter.encode(content);
		
		assertEquals("<strike>striked text</strike>", encoded);
	}
	
	/**
	 *  Test if the interpreter for strike out decodes as expected
	 */
	@Test
	public void testDecode()
	{
		XWikiStrikeTextInterpreterV21 interpreter = new XWikiStrikeTextInterpreterV21();
		String content = "<strike>striked text</strike>";
		String decoded = interpreter.decode(content);
		
		assertEquals("--striked text--", decoded);
	}

}
