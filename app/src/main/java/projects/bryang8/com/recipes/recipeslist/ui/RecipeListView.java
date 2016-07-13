package projects.bryang8.com.recipes.recipeslist.ui;

import java.util.List;

import projects.bryang8.com.recipes.entities.Recipe;

/**
 * Created by bryan_g8 on 13/07/16.
 */
public interface RecipeListView {
    void setRecipes(List<Recipe> data);
    void recipeUpdated();
    void recipeDeleted(Recipe recipe);
}
