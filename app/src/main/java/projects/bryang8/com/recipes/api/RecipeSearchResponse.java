package projects.bryang8.com.recipes.api;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import projects.bryang8.com.recipes.entities.Recipe;

/**
 * Created by bryan_g8 on 5/07/16.
 */
public class RecipeSearchResponse {
    private int count;
    @SerializedName("recipes")
    private List<Recipe> recipes;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<Recipe> getRecipes() {
        return recipes;
    }

    public void setRecipes(List<Recipe> recipes) {
        this.recipes = recipes;
    }

    public Recipe getFirstRecipe(){
        Recipe first = null;
        if (!recipes.isEmpty()) {
            first = recipes.get(0);
        }
        return first;
    }
}