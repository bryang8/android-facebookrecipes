package projects.bryang8.com.recipes.lib;

import projects.bryang8.com.recipes.lib.base.EventBus;

/**
 * Created by bryan_g8 on 5/07/16.
 */
public class GreenRobotEventBus implements EventBus {
    org.greenrobot.eventbus.EventBus eventBus;

    public GreenRobotEventBus(org.greenrobot.eventbus.EventBus eventBus){
        this.eventBus = eventBus;
    }

    public void register(Object subscriber){
        eventBus.register(subscriber);
    }

    public void unregister(Object subscriber){
        eventBus.unregister(subscriber);
    }

    public void post(Object event){
        eventBus.post(event);
    }
}