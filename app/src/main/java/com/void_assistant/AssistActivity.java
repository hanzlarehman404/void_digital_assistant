package com.void_assistant;

import android.app.Activity;
import android.os.Bundle;

/**
 * Launched when the assistant is triggered (headphone button, long-press home).
 * Finishes before drawing a single frame — no overlay, no interruption.
 */
public class AssistActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        finish();
    }
}
