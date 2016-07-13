package projects.bryang8.com.recipes.recipeslist;

import projects.bryang8.com.recipes.entities.Recipe;

/**
 * Created by bryan_g8 on 13/07/16.
 */
public class StoredRecipesInteractorImpl implements StoredRecipesInteractor{
    private RecipeListRepository repository;

    public StoredRecipesInteractorImpl(RecipeListRepository repository) {
        this.repository = repository;
    }

    @Override
    public void executeUpdate(Recipe recipe) {
        repository.updateRecipe(recipe);
    }

    @Override
    public void executeDelete(Recipe recipe) {
        repository.removeRecipe(recipe);
    }
}
