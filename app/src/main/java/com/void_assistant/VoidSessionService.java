package com.void_assistant;

import android.content.Context;
import android.os.Bundle;
import android.service.voice.VoiceInteractionSession;
import android.service.voice.VoiceInteractionSessionService;

/**
 * Android binds to this service to verify the assistant works
 * before enabling the "Save" button in Default Apps settings.
 * We return a real session object so the bind succeeds, but the
 * session immediately hides itself — no UI shown.
 */
public class VoidSessionService extends VoiceInteractionSessionService {

    @Override
    public VoiceInteractionSession onNewSession(Bundle args) {
        return new SilentSession(this);
    }

    static class SilentSession extends VoiceInteractionSession {
        SilentSession(Context context) {
            super(context);
        }

        @Override
        public void onShow(Bundle args, int showFlags) {
            // Do not call super — just silently dismiss.
            hide();
        }

        @Override
        public void onHandleAssist(AssistState state) {
            // Receive the assist data, do nothing with it.
            hide();
        }
    }
}
