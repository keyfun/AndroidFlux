package keyfun.demo.flux.test.flux.stores;

import java.util.ArrayList;

import keyfun.demo.flux.test.flux.data.TodoData;
import keyfun.demo.flux.test.flux.data.TodoDataList;
import keyfun.demo.flux.test.flux.events.TodoEvent;
import keyfun.sdk.flux.Store;

/**
 * Created by Key on 27/11/2015.
 */
public class TodoStore extends Store {

    private TodoDataList dataList = new TodoDataList();

    public TodoStore() {
        super();
    }

    public String getLabel() {
        return dataList.label;
    }

    public int getCount() {
        return dataList.count;
    }

    public ArrayList<TodoData> getList() {
        return dataList.list;
    }

    public ArrayList<String> getStringList() {
        ArrayList<String> arr = new ArrayList<String>();
        for (TodoData data: getList()) {
            arr.add(data.content);
        }
        return arr;
    }

    public void setLabel(String label) {
        if(dataList.label != null && dataList.label.equals(label)) return;
        dataList.label = label;
        dispatchEvent(new TodoEvent(TodoEvent.UPDATE_LABEL));
    }

    public void setCount(int count) {
        if(dataList.count == count) return;
        dataList.count = count;
        dispatchEvent(new TodoEvent(TodoEvent.UPDATE_COUNT));
    }

    public void addItem(int id, String content) {
        dataList.list.add(new TodoData(id, content));
        dispatchEvent(new TodoEvent(TodoEvent.ADD_ITEM));
    }

    public void removeItem() {
        if(dataList.list.size() > 0) {
            dataList.list.remove(0);
            dispatchEvent(new TodoEvent(TodoEvent.REMOVE_ITEM));
        }
    }

    @Override
    public void invoke(String action, Object[] data) {
        super.invoke(action, data);

        switch (action) {
            case TodoEvent.UPDATE_COUNT:
                setCount((Integer) data[0]);
                break;

            case TodoEvent.UPDATE_LABEL:
                setLabel(String.valueOf(data[0]));
                break;

            case TodoEvent.ADD_ITEM:
                addItem((Integer) data[0], String.valueOf(data[1]));
                break;

            case TodoEvent.REMOVE_ITEM:
                removeItem();
                break;
        }

    }
}
