package keyfun.sdk.androidflux.demo;

/**
 * Created by Key on 28/11/2015.
 */
public class TodoEvent implements Event {

    // define action
    public static final String MY_LABEL_CHANGED = "myLabelChanged";
    public static final String MY_COUNT_CHANGED = "myCountChanged";

    private String type;

    @Override
    public String getType() { return type; }

    public void setType(String type) {
        this.type = type;
    }

    protected Object source;

    @Override
    public Object getSource() {
        return source;
    }

    @Override
    public void setSource(Object source) {
        this.source = source;
    }

    public TodoEvent(String type) {
        this.type = type;
    }
}
