package projects.bryang8.com.recipes.main;

import projects.bryang8.com.recipes.entities.Recipe;

/**
 * Created by bryan_g8 on 6/07/16.
 */
public class SaveRecipeInteractorImpl implements SaveRecipeInteractor {
    RecipeMainRepository repository;

    public SaveRecipeInteractorImpl(RecipeMainRepository repository) {
        this.repository = repository;
    }
    @Override
    public void execute(Recipe recipe) {
        repository.saveRecipe(recipe);
    }
}
