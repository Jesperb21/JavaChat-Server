package Services;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

public class ReadXMLFile {

    public String ReadXMLFile() {

        String test = "";

        try {
            File inputFile = new File("C:\\File.xml");
            DocumentBuilderFactory dbFactory
                    = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();

            NodeList nList = doc.getElementsByTagName("Properties");

            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    test = eElement.getElementsByTagName("Port").item(0).getTextContent();
                    System.out.println(eElement.getElementsByTagName("Port").item(0).getTextContent());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return test;
    }
}