package com.camelsoft.recipemanager.database;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface RecipeDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertRecipe(RecipeEntity recipeEntity);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(List<RecipeEntity> recipes);

    @Delete
    void deleteRecipe(RecipeEntity recipeEntity);

    @Query("SELECT * FROM recipes WHERE id = :id")
    RecipeEntity getRecipeById(int id);

    @Query("SELECT * FROM recipes ORDER BY date DESC")
    LiveData<List<RecipeEntity>> getAll();

    @Query("DELETE FROM recipes")
    int deleteAll();

    @Query("SELECT COUNT(*) FROM recipes")
    int getCount();

}
