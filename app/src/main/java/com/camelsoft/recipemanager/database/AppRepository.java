package com.camelsoft.recipemanager.database;

import com.camelsoft.recipemanager.utilities.SampleData;

import java.util.List;

public class AppRepository {
    private static final AppRepository ourInstance = new AppRepository();

    public List<RecipeEntity> mRecipes;

    public static AppRepository getInstance() {
        return ourInstance;
    }

    private AppRepository() {
        mRecipes = SampleData.getRecipes();
    }
}
