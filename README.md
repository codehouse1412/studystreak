# Streak Pomodoro (skeleton project)

This is a minimal skeleton Android Studio project for the "Streak Pomodoro" app with:
- Home screen widget (small & medium layouts included)
- Main activity showing today's studied time and a warning popup demo
- Pomodoro activity with a basic timer
- Room DB placeholders
- GitHub Actions workflow that builds the debug APK if a Gradle wrapper is present.

**Notes**
- This project is a starting point. It intentionally includes placeholders (Room entities and full timer service logic) to keep the zip small and editable.
- To enable GitHub Actions automatic build you should add the Gradle wrapper files locally:
  1. Open the project in Android Studio and sync/build once — Android Studio will generate the Gradle wrapper.
  2. Commit the generated `gradlew`, `gradlew.bat`, and `gradle/wrapper/*` files and push to GitHub.
- After pushing, GitHub Actions (the included workflow) will run and upload `app-debug.apk` as an artifact.

## How to build locally
1. Unzip the project.
2. Open in Android Studio.
3. Let Gradle sync. (Android Studio will prompt to install the Android SDK/Gradle if missing.)
4. Build > Build APK(s).
5. Install the generated `app-debug.apk` on your device.

