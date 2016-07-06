package projects.bryang8.com.recipes.main.ui;

import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import projects.bryang8.com.recipes.FacebookRecipesApp;
import projects.bryang8.com.recipes.R;
import projects.bryang8.com.recipes.entities.Recipe;
import projects.bryang8.com.recipes.lib.base.ImageLoader;
import projects.bryang8.com.recipes.main.RecipeMainPresenter;

public class RecipesMainActivity extends AppCompatActivity implements RecipeMainView{
    @Bind(R.id.imgRecipe)
    ImageView imgRecipe;

    @Bind(R.id.imgKeep)
    ImageButton btnKeep;

    @Bind(R.id.imgDismiss)
    ImageButton btnDismiss;

    @Bind(R.id.progressBar)
    ProgressBar progressBar;

    @Bind(R.id.layoutContainer)
    RelativeLayout container;

    private Recipe currentRecipe;
    private ImageLoader imageLoader;
    private RecipeMainPresenter presenter;
    //private RecipeMainComponent component;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipes_main);
        ButterKnife.bind(this);

        setupInjection();
        //setupImageLoading();
        //setupGestureDetection();

        presenter.onCreate();
        presenter.getNextRecipe();
    }

    @Override
    protected void onDestroy() {
        presenter.onDestroy();
        super.onDestroy();
    }

    private void setupInjection() {
        FacebookRecipesApp app = (FacebookRecipesApp)getApplication();

    }

    @Override
    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void showUIElements() {
        btnKeep.setVisibility(View.VISIBLE);
        btnDismiss.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideUIElements() {
        btnKeep.setVisibility(View.GONE);
        btnDismiss.setVisibility(View.GONE);
    }

    @Override
    public void saveAnimation() {

    }

    @Override
    public void dismissAnimation() {

    }

    @Override
    public void onRecipeSaved() {
        Snackbar.make(container, R.string.recipemain_notice_saved, Snackbar.LENGTH_SHORT).show();
    }

    @Override
    public void setRecipe(Recipe recipe) {
        this.currentRecipe = recipe;
        imageLoader.load(imgRecipe, recipe.getImageURL());
    }

    @Override
    public void onGetRecipeError(String error) {
        String msgError = String.format(getString(R.string.recipemain_error), error);
        Snackbar.make(container, msgError, Snackbar.LENGTH_SHORT).show();
    }

    @OnClick(R.id.imgKeep)
    public void onKeep() {
        if (currentRecipe != null) {
            presenter.saveRecipe(currentRecipe);
        }
    }

    @OnClick(R.id.imgDismiss)
    public void onDismiss() {
        presenter.dismissRecipe();
    }
}
