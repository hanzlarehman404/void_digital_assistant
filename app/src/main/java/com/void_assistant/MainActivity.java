package com.void_assistant;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.LinearLayout;
import android.view.Gravity;
import android.graphics.Color;
import android.widget.ImageView;
import android.graphics.drawable.GradientDrawable;
import android.view.ViewGroup.LayoutParams;
import android.widget.Toast;

/**
 * MainActivity - shown when user opens the app from launcher.
 * Displays a simple "Void Assistant is active" screen.
 */
public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Build UI programmatically - no XML layout needed
        LinearLayout root = new LinearLayout(this);
        root.setOrientation(LinearLayout.VERTICAL);
        root.setGravity(Gravity.CENTER);
        root.setBackgroundColor(Color.parseColor("#0F0F1A"));
        root.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));

        // Circle icon background
        LinearLayout circle = new LinearLayout(this);
        circle.setGravity(Gravity.CENTER);
        int size = dpToPx(100);
        LinearLayout.LayoutParams circleParams = new LinearLayout.LayoutParams(size, size);
        circleParams.bottomMargin = dpToPx(32);
        circle.setLayoutParams(circleParams);
        GradientDrawable circleDrawable = new GradientDrawable();
        circleDrawable.setShape(GradientDrawable.OVAL);
        circleDrawable.setColor(Color.parseColor("#1A1A2E"));
        circleDrawable.setStroke(dpToPx(2), Color.parseColor("#4B4BFF"));
        circle.setBackground(circleDrawable);

        // Icon text inside circle
        TextView icon = new TextView(this);
        icon.setText("\uD83D\uDD07"); // mute emoji
        icon.setTextSize(40);
        circle.addView(icon);

        // Title
        TextView title = new TextView(this);
        title.setText("Void Assistant");
        title.setTextColor(Color.WHITE);
        title.setTextSize(26);
        title.setGravity(Gravity.CENTER);
        title.setTypeface(android.graphics.Typeface.DEFAULT_BOLD);
        LinearLayout.LayoutParams titleParams = new LinearLayout.LayoutParams(
                LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        titleParams.bottomMargin = dpToPx(12);
        title.setLayoutParams(titleParams);

        // Subtitle
        TextView subtitle = new TextView(this);
        subtitle.setText("Active & Silent");
        subtitle.setTextColor(Color.parseColor("#4B4BFF"));
        subtitle.setTextSize(16);
        subtitle.setGravity(Gravity.CENTER);
        LinearLayout.LayoutParams subtitleParams = new LinearLayout.LayoutParams(
                LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        subtitleParams.bottomMargin = dpToPx(40);
        subtitle.setLayoutParams(subtitleParams);

        // Status card
        LinearLayout card = new LinearLayout(this);
        card.setOrientation(LinearLayout.VERTICAL);
        card.setGravity(Gravity.CENTER);
        card.setPadding(dpToPx(24), dpToPx(20), dpToPx(24), dpToPx(20));
        GradientDrawable cardBg = new GradientDrawable();
        cardBg.setShape(GradientDrawable.RECTANGLE);
        cardBg.setCornerRadius(dpToPx(16));
        cardBg.setColor(Color.parseColor("#1A1A2E"));
        card.setBackground(cardBg);
        LinearLayout.LayoutParams cardParams = new LinearLayout.LayoutParams(
                dpToPx(280), LayoutParams.WRAP_CONTENT);
        cardParams.bottomMargin = dpToPx(32);
        card.setLayoutParams(cardParams);

        addStatusRow(card, "✅", "Intercepts assistant triggers");
        addStatusRow(card, "✅", "No overlay during gaming");
        addStatusRow(card, "✅", "Silent — no sound or popup");
        addStatusRow(card, "✅", "Headphone button blocked");

        // Instructions
        TextView hint = new TextView(this);
        hint.setText("Set as Default Assistant in\nSettings → Apps → Default Apps → Digital Assistant");
        hint.setTextColor(Color.parseColor("#888888"));
        hint.setTextSize(13);
        hint.setGravity(Gravity.CENTER);
        hint.setPadding(dpToPx(24), 0, dpToPx(24), 0);

        root.addView(circle);
        root.addView(title);
        root.addView(subtitle);
        root.addView(card);
        root.addView(hint);

        setContentView(root);
    }

    private void addStatusRow(LinearLayout parent, String emoji, String text) {
        LinearLayout row = new LinearLayout(this);
        row.setOrientation(LinearLayout.HORIZONTAL);
        row.setGravity(Gravity.CENTER_VERTICAL);
        LinearLayout.LayoutParams rowParams = new LinearLayout.LayoutParams(
                LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
        rowParams.bottomMargin = dpToPx(10);
        row.setLayoutParams(rowParams);

        TextView emojiView = new TextView(this);
        emojiView.setText(emoji);
        emojiView.setTextSize(16);
        LinearLayout.LayoutParams emojiParams = new LinearLayout.LayoutParams(
                LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        emojiParams.rightMargin = dpToPx(10);
        emojiView.setLayoutParams(emojiParams);

        TextView textView = new TextView(this);
        textView.setText(text);
        textView.setTextColor(Color.parseColor("#CCCCCC"));
        textView.setTextSize(14);

        row.addView(emojiView);
        row.addView(textView);
        parent.addView(row);
    }

    private int dpToPx(int dp) {
        float density = getResources().getDisplayMetrics().density;
        return Math.round(dp * density);
    }
}
