package com.awesomenatchos;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class XMLwriter {

    private static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        String filepath = "src/com/awesomenatchos/Users.xml";
        ArrayList<Users> allusers = XMLreader.readUserFromXml(filepath);

        // menu system of the application with create, read, update and delete options
        int choice = -1;
        while (choice != 0) {
            System.out.println(" 1. List users");
            System.out.println(" 2. Add new users");
            System.out.println(" 3. Modify user");
            System.out.println(" 4. Delete users");

            try {
                choice = scan.nextInt();
                scan.nextLine();
                if (choice < 0 || 4 < choice) {
                    System.out.println("Not valid option.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Not valid option.");
                scan.nextLine();
            }
            switch (choice) {
                case 1 -> System.out.println(allusers);
                //case 2 -> addNewUser(allusers);
               // case 3 -> modifyUser(allusers);
               // case 4 -> deleteUser(allusers);
            }
        }saveUsersToXml(allusers, filepath);




    }

    public static void saveUsersToXml(ArrayList<Users> users, String filepath) {
        try {
            Document document = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();

            Element rootElement = document.createElement("users");
            document.appendChild(rootElement);

            for (Users user : users) {
                Element userElement = document.createElement("user");
                rootElement.appendChild(userElement);
                createChildElement(document, userElement, "name", user.getName());
                createChildElement(document, userElement, "age", String.valueOf(user.getAge()));
                createChildElement(document, userElement, "doctorID", String.valueOf(user.getAge()));
                createChildElement(document, userElement, "phoneNumber", String.valueOf(user.getAge()));
            }

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();

            DOMSource source = new DOMSource(document);

            StreamResult result = new StreamResult(new FileOutputStream(filepath));

            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.transform(source, result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void createChildElement(Document document, Element parent, String tagName, String value) {
        Element element = document.createElement(tagName);
        element.setTextContent(value);
        parent.appendChild(element);
    }
}
