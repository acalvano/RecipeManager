package com.camelsoft.recipemanager;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.TextView;

import com.camelsoft.recipemanager.database.RecipeEntity;
import com.camelsoft.recipemanager.viewmodel.EditorViewModel;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.camelsoft.recipemanager.utilities.Constants.RECIPE_ID_KEY;

public class EditorActivity extends AppCompatActivity {

    @BindView(R.id.recipe_text)
    TextView mTextView;

    private EditorViewModel mViewModel;
    private boolean mNewRecipe;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editor);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_check);
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

        Bundle extras = getIntent().getExtras();
        if (extras == null) {
            setTitle(R.string.new_recipe);
            mNewRecipe = true;


        } else {
            setTitle(R.string.edit_recipe);
            int recipeId = extras.getInt(RECIPE_ID_KEY);
            mViewModel.loadData(recipeId);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            saveAndReturn();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {

        saveAndReturn();
    }

    private void saveAndReturn() {
        mViewModel.saveNote(mTextView.getText().toString());
        finish();
    }
}