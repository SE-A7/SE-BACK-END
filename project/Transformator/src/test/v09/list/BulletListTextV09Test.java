package test.v09.list;

import static org.junit.Assert.*;

import org.junit.Test;

import transform.app.impl.interpreter.xwiki.v09.list.XWikiBulletedListInterpreterV09;

public class BulletListTextV09Test 
{

	/**
	 *  Test if the interpreter for bullet list depth encodes text as expected.
	 */
	@Test
	public void testEncode() 
	{
		XWikiBulletedListInterpreterV09 interpreter = new XWikiBulletedListInterpreterV09();
		String content = "** this is a bullet list depth text";
		String encoded = interpreter.encode(content);
		
		assertEquals("<bulletList depth=\"2\">this is a bullet list depth text</bulletList>", encoded);
	}
	
	/**
	 *  Test if the interpreter for bullet list depth decodes as expected
	 */
	@Test
	public void testDecode()
	{
		XWikiBulletedListInterpreterV09 interpreter = new XWikiBulletedListInterpreterV09();
		String content = "<bulletList depth=\"2\">this is a bullet list depth text</bulletList>";
		String decoded = interpreter.decode(content);
		
		assertEquals("** this is a bullet list depth text", decoded);
	}

}