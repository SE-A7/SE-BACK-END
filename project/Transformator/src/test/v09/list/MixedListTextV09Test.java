package test.v09.list;

import static org.junit.Assert.*;

import org.junit.Test;

import transform.app.impl.interpreter.xwiki.v09.list.XWikiMixedListInterpreterV09;

public class MixedListTextV09Test 
{

	/**
	 *  Test if the interpreter for mixed list depth  encodes text as expected.
	 */
	@Test
	public void testEncode() 
	{
		XWikiMixedListInterpreterV09 interpreter = new XWikiMixedListInterpreterV09();
		String content = "1. this is item 1" + System.lineSeparator() + "1*. this is item 2" + System.lineSeparator() + "1*. this is item 3" + System.lineSeparator() + "1. this is item 4";
		String encoded = interpreter.encode(content);
		
		assertEquals("<mixedList depth=\"1\">this is item 1</mixedList>" + System.lineSeparator() + 
				"<mixedList depth=\"2\">this is item 2</mixedList>" + System.lineSeparator() + 
				"<mixedList depth=\"2\">this is item 3</mixedList>" + System.lineSeparator() + 
				"<mixedList depth=\"1\">this is item 4</mixedList>", encoded);
	}
	
	/**
	 *  Test if the interpreter for mixed list depth  decodes as expected
	 */
	@Test
	public void testDecode()
	{
		XWikiMixedListInterpreterV09 interpreter = new XWikiMixedListInterpreterV09();
		String content = "<mixedList depth=\"1\">this is item 1</mixedList>" + System.lineSeparator() + 
						"<mixedList depth=\"2\">this is item 2</mixedList>" + System.lineSeparator() + 
						"<mixedList depth=\"2\">this is item 3</mixedList>" + System.lineSeparator() + 
						"<mixedList depth=\"1\">this is item 4</mixedList>";
		String decoded = interpreter.decode(content);
		
		assertEquals("1. this is item 1" + System.lineSeparator() + "1*. this is item 2" + System.lineSeparator() + "1*. this is item 3" + System.lineSeparator() + "1. this is item 4", decoded);
	}

}