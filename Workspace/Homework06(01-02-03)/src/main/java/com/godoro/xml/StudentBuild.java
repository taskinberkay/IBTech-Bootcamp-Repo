package com.godoro.xml;

import static com.godoro.xml.XMLUtils.*;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class StudentBuild {
	public static void main(String[] args) throws Exception {
		
		//JAXP
		String path = "..\\..\\XML\\Student.xml";
		Document document = parse(path);
		
		//DOM
		Element student = document.getDocumentElement();
		long id = getAttribute(student, "id", 0);
		System.out.println("Özdeşlik: " + id);
		
		String name = getSingleElementText(student, "name", "");
		System.out.println("Ad: " +name);
		double price = getSingleElementText(student, "mark", 0);
		System.out.println("Not: " + price);
		
		
	}
}
