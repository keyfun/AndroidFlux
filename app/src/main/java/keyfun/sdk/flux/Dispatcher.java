package keyfun.sdk.flux;

/**
 * Created by Key on 27/11/2015.
 */
public interface Dispatcher {
    void addEventListener(String type, EventListener listener);
    void removeEventListener(String type, EventListener listener);
    boolean hasEventListener(String type, EventListener listener);
    void dispatchEvent(Event event);
}
