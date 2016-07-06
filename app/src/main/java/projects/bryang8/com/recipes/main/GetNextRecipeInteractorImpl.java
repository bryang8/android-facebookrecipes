package projects.bryang8.com.recipes.main;

import java.util.Random;

/**
 * Created by bryan_g8 on 6/07/16.
 */
public class GetNextRecipeInteractorImpl implements GetNextRecipeInteractor{
    RecipeMainRepository repository;

    public GetNextRecipeInteractorImpl(RecipeMainRepository repository) {
        this.repository = repository;
    }

    @Override
    public void execute() {
        int recipePage = new Random().nextInt(RecipeMainRepository.RECIPE_RANGE);
        repository.setRecipePage(recipePage);
        repository.getNextRecipe();
    }
}
