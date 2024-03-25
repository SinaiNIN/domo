package com.example.demo.demojdk21.util;

import org.apache.commons.lang3.StringEscapeUtils;

public class UserInputEncoder {
    public String encodeForHTML(String input) {
        if (input == null || input.isEmpty()) {
            return input;
        }
        return StringEscapeUtils.escapeXml11(input);
    }
}