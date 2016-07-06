package projects.bryang8.com.recipes.main.di;

import javax.inject.Singleton;

import dagger.Component;
import projects.bryang8.com.recipes.lib.base.ImageLoader;
import projects.bryang8.com.recipes.lib.di.LibsModule;
import projects.bryang8.com.recipes.main.RecipeMainPresenter;

/**
 * Created by bryan_g8 on 6/07/16.
 */
@Singleton
@Component(modules = {RecipeMainModule.class, LibsModule.class})
public interface RecipeMainComponent {
    //void inject(RecipeMainActivity activity);
    ImageLoader getImageLoader();
    RecipeMainPresenter getPresenter();
}
