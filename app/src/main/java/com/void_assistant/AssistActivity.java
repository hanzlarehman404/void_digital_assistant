package com.void_assistant;

import android.app.Activity;
import android.os.Bundle;

public class AssistActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        DebugLogger.log(this, "AssistActivity.onCreate: Triggered by system intent=" + getIntent());
        finish();
        super.onCreate(savedInstanceState);
    }
}
