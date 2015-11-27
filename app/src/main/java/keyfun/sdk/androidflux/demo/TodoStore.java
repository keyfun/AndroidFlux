package keyfun.sdk.androidflux.demo;

/**
 * Created by Key on 27/11/2015.
 */
public class TodoStore extends Store {

    private String myLabel;
    public String getMyLabel() { return myLabel; }
    private void setMyLabel(String myLabel) {
        if (this.myLabel != null && this.myLabel.equals(myLabel)) return;
        this.myLabel = myLabel;
        dispatchEvent(new TodoEvent(TodoEvent.MY_LABEL_CHANGED));
    }

    private int myCount = 0;
    public int getMyCount() { return myCount; }
    private void setMyCount(int myCount) {
        if (this.myCount == myCount) return;
        this.myCount = myCount;
        dispatchEvent(new TodoEvent(TodoEvent.MY_COUNT_CHANGED));
    }

    public TodoStore() {
        super();
    }

    @Override
    public void invoke(String action, Object[] data) {
        super.invoke(action, data);

        switch (action) {
            case TodoEvent.MY_COUNT_CHANGED:
                setMyCount((Integer) data[0]);
                break;

            case TodoEvent.MY_LABEL_CHANGED:
                setMyLabel(String.valueOf(data[0]));
                break;
        }

    }
}
