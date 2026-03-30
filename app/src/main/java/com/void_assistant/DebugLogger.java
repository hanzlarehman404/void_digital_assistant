package com.void_assistant;

import android.content.Context;
import android.os.Environment;
import android.util.Log;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DebugLogger {
    private static final String TAG = "VoidDebug";
    private static final String FILENAME = "void_assistant_log.txt";

    public static void log(Context context, String message) {
        String timestamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.getDefault()).format(new Date());
        String logEntry = timestamp + " | " + message + "\n";
        
        Log.d(TAG, message);

        try {
            // Use getExternalFilesDir to avoid permission issues on targetSdk 34
            // This will be in /sdcard/Android/data/com.void_assistant/files/void_assistant_log.txt
            File dir = context.getExternalFilesDir(null);
            if (dir != null) {
                File file = new File(dir, FILENAME);
                FileWriter writer = new FileWriter(file, true);
                writer.write(logEntry);
                writer.flush();
                writer.close();
            }
        } catch (IOException e) {
            Log.e(TAG, "Failed to write log to file", e);
        }
    }
}
