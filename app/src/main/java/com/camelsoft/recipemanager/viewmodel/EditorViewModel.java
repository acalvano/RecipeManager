package com.camelsoft.recipemanager.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.MutableLiveData;
import android.support.annotation.NonNull;

import com.camelsoft.recipemanager.database.AppRepository;
import com.camelsoft.recipemanager.database.RecipeEntity;

public class EditorViewModel extends AndroidViewModel {

    public MutableLiveData<RecipeEntity> mLiveRecipe = new MutableLiveData<>();
    private AppRepository mRepository;

    public EditorViewModel(@NonNull Application application) {
        super(application);
        mRepository = AppRepository.getInstance(getApplication());
    }
}
