package com.camelsoft.recipemanager.ui;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.camelsoft.recipemanager.EditorActivity;
import com.camelsoft.recipemanager.R;
import com.camelsoft.recipemanager.database.RecipeEntity;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.camelsoft.recipemanager.utilities.Constants.RECIPE_ID_KEY;

public class RecipesAdapter extends RecyclerView.Adapter<RecipesAdapter.ViewHolder> {

    private final List<RecipeEntity> mRecipes;
    private final Context mContext;

    public RecipesAdapter(List<RecipeEntity> mRecipes, Context mContext) {
        this.mRecipes = mRecipes;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.recipe_list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final RecipeEntity recipe = mRecipes.get(position);
        holder.mName.setText(recipe.getRecipeName());
        String summary;
        summary = "Servings: " + recipe.getRecipeServings() + " Yield: " + recipe.getRecipeYield();
        holder.mSummary.setText(summary);
        holder.mCategory.setText(recipe.getRecipeCategory());

        holder.mFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext, EditorActivity.class);
                intent.putExtra(RECIPE_ID_KEY, recipe.getId());
                mContext.startActivity(intent);

            }
        });



    }

    @Override
    public int getItemCount() {
        return mRecipes.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.name)
        TextView mName;

        @BindView(R.id.summary)
        TextView mSummary;

        @BindView(R.id.category)
        TextView mCategory;

        @BindView(R.id.fab)
        FloatingActionButton mFab;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
