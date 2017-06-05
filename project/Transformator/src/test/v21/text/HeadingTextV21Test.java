package test.v21.text;

import static org.junit.Assert.*;

import org.junit.Test;

import transform.app.impl.interpreter.xwiki.v21.text.XWikiHeadingInterpreterV21;

public class HeadingTextV21Test
{

    /**
     *  Test interpreter heading level 1 text encoding.
     */
//    @Test
//    public void testEncodeLevel1()
//    {
//        XWikiHeadingInterpreterV21 interpreter = new XWikiHeadingInterpreterV21();
//        String content = "= heading 1 test =";
//        String encoded = interpreter.encode(content);
//
//        assertEquals("<heading level=\"1\">heading 1 test</heading>", encoded);
//    }
//
//
//    /**
//     *  Test interpreter heading level 2 text encoding.
//     */
//    @Test
//    public void testEncodeLevel2()
//    {
//        XWikiHeadingInterpreterV21 interpreter = new XWikiHeadingInterpreterV21();
//        String content = "== heading 2 test ==";
//        String encoded = interpreter.encode(content);
//
//        assertEquals("<heading level=\"2\">heading 2 test</heading>", encoded);
//    }
//
//
//    /**
//     *  Test interpreter heading level 3 text encoding.
//     */
//    @Test
//    public void testEncodeLevel3()
//    {
//    	XWikiHeadingInterpreterV21 interpreter = new XWikiHeadingInterpreterV21();
//        String content = "=== heading 3 test ===";
//        String encoded = interpreter.encode(content);
//
//        assertEquals("<heading level=\"3\">heading 3 test</heading>", encoded);
//    }
//
//
//    /**
//     *  Test interpreter heading level 4 text encoding.
//     */
//    @Test
//    public void testEncodeLevel4()
//    {
//    	XWikiHeadingInterpreterV21 interpreter = new XWikiHeadingInterpreterV21();
//        String content = "==== heading 4 test ====";
//        String encoded = interpreter.encode(content);
//
//        assertEquals("<heading level=\"4\">heading 4 test</heading>", encoded);
//    }
//
//
//    /**
//     *  Test interpreter heading level 5 text encoding.
//     */
//    @Test
//    public void testEncodeLevel5()
//    {
//    	XWikiHeadingInterpreterV21 interpreter = new XWikiHeadingInterpreterV21();
//        String content = "===== heading 5 test =====";
//        String encoded = interpreter.encode(content);
//
//        assertEquals("<heading level=\"5\">heading 5 test</heading>", encoded);
//    }
//
//
//    /**
//     *  Test interpreter heading level 6 text encoding.
//     */
//    @Test
//    public void testEncodeLevel6()
//    {
//    	XWikiHeadingInterpreterV21 interpreter = new XWikiHeadingInterpreterV21();
//        String content = "====== heading 6 test ======";
//        String encoded = interpreter.encode(content);
//
//        assertEquals("<heading level=\"6\">heading 6 test</heading>", encoded);
//    }


    /**
     *  Test interpreter heading level 1 text decoding
     */
    @Test
    public void testDecodeLevel1()
    {
    	XWikiHeadingInterpreterV21 interpreter = new XWikiHeadingInterpreterV21();
        String content = "<heading level=\"1\">heading 1 test</heading>";
        String decoded = interpreter.decode(content);

        assertEquals("= heading 1 test =", decoded);
    }


    /**
     *  Test interpreter heading level 2 text decoding
     */
    @Test
    public void testDecodeLevel2()
    {
    	XWikiHeadingInterpreterV21 interpreter = new XWikiHeadingInterpreterV21();
        String content = "<heading level=\"2\">heading 2 test</heading>";
        String decoded = interpreter.decode(content);

        assertEquals("== heading 2 test ==", decoded);
    }

    
    /**
     *  Test interpreter heading level 3 text decoding
     */
    @Test
    public void testDecodeLevel3()
    {
    	XWikiHeadingInterpreterV21 interpreter = new XWikiHeadingInterpreterV21();
        String content = "<heading level=\"3\">heading 3 test</heading>";
        String decoded = interpreter.decode(content);

        assertEquals("=== heading 3 test ===", decoded);
    }

    
    /**
     *  Test interpreter heading level 4 text decoding
     */
    @Test
    public void testDecodeLevel4()
    {
    	XWikiHeadingInterpreterV21 interpreter = new XWikiHeadingInterpreterV21();
        String content = "<heading level=\"4\">heading 4 test</heading>";
        String decoded = interpreter.decode(content);

        assertEquals("==== heading 4 test ====", decoded);
    }

    
    /**
     *  Test interpreter heading level 5 text decoding
     */
    @Test
    public void testDecodeLevel5()
    {
    	XWikiHeadingInterpreterV21 interpreter = new XWikiHeadingInterpreterV21();
        String content = "<heading level=\"5\">heading 5 test</heading>";
        String decoded = interpreter.decode(content);

        assertEquals("===== heading 5 test =====", decoded);
    }

    
    /**
     *  Test interpreter heading level 6 text decoding
     */
    @Test
    public void testDecodeLevel6()
    {
    	XWikiHeadingInterpreterV21 interpreter = new XWikiHeadingInterpreterV21();
        String content = "<heading level=\"6\">heading 6 test</heading>";
        String decoded = interpreter.decode(content);

        assertEquals("====== heading 6 test ======", decoded);
    }

}
