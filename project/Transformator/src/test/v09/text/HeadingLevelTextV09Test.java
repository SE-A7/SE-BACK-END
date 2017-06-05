package test.v09.text;

import static org.junit.Assert.*;

import org.junit.Test;

import transform.app.impl.interpreter.xwiki.v09.text.XWikiHeadingInterpreterV09;

public class HeadingLevelTextV09Test 
{

	/**
	 *  Test if the interpreter for heading level encodes text as expected.
	 */
	@Test
	public void testEncode()
	{
		testEncode_1();
		testEncode_2();
		testEncode_3();
		testEncode_4();
		testEncode_5();
		testEncode_6();	
	}
	public void testEncode_1() 
	{
		XWikiHeadingInterpreterV09 interpreter = new XWikiHeadingInterpreterV09();

		//level 1
		String content = "1 this is a heading level 1 text";
		String encoded = interpreter.encode(content);
		
		assertEquals("<heading level=\"1\">this is a heading level 1 text</heading>", encoded);
	}
	
	public void testEncode_2()
	{
		XWikiHeadingInterpreterV09 interpreter = new XWikiHeadingInterpreterV09();
		//level 2
		String content = "1.1 this is a heading level 2 text";
		String encoded = interpreter.encode(content);
		
		assertEquals("<heading level=\"2\">this is a heading level 2 text</heading>", encoded);
	}

	public void testEncode_3()
	{
		XWikiHeadingInterpreterV09 interpreter = new XWikiHeadingInterpreterV09();
		//level 3
		String content = "1.1.1 this is a heading level 3 text";
		String encoded = interpreter.encode(content);
		
		assertEquals("<heading level=\"3\">this is a heading level 3 text</heading>", encoded);
	}

	public void testEncode_4()
	{
		XWikiHeadingInterpreterV09 interpreter = new XWikiHeadingInterpreterV09();
		//level 4
		String content = "1.1.1.1 this is a heading level 4 text";
		String encoded = interpreter.encode(content);
		
		assertEquals("<heading level=\"4\">this is a heading level 4 text</heading>", encoded);
	}

	public void testEncode_5()
	{
		XWikiHeadingInterpreterV09 interpreter = new XWikiHeadingInterpreterV09();
		//level 5
		String content = "1.1.1.1.1 this is a heading level 5 text";
		String encoded = interpreter.encode(content);
		
		assertEquals("<heading level=\"5\">this is a heading level 5 text</heading>", encoded);
	}
	
	public void testEncode_6()
	{
		XWikiHeadingInterpreterV09 interpreter = new XWikiHeadingInterpreterV09();
		//level 6
		String content = "1.1.1.1.1.1 this is a heading level 6 text";
		String encoded = interpreter.encode(content);
		
		assertEquals("<heading level=\"6\">this is a heading level 6 text</heading>", encoded);
	}
	
	/**
	 *  Test if the interpreter for heading level decodes as expected
	 */
	@Test

	public void testDecode()
	{
		testDecode_1();
		testDecode_2();
		testDecode_3();
		testDecode_4();
		testDecode_5();
		testDecode_6();		
	}
	
	public void testDecode_1()
	{
		XWikiHeadingInterpreterV09 interpreter = new XWikiHeadingInterpreterV09();
		//level 1
		String content = "<heading level=\"1\">this is a heading level 1 text</heading>";
		String decoded = interpreter.decode(content);
		
		assertEquals("1 this is a heading level 1 text", decoded);
	}

	public void testDecode_2()
	{
		XWikiHeadingInterpreterV09 interpreter = new XWikiHeadingInterpreterV09();
		//level 2
		String content = "<heading level=\"2\">this is a heading level 2 text</heading>";
		String decoded = interpreter.decode(content);
		
		assertEquals("1.1 this is a heading level 2 text", decoded);
	}

	public void testDecode_3()
	{
		XWikiHeadingInterpreterV09 interpreter = new XWikiHeadingInterpreterV09();
		//level 3
		String content = "<heading level=\"3\">this is a heading level 3 text</heading>";
		String decoded = interpreter.decode(content);
		
		assertEquals("1.1.1 this is a heading level 3 text", decoded);
	}

	public void testDecode_4()
	{
		XWikiHeadingInterpreterV09 interpreter = new XWikiHeadingInterpreterV09();
		//level 4
		String content = "<heading level=\"4\">this is a heading level 4 text</heading>";
		String decoded = interpreter.decode(content);
		
		assertEquals("1.1.1.1 this is a heading level 4 text", decoded);

	}

	public void testDecode_5()
	{
		XWikiHeadingInterpreterV09 interpreter = new XWikiHeadingInterpreterV09();
		//level 5
		String content = "<heading level=\"5\">this is a heading level 5 text</heading>";
		String decoded = interpreter.decode(content);
		
		assertEquals("1.1.1.1.1 this is a heading level 5 text", decoded);
	}

	public void testDecode_6()
	{
		XWikiHeadingInterpreterV09 interpreter = new XWikiHeadingInterpreterV09();
		//level 6
		String content = "<heading level=\"6\">this is a heading level 6 text</heading>";
		String decoded = interpreter.decode(content);
		
		assertEquals("1.1.1.1.1.1 this is a heading level 6 text", decoded);

	}


}