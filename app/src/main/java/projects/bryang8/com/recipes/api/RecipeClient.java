package projects.bryang8.com.recipes.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by bryan_g8 on 5/07/16.
 */
public class RecipeClient {
    private Retrofit retrofit;
    private final static String BASE_URL = "http://food2fork.com/api/";

    public RecipeClient() {
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public RecipeService getRecipeService() {
        return retrofit.create(RecipeService.class);
    }
}
