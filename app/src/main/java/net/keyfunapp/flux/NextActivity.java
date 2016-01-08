package net.keyfunapp.flux;

import android.os.Bundle;
import android.util.Log;

/**
 * Created by Key on 28/11/2015.
 */
public class NextActivity extends MainActivity  {
    private static final String TAG = "NextActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("NextActivity + " + AppGlobal.getInstance().activityCount);
        Log.d(TAG, "onCreate");
    }
}
