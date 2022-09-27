package XML;

import java.util.List;

import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import composition.entities.Category;

public class CategoryXMLUtils extends XMLUtils<Category> {

	public Document format(List<Category> categories) {
		Document document = null;
		try {
			document = create("categories");
			Element element = document.getDocumentElement();
			for (Category category : categories) {
				Element categoryElement = addSingleElement(document, element, "category");
				categoryElement.setAttribute("categoryId", Long.toString(category.getCategoryId()));
				categoryElement.setAttribute("categoryName", category.getCategoryName());
			}
		} catch (ParserConfigurationException e) {
			System.out.println(e.getMessage());
		}

		return document;
	}
	public NodeList getCategoryList(Document document) {
		Element categories = document.getDocumentElement();
		NodeList productList = categories.getElementsByTagName("category");
		return productList;
		
	}

}
