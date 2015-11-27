package keyfun.sdk.androidflux.ottodemo;

import com.squareup.otto.Subscribe;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import keyfun.sdk.androidflux.otto.Action;
import keyfun.sdk.androidflux.otto.Dispatcher;
import keyfun.sdk.androidflux.otto.Store;

/**
 * Created by Key on 24/11/2015.
 */
public class TodoStore extends Store {

    private static TodoStore instance;
    private final List<Todo> todos;
    private Todo lastDeleted;

    protected TodoStore(Dispatcher dispatcher) {
        super(dispatcher);
        todos = new ArrayList<>();
    }

    public static TodoStore get(Dispatcher dispatcher) {
        if (instance == null) {
            instance = new TodoStore(dispatcher);
        }
        return instance;
    }

    public List<Todo> getTodos() {
        return todos;
    }

    public boolean canUndo() {
        return lastDeleted != null;
    }


    @Override
    @Subscribe
    @SuppressWarnings("unchecked")
    public void onAction(Action action) {
        long id;
        switch (action.getType()) {
            case TodoAction.TODO_CREATE:
                String text = ((String) action.getData().get(TodoAction.KEY_TEXT));
                create(text);
                emitStoreChange();
                break;

            case TodoAction.TODO_DESTROY:
                id = ((long) action.getData().get(TodoAction.KEY_ID));
                destroy(id);
                emitStoreChange();
                break;

            case TodoAction.TODO_UNDO_DESTROY:
                undoDestroy();
                emitStoreChange();
                break;

            case TodoAction.TODO_COMPLETE:
                id = ((long) action.getData().get(TodoAction.KEY_ID));
                updateComplete(id, true);
                emitStoreChange();
                break;

            case TodoAction.TODO_UNDO_COMPLETE:
                id = ((long) action.getData().get(TodoAction.KEY_ID));
                updateComplete(id, false);
                emitStoreChange();
                break;

            case TodoAction.TODO_DESTROY_COMPLETED:
                destroyCompleted();
                emitStoreChange();
                break;

            case TodoAction.TODO_TOGGLE_COMPLETE_ALL:
                updateCompleteAll();
                emitStoreChange();
                break;

        }

    }

    private void destroyCompleted() {
        Iterator<Todo> iter = todos.iterator();
        while (iter.hasNext()) {
            Todo todo = iter.next();
            if (todo.isComplete()) {
                iter.remove();
            }
        }
    }

    private void updateCompleteAll() {
        if (areAllComplete()) {
            updateAllComplete(false);
        } else {
            updateAllComplete(true);
        }
    }

    private boolean areAllComplete() {
        for (Todo todo : todos) {
            if (!todo.isComplete()) {
                return false;
            }
        }
        return true;
    }

    private void updateAllComplete(boolean complete) {
        for (Todo todo : todos) {
            todo.setComplete(complete);
        }
    }

    private void updateComplete(long id, boolean complete) {
        Todo todo = getById(id);
        if (todo != null) {
            todo.setComplete(complete);
        }
    }

    private void undoDestroy() {
        if (lastDeleted != null) {
            addElement(lastDeleted.clone());
            lastDeleted = null;
        }
    }

    private void create(String text) {
        long id = System.currentTimeMillis();
        Todo todo = new Todo(id, text);
        addElement(todo);
        Collections.sort(todos);
    }

    private void destroy(long id) {
        Iterator<Todo> iter = todos.iterator();
        while (iter.hasNext()) {
            Todo todo = iter.next();
            if (todo.getId() == id) {
                lastDeleted = todo.clone();
                iter.remove();
                break;
            }
        }
    }

    private Todo getById(long id) {
        Iterator<Todo> iter = todos.iterator();
        while (iter.hasNext()) {
            Todo todo = iter.next();
            if (todo.getId() == id) {
                return todo;
            }
        }
        return null;
    }


    private void addElement(Todo clone) {
        todos.add(clone);
        Collections.sort(todos);
    }

    @Override
    public StoreChangeEvent changeEvent() {
        return new TodoStoreChangeEvent();
    }

    public class TodoStoreChangeEvent implements StoreChangeEvent {
    }
}
