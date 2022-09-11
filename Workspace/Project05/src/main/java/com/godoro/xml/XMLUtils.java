package com.godoro.xml;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class XMLUtils {
	private static DocumentBuilderFactory factory;
	public static DocumentBuilderFactory getFactory() {
		if(factory == null) {
			factory = DocumentBuilderFactory.newInstance();
		}
		return factory;
	}
	public static Document parse(String path) throws ParserConfigurationException, SAXException, IOException {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document document = builder.parse(path);
		return document;
	}
	public static Document create() {
		return null;
	}
	public static void addSingleElement(Document document, Element parent, String tag, String content) {
		Element name = document.createElement(tag);
		name.setTextContent(content);
		parent.appendChild(name);
	}
	public static void addSingleElement(Document document, Element parent, String tag, double content) {
		Element name = document.createElement(tag);
		name.setTextContent(Double.toString(content));
		parent.appendChild(name);
		
	}
	public static String getSingleElement(Element parent, String tag, String defaultValue) {
		NodeList elementList = parent.getElementsByTagName(tag);
		if(elementList.getLength()==0) {
			return defaultValue;
		}
		return elementList.item(0).getTextContent();
	}
	public static double getSingleElement(Element parent, String tag, double defaultValue) {
		String  string = getSingleElement(parent, tag, Double.toString(defaultValue));
		return Double.parseDouble(string);
	}
	public static String getAttribute(Element element, String name, String defaultValue) {
		if(!element.hasAttribute(name)) {
			return defaultValue;
		}
		return element.getAttribute(name);
	}
	
}
