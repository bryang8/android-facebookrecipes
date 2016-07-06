package projects.bryang8.com.recipes;

import android.app.Application;

import com.facebook.FacebookSdk;
import com.raizlabs.android.dbflow.config.FlowManager;

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
}
