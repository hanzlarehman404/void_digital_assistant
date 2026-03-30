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
            // Called if the session is ever shown — immediately hide AND finish.
            // Do NOT call super — prevents any window from drawing or lasting.
            hide();
            finish();
        }

        @Override
        public void onHandleAssist(AssistState state) {
            hide();
            finish();
        }

        @Override
        public void onHandleScreenshot(android.graphics.Bitmap screenshot) {
            hide();
            finish();
        }
    }
}
