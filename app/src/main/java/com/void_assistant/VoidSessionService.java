package com.void_assistant;

import android.service.voice.VoiceInteractionSessionService;
import android.service.voice.VoiceInteractionSession;
import android.os.Bundle;

/**
 * VoidSessionService — required by the VoiceInteractionService contract.
 * Sessions are never actually started; this just satisfies the framework.
 */
public class VoidSessionService extends VoiceInteractionSessionService {

    @Override
    public VoiceInteractionSession onNewSession(Bundle args) {
        return new VoidSession(this);
    }

    // Inner session class — does nothing
    static class VoidSession extends VoiceInteractionSession {
        VoidSession(android.content.Context context) {
            super(context);
        }

        @Override
        public void onShow(Bundle args, int showFlags) {
            // Immediately hide — don't show anything
            hide();
        }
    }
}
