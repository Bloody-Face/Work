
import java.net.URL;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;


public class Main {
    static void MyFun(){
        try {
            URL connect = new URL("http://www.cbr.ru/scripts/XML_daily.asp");
            DocumentBuilder documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document document = documentBuilder.parse(connect.openStream());


            System.out.println(document.getPrefix());
            System.out.println(document.getElementsByTagName("Date"));

            Node root = document.getDocumentElement();
            System.out.println("Курс валют:");
            System.out.println();



            //NodeList Lisps = root.getChildNodes();
            /*for (int i = 0; i < Lisps.getLength(); i++) {
                Node Lisp = Lisps.item(i);
                if (Lisp.getNodeType() != Node.TEXT_NODE) {
                    NodeList bookProps = Lisp.getChildNodes();
                    for(int j = 0; j < bookProps.getLength(); j++) {
                        Node bookProp = bookProps.item(j);
                        if (bookProp.getNodeType() != Node.TEXT_NODE) {
                            System.out.println(bookProp.getNodeName() + ":" + bookProp.getChildNodes().item(0).getTextContent());
                        }
                    }
                    System.out.println("===========>>>>");
                }
            }*/


        } catch (ParserConfigurationException ex) {
            ex.printStackTrace(System.out);
        } catch (SAXException ex) {
            ex.printStackTrace(System.out);
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
        }

    }
    public static void main(String[] args) {
        System.out.println("Hello world!");
        int S = 2;
        int f = S + 10;
        System.err.println(f);
        MyFun();
    }

}
