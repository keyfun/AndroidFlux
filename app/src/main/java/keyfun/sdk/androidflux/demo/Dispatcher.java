package keyfun.sdk.androidflux.demo;

/**
 * Created by Key on 27/11/2015.
 */
public class Dispatcher {
    private static Dispatcher ourInstance = new Dispatcher();

    public static Dispatcher getInstance() {
        return ourInstance;
    }

    private Dispatcher() {

    }

    //public void

    public void dispatch(String type, Object... data) {

    }
}
