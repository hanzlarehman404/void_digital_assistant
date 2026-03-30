package com.void_assistant;

import android.service.voice.VoiceInteractionService;
import android.os.Bundle;

public class VoidVoiceService extends VoiceInteractionService {

    @Override
    public void onCreate() {
        super.onCreate();
        DebugLogger.log(this, "VoidVoiceService.onCreate: Service instantiated");
    }

    @Override
    public void onReady() {
        super.onReady();
        DebugLogger.log(this, "VoidVoiceService.onReady: System has bound and is ready");
    }

    @Override
    public void showSession(Bundle args, int flags) {
        DebugLogger.log(this, "VoidVoiceService.showSession: Trigger recognized. Consuming silently (flags=" + flags + ")");
        // CALL super to satisfy the OS that the assistant trigger has been correctly Handled.
        // Our Session window is 0x0 and Finish() happens in onShow.
        super.showSession(args, flags);
    }

    @Override
    public void onLaunchVoiceAssistFromKeyguard() {
        DebugLogger.log(this, "VoidVoiceService.onLaunchVoiceAssistFromKeyguard: Triggered from lock screen");
        showSession(new Bundle(), 0);
    }
}
