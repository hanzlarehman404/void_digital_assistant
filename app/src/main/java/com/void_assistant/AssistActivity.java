package com.void_assistant;

import android.app.Activity;
import android.os.Bundle;

/**
 * AssistActivity — THE CORE OF THIS APP.
 *
 * When headphones trigger the digital assistant (via ACTION_ASSIST or
 * VOICE_COMMAND intent), Android launches this activity.
 *
 * This activity:
 *   1. Receives the trigger silently
 *   2. Does absolutely NOTHING
 *   3. Finishes immediately (no UI, no overlay, no sound)
 *
 * Your game keeps running uninterrupted.
 */
public class AssistActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Immediately finish — no UI, no overlay, no nothing.
        finish();
    }

    @Override
    protected void onStart() {
        super.onStart();
        finish();
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        // Do not call super — prevents any focus-related UI flicker
        finish();
    }
}
