package com.void_assistant;
import android.app.Activity;
import android.os.Bundle;
import android.widget.*;
import android.view.*;
import android.graphics.*;
import android.graphics.drawable.GradientDrawable;
public class MainActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LinearLayout root = new LinearLayout(this);
        root.setOrientation(LinearLayout.VERTICAL);
        root.setGravity(Gravity.CENTER);
        root.setBackgroundColor(Color.parseColor("#0F0F1A"));
        TextView t = new TextView(this);
        t.setText("Void Assistant\nActive & Silent");
        t.setTextColor(Color.WHITE);
        t.setTextSize(22);
        t.setGravity(Gravity.CENTER);
        TextView s = new TextView(this);
        s.setText("\nHeadphone assistant triggers are blocked.\nYour games run uninterrupted.");
        s.setTextColor(Color.parseColor("#AAAAAA"));
        s.setTextSize(14);
        s.setGravity(Gravity.CENTER);
        root.addView(t);
        root.addView(s);
        setContentView(root);
    }
}