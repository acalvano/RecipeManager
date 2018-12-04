package com.camelsoft.recipemanager.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.MutableLiveData;
import android.support.annotation.NonNull;

import com.camelsoft.recipemanager.database.AppRepository;
import com.camelsoft.recipemanager.database.RecipeEntity;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class EditorViewModel extends AndroidViewModel {

    public MutableLiveData<RecipeEntity> mLiveRecipe = new MutableLiveData<>();
    private AppRepository mRepository;
    private Executor executor = Executors.newSingleThreadExecutor();

    public EditorViewModel(@NonNull Application application) {
        super(application);
        mRepository = AppRepository.getInstance(getApplication());
    }

    public void loadData(final int recipeId) {
        executor.execute(new Runnable() {
            @Override
            public void run() {
                RecipeEntity recipe = mRepository.getRecipeById(recipeId);
                mLiveRecipe.postValue(recipe);
            }
        });
    }

    public void saveNote(String recipeText) {
        RecipeEntity recipe = mLiveRecipe.getValue();

        if (recipe == null) {

        } else {
            recipe.setRecipeInstructions(recipeText);
        }
        mRepository.insertRecipe(recipe);

    }
}
