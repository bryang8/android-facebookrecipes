package projects.bryang8.com.recipes.recipeslist;

import projects.bryang8.com.recipes.entities.Recipe;

/**
 * Created by bryan_g8 on 13/07/16.
 */
public interface StoredRecipesInteractor {
    void executeUpdate(Recipe recipe);
    void executeDelete(Recipe recipe);
}
