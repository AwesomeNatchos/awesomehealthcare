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

            //Getting the class USERS
            Element rootElement = document.getDocumentElement();
            //System.out.println("The TAG NAME of root element: " + rootElement.getNodeName());

            //Inherited class PATIENT
            NodeList childrenOfRootElement = rootElement.getElementsByTagName("patient");
            for(int i=0; i < childrenOfRootElement.getLength(); i++){
                Node childNode = childrenOfRootElement.item(i);
                System.out.println(childNode.getNodeType());
                Element element = (Element)childNode;

                if(childNode.getNodeType() == Node.ELEMENT_NODE){
                    System.out.println(((Element) childNode).getTextContent());
                    System.out.println("" + element.getAttributeNode("name").getTextContent());
                }

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
