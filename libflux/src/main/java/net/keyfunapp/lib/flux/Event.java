package net.keyfunapp.lib.flux;

/**
 * Created by Key on 28/11/2015.
 */
public interface Event {
    public String getType();
    public Object getSource();
    public void setSource(Object source);
}
