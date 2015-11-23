package keyfun.sdk.androidflux.demo;

/**
 * Created by Key on 24/11/2015.
 */
public interface TodoAction {
    String TODO_CREATE = "todo-create";
    String TODO_COMPLETE = "todo-complete";
    String TODO_DESTROY = "todo-destroy";
    String TODO_DESTROY_COMPLETED = "todo-destroy-completed";
    String TODO_TOGGLE_COMPLETE_ALL = "todo-toggle-complete-all";
    String TODO_UNDO_COMPLETE = "todo-undo-complete";
    String TODO_UNDO_DESTROY = "todo-undo-destroy";

    String KEY_TEXT = "key-text";
    String KEY_ID = "key-id";
}
