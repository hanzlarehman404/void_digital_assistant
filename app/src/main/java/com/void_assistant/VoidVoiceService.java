package com.void_assistant;

import android.service.voice.VoiceInteractionService;

/**
 * Main entry point. Android binds here first when evaluating
 * whether to allow this app as the default assistant.
 */
public class VoidVoiceService extends VoiceInteractionService {
    @Override
    public void onReady() {
        super.onReady();
        // No-op — we are the void.
    }
}
