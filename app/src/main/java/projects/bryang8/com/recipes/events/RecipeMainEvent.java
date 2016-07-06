package projects.bryang8.com.recipes.events;

import projects.bryang8.com.recipes.entities.Recipe;

/**
 * Created by bryan_g8 on 6/07/16.
 */
public class RecipeMainEvent {
    private int type;
    private String error;
    private Recipe recipe;

    public final static int NEXT_EVENT = 0;
    public final static int SAVE_EVENT = 1;

    public Recipe getRecipe() {
        return recipe;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
