package com.void_assistant;
import android.service.voice.VoiceInteractionSessionService;
import android.service.voice.VoiceInteractionSession;
import android.os.Bundle;
public class VoidSessionService extends VoiceInteractionSessionService {
    @Override
    public VoiceInteractionSession onNewSession(Bundle args) {
        return new VoiceInteractionSession(this) {
            @Override public void onShow(Bundle args, int showFlags) { hide(); }
        };
    }
}