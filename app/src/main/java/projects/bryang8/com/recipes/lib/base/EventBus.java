package projects.bryang8.com.recipes.lib.base;

/**
 * Created by bryan_g8 on 5/07/16.
 */
public interface EventBus {
    void register(Object subscriber);
    void unregister(Object subscriber);
    void post(Object event);
}
