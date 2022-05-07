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

            Element rootElement = document.getDocumentElement();

            NodeList childrenOfRootElement = rootElement.getChildNodes();       //Now we are getting subclasses (doctors, patiens, family)

            for(int i=0; i < childrenOfRootElement.getLength(); i++){
                Node childNode = childrenOfRootElement.item(i);             //Get a child node object  User tag
                //System.out.println(i + ". Childnode: " + childNode.getNodeName());

                if(childNode.getNodeType() == Node.ELEMENT_NODE){
                    NodeList childrenOfUserTag = childNode.getChildNodes();             //get all the children nodes from user tag
                    String name = "";
                    int age = 0;
                    int doctorID = 0;
                    int phoneNumber = 0;


                    //Getting the inheritance classes
                    for(int j= 0; j< childrenOfUserTag.getLength(); j++){
                        Node childrenNodeOfUserTag = childrenOfUserTag.item(j);
                        if(childrenNodeOfUserTag.getNodeType() == Node.ELEMENT_NODE){

                            //Finding attributes from doctors, patients and family
                            switch (childrenNodeOfUserTag.getNodeName()){
                                case "name" -> name = childrenNodeOfUserTag.getTextContent();
                                case "age" -> age = Integer.parseInt(childrenNodeOfUserTag.getTextContent());
                                case "doctorID" -> doctorID = Integer.parseInt(childrenNodeOfUserTag.getTextContent());
                                case "phoneNumber" -> phoneNumber = Integer.parseInt(childrenNodeOfUserTag.getTextContent());



                            }
                        }

                    }
                    users.add(new Users(name,age));


                }
            }

        } catch(Exception e){
            e.printStackTrace();
        }
        return users;
    }

}
