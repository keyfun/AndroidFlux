package keyfun.sdk.androidflux.demo;

/**
 * Created by Key on 27/11/2015.
 */
public interface Dispatcher {
    void addListener(String type, EventListener listener);
    void removeListener(String type, EventListener listener);
    boolean hasListener(String type, EventListener listener);
    void dispatchEvent(Event event);
}
