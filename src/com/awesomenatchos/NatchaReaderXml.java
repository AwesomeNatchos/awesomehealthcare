package com.awesomenatchos;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.FileInputStream;
import java.util.ArrayList;

public class NatchaReaderXml {

    public static ArrayList<Users> readUserFromXMl(String filepath){

        ArrayList<Users> allUsers = new ArrayList<>();
        try{
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document document = documentBuilder.parse(new FileInputStream(filepath));

            // It gets the list of all patients nodes
           NodeList root = document.getElementsByTagName("patient");
           for (int i=0; i< root.getLength(); i++) {
               Node node = root.item(i);
               if (node.getNodeType() == Node.ELEMENT_NODE) {
                   Element element = (Element) node; // Here just casting the node into Element, because node does not have

                   //System.out.println(((Element) node).getElementsByTagName());
                   //System.out.println(((Element) node).getElementsByTagName("name").item(0).getTextContent());

                   String firstname = ((Element) element.getElementsByTagName("name").item(0)).getElementsByTagName("first").item(0).getTextContent();

                   String lastname = ((Element) element.getElementsByTagName("name").item(0)).getElementsByTagName("last").item(0).getTextContent();

                   System.out.println(firstname);
                   System.out.println(lastname);

                   System.out.println(element.getElementsByTagName("age").item(0).getTextContent());
                   System.out.println(element.getElementsByTagName("phoneNumber").item(0).getTextContent());
               }

               System.out.println("");

           }



        } catch (Exception e){
            e.printStackTrace();
        }
        return allUsers;
    }

    public static void main(String[] args) {
        ArrayList< Users> allusers = new ArrayList<>();
        String filepath = "src/com/awesomenatchos/Patients.xml";
        readUserFromXMl(filepath);
    }
}
