package test.v09;

import static org.junit.Assert.*;
import org.junit.Test;

import transform.app.impl.interpreter.xwiki.v09.XWikiMacroInterpreterV09;

public class MacroV09Test 
{

	@Test
	public void testEncode()
	{
		testEncode_VelocityMacro();
		testEncode_RadeoxMacro();
	}
	
	private void testEncode_RadeoxMacro() 
	{
		XWikiMacroInterpreterV09 interpreter = new XWikiMacroInterpreterV09();
		String content = "{code:java}"+ System.lineSeparator() +
						"System.out.println(\"Hello World\")"+ System.lineSeparator() + 
						"{code}";
		String encoded = interpreter.encode(content);
		
		assertEquals("<macro>" + System.lineSeparator() + content + System.lineSeparator() + "</macro>",encoded);
	}

	private void testEncode_VelocityMacro() 
	{
		XWikiMacroInterpreterV09 interpreter = new XWikiMacroInterpreterV09();
		String content = "#info(\"Some text\")";
		String encoded = interpreter.encode(content);
		
		assertEquals("<macro>" + System.lineSeparator() + content + System.lineSeparator() + "</macro>",encoded);
		
	}

	@Test
	public void testDecode()
	{
		testDecode_VelocityMacro();
		testDecode_RadeoxMacro();
	}

	private void testDecode_RadeoxMacro() 
	{
		XWikiMacroInterpreterV09 intepreter = new XWikiMacroInterpreterV09();
		String content = "<macro>" + System.lineSeparator() + "{code:java}"+ System.lineSeparator() +
				"System.out.println(\"Hello World\")"+ System.lineSeparator() + 
				"{code}" + System.lineSeparator() + "</macro>";
		
		String decoded = intepreter.decode(content);
		
		assertEquals("##{code:java}"+ System.lineSeparator() +
					"##System.out.println(\"Hello World\")"+ System.lineSeparator() + 
					"##{code}",decoded);
	}

	private void testDecode_VelocityMacro() 
	{
		XWikiMacroInterpreterV09 intepreter = new XWikiMacroInterpreterV09();
		String content = "<macro>" + System.lineSeparator() + "#info(\"Some text\")" + System.lineSeparator() + "</macro>";
		
		String decoded = intepreter.decode(content);
		
		assertEquals("###info(\"Some text\")",decoded);
		
	}
}
