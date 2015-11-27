package keyfun.sdk.androidflux;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import keyfun.sdk.androidflux.demo.Event;
import keyfun.sdk.androidflux.demo.EventListener;
import keyfun.sdk.androidflux.demo.TodoStore;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = "MainActivity";
    private TodoStore todoStore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnNewAction = (Button) findViewById(R.id.btn_new_action);
        btnNewAction.setOnClickListener(this);

        initFlux();
    }

    private void initFlux() {
        Log.d(TAG, "initFlux");
        todoStore = new TodoStore();
        todoStore.addListener(TodoStore.ChangeEvent.MY_LABEL_CHANGED, labelChangedListener);
        todoStore.addListener(TodoStore.ChangeEvent.MY_COUNT_CHANGED, countChangedListener);
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
            case R.id.btn_new_action:
                newAction();
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        todoStore.removeListener(TodoStore.ChangeEvent.MY_LABEL_CHANGED, labelChangedListener);
        todoStore.removeListener(TodoStore.ChangeEvent.MY_COUNT_CHANGED, countChangedListener);
    }

    private void newAction() {
        //Log.d(TAG, "newAction");
        todoStore.setMyCount(todoStore.getMyCount()+1);
    }

    // this is our action/event listeners. They get called when a property changes.
    private EventListener labelChangedListener = new EventListener() {
        @Override
        public void onEvent(Event event) {
            Log.d(TAG, "Label: " + todoStore.getMyLabel());
        }
    };

    private EventListener countChangedListener = new EventListener() {
        @Override
        public void onEvent(Event event) {
            Log.d(TAG, "Count: " + todoStore.getMyCount());
        }
    };
}
