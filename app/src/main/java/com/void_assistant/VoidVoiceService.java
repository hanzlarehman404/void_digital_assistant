package com.void_assistant;

import android.service.voice.VoiceInteractionService;
import android.os.Bundle;

public class VoidVoiceService extends VoiceInteractionService {

    @Override
    public void onReady() {
        super.onReady();
    }

    @Override
    public void showSession(Bundle args, int flags) {
        // CALL super.showSession() — this lets the system know we've acknowledged the trigger.
        // Our Session (SilentSession) is configured to hide itself immediately in onShow().
        super.showSession(args, flags);
    }

    @Override
    public void onLaunchVoiceAssistFromKeyguard() {
        // Called when triggered from lock screen.
        // Call showSession to ensure it's "handled" then hidden.
        showSession(new Bundle(), 0);
    }
}
