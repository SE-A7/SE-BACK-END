package test.v21.list;

import static org.junit.Assert.assertEquals;

import org.junit.Test;


import transform.app.impl.interpreter.xwiki.v21.list.XWikiMixedListInterpreterV21;

public class MixedListV21Test 
{
	/**
	 *  Test if the interpreter for mixed list depth  encodes text as expected.
	 */
	@Test
	public void testEncode() 
	{
		XWikiMixedListInterpreterV21 interpreter = new XWikiMixedListInterpreterV21();
		String content = "1. this is a mixed list depth text";
		String encoded = interpreter.encode(content);
		
		assertEquals("<mixedList depth=\"1\">this is a mixed list depth text</mixedList> ", encoded);
	}
	
	/**
	 *  Test if the interpreter for mixed list depth  decodes as expected
	 */
	@Test
	public void testDecode()
	{
		XWikiMixedListInterpreterV21 interpreter = new XWikiMixedListInterpreterV21();
		String content = "<mixedList depth=\"1\">this is a mixed list depth text</mixedList> ";
		String decoded = interpreter.decode(content);
		
		assertEquals("1. this is a mixed list depth text", decoded);
	}

}
