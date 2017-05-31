package test.v21;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import transform.app.impl.interpreter.xwiki.v21.XWikiScriptInterpreterV21;

public class ScriptV21Test 
{
	@Test
	public void testDecode()
	{
		testDecode_VelocityScript();
		testDecode_GroovyScript();
	}

	private void testDecode_VelocityScript()
	{
		XWikiScriptInterpreterV21 intepreter = new XWikiScriptInterpreterV21();
		String content = "<script type=\"velocity\">" + System.lineSeparator() + "#set ($var = \"whatever\")" + System.lineSeparator() + "</script>";
		String decoded = intepreter.decode(content);
		
		assertEquals("{{velocity}}" + System.lineSeparator() + "#set ($var = \"whatever\")" + System.lineSeparator() + "{{/velocity}}",decoded);
	}
	
	private void testDecode_GroovyScript()
	{
		XWikiScriptInterpreterV21 intepreter = new XWikiScriptInterpreterV21();
		String content = "<script type=\"groovy\">" + System.lineSeparator() + "def var = \"whatever\"" + System.lineSeparator() + "</script>";
		String decoded = intepreter.decode(content);
		
		assertEquals("{{groovy}}" + System.lineSeparator() + 
				"def var = \"whatever\"" + System.lineSeparator() + 
				"{{/groovy}}",decoded);
	}
}
