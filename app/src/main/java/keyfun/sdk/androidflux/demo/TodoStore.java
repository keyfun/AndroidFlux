package keyfun.sdk.androidflux.demo;

/**
 * Created by Key on 27/11/2015.
 */
public class TodoStore extends EventDispatcher {

    public static class ChangeEvent extends TodoEvent {
        public static final String MY_LABEL_CHANGED = "myLabelChanged";
        public static final String MY_COUNT_CHANGED = "myCountChanged";

        public ChangeEvent(String type) {
            super(type);
        }
    }

    private String myLabel;
    public String getMyLabel() { return myLabel; }
    public void setMyLabel(String myLabel) {
        if (this.myLabel != null && this.myLabel.equals(myLabel)) return;
        this.myLabel = myLabel;
        dispatchEvent(new ChangeEvent(ChangeEvent.MY_LABEL_CHANGED));
    }

    private int myCount = 0;
    public int getMyCount() { return myCount; }
    public void setMyCount(int myCount) {
        if (this.myCount == myCount) return;
        this.myCount = myCount;
        dispatchEvent(new ChangeEvent(ChangeEvent.MY_COUNT_CHANGED));
    }

    public TodoStore() {
        super();
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
