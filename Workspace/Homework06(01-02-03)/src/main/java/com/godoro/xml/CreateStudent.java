package com.godoro.xml;
import static com.godoro.xml.XMLUtils.*;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
public class CreateStudent {
	public static void main(String[] args) throws Exception {
		
		Document document = create("student");
		Element student = document.getDocumentElement();
		student.setAttribute("id", "601");
		addSingleElement(document, student, "name", "Yıldırım Gürses");
		addSingleElement(document, student, "mark", 2.7);
		Element name = document.createElement("name");
		student.appendChild(name);
		String path = "..\\..\\XML\\Generated.xml";
		dump(document, path);
		
	}
}
