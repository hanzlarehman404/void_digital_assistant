package com.void_assistant;

import android.service.voice.VoiceInteractionService;
import android.content.ComponentName;

/**
 * VoidVoiceService
 *
 * Extends VoiceInteractionService so the OS lists this app in
 * Settings → Default Apps → Digital Assistant.
 *
 * Does nothing — just exists to claim the assistant slot.
 */
public class VoidVoiceService extends VoiceInteractionService {

    @Override
    public void onReady() {
        super.onReady();
        // No-op: we are ready to do nothing.
    }

    @Override
    public void onShutdown() {
        super.onShutdown();
    }
}
