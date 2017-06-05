package test.v21.text;

import static org.junit.Assert.*;

import org.junit.Test;

import transform.app.impl.interpreter.xwiki.v21.text.XWikiBoldTextInterpreterV21;

public class BoldTextV21Test
{

    /**
     *  Test interpreter bold text encoding.
     */
//    @Test
//    public void testEncode()
//    {
//        XWikiBoldTextInterpreterV21 interpreter = new XWikiBoldTextInterpreterV21();
//        String content = "**bold text test**";
//        String encoded = interpreter.encode(content);
//
//        assertEquals("<bold>bold text test</bold>", encoded);
//    }
//
//    /**
//     *  Test interpreter bold text encoding with space before and after text.
//     */
//    @Test
//    public void testEncodeSpaces()
//    {
//        XWikiBoldTextInterpreterV21 interpreter = new XWikiBoldTextInterpreterV21();
//        String content = "** bold text test **";
//        String encoded = interpreter.encode(content);
//
//        assertEquals("<bold>bold text test</bold>", encoded);
//    }
//
//    /**
//     *  Test interpreter bold text encoding with space text outside tag.
//     */
//    @Test
//    public void testEncodeWithOutsideText()
//    {
//        XWikiBoldTextInterpreterV21 interpreter = new XWikiBoldTextInterpreterV21();
//        String content = "** text inside ** text outside";
//        String encoded = interpreter.encode(content);
//
//        assertEquals("<bold>text inside</bold> text outside", encoded);
//    }
//
//    /**
//     *  Test interpreter bold text encoding with no tag.
//     */
//    @Test
//    public void testEncodeWithNoTag()
//    {
//        XWikiBoldTextInterpreterV21 interpreter = new XWikiBoldTextInterpreterV21();
//        String content = "text with no tags";
//        String encoded = interpreter.encode(content);
//
//        assertEquals("text with no tags", encoded);
//    }
//
//    /**
//     *  Test interpreter bold text encoding with tag in tag.
//     */
//    @Test
//    public void testEncodeTagInTag()
//    {
//        XWikiBoldTextInterpreterV21 interpreter = new XWikiBoldTextInterpreterV21();
//        String content = "**bold text test //italic text//**";
//        String encoded = interpreter.encode(content);
//
//        assertEquals("<bold>bold text test //italic text//</bold>", encoded);
//    }
//
//    /**
//     *  Test interpreter bold text encoding with two bold tags.
//     */
//    @Test
//    public void testEncodeTwoTags()
//    {
//        XWikiBoldTextInterpreterV21 interpreter = new XWikiBoldTextInterpreterV21();
//        String content = "**bold1****bold2**";
//        String encoded = interpreter.encode(content);
//
//        assertEquals("<bold>bold1</bold><bold>bold2</bold>", encoded);
//    }
//
//    /**
//     *  Test interpreter bold text encoding with one bold inside the other.
//     */
//    @Test
//    public void testEncodeTagWithSelf()
//    {
//        XWikiBoldTextInterpreterV21 interpreter = new XWikiBoldTextInterpreterV21();
//        String content = "**bold1**bold2****";
//        String encoded = interpreter.encode(content);
//
//        assertEquals("<bold>bold1</bold>bold2<bold></bold>", encoded);
//    }
//
//    /**
//     *  Test interpreter bold text encoding with empty tag content.
//     */
//    @Test
//    public void testEncodeEmptyTags()
//    {
//        XWikiBoldTextInterpreterV21 interpreter = new XWikiBoldTextInterpreterV21();
//        String content = "****";
//        String encoded = interpreter.encode(content);
//
//        assertEquals("<bold></bold>", encoded);
//    }
//
//    /**
//     *  Test interpreter bold text encoding with no tags.
//     */
//    @Test
//    public void testEncodeEmptyString()
//    {
//        XWikiBoldTextInterpreterV21 interpreter = new XWikiBoldTextInterpreterV21();
//        String content = "";
//        String encoded = interpreter.encode(content);
//
//        assertEquals("", encoded);
//    }

    /**
     *  Test interpreter bold text decoding
     */
    @Test
    public void testDecode()
    {
        XWikiBoldTextInterpreterV21 interpreter = new XWikiBoldTextInterpreterV21();
        String content = "<bold>bold text test</bold>";
        String decoded = interpreter.decode(content);

        assertEquals("**bold text test**", decoded);
    }

    /**
     *  Test interpreter bold text decoding with empty string
     */
    @Test
    public void testDecodeEmptyString()
    {
        XWikiBoldTextInterpreterV21 interpreter = new XWikiBoldTextInterpreterV21();
        String content = "";
        String decoded = interpreter.decode(content);

        assertEquals("", decoded);
    }

    /**
     *  Test interpreter bold text decoding with empty tag
     */
    @Test
    public void testDecodeEmptyTag()
    {
        XWikiBoldTextInterpreterV21 interpreter = new XWikiBoldTextInterpreterV21();
        String content = "<bold></bold>";
        String decoded = interpreter.decode(content);

        assertEquals("****", decoded);
    }

    /**
     *  Test interpreter bold text decoding with tag in tag
     */
    @Test
    public void testDecodeTagInTag()
    {
        XWikiBoldTextInterpreterV21 interpreter = new XWikiBoldTextInterpreterV21();
        String content = "<bold>test <italic>bold</italic></bold>";
        String decoded = interpreter.decode(content);

        assertEquals("**test <italic>bold</italic>**", decoded);
    }


    /**
     *  Test interpreter bold text decoding with one bold inside the other
     */
    @Test
    public void testDecodeTagWithSelf()
    {
        XWikiBoldTextInterpreterV21 interpreter = new XWikiBoldTextInterpreterV21();
        String content = "<bold>some <bold>test</bold></bold>";
        String decoded = interpreter.decode(content);

        assertEquals("**some **test****", decoded);
    }

    /**
     *  Test interpreter bold text decoding with spaces
     */
    @Test
    public void testDecodeTagWithSpace()
    {
        XWikiBoldTextInterpreterV21 interpreter = new XWikiBoldTextInterpreterV21();
        String content = "<bold> spacing test </bold>";
        String decoded = interpreter.decode(content);

        assertFalse(decoded.equals("**spacing test**"));
    }

    /**
     *  Test interpreter bold text decoding with text outside tag
     */
    @Test
    public void testDecodeTagWithTextOutside()
    {
        XWikiBoldTextInterpreterV21 interpreter = new XWikiBoldTextInterpreterV21();
        String content = "<bold>text inside</bold> text outside";
        String decoded = interpreter.decode(content);

        assertEquals("**text inside** text outside", decoded);
    }

    /**
     *  Test interpreter bold text decoding with text outside tag
     */
    @Test
    public void testDecodeTagWithNoTag()
    {
        XWikiBoldTextInterpreterV21 interpreter = new XWikiBoldTextInterpreterV21();
        String content = "free text";
        String decoded = interpreter.decode(content);

        assertEquals("free text", decoded);
    }
}
