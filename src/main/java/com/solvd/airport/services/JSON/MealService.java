package com.solvd.airport.services.JSON;

import com.solvd.airport.DAO.MealDAO;
import com.solvd.airport.models.Meal;
import com.solvd.airport.utils.ParserDOM;
import org.apache.log4j.Logger;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class MealService {
    private static final Logger LOGGER = Logger.getLogger(MealService.class.getName());
    private MealDAO mealDAO = new MealDAO();
    private ParserDOM parseMeal = new ParserDOM();

    public void getMealFromXML(String xmlFile, String xsdFile) {
        Meal mealFromXML = new Meal();
        try {
            JAXBContext context = JAXBContext.newInstance(Meal.class);
            mealFromXML = (Meal) context.createUnmarshaller().unmarshal(new FileReader(xmlFile));
        } catch (JAXBException | FileNotFoundException e) {
            LOGGER.warn(e.getMessage());
        }
        //bagDAO.create(bagFromXML);

    }
    public void createXML(String xmlFile) {
        Meal meal = new Meal();
        try {
            JAXBContext context = JAXBContext.newInstance(Meal.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(meal, new File(xmlFile));
        } catch (JAXBException e) {
            LOGGER.warn(e.getMessage());
        }
    }
}
