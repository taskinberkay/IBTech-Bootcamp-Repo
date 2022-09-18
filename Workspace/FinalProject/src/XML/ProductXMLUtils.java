package XML;

import java.util.List;

import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import composition.entities.Product;

public class ProductXMLUtils extends XMLUtils<Product> {

	public Document format(List<Product> products) {
		Document document = null;
		try {
			document = create("products");
			Element element = document.getDocumentElement();
			for (Product product : products) {
				Element productElement = addSingleElement(document, element, "product");
				productElement.setAttribute("productId", Long.toString(product.getProductId()));
				productElement.setAttribute("productName", product.getProductName());
				productElement.setAttribute("categoryId", Long.toString(product.getCategoryId()));
				productElement.setAttribute("salesPrice", Double.toString(product.getSalesPrice()));
				productElement.setAttribute("imgPath", product.getImgPath());
			}
		} catch (ParserConfigurationException e) {
			System.out.println(e.getMessage());
			;
		}

		return document;
	}

}
