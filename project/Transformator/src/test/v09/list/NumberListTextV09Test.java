package test.v09.list;

import static org.junit.Assert.*;

import org.junit.Test;

import transform.app.impl.interpreter.xwiki.v09.list.XWikiNumberedListInterpreterV09;

public class NumberListTextV09Test 
{

	/**
	 *  Test if the interpreter for number list depth encodes text as expected.
	 */
	@Test
	public void testEncode() 
	{
		XWikiNumberedListInterpreterV09 interpreter = new XWikiNumberedListInterpreterV09();
		String content = "1. this is a number list depth text";
		String encoded = interpreter.encode(content);
		
		assertEquals("<numberList depth=\"1\">this is a number list depth text</numberList>", encoded);
	}
	
	/**
	 *  Test if the interpreter for number list depth decodes as expected
	 */
	@Test
	public void testDecode()
	{
		XWikiNumberedListInterpreterV09 interpreter = new XWikiNumberedListInterpreterV09();
		String content = "<numberList depth=\"1\">this is a number list depth text</numberList>";
		String decoded = interpreter.decode(content);
		
		assertEquals("1. this is a number list depth text", decoded);
	}

}