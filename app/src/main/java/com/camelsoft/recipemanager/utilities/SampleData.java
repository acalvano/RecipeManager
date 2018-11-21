package com.camelsoft.recipemanager.utilities;

import com.camelsoft.recipemanager.database.RecipeEntity;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

public class SampleData {

    private static final String RECIPE_NAME_1 = "first recipe";
    private static final int RECIPE_SERVINGS_1 = 2;
    private static final String RECIPE_CATEGORY_1 = "lunch";
    private static final int RECIPE_YIELD_1 = 2;
    private static final String RECIPE_YIELD_UNITS_1 = "cups";
    private static final String RECIPE_INSTRUCTIONS_1 = "simple instructions";

    private static final String RECIPE_NAME_2 = "second recipe";
    private static final int RECIPE_SERVINGS_2 = 2;
    private static final String RECIPE_CATEGORY_2 = "lunch";
    private static final int RECIPE_YIELD_2 = 2;
    private static final String RECIPE_YIELD_UNITS_2 = "cups";
    private static final String RECIPE_INSTRUCTIONS_2 = "more simple instructions with a\nline feed";

    private static final String RECIPE_NAME_3 = "third recipe";
    private static final int RECIPE_SERVINGS_3 = 2;
    private static final String RECIPE_CATEGORY_3 = "lunch";
    private static final int RECIPE_YIELD_3 = 2;
    private static final String RECIPE_YIELD_UNITS_3 = "cups";
    private static final String RECIPE_INSTRUCTIONS_3 = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Morbi augue ," +
            "\n" +
            " euismod id nisi eu, pellentesque venenatis nisl. Duis ut est id nisi pellentesque scelerisque. Ut id sem in ," +
            "\n" +
            "vehicula dapibus. Sed condimentum viverra ipsum eu facilisis. Aliquam porta, tortor eu pretium ultricies, purus ," +
            "\n" +
            "lacinia sapien, eu rhoncus risus orci sed neque. Phasellus mollis felis ac purus congue, et mattis odio rutrum. ," +
            "\n" +
            " sed eleifend arcu. Nulla aliquet magna ut ante lobortis, in convallis lorem laoreet.";



    private static Date getDate(int diff) {
        GregorianCalendar cal = new GregorianCalendar();
        cal.add(Calendar.MILLISECOND, diff);
        return cal.getTime();
    }

    public static List<RecipeEntity> getRecipes() {
        List<RecipeEntity> recipes = new ArrayList<>();
        recipes.add(new RecipeEntity(getDate(0), RECIPE_NAME_1, RECIPE_SERVINGS_1, RECIPE_CATEGORY_1,
                RECIPE_YIELD_1, RECIPE_YIELD_UNITS_1, RECIPE_INSTRUCTIONS_1));
        recipes.add(new RecipeEntity(getDate(-1), RECIPE_NAME_2, RECIPE_SERVINGS_2, RECIPE_CATEGORY_2,
                RECIPE_YIELD_2, RECIPE_YIELD_UNITS_2, RECIPE_INSTRUCTIONS_2));
        recipes.add(new RecipeEntity(getDate(-2), RECIPE_NAME_3, RECIPE_SERVINGS_3, RECIPE_CATEGORY_3,
                RECIPE_YIELD_3, RECIPE_YIELD_UNITS_3, RECIPE_INSTRUCTIONS_3));
        return recipes;
    }
}
