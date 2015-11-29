package keyfun.demo.flux.test;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import keyfun.sdk.flux.R;
import keyfun.sdk.flux.ActionCreators;
import keyfun.sdk.flux.Event;
import keyfun.sdk.flux.EventListener;
import keyfun.demo.flux.test.flux.events.TodoEvent;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("MainActivity");

        Button btnNewAction = (Button) findViewById(R.id.btn_new_action);
        btnNewAction.setOnClickListener(this);

        Button btnNextActivity = (Button) findViewById(R.id.btn_next_activity);
        btnNextActivity.setOnClickListener(this);

        initFlux();
    }

    private void initFlux() {
        Log.d(TAG, "initFlux");
        AppGlobal.getInstance().todoStore.addEventListener(TodoEvent.UPDATE_TEXT, labelChangedListener);
        AppGlobal.getInstance().todoStore.addEventListener(TodoEvent.UPDATE_COUNT, countChangedListener);
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
        AppGlobal.getInstance().todoStore.removeEventListener(TodoEvent.UPDATE_TEXT, labelChangedListener);
        AppGlobal.getInstance().todoStore.removeEventListener(TodoEvent.UPDATE_COUNT, countChangedListener);
    }

    private void newAction() {
        //Log.d(TAG, "newAction");
        ActionCreators.invoke(AppGlobal.getInstance().todoStore, TodoEvent.UPDATE_COUNT, AppGlobal.getInstance().todoStore.getMyCount() + 1);
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
