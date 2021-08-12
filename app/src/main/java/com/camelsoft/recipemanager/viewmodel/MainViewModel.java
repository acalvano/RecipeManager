package com.camelsoft.recipemanager.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import com.camelsoft.recipemanager.database.AppRepository;
import com.camelsoft.recipemanager.database.RecipeEntity;

import java.util.List;

public class MainViewModel extends AndroidViewModel {

    public LiveData<List<RecipeEntity>> mRecipes;
    private AppRepository mRepository;

    public MainViewModel(@NonNull Application application) {
        super(application);

        mRepository = AppRepository.getInstance(application.getApplicationContext());
        mRecipes = mRepository.mRecipes;
    }

    public void addSampleData() { mRepository.addSampleData(); }

    public void deleteAllRecipes() {
        mRepository.deleteAllRecipes();
    }
}
