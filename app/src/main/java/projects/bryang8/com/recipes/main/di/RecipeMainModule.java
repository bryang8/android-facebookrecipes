package projects.bryang8.com.recipes.main.di;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import projects.bryang8.com.recipes.api.RecipeClient;
import projects.bryang8.com.recipes.api.RecipeService;
import projects.bryang8.com.recipes.lib.base.EventBus;
import projects.bryang8.com.recipes.main.GetNextRecipeInteractor;
import projects.bryang8.com.recipes.main.GetNextRecipeInteractorImpl;
import projects.bryang8.com.recipes.main.RecipeMainPresenter;
import projects.bryang8.com.recipes.main.RecipeMainPresenterImpl;
import projects.bryang8.com.recipes.main.RecipeMainRepository;
import projects.bryang8.com.recipes.main.RecipeMainRepositoryImpl;
import projects.bryang8.com.recipes.main.SaveRecipeInteractor;
import projects.bryang8.com.recipes.main.SaveRecipeInteractorImpl;
import projects.bryang8.com.recipes.main.ui.RecipeMainView;

/**
 * Created by bryan_g8 on 6/07/16.
 */
@Module
public class RecipeMainModule {
    RecipeMainView view;

    public RecipeMainModule(RecipeMainView view) {
        this.view = view;
    }

    @Provides
    @Singleton
    RecipeMainView provideRecipeMainView() {
        return this.view;
    }

    @Provides @Singleton
    RecipeMainPresenter provideRecipeMainPresenter(EventBus eventBus, RecipeMainView view, SaveRecipeInteractor save, GetNextRecipeInteractor getNext) {
        return new RecipeMainPresenterImpl(eventBus, view, save, getNext);
    }

    @Provides @Singleton
    SaveRecipeInteractor provideSaveRecipeInteractor(RecipeMainRepository repository) {
        return new SaveRecipeInteractorImpl(repository);
    }

    @Provides @Singleton
    GetNextRecipeInteractor provideGetNextRecipeInteractor(RecipeMainRepository repository) {
        return new GetNextRecipeInteractorImpl(repository);
    }

    @Provides @Singleton
    RecipeMainRepository provideRecipeMainRepository(EventBus eventBus, RecipeService service) {
        return new RecipeMainRepositoryImpl(eventBus, service);
    }

    @Provides
    @Singleton
    RecipeService provideRecipeService() {
        RecipeClient client = new RecipeClient();
        return client.getRecipeService();
    }
}
