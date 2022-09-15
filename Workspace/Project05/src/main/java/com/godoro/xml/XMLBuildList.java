package com.godoro.xml;

import static com.godoro.xml.XMLUtils.*;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class XMLBuildList {
	public static void main(String[] args) throws Exception, SAXException, IOException {
		String path = "..\\..\\XML\\Exam.xml";
		Document document = parse(path);
		Element exam = document.getDocumentElement();
		String id = getAttribute(exam, "id", "0");
		String title = getAttribute(exam, "title", "");
		System.out.println(id + " : " + title);
		NodeList questions = exam.getElementsByTagName("question");
		for(int i = 0; i < questions.getLength(); i++) {
			Element question = (Element)questions.item(i);
			String number = getSingleElementText(question, "number", "");
			String text = getSingleElementText(question, "text", "");
			System.out.println(number + ". " + text);
			NodeList optionsList = question.getElementsByTagName("option");
			for(int j = 0; j < optionsList.getLength(); j++) {
				Element option = (Element)optionsList.item(j);
				String code= getAttribute(option, "code", "");
				String content = option.getTextContent();
				System.out.println("\t" + code + ")" + content);
			}
		}
		
		
	}
}
