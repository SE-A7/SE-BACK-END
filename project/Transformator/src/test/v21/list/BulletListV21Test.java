package test.v21.list;

import static org.junit.Assert.*;

import org.junit.Test;

import transform.app.impl.interpreter.xwiki.v21.list.XWikiBulletedListInterpreterV21;

public class BulletListV21Test
{

    /**
     *  Test if the interpreter for bullet lists encodes text as expected.
     */
    @Test
    public void testEncode()
    {
        XWikiBulletedListInterpreterV21 interpreter = new XWikiBulletedListInterpreterV21();
        String content =
                "* list item 1" + System.lineSeparator() + 
                "* list item 2";
        String encoded = interpreter.encode(content);

        assertEquals(
               "<bulletList depth=\"1\">list item 1</bulletList>" + 
            	System.lineSeparator() + 
            	"<bulletList depth=\"1\">list item 2</bulletList>",encoded);
    }

    /**
     *  Test if the interpreter for bullet lists encodes text as expected with an empty string.
     */
    @Test
    public void testEncodeEmptyString()
    {
    	XWikiBulletedListInterpreterV21 interpreter = new XWikiBulletedListInterpreterV21();
        String content = "";
        String encoded = interpreter.encode(content);

        assertEquals("", encoded);
    }

    /**
     *  Test if the interpreter for bullet lists encodes text as expected with an empty tag.
     */
    @Test
    public void testEncodeEmptyTag()
    {
    	XWikiBulletedListInterpreterV21 interpreter = new XWikiBulletedListInterpreterV21();
        String content = "*";
        String encoded = interpreter.encode(content);

        assertEquals(
                "<bulletList depth=\"1\"></bulletList>", encoded);
    }

    /**
     *  Test if the interpreter for bullet lists decodes as expected
     */
    @Test
    public void testDecode()
    {
    	XWikiBulletedListInterpreterV21 interpreter = new XWikiBulletedListInterpreterV21();
        String content =
                "<bulletList depth=\"1\">list item 1</bulletList>" + 
                System.lineSeparator() + 
                "<bulletList depth=\"1\">list item 2</bulletList>";
        String decoded = interpreter.decode(content);

        assertEquals(
                "* list item 1" + System.lineSeparator() +
                "* list item 2", decoded);
    }

    /**
     *  Test if the interpreter for bullet lists decodes as expected with an empty string.
     */
    @Test
    public void testDecodeEmptyString()
    {
    	XWikiBulletedListInterpreterV21 interpreter = new XWikiBulletedListInterpreterV21();
        String content = "";
        String decoded = interpreter.decode(content);

        assertEquals("", decoded);
    }

    /**
     *  Test if the interpreter for bullet lists decodes as expected with an empty tag.
     */
    @Test
    public void testDecodeEmptyTag()
    {
    	XWikiBulletedListInterpreterV21 interpreter = new XWikiBulletedListInterpreterV21();
        String content =
                "<bulletList depth=\"1\"></bulletList>";
        String decoded = interpreter.decode(content);

        assertEquals("*", decoded);
    }

}
