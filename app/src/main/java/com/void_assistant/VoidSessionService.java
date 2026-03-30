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
        public void onShow(Bundle args, int showFlags) {
            DebugLogger.log(getContext(), "SilentSession.onShow: flags=" + showFlags);
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
