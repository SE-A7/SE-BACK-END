package test.v21;

import static org.junit.Assert.*;
import org.junit.Test;

import transform.app.impl.interpreter.xwiki.v21.XWikiMacroInterpreterV21;

public class MacroV21Test 
{

	@Test
	public void testDecode()
	{
		testDecode_VelocityMacro();
		testDecode_RadeoxMacro();
	}
	
	private void testDecode_RadeoxMacro() 
	{
		XWikiMacroInterpreterV21 intepreter = new XWikiMacroInterpreterV21();
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
		XWikiMacroInterpreterV21 intepreter = new XWikiMacroInterpreterV21();
		String content = "<macro>" + System.lineSeparator() + "#info(\"Some text\")" + System.lineSeparator() + "</macro>";
		
		String decoded = intepreter.decode(content);
		
		assertEquals("###info(\"Some text\")",decoded);
		
	}
}
