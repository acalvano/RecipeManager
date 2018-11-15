package com.camelsoft.recipemanager.model;

import java.util.Date;

public class RecipeEntity {
    private int     id;
    private Date    date;
    private String  recipeName;
    private int     recipeServings;
    private String  recipeCategory;
    private int     recipeYield;
    private int     recipeYieldUnits;
    private String  recipeInstructions;

    public RecipeEntity() {
    }

    public RecipeEntity(int id, Date date, String recipeName, int recipeServings,
                        String recipeCategory, int recipeYield, int recipeYieldUnits, String recipeInstructions) {
        this.id = id;
        this.date = date;
        this.recipeName = recipeName;
        this.recipeServings = recipeServings;
        this.recipeCategory = recipeCategory;
        this.recipeYield = recipeYield;
        this.recipeYieldUnits = recipeYieldUnits;
        this.recipeInstructions = recipeInstructions;
    }

    public RecipeEntity(Date date, String recipeName, int recipeServings,
                        String recipeCategory, int recipeYield, int recipeYieldUnits, String recipeInstructions) {
        this.date = date;
        this.recipeName = recipeName;
        this.recipeServings = recipeServings;
        this.recipeCategory = recipeCategory;
        this.recipeYield = recipeYield;
        this.recipeYieldUnits = recipeYieldUnits;
        this.recipeInstructions = recipeInstructions;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getRecipeName() {
        return recipeName;
    }

    public void setRecipeName(String recipeName) {
        this.recipeName = recipeName;
    }

    public int getRecipeServings() {
        return recipeServings;
    }

    public void setRecipeServings(int recipeServings) {
        this.recipeServings = recipeServings;
    }

    public String getRecipeCategory() {
        return recipeCategory;
    }

    public void setRecipeCategory(String recipeCategory) {
        this.recipeCategory = recipeCategory;
    }

    public int getRecipeYield() {
        return recipeYield;
    }

    public void setRecipeYield(int recipeYield) {
        this.recipeYield = recipeYield;
    }

    public int getRecipeYieldUnits() {
        return recipeYieldUnits;
    }

    public void setRecipeYieldUnits(int recipeYieldUnits) {
        this.recipeYieldUnits = recipeYieldUnits;
    }

    public String getRecipeInstructions() {
        return recipeInstructions;
    }

    public void setRecipeInstructions(String recipeInstructions) {
        this.recipeInstructions = recipeInstructions;
    }

    @Override
    public String toString() {
        return "RecipeEntity{" +
                "id=" + id +
                ", date=" + date +
                ", recipeName='" + recipeName + '\'' +
                ", recipeServings=" + recipeServings +
                ", recipeCategory='" + recipeCategory + '\'' +
                ", recipeYield=" + recipeYield +
                ", recipeYieldUnits=" + recipeYieldUnits +
                ", recipeInstructions='" + recipeInstructions + '\'' +
                '}';
    }
}
