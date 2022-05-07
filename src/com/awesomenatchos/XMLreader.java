package com.awesomenatchos;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.FileInputStream;
import java.util.ArrayList;

public class XMLreader {

    public static ArrayList<Users> readUserFromXml(String filepath){
        ArrayList<Users> users = new ArrayList<>();
        try{
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document document = documentBuilder.parse(new FileInputStream(filepath));

            //Getting the class USERS
            Element rootElement = document.getDocumentElement();
            System.out.println("The TAG NAME of root element: " + rootElement.getNodeName());
            /*System.out.println("The node type of root element: " + rootElement.getNodeType());
            System.out.println("The node type of element nodes: " + Node.ELEMENT_NODE);
            System.out.println("The node type of text nodes: " + Node.TEXT_NODE);*/

            // Inherited class PATIENT
            NodeList childrenOfRootElement = rootElement.getChildNodes();       //Now we are getting subclasses (doctors, patiens, family)

            for(int i=0; i < childrenOfRootElement.getLength(); i++){
                Node childNode = childrenOfRootElement.item(i);             //Get instances tag nodes
                //System.out.println(i + ". Child node: " + childNode.getNodeName());             //Print out the patient class
                /*
                System.out.println(i + ". child node: node type is " + childNode.getNodeType()
                                     + ", tag name is " + childNode.getNodeName());*/

                if(childNode.getNodeType() == Node.ELEMENT_NODE){
                    NodeList childrenOfUserTag = childNode.getChildNodes();             //get all the INSTANCES
                    String name = "";
                    int age = 0;
                    int phoneNumber = 0;

                    //Getting the inheritance classes
                    for(int j= 0; j< childrenOfUserTag.getLength(); j++){
                        Node childNodeOfUserTag = childrenOfUserTag.item(j);
                       // System.out.println(childrenOfUserTag.item(j));
                        //System.out.println(childrenNodeOfUserTag.getNodeName() + "  Node type " + childrenNodeOfUserTag.getNodeType());
                        //System.out.println(childrenOfUserTag.item(j));
                        if(childNodeOfUserTag.getNodeType() == Node.ELEMENT_NODE){


                            //Finding attributes patients
                            switch (childNodeOfUserTag.getNodeName()){
                                case "name" -> name = childNodeOfUserTag.getTextContent();
                                case "age" -> age = Integer.parseInt(childNodeOfUserTag.getTextContent());
                                case "phoneNumber" -> phoneNumber = Integer.parseInt((childNodeOfUserTag.getTextContent()));
                            }
                        }
                    }
                    users.add(new Patient(name,age,phoneNumber));
                }
            }

        } catch(Exception e){
            e.printStackTrace();
        }
        return users;
    }


    public static void main(String[] args) {


        String xlm = "src/com/awesomenatchos/Patients.xml";

        ArrayList<Users> allpatients = XMLreader.readUserFromXml(xlm);

        System.out.print(allpatients);


    }

}
