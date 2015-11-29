package keyfun.demo.flux.test;

import keyfun.demo.flux.test.flux.stores.TodoStore;

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
