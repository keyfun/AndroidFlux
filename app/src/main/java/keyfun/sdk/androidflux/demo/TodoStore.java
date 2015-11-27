package keyfun.sdk.androidflux.demo;

/**
 * Created by Key on 27/11/2015.
 */
public class TodoStore {

    private Dispatcher mDispatcher;

    public TodoStore(Dispatcher dispatcher) {
        mDispatcher = dispatcher;
    }

    public void onAction(TodoAction action) {
        switch (action) {
            case TODO_COMPLETE:
                todoComplete();
                break;
            case TODO_CREATE:
                todoCreate();
                break;
            case TODO_DESTROY:
                todoDestroy();
                break;
            case UPDATE_TEXT:
                updateText();
                break;
        }
    }

    private void todoComplete() {

    }

    private void todoCreate() {

    }

    private void todoDestroy() {

    }

    private void updateText() {

    }

}
