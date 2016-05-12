package problems;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;

/**
 * Created by lucas on 08/05/16.
 */
public class RestaurantTypes {

    public static void main(String[] args) {

        Map<String,String[]> input = new HashMap<String,String[]>();
        input.put("American", new String[]{"Burger", "French fries", "Potato Chips"});
        input.put("Italian", new String[]{"Pizza", "Bread Sticks", "Potato Chips"});

        Map<String,Set<String>> output = new HashMap<String,Set<String>>();

        for (String restaurant:input.keySet()) {
            String[] categoryTypes = input.get(restaurant);
            for (String categoryType: categoryTypes) {
                if (output.containsKey(categoryType)) {
                    output.get(categoryType).add(restaurant);
                } else {
                    Set<String> restaurants = new HashSet<String>();
                    restaurants.add(restaurant);
                    output.put(categoryType, restaurants);
                }
            }
        }


        System.out.println(output.get("Potato Chips"));

    }
}
