package com.void_assistant;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.view.KeyEvent;

public class VoidHeadsetReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        if (Intent.ACTION_MEDIA_BUTTON.equals(intent.getAction())) {
            KeyEvent event = intent.getParcelableExtra(Intent.EXTRA_KEY_EVENT);
            if (event != null && event.getKeyCode() == KeyEvent.KEYCODE_HEADSETHOOK) {
                DebugLogger.log(context, "VoidHeadsetReceiver: Absorbed HEADSETHOOK button press.");
                // Consume the broadcast
                abortBroadcast();
            }
        }
    }
}
