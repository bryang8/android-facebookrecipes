package projects.bryang8.com.recipes.recipeslist;

import org.greenrobot.eventbus.Subscribe;

import projects.bryang8.com.recipes.entities.Recipe;
import projects.bryang8.com.recipes.lib.base.EventBus;
import projects.bryang8.com.recipes.recipeslist.events.RecipeListEvent;
import projects.bryang8.com.recipes.recipeslist.ui.RecipeListView;

/**
 * Created by bryan_g8 on 13/07/16.
 */
public class RecipeListPresenterImpl implements RecipeListPresenter {
    private EventBus eventBus;
    private RecipeListView view;
    private RecipeListInteractor listInteractor;
    private StoredRecipesInteractor storedInteractor;

    public RecipeListPresenterImpl(EventBus eventBus, RecipeListView view, RecipeListInteractor listInteractor, StoredRecipesInteractor storedInteractor) {
        this.eventBus = eventBus;
        this.view = view;
        this.listInteractor = listInteractor;
        this.storedInteractor = storedInteractor;
    }

    @Override
    public void onCreate() {
        eventBus.register(this);
    }

    @Override
    public void onDestroy() {
        eventBus.unregister(this);
        view = null;
    }

    @Override
    public RecipeListView getView() {
        return this.view;
    }

    @Override
    public void getRecipes() {
        listInteractor.execute();
    }

    @Override
    public void toggleFavorite(Recipe recipe) {
        boolean fav = recipe.getFavorite();
        recipe.setFavorite(!fav);
        storedInteractor.executeUpdate(recipe);
    }

    @Override
    public void removeRecipe(Recipe recipe) {
        storedInteractor.executeDelete(recipe);
    }

    @Override
    @Subscribe
    public void onEventMainThread(RecipeListEvent event) {
        if (this.view != null) {
            switch (event.getType()){
                case RecipeListEvent.READ_EVENT:
                    view.setRecipes(event.getRecipes());
                    break;
                case RecipeListEvent.UPDATE_EVENT:
                    view.recipeUpdated();
                    break;
                case RecipeListEvent.DELETE_EVENT:
                    Recipe recipe = event.getRecipes().get(0);
                    view.recipeDeleted(recipe);
                    break;

            }
        }
    }
}