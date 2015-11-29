package keyfun.demo.flux.ottotest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.squareup.otto.Bus;
import com.squareup.otto.Subscribe;

import keyfun.sdk.flux.R;
import keyfun.demo.flux.ottolib.ActionsCreator;
import keyfun.demo.flux.ottolib.Dispatcher;

public class OttoMainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private Dispatcher dispatcher;
    private ActionsCreator actionsCreator;
    private TodoStore todoStore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initDependencies();
    }

    private void initDependencies() {
        Log.d(TAG, "initDependencies");
        dispatcher = Dispatcher.get(new Bus());
        actionsCreator = ActionsCreator.get(dispatcher);
        todoStore = TodoStore.get(dispatcher);

        /*
                self.todoStore.eventEmitter.listen(TodoStore.Event.Deleted) { () in
                    self.tableView.reloadData()
                }
                ActionCreator.invoke(TodoAction.Fetch())
                */
    }

    @Override
    protected void onResume() {
        super.onResume();
        dispatcher.register(this);
        dispatcher.register(todoStore);

        testAction();
    }

    @Override
    protected void onPause() {
        super.onPause();
        dispatcher.unregister(this);
        dispatcher.unregister(todoStore);
    }

    private void testAction() {
        actionsCreator.toggleCompleteAll();
        actionsCreator.create("abc");
    }

    @Subscribe
    public void onTodoStoreChange(TodoStore.TodoStoreChangeEvent event) {
        Log.d(TAG, "onTodoStoreChange = " + event.toString());
    }

}
