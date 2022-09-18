package com.godoro.xml;

import static com.godoro.xml.XMLUtils.*;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class XmlBuild {
	public static void main(String[] args) throws Exception {
		
		//JAXP
		String path = "..\\..\\XML\\Product.xml";
		Document document = parse(path);
		
		//DOM
		Element product = document.getDocumentElement();
		long id = getAttribute(product, "id", 0);
		System.out.println("Özdeşlik: " + id);
		
		String name = getSingleElement(product, "name", "");
		System.out.println("Ad: " +name);
		double price = getSingleElement(product, "price", 0);
		System.out.println("Eder: " + price);
		
		
	}
}
