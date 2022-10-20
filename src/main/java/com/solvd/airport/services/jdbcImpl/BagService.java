package com.solvd.airport.services.jdbcImpl;

import com.solvd.airport.DAO.BagDAO;
import com.solvd.airport.models.Bag;
import com.solvd.airport.services.IBagService;
import com.solvd.airport.utils.ParserDOM;
import org.apache.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class BagService implements IBagService {
    private static final Logger LOGGER = Logger.getLogger(BagService.class.getName());
    private BagDAO bagDAO = new BagDAO();
    private ParserDOM parseBag = new ParserDOM();

    @Override
    public void createBag(Bag b) {
        this.bagDAO.create(b);
    }

    @Override
    public void parseDOM(String xmlFile, String xsdFile) {
        parseBag.validate(xmlFile);
        Document doc = parseBag.validate(xsdFile);
        NodeList list = doc.getElementsByTagName("bag");
        for (int i = 0; i < list.getLength(); i++) {
            Node node = list.item(i);
            if (node.getNodeType() == node.ELEMENT_NODE) {
                Element element = (Element) node;
                Bag b = new Bag();
                b.setId(Integer.parseInt(element.getAttribute("id")));
                b.setAmount(Integer.parseInt(element.getElementsByTagName("amount").item(0).getTextContent()));
                b.setSize(Integer.parseInt(element.getElementsByTagName("size").item(0).getTextContent()));
                b.setWeight(Integer.parseInt(element.getElementsByTagName("weight").item(0).getTextContent()));
            }
        }
    }

    @Override
    public void getBagFromXML(String xsdFile, String xmlFile) {
        Bag bagFromXML = new Bag();
        try {
            JAXBContext context = JAXBContext.newInstance(Bag.class);
            bagFromXML = (Bag) context.createUnmarshaller().unmarshal(new FileReader(xmlFile));
        } catch (JAXBException | FileNotFoundException e) {
            LOGGER.warn(e.getMessage());
        }
        //bagDAO.create(bagFromXML);

    }
    @Override
    public void createXML(String xmlFile) {
        Bag bag = new Bag();
        try {
            JAXBContext context = JAXBContext.newInstance(Bag.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(bag, new File(xmlFile));
        } catch (JAXBException e) {
            LOGGER.warn(e.getMessage());
        }
    }
}
