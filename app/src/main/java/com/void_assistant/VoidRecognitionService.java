package com.void_assistant;

import android.content.Intent;
import android.os.Bundle;
import android.os.RemoteException;
import android.speech.RecognitionService;
import android.util.Log;

public class VoidRecognitionService extends RecognitionService {
    private static final String TAG = "VoidRecognitionService";

    @Override
    protected void onStartListening(Intent recognizerIntent, Callback listener) {
        try {
            // 1. Signal that the 'mic' is ready
            listener.readyForSpeech(new Bundle());
            
            // 2. Immediately send empty results to satisfy the requester
            listener.results(new Bundle());
            
        } catch (RemoteException e) {
            Log.e(TAG, "Failed to communicate with the recognition client", e);
        }
    }

    @Override
    protected void onCancel(Callback listener) {
        // No cleanup needed for a stub
    }

    @Override
    protected void onStopListening(Callback listener) {
        // No-op: we don't hold any recording resources
    }
}