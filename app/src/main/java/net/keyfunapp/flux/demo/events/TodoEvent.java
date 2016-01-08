package net.keyfunapp.flux.demo.events;

import net.keyfunapp.lib.flux.ActionEvent;

/**
 * Created by Key on 28/11/2015.
 * It is so-call "Actions" in flux Architecture
 */
public class TodoEvent extends ActionEvent {
    // define action
    public static final String ADD_ITEM = "todo_add_item";
    public static final String REMOVE_ITEM = "todo_remove_item";
    public static final String UPDATE_LABEL = "update_text";
    public static final String UPDATE_COUNT = "update_count";

    public TodoEvent(String type) {
        this.type = type;
    }
}
