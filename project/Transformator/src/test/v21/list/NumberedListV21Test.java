package test.v21.list;

import static org.junit.Assert.*;

import org.junit.Test;

import transform.app.impl.interpreter.xwiki.v21.list.XWikiNumberedListInterpreterV21;

public class NumberedListV21Test
{

    /**
     *  Test if the interpreter for numbered lists encodes text as expected.
     */
    @Test
    public void testEncode()
    {
    	XWikiNumberedListInterpreterV21 interpreter = new XWikiNumberedListInterpreterV21();
        String content =
                "1. list item 1\n" +
                "1.list item 2\n";
        interpreter.encode(content);

        assertEquals(
                "<list style=\"numbered\">\n" +
                "    <listItem>list item 1</listItem>\n" +
                "    <listItem>list item 2</listItem>\n" +
                "</list>\n", content);
    }

    /**
     *  Test if the interpreter for numbered lists decodes as expected
     */
    @Test
    public void testDecode()
    {
    	XWikiNumberedListInterpreterV21 interpreter = new XWikiNumberedListInterpreterV21();
        String content =
                "<list style=\"numbered\">\n" +
                "    <listItem>list item 1</listItem>\n" +
                "    <listItem>list item 2</listItem>\n" +
                "</list>\n";
        interpreter.decode(content);

        assertEquals(
                "1.list item 1\n" +
                "1.list item 2\n", content);
    }

}
