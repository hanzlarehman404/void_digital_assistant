package com.void_assistant;

import android.app.Activity;
import android.os.Bundle;

public class AssistActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // Finish BEFORE calling super or setContentView.
        // This prevents even a single frame from rendering.
        finish();
        super.onCreate(savedInstanceState);
    }
}
