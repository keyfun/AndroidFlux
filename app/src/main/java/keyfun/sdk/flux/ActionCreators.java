package keyfun.sdk.flux;

/**
 * Created by Key on 27/11/2015.
 */
public class ActionCreators {
    private static ActionCreators instance;

    public static ActionCreators getInstance() {
        if (instance == null) {
            instance = new ActionCreators();
        }
        return instance;
    }

    public static void invoke(Store store, String action, Object... data) {
        store.invoke(action, data);
    }

}
