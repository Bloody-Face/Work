import java.sql.*;
import java.net.URL;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.swing.JFrame;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.BorderLayout;

public class Main {
    private static Connection connection;

    static String[] MyFun(String CharCode){
        String[] res = {"Date","Value", CharCode};
        try {
            URL connect = new URL("http://www.cbr.ru/scripts/XML_daily.asp");
            DocumentBuilder documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document document = documentBuilder.parse(connect.openStream());
            res[0] = document.getDocumentElement().getAttribute("Date");
            boolean flag = false;
            Node root = document.getDocumentElement();
            NodeList Lisps = root.getChildNodes();
            for (int i = 0; i < Lisps.getLength(); i++) {
                Node Lisp = Lisps.item(i);
                if (Lisp.getNodeType() != Node.TEXT_NODE) {
                    NodeList bookProps = Lisp.getChildNodes();
                    for(int j = 0; j < bookProps.getLength(); j++) {
                        Node bookProp = bookProps.item(j);
                        if(bookProp.getNodeName() == "CharCode" && CharCode.equals(bookProp.getChildNodes().item(0).getTextContent())){
                            flag = true;
                        }
                        if(bookProp.getNodeName() == "Value" && flag){

                            res[1] = bookProp.getChildNodes().item(0).getTextContent();
                            flag = false;
                        }
                    }
                }
            }



        } catch (ParserConfigurationException ex) {
            ex.printStackTrace(System.out);
        } catch (SAXException ex) {
            ex.printStackTrace(System.out);
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
        }
        return res;
    }
    public static void main(String[] args) {
        //new Main().setVisible(true);
        try{
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection ("jdbc:sqlite:c://Games//my.db");
            //if not exists: CREATE TABLE IF NOT EXISTS MyTable();
        }
       catch (Exception e){
            System.err.println(e.getMessage());
       }
    }
    public Main() {

        /*final Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        setDefaultCloseOperation(this.EXIT_ON_CLOSE);
        setSize(screen.height*3/4,screen.width*3/8);
        setLocationRelativeTo(null);

        MyModel m = new MyModel();
        JTable MyTable = new JTable(m);
        JScrollPane S = new JScrollPane(MyTable);
        getContentPane().add(S , BorderLayout.CENTER);
        m.MyAdd(MyFun("USD"));*/
    }


}
