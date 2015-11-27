package keyfun.sdk.androidflux;

import keyfun.sdk.androidflux.demo.TodoStore;

/**
 * Created by Key on 28/11/2015.
 */
public class AppGlobal {
    private static AppGlobal ourInstance = new AppGlobal();

    public static AppGlobal getInstance() {
        return ourInstance;
    }

    public TodoStore todoStore = new TodoStore();

    private AppGlobal() {
    }
}
