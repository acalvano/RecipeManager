package com.camelsoft.recipemanager;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import com.camelsoft.recipemanager.database.RecipeEntity;
import com.camelsoft.recipemanager.viewmodel.EditorViewModel;

import butterknife.BindView;
import butterknife.ButterKnife;

public class EditorActivity extends AppCompatActivity {

    @BindView(R.id.recipe_text)
    TextView mTextView;

    private EditorViewModel mViewModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editor);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        ButterKnife.bind(this);

        initViewModel();
    }

    private void initViewModel() {
        mViewModel = ViewModelProviders.of(this)
                .get(EditorViewModel.class);

        mViewModel.mLiveRecipe.observe(this, new Observer<RecipeEntity>() {

            @Override
            public void onChanged(@Nullable RecipeEntity recipeEntity) {
                if (recipeEntity != null) {
                    mTextView.setText(recipeEntity.getRecipeInstructions());
                }
            }
        });
    }
}