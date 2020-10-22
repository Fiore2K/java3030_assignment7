package edu.uml.kfiore.apps;

import edu.uml.kfiore.xml.Stock;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;

/**
 * A basic app that shows how to marshall and unmarshal XML instances.
 */
public class BasicJAXB {

    private static String xmlInstance ="<stock>\n" +
            "    <symbol=> VNET </symbol>\n" +
            "    <price=> 110.10 </price>\n" +
            "    <time= > 2015-02-10 00:00:01 </time>\n" +
            "</stock>";


    public static void main(String[] args) throws JAXBException {

        // here is how to go from XML to Java
        JAXBContext jaxbContext = JAXBContext.newInstance(Stock.class);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        Stock stock = (Stock) unmarshaller.unmarshal(new StringReader(xmlInstance));
        System.out.println(stock.toString());

        // here is how to go from Java to XML
        JAXBContext context = JAXBContext.newInstance(Stock.class);
        Marshaller marshaller = context.createMarshaller();
        //for pretty-print XML in JAXB
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        marshaller.marshal(stock, System.out);

    }
}

