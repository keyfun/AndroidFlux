package keyfun.demo.flux.test.flux.events;

import keyfun.sdk.flux.ActionEvent;

/**
 * Created by Key on 28/11/2015.
 * It is so-call "Actions" in flux Architecture
 */
public class TodoEvent extends ActionEvent {

    // define action
    public static final String UPDATE_COUNT = "update_count";
    public static final String TODO_COMPLETE = "todo_complete";
    public static final String TODO_CREATE = "todo_create";
    public static final String TODO_DESTROY = "todo_destroy";
    public static final String UPDATE_TEXT = "update_text";

    public TodoEvent(String type) {
        this.type = type;
    }
}
