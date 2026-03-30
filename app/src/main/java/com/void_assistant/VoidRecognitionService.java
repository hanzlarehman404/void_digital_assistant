package com.void_assistant;

import android.speech.RecognitionService;
import android.content.Intent;
import android.os.Bundle;

/**
 * Stub RecognitionService.
 * Declared in voice_interaction_service.xml as recognitionService.
 * Android checks it exists and can bind — no real speech processing needed.
 */
public class VoidRecognitionService extends RecognitionService {

    @Override
    protected void onStartListening(Intent recognizerIntent, Callback listener) {
        // Immediately report empty results — no audio captured.
        listener.results(new Bundle());
    }

    @Override
    protected void onCancel(Callback listener) { }

    @Override
    protected void onStopListening(Callback listener) { }
}
