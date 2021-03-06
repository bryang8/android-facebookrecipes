package projects.bryang8.com.recipes;

import android.app.Application;

import com.facebook.FacebookSdk;
import com.raizlabs.android.dbflow.config.FlowManager;

import projects.bryang8.com.recipes.lib.di.LibsModule;
import projects.bryang8.com.recipes.main.di.DaggerRecipeMainComponent;
import projects.bryang8.com.recipes.main.di.RecipeMainComponent;
import projects.bryang8.com.recipes.main.di.RecipeMainModule;
import projects.bryang8.com.recipes.main.ui.RecipeMainView;
import projects.bryang8.com.recipes.main.ui.RecipesMainActivity;
import projects.bryang8.com.recipes.recipeslist.adapters.OnItemClickListener;
import projects.bryang8.com.recipes.recipeslist.di.DaggerRecipeListComponent;
import projects.bryang8.com.recipes.recipeslist.di.RecipeListComponent;
import projects.bryang8.com.recipes.recipeslist.di.RecipeListModule;
import projects.bryang8.com.recipes.recipeslist.ui.RecipeListActivity;
import projects.bryang8.com.recipes.recipeslist.ui.RecipeListView;

/**
 * Created by bryan_g8 on 5/07/16.
 */
public class FacebookRecipesApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        initFacebook();
        initDB();
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
        FBTearDown();
    }

    private void FBTearDown() {
        FlowManager.destroy();
    }

    private void initDB() {
        FlowManager.init(this);
    }

    private void initFacebook() {
        FacebookSdk.sdkInitialize(this);
    }

    public RecipeMainComponent getRecipeMainComponent(RecipesMainActivity activity, RecipeMainView view){
      return DaggerRecipeMainComponent
              .builder()
              .libsModule(new LibsModule(activity))
              .recipeMainModule(new RecipeMainModule(view))
              .build();
    }

    public RecipeListComponent getRecipeListComponent(RecipeListActivity activity, RecipeListView view, OnItemClickListener listener){
        return DaggerRecipeListComponent
                .builder()
                .libsModule(new LibsModule(activity))
                .recipeListModule(new RecipeListModule(view, listener))
                .build();
    }
}
