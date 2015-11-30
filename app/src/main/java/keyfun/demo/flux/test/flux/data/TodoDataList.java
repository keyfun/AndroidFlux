package keyfun.demo.flux.test.flux.data;

import java.util.ArrayList;

/**
 * Created by Key on 30/11/2015.
 */
public class TodoDataList {
    public int count;
    public String label;
    public ArrayList<TodoData> list;

    public TodoDataList() {
        count = 0;
        label = "";
        list = new ArrayList<TodoData>();
    }
}
