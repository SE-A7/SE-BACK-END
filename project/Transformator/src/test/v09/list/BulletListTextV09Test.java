package test.v09.list;

import static org.junit.Assert.*;

import org.junit.Test;

import transform.app.impl.interpreter.xwiki.v09.list.XWikiBulletListInterpreterV09;

public class BulletListTextV09Test 
{

	/**
	 *  Test if the interpreter for bullet list depth encodes text as expected.
	 */
	@Test
	public void testEncode() 
	{
		XWikiBulletListInterpreterV09 interpreter = new XWikiBulletListInterpreterV09();
		String content = "* This is item 1" + System.lineSeparator() + "* This is item 2*" + System.lineSeparator() + "** this is a bullet list depth text";
		String encoded = interpreter.encode(content);
		
		assertEquals("<bulletList depth=\"1\">This is item 1</bulletList>" + System.lineSeparator() + 
				"<bulletList depth=\"1\">This is item 2*</bulletList>" + System.lineSeparator() +
				"<bulletList depth=\"2\">this is a bullet list depth text</bulletList>", encoded);
	}
	
	/**
	 *  Test if the interpreter for bullet list depth decodes as expected
	 */
	@Test
	public void testDecode()
	{
		XWikiBulletListInterpreterV09 interpreter = new XWikiBulletListInterpreterV09();
		String content = "<bulletList depth=\"1\">This is item 1</bulletList>" + System.lineSeparator() + 
						"<bulletList depth=\"1\">This is item 2*</bulletList>" + System.lineSeparator() +
						"<bulletList depth=\"2\">this is a bullet list depth text</bulletList>";
		String decoded = interpreter.decode(content);
		
		assertEquals("* This is item 1" + System.lineSeparator() + "* This is item 2*" + System.lineSeparator() + "** this is a bullet list depth text", decoded);
	}

}