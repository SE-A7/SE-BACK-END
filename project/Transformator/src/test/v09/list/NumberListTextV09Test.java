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
		String content = "1. this is item 1" + System.lineSeparator() + "11. this is item 2" + System.lineSeparator() + "1. this is item 3" + System.lineSeparator() + "111. this is item 4";
		String encoded = interpreter.encode(content);
		
		assertEquals("<numberList depth=\"1\">this is item 1</numberList>" + System.lineSeparator() + 
				"<numberList depth=\"2\">this is item 2</numberList>" + System.lineSeparator() + 
				"<numberList depth=\"1\">this is item 3</numberList>" + System.lineSeparator() + 
				"<numberList depth=\"3\">this is item 4</numberList>", encoded);
	}
	
	/**
	 *  Test if the interpreter for number list depth decodes as expected
	 */
	@Test
	public void testDecode()
	{
		XWikiNumberedListInterpreterV09 interpreter = new XWikiNumberedListInterpreterV09();
		String content = "<numberList depth=\"1\">this is item 1</numberList>" + System.lineSeparator() + 
						"<numberList depth=\"2\">this is item 2</numberList>" + System.lineSeparator() + 
						"<numberList depth=\"1\">this is item 3</numberList>" + System.lineSeparator() + 
						"<numberList depth=\"3\">this is item 4</numberList>";
		String decoded = interpreter.decode(content);
		
		assertEquals("1. this is item 1" + System.lineSeparator() + "11. this is item 2" + System.lineSeparator() + "1. this is item 3" + System.lineSeparator() + "111. this is item 4", decoded);
	}

}