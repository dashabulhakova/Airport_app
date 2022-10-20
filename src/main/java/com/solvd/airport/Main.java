package com.solvd.airport;

import com.solvd.airport.models.Meal;
import com.solvd.airport.models.Staff;
import com.solvd.airport.services.IStaffService;
import com.solvd.airport.services.JSON.MealService;
import com.solvd.airport.services.MyBatisImpl.StaffService;
import com.solvd.airport.services.jdbcImpl.UserService;
import com.solvd.airport.utils.JsonMapper;
import org.apache.log4j.Logger;

import java.util.List;

public class Main {
    private static final Logger LOGGER = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {
        MealService mealService = new MealService();
        UserService userService = new UserService();
        //create staff with mybatis
        IStaffService staffService = new StaffService();
        Staff newStaff = new Staff(1, "Pilot", 345);
        staffService.createStaff(newStaff);
        //userService.getUserByID(1);
        //LOGGER.info(userService);
        //..mealService.getMealFromXML("src/main/resources/xml/meals.xml", "src/main/resources/xsd/meals.xsd");
        //..mealService.createXML("src/main/resources/xml/meals.xml");

        //bagService.parseDOM("src/main/resources/xsd/bags.xml", "src/main/resources/xml/bags.xsd");
        //LOGGER.info("Bags was parsed succesfully");
        JsonMapper jsonMapper = new JsonMapper();
        List<Meal> mealsList = jsonMapper.readJSON("src/main/resources/json/meals.json", Meal.class);
        jsonMapper.writeJSON(mealsList, "src/main/resources/json/new_meal.json");
        //Read Discount data from Json file
        /*JsonParser jsonParser = new JsonParser();
        List<Discount> discounts = jsonParser.parseJson("src/main/resources/json/discounts.json", Discount.class);
        for (Discount d: discounts) {
            discountService.createDiscount(d);
        }*/

    }
}