package utils;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;

public class ParserDOM {
    private static final Logger LOGGER = Logger.getLogger(ParserDOM.class.getName());
        Document doc;
        Schema schema;
        public void getSchema(String filename) {
            try {
                SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
                // load a WXS schema, represented by a Schema instance
                schema = factory.newSchema(new File(filename));
            } catch (SAXException e) {
                LOGGER.warn(e.getMessage());
            }
        }
    public Document readXML(String filename) {
        try {
            File file = FileUtils.getFile("DOMFile.txt");
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            doc = db.parse((file));
            // create a Validator instance to validate an instance document
            Validator validator = schema.newValidator();

            // validate the DOM tree
            try {
                validator.validate(new DOMSource(doc));
            } catch (SAXException e) {
                LOGGER.warn(e.getMessage() + "instance document is invalid");
            }
        } catch (Exception e) {
            LOGGER.warn(e.getMessage() + "can't parse a document");
            return null;
        }
        return doc;
    }
}
