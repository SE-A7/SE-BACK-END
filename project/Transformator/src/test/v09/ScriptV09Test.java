package test.v09;

import static org.junit.Assert.*;
import org.junit.Test;

import transform.app.impl.interpreter.xwiki.v09.XWikiScriptInterpreterV09;

public class ScriptV09Test 
{
	@Test
	public void testEncode()
	{
		testEncode_VelocityScript();
		testEncode_GroovyScript();
	}
	
	@Test
	public void testDecode()
	{
		testDecode_VelocityScript();
		testDecode_GroovyScript();
	}
	
	
	private void testEncode_VelocityScript()
	{
		XWikiScriptInterpreterV09 interpreter = new XWikiScriptInterpreterV09();
		String content = "#set ($var = \"whatever\")";
		String encoded = interpreter.encode(content);
		
		assertEquals("<script type=\"velocity\">" + System.lineSeparator() +  content + System.lineSeparator() + "</script>",encoded);
	}
	
	private void testEncode_GroovyScript()
	{
		XWikiScriptInterpreterV09 interpreter = new XWikiScriptInterpreterV09();
		String content = "<%" + System.lineSeparator() + 
						"def var = \"whatever\"" + System.lineSeparator() + 
						"%>";
		String encoded = interpreter.encode(content);
		
		assertEquals("<script type=\"groovy\">" + System.lineSeparator() + "def var = \"whatever\"" + System.lineSeparator() + "</script>",encoded);
		 
	}
	
	
	private void testDecode_VelocityScript()
	{
		XWikiScriptInterpreterV09 intepreter = new XWikiScriptInterpreterV09();
		String content = "<script type=\"velocity\">" + System.lineSeparator() + "#set ($var = \"whatever\")" + System.lineSeparator() + "</script>";
		String decoded = intepreter.decode(content);
		
		assertEquals("#set ($var = \"whatever\")",decoded);
	}
	
	private void testDecode_GroovyScript()
	{
		XWikiScriptInterpreterV09 intepreter = new XWikiScriptInterpreterV09();
		String content = "<script type=\"groovy\">" + System.lineSeparator() + "def var = \"whatever\"" + System.lineSeparator() + "</script>";
		String decoded = intepreter.decode(content);
		
		assertEquals("<%" + System.lineSeparator() + 
				"def var = \"whatever\"" + System.lineSeparator() + 
				"%>",decoded);
	}
}
