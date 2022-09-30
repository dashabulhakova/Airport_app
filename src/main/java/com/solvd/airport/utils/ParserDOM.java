package com.solvd.airport.utils;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Source;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.IOException;

public class ParserDOM {
    private static final Logger LOGGER = Logger.getLogger(ParserDOM.class.getName());

    public Document validate(String filename) {
        /*Schema schema = null;
        Document doc;
        try {
            SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            schema = factory.newSchema(new File(filename));
        } catch (Exception e) {
            LOGGER.warn(e.getMessage() + "can't load schema");
        }
        try {
            File file = FileUtils.getFile(filename);
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            dbf.setNamespaceAware(true);
            DocumentBuilder parser = dbf.newDocumentBuilder();
            doc = parser.parse((file));

            try {
                Validator validator = schema.newValidator();
                validator.validate(new DOMSource(doc));
            } catch (Exception e) {
                LOGGER.warn(e.getMessage() + "instance document is invalid");
            }
        } catch (Exception e) {
            LOGGER.warn(e.getMessage() + "can't parse a document");
            return null;
        }*/
        // parse an XML document into a DOM tree
        Document document = null;
        try {
            DocumentBuilder parser = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            document = parser.parse(new File("src/main/resources/xml/bags.xml"));
        } catch (SAXException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }  catch (ParserConfigurationException e) {
        throw new RuntimeException(e);
    }

        // create a SchemaFactory capable of understanding WXS schemas
        SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);

        // load a WXS schema, represented by a Schema instance
        Source schemaFile = new StreamSource(new File("src/main/resources/xsd/bags.xsd"));
        Schema schema = null;
        try {
            schema = factory.newSchema(schemaFile);
        } catch (SAXException e) {
            throw new RuntimeException(e);
        }

        // create a Validator instance, which can be used to validate an instance document
        Validator validator = schema.newValidator();

        // validate the DOM tree
        try {
            validator.validate(new DOMSource(document));
        } catch (SAXException | IOException e) {
            // instance document is invalid!
        }
        return document;
    }
}

