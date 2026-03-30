package com.void_assistant;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
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
        root.setPadding(px(24), px(24), px(24), px(24));

        // Title
        TextView title = new TextView(this);
        title.setText("🔇 Void Assistant");
        title.setTextColor(Color.WHITE);
        title.setTextSize(28);
        title.setGravity(Gravity.CENTER);
        title.setTypeface(Typeface.DEFAULT_BOLD);
        title.setPadding(0, 0, 0, px(8));

        // Subtitle
        TextView sub = new TextView(this);
        sub.setText("Silent — Active — Gaming-safe");
        sub.setTextColor(Color.parseColor("#4B4BFF"));
        sub.setTextSize(15);
        sub.setGravity(Gravity.CENTER);
        sub.setPadding(0, 0, 0, px(36));

        // Status card
        LinearLayout card = makeCard();
        addRow(card, "✅", "Registered as digital assistant");
        addRow(card, "✅", "Headphone button trigger absorbed");
        addRow(card, "✅", "No overlay — game keeps focus");
        addRow(card, "📁", "Logs: Internal Storage/Android/data/com.void_assistant/files/void_assistant_log.txt");

        // Button to open default apps settings
        Button btn = new Button(this);
        btn.setText("Set as Default Assistant →");
        btn.setTextColor(Color.WHITE);
        btn.setTextSize(15);
        GradientDrawable btnBg = new GradientDrawable();
        btnBg.setShape(GradientDrawable.RECTANGLE);
        btnBg.setCornerRadius(px(12));
        btnBg.setColor(Color.parseColor("#4B4BFF"));
        btn.setBackground(btnBg);
        LinearLayout.LayoutParams btnP = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT);
        btnP.topMargin = px(28);
        btn.setLayoutParams(btnP);
        btn.setOnClickListener(v -> {
            try {
                startActivity(new Intent(Settings.ACTION_VOICE_INPUT_SETTINGS));
            } catch (Exception e) {
                try {
                    startActivity(new Intent(Settings.ACTION_SETTINGS));
                } catch (Exception ignored) {}
            }
        });

        root.addView(title);
        root.addView(sub);
        root.addView(card);
        root.addView(btn);
        setContentView(root);
    }

    private LinearLayout makeCard() {
        LinearLayout card = new LinearLayout(this);
        card.setOrientation(LinearLayout.VERTICAL);
        card.setPadding(px(20), px(16), px(20), px(16));
        GradientDrawable bg = new GradientDrawable();
        bg.setCornerRadius(px(16));
        bg.setColor(Color.parseColor("#1A1A2E"));
        card.setBackground(bg);
        card.setLayoutParams(new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT));
        return card;
    }

    private void addRow(LinearLayout parent, String emoji, String text) {
        LinearLayout row = new LinearLayout(this);
        row.setOrientation(LinearLayout.HORIZONTAL);
        row.setGravity(Gravity.CENTER_VERTICAL);
        LinearLayout.LayoutParams rp = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        rp.bottomMargin = px(10);
        row.setLayoutParams(rp);

        TextView e = new TextView(this);
        e.setText(emoji + "  ");
        e.setTextSize(16);

        TextView t = new TextView(this);
        t.setText(text);
        t.setTextColor(Color.parseColor("#CCCCCC"));
        t.setTextSize(14);

        row.addView(e);
        row.addView(t);
        parent.addView(row);
    }

    private int px(int dp) {
        return Math.round(dp * getResources().getDisplayMetrics().density);
    }
}
