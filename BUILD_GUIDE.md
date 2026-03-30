# Void Assistant — Build & Setup Guide

## What This App Does
Registers itself as your phone's digital assistant.
When your headphone button triggers the assistant, this app silently absorbs the trigger
and finishes immediately — **no popup, no overlay, no interruption to your game.**

---

## Method 1: Build with Android Studio (Easiest)

### Step 1 — Install Android Studio
Download from: https://developer.android.com/studio
Install and let it download the Android SDK automatically.

### Step 2 — Open the Project
1. Open Android Studio
2. File → Open → select the `VoidAssistant` folder
3. Wait for Gradle sync to complete (~2 min first time)

### Step 3 — Build the APK
**Option A — Debug APK (install directly, no signing needed):**
```
Build → Build Bundle(s) / APK(s) → Build APK(s)
```
APK will be at: `app/build/outputs/apk/debug/app-debug.apk`

**Option B — Release APK (signed, for sharing):**
```
Build → Generate Signed Bundle / APK → APK
```
Create a keystore when prompted, fill in any values you like.
APK will be at: `app/build/outputs/apk/release/app-release.apk`

### Step 4 — Install on Phone
Transfer the APK to your phone and install it.
(Enable "Install from Unknown Sources" in Settings → Security if prompted)

---

## Method 2: Build with Command Line (No Android Studio UI)

### Prerequisites
- Java JDK 17+ installed
- Android SDK installed (or just Android Studio)

```bash
# Clone / extract the project, then:
cd VoidAssistant

# Make gradlew executable (Linux/Mac)
chmod +x gradlew

# Build debug APK
./gradlew assembleDebug

# APK location:
# app/build/outputs/apk/debug/app-debug.apk
```

**Windows:**
```cmd
cd VoidAssistant
gradlew.bat assembleDebug
```

---

## Method 3: Online Build (No PC needed)

1. Go to https://appetize.io or use **GitHub Actions**
2. Or use **Buildozer** online services
3. **Easiest online option:** Upload to https://replit.com, install Android SDK, run gradle

---

## Method 4: Use an APK Builder App (Phone only)

Apps like **AIDE** (Android IDE) on Play Store let you compile Java projects
directly on your phone. Import the project files and build.

---

## CRITICAL: Set Void Assistant as Default Assistant

After installing, you MUST set it as default or headphone triggers still go to Gemini/Google.

### On Stock Android / Pixel:
```
Settings → Apps → Default Apps → Digital Assistant App → Void Assistant
```

### On Samsung (One UI):
```
Settings → Apps → Choose Default Apps → Digital Assistant App → Void Assistant
```

### On Xiaomi / MIUI:
```
Settings → Apps → Manage Apps → Default Apps → Voice Assistant → Void Assistant
```

### On OnePlus / OxygenOS:
```
Settings → Apps & Notifications → Default Apps → Assist & Voice Input → Void Assistant
```

### Alternative method (works on all Android):
1. Long-press the Home button (or use the gesture that opens your assistant)
2. Tap the settings icon that appears
3. Tap "Change" or "Assistant"
4. Select "Void Assistant"

---

## How It Works (Technical)

```
Headphone button pressed
        │
        ▼
Android broadcasts ACTION_ASSIST
        │
        ▼
VoidVoiceService receives it (registered as VoiceInteractionService)
        │
        ▼
AssistActivity is launched with transparent theme
        │
        ▼
onCreate() calls finish() immediately
        │
        ▼
Activity destroyed — nothing happened
        │
        ▼
Your game continues uninterrupted ✅
```

### Why no overlay / black flash?
- `AssistActivity` uses `Theme.VoidAssistant.Transparent`
- `android:windowIsTranslucent="true"` — no background
- `android:backgroundDimEnabled="false"` — no dim
- `android:windowAnimationStyle="@null"` — no enter/exit animation
- `android:excludeFromRecents="true"` — won't appear in recent apps
- `finish()` called in `onCreate()` — lives for < 1 frame

---

## Files Structure

```
VoidAssistant/
├── app/
│   └── src/main/
│       ├── AndroidManifest.xml          ← Declares assistant capabilities
│       ├── java/com/void_assistant/
│       │   ├── MainActivity.java        ← Launcher screen (info only)
│       │   ├── AssistActivity.java      ← THE CORE: absorbs & ignores trigger
│       │   ├── VoidVoiceService.java    ← Registers as VoiceInteractionService
│       │   └── VoidSessionService.java  ← Required companion service
│       └── res/
│           ├── xml/voice_interaction_service.xml
│           └── values/
│               ├── strings.xml
│               └── styles.xml          ← Transparent theme definition
├── build.gradle
├── settings.gradle
└── gradle.properties
```

---

## Troubleshooting

**"App not showing in Default Assistant list"**
→ The VoiceInteractionService needs to be running.
→ Go to Settings → Apps → Void Assistant → Permissions → allow Microphone.
→ Restart phone, try again.

**"Still seeing a flash when assistant triggers"**
→ Make sure minSdk is 26+ and the transparent style is applied correctly.
→ On MIUI/One UI, there may be a system overlay — disable "Bixby" or "Mi AI" separately.

**"Headphone button still opens Google"**
→ Some OEMs hard-code the headphone button to their own assistant.
→ Try: Settings → Accessibility → Interaction Controls → disable system assistant shortcut.
→ Or use a button remapper app (Button Mapper on Play Store) to intercept the headphone button before Android sees it.

**Build error: "Gradle sync failed"**
→ Check you have JDK 17 (not 8 or 11): `java -version`
→ In Android Studio: File → Project Structure → SDK Location → set JDK to 17

---

## Reverting (Going Back to Google Assistant)

Settings → Apps → Default Apps → Digital Assistant → Google / Gemini
