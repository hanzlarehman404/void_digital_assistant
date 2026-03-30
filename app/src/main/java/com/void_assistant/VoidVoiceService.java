package com.void_assistant;

import android.service.voice.VoiceInteractionService;
import android.os.Bundle;

public class VoidVoiceService extends VoiceInteractionService {

    @Override
    public void onReady() {
        super.onReady();
    }

    /**
     * Called by Android when the assistant is triggered (headphone button etc).
     * We override showSession to intercept it HERE — before any UI is shown.
     * Passing null options with no flags means nothing launches.
     */
    @Override
    public void showSession(Bundle args, int flags) {
        // Do NOT call super.showSession() — that would show the session UI.
        // By swallowing this call, nothing happens. Trigger is consumed silently.
    }
}
