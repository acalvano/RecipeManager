package com.camelsoft.recipemanager.database;

import android.content.Context;

import com.camelsoft.recipemanager.utilities.SampleData;

import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class AppRepository {
    private static AppRepository ourInstance;

    public List<RecipeEntity> mRecipes;
    private AppDatabase mDb;
    private Executor executor = Executors.newSingleThreadExecutor();

    public static AppRepository getInstance(Context context) {
        if (ourInstance == null) {
            ourInstance = new AppRepository(context);
        }

        return ourInstance;
    }

    private AppRepository(Context context) {
        mRecipes = SampleData.getRecipes();
        mDb = AppDatabase.getInstance(context);
    }

    public void addSampleData() {
        executor.execute(new Runnable() {
            @Override
            public void run() {
                mDb.recipeDao().insertAll(SampleData.getRecipes());
            }
        });

    }
}
