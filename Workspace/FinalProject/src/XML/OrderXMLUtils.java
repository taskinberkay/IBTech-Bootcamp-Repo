package XML;

import java.util.List;

import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import composition.entities.Order;

public class OrderXMLUtils extends XMLUtils<Order>{
	
	public Document format(List<Order> order){
		Document document = null;
		try {
			document = create("order");
			return document;
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Element element = document.getDocumentElement();
		return document;
	}


}
