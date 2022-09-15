package com.godoro.xml;
import static com.godoro.xml.XMLUtils.*;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
public class XMLCreate {
	public static void main(String[] args) throws Exception {
		
		Document document = create("employee");
		Element employee = document.getDocumentElement();
		employee.setAttribute("id", "101");
		addSingleElement(document, employee, "name", "Neşet Ertaş");
		addSingleElement(document, employee, "salary", 9845);
		Element name = document.createElement("name");
		employee.appendChild(name);
		String path = "..\\..\\XML\\Dump.xml";
		dump(document, path);
		
	}
}
