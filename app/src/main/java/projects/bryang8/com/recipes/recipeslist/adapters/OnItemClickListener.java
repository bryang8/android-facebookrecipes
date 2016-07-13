package projects.bryang8.com.recipes.recipeslist.adapters;

import projects.bryang8.com.recipes.entities.Recipe;

/**
 * Created by bryan_g8 on 13/07/16.
 */
public interface OnItemClickListener {
    void onFavClick(Recipe recipe);
    void onItemClick(Recipe recipe);
    void onDeleteClick(Recipe recipe);
}