package projects.bryang8.com.recipes.recipeslist;

import projects.bryang8.com.recipes.entities.Recipe;
import projects.bryang8.com.recipes.recipeslist.events.RecipeListEvent;
import projects.bryang8.com.recipes.recipeslist.ui.RecipeListView;

/**
 * Created by bryan_g8 on 13/07/16.
 */
public interface RecipeListPresenter {
    void onCreate();
    void onDestroy();

    void getRecipes();
    void removeRecipe(Recipe recipe);
    void toggleFavorite(Recipe recipe);
    void onEventMainThread(RecipeListEvent event);

    RecipeListView getView();
}