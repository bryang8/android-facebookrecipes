package projects.bryang8.com.recipes.lib;

import android.app.Activity;
import android.util.Log;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestListener;

import projects.bryang8.com.recipes.lib.base.ImageLoader;

/**
 * Created by bryan_g8 on 5/07/16.
 */
public class GlideImageLoader implements ImageLoader {
    private RequestManager glideRequestManager;
    private RequestListener onFinishedImageLoadingListener;

    public GlideImageLoader(RequestManager glideRequestManager) {
        this.glideRequestManager = glideRequestManager;
    }

    public void setLoaderContext(Activity activity) {
        this.glideRequestManager = Glide.with(activity);
    }

    @Override
    public void load(ImageView imageView, String URL) {
        if (onFinishedImageLoadingListener != null) {
            glideRequestManager
                    .load(URL)
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .centerCrop()
                    .listener(onFinishedImageLoadingListener)
                    .into(imageView);
        } else {
            glideRequestManager
                    .load(URL)
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .centerCrop()
                    .into(imageView);
        }
    }


    @Override
    public void setOnFinishedImageLoadingListener(Object listener) {
        if (listener instanceof RequestListener) {
            this.onFinishedImageLoadingListener = (RequestListener) listener;
        }
    }
}
