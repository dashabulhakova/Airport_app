package com.solvd.airport;

import com.solvd.airport.services.MealService;
import com.solvd.airport.services.jdbcImpl.UserService;
import org.apache.log4j.Logger;
import com.solvd.airport.services.BagService;

public class Main {
    private static final Logger LOGGER = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {
        MealService mealService = new MealService();
        UserService userService = new UserService();
        //userService.createUser(new User(1, "Jon", "Doe", "jon@mail.com"));
        //userService.getUserByID(1);
        //LOGGER.info(userService);
        mealService.getMealFromXML("src/main/resources/xml/meals.xml", "src/main/resources/xsd/meals.xsd");
        mealService.createXML("src/main/resources/xml/meals.xml");

        //bagService.parseDOM("src/main/resources/xsd/bags.xml", "src/main/resources/xml/bags.xsd");
        //LOGGER.info("Bags was parsed succesfully");
    }
}