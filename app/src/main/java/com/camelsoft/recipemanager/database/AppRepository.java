package com.camelsoft.recipemanager.database;

import android.arch.lifecycle.LiveData;
import android.content.Context;

import com.camelsoft.recipemanager.utilities.SampleData;

import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class AppRepository {
    private static AppRepository ourInstance;

    public LiveData<List<RecipeEntity>> mRecipes;
    private AppDatabase mDb;
    private Executor executor = Executors.newSingleThreadExecutor();

    public static AppRepository getInstance(Context context) {
        if (ourInstance == null) {
            ourInstance = new AppRepository(context);
        }

        return ourInstance;
    }

    private AppRepository(Context context) {
        mDb = AppDatabase.getInstance(context);
        mRecipes = getAllRecipes();
    }

    public void addSampleData() {
        executor.execute(new Runnable() {
            @Override
            public void run() {
                mDb.recipeDao().insertAll(SampleData.getRecipes());
            }
        });
    }

    private LiveData<List<RecipeEntity>> getAllRecipes() {
        return mDb.recipeDao().getAll();
    }

    public void deleteAllRecipes() {
        executor.execute(new Runnable() {
            @Override
            public void run() {
                mDb.recipeDao().deleteAll();
            }
        });
    }

    public RecipeEntity getRecipeById(int recipeId) {
        return mDb.recipeDao().getRecipeById(recipeId);
    }

    public void insertRecipe(final RecipeEntity recipe) {
        executor.execute(new Runnable() {
            @Override
            public void run() {
                mDb.recipeDao().insertRecipe(recipe);
            }
        });
    }

    public void deleteRecipe(final RecipeEntity recipe) {
        executor.execute(new Runnable() {
            @Override
            public void run() {
                mDb.recipeDao().deleteRecipe(recipe);
            }
        });
    }
}
