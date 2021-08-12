package com.camelsoft.recipemanager;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;

import com.camelsoft.recipemanager.database.RecipeEntity;
import com.camelsoft.recipemanager.viewmodel.EditorViewModel;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.camelsoft.recipemanager.utilities.Constants.EDITING_KEY;
import static com.camelsoft.recipemanager.utilities.Constants.RECIPE_ID_KEY;

public class EditorActivity extends AppCompatActivity {

    @BindView(R.id.recipe_text)
    TextView mTextView;

    private EditorViewModel mViewModel;
    private boolean mNewRecipe, mEditing;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editor);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_check);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        ButterKnife.bind(this);

        if (savedInstanceState != null) {
            mEditing = savedInstanceState.getBoolean(EDITING_KEY);
        }

        initViewModel();
    }

    private void initViewModel() {
        mViewModel = ViewModelProviders.of(this)
                .get(EditorViewModel.class);

        mViewModel.mLiveRecipe.observe(this, new Observer<RecipeEntity>() {
            @Override
            public void onChanged(@Nullable RecipeEntity recipeEntity) {
                if (recipeEntity != null && !mEditing) {
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
    public boolean onCreateOptionsMenu(Menu menu) {
        if (!mNewRecipe) {
            MenuInflater inflater = getMenuInflater();
            inflater.inflate(R.menu.menu_editor, menu);
        }
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            saveAndReturn();
            return true;
        } else if (item.getItemId() == R.id.action_delete) {
            mViewModel.deleteRecipe();
            finish();
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

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putBoolean(EDITING_KEY, true);
        super.onSaveInstanceState(outState);
    }
}