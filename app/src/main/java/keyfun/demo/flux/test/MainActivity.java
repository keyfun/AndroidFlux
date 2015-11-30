package keyfun.demo.flux.test;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import keyfun.sdk.flux.R;
import keyfun.sdk.flux.ActionCreators;
import keyfun.sdk.flux.Event;
import keyfun.sdk.flux.EventListener;
import keyfun.demo.flux.test.flux.events.TodoEvent;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = "MainActivity";
    private EditText editText;
    private ListView listView;
    private int addCount = 0;
    private ArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("MainActivity");

        Button btnUpdate = (Button) findViewById(R.id.btn_update);
        btnUpdate.setOnClickListener(this);

        Button btnNextActivity = (Button) findViewById(R.id.btn_next_activity);
        btnNextActivity.setOnClickListener(this);

        listView = (ListView) findViewById(R.id.listView);

        adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, AppGlobal.getInstance().todoStore.getStringList());

        listView.setAdapter(adapter);

        findViewById(R.id.btn_add_item).setOnClickListener(this);
        findViewById(R.id.btn_remove_item).setOnClickListener(this);

        editText = (EditText) findViewById(R.id.editText);

        initFlux();
    }

    private void initFlux() {
        AppGlobal.getInstance().todoStore.addEventListener(TodoEvent.UPDATE_LABEL, onUpdateLabel);
        AppGlobal.getInstance().todoStore.addEventListener(TodoEvent.UPDATE_COUNT, onUpdateCount);
        AppGlobal.getInstance().todoStore.addEventListener(TodoEvent.ADD_ITEM, onAddItem);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_update:
                onUpdate();
                break;

            case R.id.btn_next_activity:
                nextActivity();
                break;

            case R.id.btn_add_item:
                addItem();
                break;

            case R.id.btn_remove_item:
                removeItem();
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        AppGlobal.getInstance().todoStore.removeEventListener(TodoEvent.UPDATE_LABEL, onUpdateLabel);
        AppGlobal.getInstance().todoStore.removeEventListener(TodoEvent.UPDATE_COUNT, onUpdateCount);
    }

    private void onUpdate() {
        //Log.d(TAG, "newAction");
        ActionCreators.invoke(AppGlobal.getInstance().todoStore, TodoEvent.UPDATE_COUNT, AppGlobal.getInstance().todoStore.getCount() + 1);
        ActionCreators.invoke(AppGlobal.getInstance().todoStore, TodoEvent.UPDATE_LABEL, editText.getText());
    }

    private void addItem() {
        addCount++;
        String content = "Dummy Content " + addCount;
        ActionCreators.invoke(AppGlobal.getInstance().todoStore, TodoEvent.ADD_ITEM, addCount, content);
    }

    private void removeItem() {
        ActionCreators.invoke(AppGlobal.getInstance().todoStore, TodoEvent.REMOVE_ITEM);
    }

    private void nextActivity() {
        AppGlobal.getInstance().activityCount++;
        Intent intent = new Intent(this, NextActivity.class);
        startActivity(intent);
    }

    // this is our action/event listeners. They get called when a property changes.
    private EventListener onUpdateLabel = new EventListener() {
        @Override
        public void onEvent(Event event) {
            Log.d(TAG, "Label: " + AppGlobal.getInstance().todoStore.getLabel());
            editText.setText(AppGlobal.getInstance().todoStore.getLabel());
        }
    };

    private EventListener onUpdateCount = new EventListener() {
        @Override
        public void onEvent(Event event) {
            Log.d(TAG, "Count: " + AppGlobal.getInstance().todoStore.getCount());
        }
    };

    private EventListener onAddItem = new EventListener() {
        @Override
        public void onEvent(Event event) {
            Log.d(TAG, "onAddItem");
            adapter.notifyDataSetChanged();
            listView.invalidateViews();
        }
    };

    private EventListener onRemvoeItem = new EventListener() {
        @Override
        public void onEvent(Event event) {
            Log.d(TAG, "onRemvoeItem");
            adapter.notifyDataSetChanged();
        }
    };
}
