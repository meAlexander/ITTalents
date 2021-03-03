package xml;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DemoReading {
    public static void main(String[] args) {
        File xmlFile = new File("employee.xml");
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(xmlFile);
            System.out.println("Root element : " + doc.getDocumentElement().getNodeName());
            NodeList nodeList = doc.getElementsByTagName("Employee");
            //now XML is loaded as Document in memory, lets convert it to Object List
            List<Employee> empList = new ArrayList<>();
            for (int i = 0; i < nodeList.getLength(); i++) {
                empList.add(getEmployee(nodeList.item(i)));
            }
            //lets print Employee list information
            for (Employee emp : empList) {
                System.out.println(emp.toString());
            }
        } catch (ParserConfigurationException | IOException | org.xml.sax.SAXException e1) {
            e1.printStackTrace();
        }
    }

    private static Employee getEmployee(Node node) {
        //XMLReaderDOM domReader = new XMLReaderDOM();
        Employee emp = new Employee();
        if (node.getNodeType() == Node.ELEMENT_NODE) {
            Element element = (Element) node;
            emp.setName(getTagValue("name", element));
            emp.setAge(Integer.parseInt(getTagValue("age", element)));
            emp.setGender(getTagValue("gender", element));
            emp.setRole(getTagValue("role", element));
        }
        return emp;
    }

    private static String getTagValue(String tag, Element element) {
        //NodeList nodeList = element.getElementsByTagName(tag).item(0).getChildNodes();
        Node node2 = element.getElementsByTagName(tag).item(0).getFirstChild();
        //Node node = nodeList.item(0);
        return node2.getNodeValue();
    }
}