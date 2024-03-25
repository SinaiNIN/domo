package com.example.demo.demojdk21.util;

import java.io.ByteArrayInputStream;
import java.util.Objects;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.apache.commons.lang3.StringEscapeUtils;
import org.owasp.validator.html.AntiSamy;
import org.owasp.validator.html.CleanResults;
import org.owasp.validator.html.Policy;
import org.owasp.validator.html.PolicyException;
import org.owasp.validator.html.ScanException;
import org.w3c.dom.Document;

public class XssUtils {
    private static AntiSamy as;
    private static DocumentBuilderFactory df;

    static {

        df = DocumentBuilderFactory.newInstance();

        try {
            Policy policy = Policy.getInstance(Policy.class.getClassLoader().getResourceAsStream("antisamy.xml"));
            as = new AntiSamy(policy);
        } catch (Exception e) {
            throw new RuntimeException("Failed to load AntiSamy policy", e);
        }

    }

    public static boolean isContainXssString(String content) {
        if (Objects.isNull(content)) {
            return false;
        }

        try {

            content = StringEscapeUtils.unescapeHtml4(content);
            CleanResults cleanResults = as.scan(content, AntiSamy.DOM);
            if (cleanResults.getNumberOfErrors() > 0) {
                return true;
            }
        } catch (ScanException | PolicyException e) {
            throw new RuntimeException("Failed to scan content", e);
        }

        return false;
    }

    public static boolean isXmlContainXssString(String xml) {
        String xmlContent = getXmlContent(xml);
        return isContainXssString(xmlContent);

    }

    private static String getXmlContent(String xmlContent) {
        if (Objects.isNull(xmlContent)) {
            return xmlContent;
        }
        try {
            DocumentBuilder docBuilder = df.newDocumentBuilder();
            Document document = docBuilder.parse(new ByteArrayInputStream(xmlContent.getBytes()));
            return document.getDocumentElement().getTextContent();
        } catch (Exception e) {
            return xmlContent;
        }
    }

}