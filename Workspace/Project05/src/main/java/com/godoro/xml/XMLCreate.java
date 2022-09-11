package com.godoro.xml;
import static com.godoro.xml.XMLUtils.create;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
public class XMLCreate {
	public static void main(String[] args) {
		Document document = create();
		Element employee = document.createElement("employee");
		employee.setAttribute("id", "101");
		
	}
}
