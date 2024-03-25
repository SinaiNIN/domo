package com.example.demo.demojdk21.util;

import com.example.demo.demojdk21.exception.UnSupportScriptInputException;

public class UserInputXssDetector {
    public Object encodeForHTML(Object input) {
        if (input instanceof String && XssUtils.isContainXssString(input.toString())) {
            throw new UnSupportScriptInputException();
        }
        return input;
    }
}