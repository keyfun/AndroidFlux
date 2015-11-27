package keyfun.sdk.androidflux;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import keyfun.sdk.androidflux.demo.Dispatcher;
import keyfun.sdk.androidflux.demo.TodoStore;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = "MainActivity";
    private TodoStore store;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initFlux();
    }

    private void initFlux() {
        Log.d(TAG, "initActions");
        store = new TodoStore(Dispatcher.getInstance());

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

    private void newAction() {
        Log.d(TAG, "newAction");
    }
}
