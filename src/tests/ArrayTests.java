package tests;

import main.Array;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class ArrayTests {

    private final String none = "Нет такого имени";
    private ByteArrayOutputStream bos;
    private PrintStream ps;

    @Before
    public void changeOut() {
        ps = System.out;
        bos = new ByteArrayOutputStream();
        PrintStream stream = new PrintStream(bos);
        System.setOut(stream);
    }

    @Test
    public void testSimple1() {
        Array.multiplesOfThree(new int[]{1, 3, 2, 6, 4, 9});
        String expected = "3" + System.lineSeparator() + "6" + System.lineSeparator() + "9" + System.lineSeparator();
        Assert.assertEquals(expected, bos.toString());
    }

    @Test
    public void testSimple2() {
        Array.multiplesOfThree(null);
        String expected = "";
        Assert.assertEquals(expected, bos.toString());
    }

    @Test
    public void testSimple3() {
        Array.multiplesOfThree(new int[]{1});
        String expected = "";
        Assert.assertEquals(expected, bos.toString());
    }

    @Test
    public void testSimple4() {
        Array.multiplesOfThree(new int[]{});
        String expected = "";
        Assert.assertEquals(expected, bos.toString());
    }

    @Test
    public void testSimple5() {
        Array.multiplesOfThree(new int[]{9});
        String expected = "9" + System.lineSeparator();
        Assert.assertEquals(expected, bos.toString());
    }

    @After
    public void returnOut() {
        System.setOut(ps);
    }
}
