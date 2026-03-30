package com.void_assistant;

import android.content.Context;
import android.os.Bundle;
import android.service.voice.VoiceInteractionSession;
import android.service.voice.VoiceInteractionSessionService;

public class VoidSessionService extends VoiceInteractionSessionService {

    @Override
    public VoiceInteractionSession onNewSession(Bundle args) {
        return new SilentSession(this);
    }

    static class SilentSession extends VoiceInteractionSession {

        SilentSession(Context context) { super(context); }

        @Override
        public void onCreate() {
            super.onCreate();
            // Force the session window to be completely invisible and non-interactive
            if (getWindow() != null && getWindow().getWindow() != null) {
                android.view.Window w = getWindow().getWindow();
                w.setBackgroundDrawableResource(android.R.color.transparent);
                w.setDimAmount(0f);
                w.setLayout(0, 0); // 0-size
                w.addFlags(android.view.WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE
                        | android.view.WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);
            }
            hide();
            finish();
        }

        @Override
        public void onPrepareShow(Bundle args, int showFlags) {
            super.onPrepareShow(args, showFlags);
            hide();
            finish();
        }

        @Override
        public void onShow(Bundle args, int showFlags) {
            hide();
            finish();
        }

        @Override
        public void onHandleAssist(AssistState state) {
            finish();
        }

        @Override
        public void onHandleScreenshot(android.graphics.Bitmap screenshot) {
            finish();
        }
    }
}
