package com.camelsoft.recipemanager.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.support.annotation.NonNull;

import com.camelsoft.recipemanager.database.RecipeEntity;
import com.camelsoft.recipemanager.utilities.SampleData;

import java.util.List;

public class MainViewModel extends AndroidViewModel {

    public List<RecipeEntity> mRecipes = SampleData.getRecipes();

    public MainViewModel(@NonNull Application application) {
        super(application);
    }
}
