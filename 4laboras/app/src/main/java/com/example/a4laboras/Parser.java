package com.example.a4laboras;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.io.InputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

public class Parser {
    public static String parse(InputStream stream, String code) throws IOException {
        String result = "";
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(stream);

            NodeList nodes = document.getElementsByTagName("Cube");
            for (int i = 0; i < nodes.getLength(); ++i) {
                Element cube = (Element) nodes.item(i);

                if (cube.hasAttribute("currency")){
                    String currency = cube.getAttribute("currency");
                    if (currency.equals(code)) {
                        result = cube.getAttribute("rate");
                        break;
                    }
                }
            }
        } catch (ParserConfigurationException | SAXException e) {
            e.printStackTrace();
        }
        return result;
    }
}