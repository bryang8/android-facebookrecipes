package projects.bryang8.com.recipes.recipeslist;

import projects.bryang8.com.recipes.entities.Recipe;

/**
 * Created by bryan_g8 on 13/07/16.
 */
public interface RecipeListRepository {
    void getSavedRecipes();
    void updateRecipe(Recipe recipe);
    void removeRecipe(Recipe recipe);
}
