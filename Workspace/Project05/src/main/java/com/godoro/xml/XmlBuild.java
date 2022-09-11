package com.godoro.xml;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import static com.godoro.xml.XMLUtils.*;

public class XmlBuild {
	public static void main(String[] args) throws Exception {
		//JAXP
		String path = "..\\..\\XML\\Product.xml";
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document document = builder.parse(path);
		//DOM
		Element product = document.getDocumentElement();
		String id = product.getAttribute("id");
		System.out.println("Özdeşlik: " + id);
		String name = getSingleElement(product, "name", "");
		System.out.println("Ad: " +name);
		double price = getSingleElement(product, "price", 0);
		System.out.println("Eder: " + price);
		
		
	}
}
