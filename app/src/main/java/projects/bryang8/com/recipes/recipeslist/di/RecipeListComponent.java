package projects.bryang8.com.recipes.recipeslist.di;

import javax.inject.Singleton;

import dagger.Component;
import projects.bryang8.com.recipes.lib.di.LibsModule;
import projects.bryang8.com.recipes.recipeslist.RecipeListPresenter;
import projects.bryang8.com.recipes.recipeslist.adapters.RecipesAdapter;

/**
 * Created by bryan_g8 on 13/07/16.
 */
@Singleton
@Component(modules = {RecipeListModule.class, LibsModule.class})
public interface RecipeListComponent {
    //void inject(RecipeListActivity activity);
    RecipeListPresenter getPresenter();
    RecipesAdapter getAdapter();
}
