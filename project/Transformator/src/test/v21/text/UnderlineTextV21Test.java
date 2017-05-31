package test.v21.text;

import static org.junit.Assert.*;

import org.junit.Test;

import transform.app.impl.interpreter.xwiki.v21.text.XWikiUnderlineTextInterpreterV21;

public class UnderlineTextV21Test
{

    /**
     *  Test if the interpreter for underline encodes text as expected.
     */
    @Test
    public void testEncode()
    {
        XWikiUnderlineTextInterpreterV21 interpreter = new XWikiUnderlineTextInterpreterV21();
        String content = "__underline tag test__";
        String encoded = interpreter.encode(content);

        assertEquals("<underline>underline tag test</underline>", encoded);
    }

    /**
     *  Test if the interpreter for underline decodes as expected
     */
    @Test
    public void testDecode()
    {
        XWikiUnderlineTextInterpreterV21 interpreter = new XWikiUnderlineTextInterpreterV21();
        String content = "<underline>underline tag test</underline>";
        String decoded = interpreter.decode(content);

        assertEquals("__underline tag test__", decoded);
    }

}
