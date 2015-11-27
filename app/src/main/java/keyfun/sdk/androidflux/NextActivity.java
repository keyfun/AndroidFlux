package keyfun.sdk.androidflux;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import keyfun.sdk.androidflux.demo.Event;
import keyfun.sdk.androidflux.demo.EventListener;
import keyfun.sdk.androidflux.demo.TodoStore;

/**
 * Created by Key on 28/11/2015.
 */
public class NextActivity extends AppCompatActivity implements View.OnClickListener  {
    private static final String TAG = "NextActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("NextActivity");
        Log.d(TAG, "onCreate");

        Button btnNewAction = (Button) findViewById(R.id.btn_new_action);
        btnNewAction.setOnClickListener(this);

        Button btnNextActivity = (Button) findViewById(R.id.btn_next_activity);
        btnNextActivity.setOnClickListener(this);

        initFlux();
    }

    private void initFlux() {
        Log.d(TAG, "initFlux");
        AppGlobal.getInstance().todoStore.addListener(TodoStore.ChangeEvent.MY_LABEL_CHANGED, labelChangedListener);
        AppGlobal.getInstance().todoStore.addListener(TodoStore.ChangeEvent.MY_COUNT_CHANGED, countChangedListener);
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

            case R.id.btn_next_activity:
                nextActivity();
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy");
        AppGlobal.getInstance().todoStore.removeListener(TodoStore.ChangeEvent.MY_LABEL_CHANGED, labelChangedListener);
        AppGlobal.getInstance().todoStore.removeListener(TodoStore.ChangeEvent.MY_COUNT_CHANGED, countChangedListener);
    }

    private void newAction() {
        //Log.d(TAG, "newAction");
        AppGlobal.getInstance().todoStore.setMyCount(AppGlobal.getInstance().todoStore.getMyCount() + 1);
    }

    private void nextActivity() {
        Intent intent = new Intent(this, NextActivity.class);
        startActivity(intent);
    }

    // this is our action/event listeners. They get called when a property changes.
    private EventListener labelChangedListener = new EventListener() {
        @Override
        public void onEvent(Event event) {
            Log.d(TAG, "Label: " + AppGlobal.getInstance().todoStore.getMyLabel());
        }
    };

    private EventListener countChangedListener = new EventListener() {
        @Override
        public void onEvent(Event event) {
            Log.d(TAG, "Count: " + AppGlobal.getInstance().todoStore.getMyCount());
        }
    };
}
