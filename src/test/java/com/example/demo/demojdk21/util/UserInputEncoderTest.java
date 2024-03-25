package com.example.demo.demojdk21.util;

import org.junit.Before;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserInputEncoderTest{

    private UserInputEncoder userInputEncoder;

    @Before
    public void setUp() {
        userInputEncoder = new UserInputEncoder();
    }
    @Test
    public void test_encodeForHTML_encodesSpecialCharacters() {
        String input = "<script>alert('XSS');</script>";
        String expected = "&lt;script&gt;alert(&#39;XSS&#39;);&lt;/script&gt;";
        assertEquals(expected, userInputEncoder.encodeForHTML(input));
    }

    @Test
    public void test_encodeForHTML_encodesSpecialCharactersWithEvent() {
        String input = "<img src=\"javascript:alert('XSS');\" onmouseover=\"alert('XSS');\">";
        String expected = "&lt;img src=&#34;javascript:alert(&#39;XSS&#39;);&#34; onmouseover=&#34;alert(&#39;XSS&#39;);&#34;&gt;";
        assertEquals(expected, userInputEncoder.encodeForHTML(input));
    }

    @Test
    public void test_encodeForHTML_returnsEmptyString_whenInputIsEmpty() {
        String input = "";
        String expected = "";
        assertEquals(expected, userInputEncoder.encodeForHTML(input));
    }

    @Test
    public void test_encodeForHTML_returnsSameString_whenNoSpecialCharacters() {
        String input = "NoSpecialCharacters";
        String expected = "NoSpecialCharacters";
        assertEquals(expected, userInputEncoder.encodeForHTML(input));
    }

    @Test
    public void test_encodeForHTML_returnsNull_whenInputIsNull() {
        String input = null;
        String expected = null;
        assertEquals(expected, userInputEncoder.encodeForHTML(input));
    }
}