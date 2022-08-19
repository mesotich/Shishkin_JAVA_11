package tests;

import main.Slava;
import org.junit.Assert;
import org.junit.Test;

public class SlavaTests {

    private final String none = "Нет такого имени";

    @Test
    public void testSimple1() {
        String actual = Slava.helloSlava("asfasfasf");
        Assert.assertEquals(none, actual);
    }

    @Test
    public void testSimple2() {
        String actual = Slava.helloSlava("");
        Assert.assertEquals(none, actual);
    }
    @Test
    public void testSimple3() {
        String actual = Slava.helloSlava(null);
        Assert.assertEquals(none, actual);
    }
    @Test
    public void testSimple4() {
        String actual = Slava.helloSlava("вячеслав");
        Assert.assertEquals(none, actual);
    }
    @Test
    public void testSimple5() {
        String actual = Slava.helloSlava("Вячеслав1");
        Assert.assertEquals(none, actual);
    }
    @Test
    public void testSimple6() {
        String actual = Slava.helloSlava("Вячеслав");
        Assert.assertEquals("Привет, Вячеслав", actual);
    }
}

