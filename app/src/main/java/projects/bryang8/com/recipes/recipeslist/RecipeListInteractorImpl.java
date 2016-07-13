package projects.bryang8.com.recipes.recipeslist;

/**
 * Created by bryan_g8 on 13/07/16.
 */
public class RecipeListInteractorImpl implements RecipeListInteractor{
    private RecipeListRepository repository;

    public RecipeListInteractorImpl(RecipeListRepository repository) {
        this.repository = repository;
    }

    @Override
    public void execute() {
        repository.getSavedRecipes();
    }
}
