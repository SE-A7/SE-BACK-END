package test.v21.text;

import static org.junit.Assert.*;

import org.junit.Test;

import transform.app.impl.interpreter.xwiki.v21.text.XWikiItalicTextInterpreterV21;

public class ItalicTextV21Test 
{

//	/**
//	 *  Test interpreter italic text encoding.
//	 */
//	@Test
//	public void testEncode() 
//	{
//		XWikiItalicTextInterpreterV21 interpreter = new XWikiItalicTextInterpreterV21();
//		String content = "//italic text test//";
//		String encoded = interpreter.encode(content);
//		
//		assertEquals("<italic>italic text test</italic>", encoded);
//	}
	
	/**
	 *  Test interpreter italic text decoding
	 */
	@Test
	public void testDecode()
	{
		XWikiItalicTextInterpreterV21 interpreter = new XWikiItalicTextInterpreterV21();
		String content = "<italic>italic text test</italic>";
		String decoded = interpreter.decode(content);
		
		assertEquals("//italic text test//", decoded);
	}

}
