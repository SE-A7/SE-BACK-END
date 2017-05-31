package test.v09.text;

import static org.junit.Assert.*;

import org.junit.Test;

import transform.app.impl.interpreter.xwiki.v09.text.XWikiBoldTextInterpreterV09;

public class BoldTextV09Test 
{

	/**
	 *  Test if the interpreter for bold encodes text as expected.
	 */
	@Test
	public void  testEncode()
	{
		testEncode_1();
		testEncode_2();
		testEncode_3();
		testEncode_4();
	}

	public void testEncode_1() 
	{
		XWikiBoldTextInterpreterV09 interpreter = new XWikiBoldTextInterpreterV09();
		String content = "*this is a bold text*";
		String encoded = interpreter.encode(content);
		
		assertEquals("<bold>this is a bold text</bold>", encoded);
	}
	
	public void testEncode_2() 
	{
		XWikiBoldTextInterpreterV09 interpreter = new XWikiBoldTextInterpreterV09();
		String content = "*this is a bold text* and *another bold text*";
		String encoded = interpreter.encode(content);
		
		assertEquals("<bold>this is a bold text</bold> and <bold>another bold text</bold>", encoded);
	}

	public void testEncode_3() 
	{
		XWikiBoldTextInterpreterV09 interpreter = new XWikiBoldTextInterpreterV09();
		String content = "**";
		String encoded = interpreter.encode(content);
		
		assertEquals("<bold></bold>", encoded);
	}

	public void testEncode_4() 
	{
		XWikiBoldTextInterpreterV09 interpreter = new XWikiBoldTextInterpreterV09();
		String content = "*this is not a bold text";
		String encoded = interpreter.encode(content);
		
		assertEquals("*this is not a bold text", encoded);
	}

	
	/**
	 *  Test if the interpreter for bold decodes as expected
	 */
	@Test
	public void testDecode()
	{
		testDecode_1();
		testDecode_2();
		testDecode_3();
		testDecode_4();
	}

	public void testDecode_1()
	{
		XWikiBoldTextInterpreterV09 interpreter = new XWikiBoldTextInterpreterV09();
		String content = "<bold>this is a bold text</bold> and <bold>another bold text</bold>";
		String decoded = interpreter.decode(content);
		
		assertEquals("*this is a bold text* and *another bold text*", decoded);
	}

	public void testDecode_2()
	{
		XWikiBoldTextInterpreterV09 interpreter = new XWikiBoldTextInterpreterV09();
		String content = "<bold>this is a bold text</bold>";
		String decoded = interpreter.decode(content);
		
		assertEquals("*this is a bold text*", decoded);
	}

	public void testDecode_3()
	{
		XWikiBoldTextInterpreterV09 interpreter = new XWikiBoldTextInterpreterV09();
		String content = "<bold></bold>";
		String decoded = interpreter.decode(content);
		
		assertEquals("**", decoded);
	}

	public void testDecode_4()
	{
		XWikiBoldTextInterpreterV09 interpreter = new XWikiBoldTextInterpreterV09();
		String content = "<bold>text";
		String decoded = interpreter.decode(content);
		
		assertEquals("*text", decoded);
	}
}