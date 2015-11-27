package keyfun.sdk.androidflux.demo;

/**
 * Created by Key on 27/11/2015.
 */
public enum TodoAction {
    TODO_COMPLETE,
    TODO_CREATE,
    TODO_DESTROY,
    UPDATE_TEXT;

    @Override
    public String toString() {
        switch (this) {
            case TODO_COMPLETE:
                return "todo-complete";

            case TODO_CREATE:
                return "todo-create";

            case TODO_DESTROY:
                return "todo-destroy";

            case UPDATE_TEXT:
                return "update-tex";
        }
        return super.toString();
    }
}
