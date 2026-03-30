package com.void_assistant;

import android.service.voice.VoiceInteractionService;
import android.os.Bundle;

public class VoidVoiceService extends VoiceInteractionService {

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public void onReady() {
        super.onReady();
    }

    @Override
    public void showSession(Bundle args, int flags) {
        // CALL super to satisfy the OS that the assistant trigger has been correctly Handled.
        // Our Session window is 0x0 and Finish() happens in onShow.
        super.showSession(args, flags);
    }

    @Override
    public void onLaunchVoiceAssistFromKeyguard() {
        showSession(new Bundle(), 0);
    }
}
