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
            }
        }

        @Override
        public void onPrepareShow(Bundle args, int showFlags) {
            super.onPrepareShow(args, showFlags);
            DebugLogger.log(getContext(), "SilentSession.onPrepareShow: Proceeding to hide");
        }

        @Override
        public void onShow(Bundle args, int showFlags) {
            DebugLogger.log(getContext(), "SilentSession.onShow: Proceeding to hide");
            hide();
            finish();
        }

        @Override
        public void onHandleAssist(AssistState state) {
            DebugLogger.log(getContext(), "SilentSession.onHandleAssist triggered");
            hide();
            finish();
        }

        @Override
        public void onHandleScreenshot(android.graphics.Bitmap screenshot) {
            DebugLogger.log(getContext(), "SilentSession.onHandleScreenshot triggered");
            hide();
            finish();
        }
    }
}
