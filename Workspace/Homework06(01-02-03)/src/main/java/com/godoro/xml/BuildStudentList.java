package com.godoro.xml;

import static com.godoro.xml.XMLUtils.*;

import java.io.IOException;


import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class BuildStudentList {
	public static void main(String[] args) throws Exception, SAXException, IOException {
		String path = "..\\..\\XML\\Students.xml";
		Document document = parse(path);
		Element students = document.getDocumentElement();
		NodeList studentList = students.getElementsByTagName("student");
		for(int i = 0; i < studentList.getLength(); i++) {
			Element student = (Element)studentList.item(i);
			String name = getSingleElementText(student, "name", "");
			double mark = getSingleElementText(student, "mark", 0);
			System.out.println(name + ". " + mark);
		}
		
		
	}
}
