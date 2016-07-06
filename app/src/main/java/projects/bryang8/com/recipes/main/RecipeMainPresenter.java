package projects.bryang8.com.recipes.main;

import projects.bryang8.com.recipes.entities.Recipe;
import projects.bryang8.com.recipes.events.RecipeMainEvent;
import projects.bryang8.com.recipes.main.ui.RecipeMainView;

/**
 * Created by bryan_g8 on 6/07/16.
 */
public interface RecipeMainPresenter {
    void onCreate();
    void onDestroy();

    void dismissRecipe();
    void getNextRecipe();
    void saveRecipe(Recipe recipe);
    void onEventMainThread(RecipeMainEvent event);

    RecipeMainView getView();
}
