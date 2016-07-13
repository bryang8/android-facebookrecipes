package projects.bryang8.com.recipes.recipeslist.di;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import projects.bryang8.com.recipes.entities.Recipe;
import projects.bryang8.com.recipes.lib.base.EventBus;
import projects.bryang8.com.recipes.lib.base.ImageLoader;
import projects.bryang8.com.recipes.recipeslist.RecipeListInteractor;
import projects.bryang8.com.recipes.recipeslist.RecipeListInteractorImpl;
import projects.bryang8.com.recipes.recipeslist.RecipeListPresenter;
import projects.bryang8.com.recipes.recipeslist.RecipeListPresenterImpl;
import projects.bryang8.com.recipes.recipeslist.RecipeListRepository;
import projects.bryang8.com.recipes.recipeslist.RecipeListRepositoryImpl;
import projects.bryang8.com.recipes.recipeslist.StoredRecipesInteractor;
import projects.bryang8.com.recipes.recipeslist.StoredRecipesInteractorImpl;
import projects.bryang8.com.recipes.recipeslist.adapters.OnItemClickListener;
import projects.bryang8.com.recipes.recipeslist.adapters.RecipesAdapter;
import projects.bryang8.com.recipes.recipeslist.ui.RecipeListView;

/**
 * Created by bryan_g8 on 13/07/16.
 */
@Module
public class RecipeListModule {
    RecipeListView view;
    OnItemClickListener onItemClickListener;

    public RecipeListModule(RecipeListView view, OnItemClickListener onItemClickListener) {
        this.view = view;
        this.onItemClickListener = onItemClickListener;
    }

    @Provides
    @Singleton
    RecipeListView provideRecipeListView() {
        return this.view;
    }

    @Provides @Singleton
    RecipeListPresenter provideRecipeListPresenter(EventBus eventBus, RecipeListView view, RecipeListInteractor listInteractor, StoredRecipesInteractor storedInteractor) {
        return new RecipeListPresenterImpl(eventBus, view, listInteractor, storedInteractor);
    }

    @Provides @Singleton
    RecipeListInteractor provideRecipeListInteractor(RecipeListRepository repository) {
        return new RecipeListInteractorImpl(repository);
    }

    @Provides @Singleton
    StoredRecipesInteractor provideStoredRecipesInteractor(RecipeListRepository repository) {
        return new StoredRecipesInteractorImpl(repository);
    }

    @Provides @Singleton
    RecipeListRepository provideRecipeListRepository(EventBus eventBus) {
        return new RecipeListRepositoryImpl(eventBus);
    }

    @Provides @Singleton
    RecipesAdapter provideRecipesAdapter(List<Recipe> recipes, ImageLoader imageLoader, OnItemClickListener onItemClickListener) {
        return new RecipesAdapter(recipes, imageLoader, onItemClickListener);
    }

    @Provides @Singleton
    OnItemClickListener provideOnItemClickListener() {
        return this.onItemClickListener;
    }

    @Provides @Singleton
    List<Recipe> provideRecipesList() {
        return new ArrayList<Recipe>();
    }

}