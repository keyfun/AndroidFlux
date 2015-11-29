package keyfun.demo.flux.test.flux.stores;

import keyfun.demo.flux.test.flux.events.TodoEvent;
import keyfun.sdk.flux.Store;

/**
 * Created by Key on 27/11/2015.
 */
public class TodoStore extends Store {

    private String myLabel;
    public String getMyLabel() { return myLabel; }
    private void setMyLabel(String myLabel) {
        if (this.myLabel != null && this.myLabel.equals(myLabel)) return;
        this.myLabel = myLabel;
        dispatchEvent(new TodoEvent(TodoEvent.UPDATE_TEXT));
    }

    private int myCount = 0;
    public int getMyCount() { return myCount; }
    private void setMyCount(int myCount) {
        if (this.myCount == myCount) return;
        this.myCount = myCount;
        dispatchEvent(new TodoEvent(TodoEvent.UPDATE_COUNT));
    }

    public TodoStore() {
        super();
    }

    @Override
    public void invoke(String action, Object[] data) {
        super.invoke(action, data);

        switch (action) {
            case TodoEvent.UPDATE_COUNT:
                setMyCount((Integer) data[0]);
                break;

            case TodoEvent.UPDATE_TEXT:
                setMyLabel(String.valueOf(data[0]));
                break;
        }

    }
}
