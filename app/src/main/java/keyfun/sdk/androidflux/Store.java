package keyfun.sdk.androidflux;

/**
 * Created by Key on 24/11/2015.
 */
public abstract class Store {
    final Dispatcher dispatcher;

    protected Store(Dispatcher dispatcher) {
        this.dispatcher = dispatcher;
    }

    public void emitStoreChange() {
        dispatcher.emitChange(changeEvent());
    }

    public abstract StoreChangeEvent changeEvent();
    public abstract void onAction(Action action);

    public interface StoreChangeEvent {}
}
