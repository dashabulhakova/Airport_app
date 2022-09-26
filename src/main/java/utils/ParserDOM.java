package utils;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.w3c.dom.Document;

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

    public Document validate(String filename) {
        Schema schema = null;
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
            DocumentBuilder db = dbf.newDocumentBuilder();
            doc = db.parse((file));

            try {
                Validator validator = schema.newValidator();
                validator.validate(new DOMSource(doc));
            } catch (Exception e) {
                LOGGER.warn(e.getMessage() + "instance document is invalid");
            }
        } catch (Exception e) {
            LOGGER.warn(e.getMessage() + "can't parse a document");
            return null;
        }
        return doc;
    }
}

