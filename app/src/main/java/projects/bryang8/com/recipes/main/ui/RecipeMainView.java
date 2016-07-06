package projects.bryang8.com.recipes.main.ui;

import projects.bryang8.com.recipes.entities.Recipe;

/**
 * Created by bryan_g8 on 6/07/16.
 */
public interface RecipeMainView {
    void showProgress();
    void hideProgress();
    void showUIElements();
    void hideUIElements();
    void saveAnimation();
    void dismissAnimation();

    void onRecipeSaved();
    void setRecipe(Recipe recipe);
    void onGetRecipeError(String error);
}