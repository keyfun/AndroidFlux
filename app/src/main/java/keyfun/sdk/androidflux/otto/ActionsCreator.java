package keyfun.sdk.androidflux.otto;

import keyfun.sdk.androidflux.ottodemo.Todo;
import keyfun.sdk.androidflux.ottodemo.TodoAction;

/**
 * Created by Key on 24/11/2015.
 */
public class ActionsCreator {

    private static ActionsCreator instance;
    final Dispatcher dispatcher;

    ActionsCreator(Dispatcher dispatcher) {
        this.dispatcher = dispatcher;
    }

    public static ActionsCreator get(Dispatcher dispatcher) {
        if (instance == null) {
            instance = new ActionsCreator(dispatcher);
        }
        return instance;
    }

    public void create(String text) {
        dispatcher.dispatch(
                TodoAction.TODO_CREATE,
                TodoAction.KEY_TEXT, text
        );

    }

    public void destroy(long id) {
        dispatcher.dispatch(
                TodoAction.TODO_DESTROY,
                TodoAction.KEY_ID, id
        );
    }

    public void undoDestroy() {
        dispatcher.dispatch(
                TodoAction.TODO_UNDO_DESTROY
        );
    }

    public void toggleComplete(Todo todo) {
        long id = todo.getId();
        String actionType = todo.isComplete() ? TodoAction.TODO_UNDO_COMPLETE : TodoAction.TODO_COMPLETE;

        dispatcher.dispatch(
                actionType,
                TodoAction.KEY_ID, id
        );
    }

    public void toggleCompleteAll() {
        dispatcher.dispatch(TodoAction.TODO_TOGGLE_COMPLETE_ALL);
    }

    public void destroyCompleted() {
        dispatcher.dispatch(TodoAction.TODO_DESTROY_COMPLETED);
    }
}
