package net.keyfunapp.flux;

import net.keyfunapp.flux.demo.stores.TodoStore;

/**
 * Created by Key on 28/11/2015.
 */
public class AppGlobal {
    private static AppGlobal ourInstance = new AppGlobal();

    public static AppGlobal getInstance() {
        return ourInstance;
    }

    public TodoStore todoStore = new TodoStore();

    public int activityCount = 0;

    private AppGlobal() {
    }
}
