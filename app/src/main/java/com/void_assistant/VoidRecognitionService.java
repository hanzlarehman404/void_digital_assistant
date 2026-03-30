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
            listener.results(new Bundle());
        } catch (RemoteException ignored) {
        }
    }

    @Override
    protected void onCancel(Callback listener) {
        // Required override - no-op for a stub
    }

    @Override
    protected void onStopListening(Callback listener) {
        // Required override - no-op for a stub
    }
}