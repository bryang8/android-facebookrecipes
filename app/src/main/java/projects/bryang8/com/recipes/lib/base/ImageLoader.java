package projects.bryang8.com.recipes.lib.base;

import android.widget.ImageView;

/**
 * Created by bryan_g8 on 5/07/16.
 */
public interface ImageLoader {
    void load(ImageView imageView, String URL);
    void setOnFinishedImageLoadingListener(Object object);
}