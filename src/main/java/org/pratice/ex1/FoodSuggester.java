package org.pratice.ex1;

import java.util.HashMap;
import java.util.Map;

public class FoodSuggester {

    public String suggest(String country) throws Exception {
        country = country.toLowerCase();

        Map<String, String[]> foodMap =  new HashMap<String, String[]>();
        foodMap.put("korean", new String[] {"불고기", "비빔밥", "김치찌개"});
        foodMap.put("japan", new String[] {"스시", "후토마키", "소바", "돈카츠"});
        foodMap.put("western", new String[] {"갈릭스테이크", "알리오올리오", "고르곤졸라피자", "슈바인학센"});
        foodMap.put("snack", new String[] {"떡볶이", "순대", "감자튀김", "고구마맛탕", "오뎅"});

        String[] arr = foodMap.get(country);

        String menu;

        return menu = arr[(int)(Math.random() * arr.length)];
    }
}
