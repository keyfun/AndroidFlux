package keyfun.sdk.flux;

/**
 * Created by Key on 29/11/2015.
 */
public class ActionEvent implements Event {

    protected String type;

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
}
