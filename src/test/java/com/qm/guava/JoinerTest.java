package com.qm.guava;

import com.google.common.base.CharMatcher;
import com.google.common.base.Joiner;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by wodvpn on 2017/3/19.
 */
public class JoinerTest {

    @Test
    public void test1()
    {
        String str1 = Joiner.on(' ').join(1, 2, 3);
        Assert.assertTrue(str1.equals("1 2 3"));
    }

    @Test
    public void test2()
    {
        String string = CharMatcher.digit().retainFrom("some text 89983 and more");
        Assert.assertTrue(string.equals("89983"));
    }

    @Test
    public void test3()
    {
        System.out.println(~-1-1);
    }
}
