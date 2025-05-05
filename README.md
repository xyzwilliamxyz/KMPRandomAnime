# 🎲 Compose Multiplatform Random Anime Generator

A showcase project built with **Jetpack Compose Multiplatform**, demonstrating modern mobile development patterns and tooling across Android and iOS. It fetches data from the [Jikan API](https://jikan.moe), which provides access to anime information from MyAnimeList.

## 🎥 Demo Video
Take a look at a quick demo showcasing the UI in action on both platforms:
| Android | iOS |
|---------|-------|
| <video src="https://github.com/user-attachments/assets/30f1de7c-e423-4ad1-b6ad-1c3b2b49e916" /> | <video src="https://github.com/user-attachments/assets/9016767a-aebb-4649-ba46-678b5653dbc3" /> |

## 🚀 Features
- Cross-platform UI built with Jetpack Compose Multiplatform
- Seamless support for Android and iOS targets
- REST API integration with local caching on both platforms using `Room` and `SQLite`
- MVI architecture with clean modular boundaries
- Dependency injection with Koin
- Full support for light and dark themes
- Modular and reusable UI components

## 🌱 Quality
- Unit tests with `MockK`, including `Flow` testing
- JVM-based database tests using Robolectric and in-memory `Room`
- Snapshot testing with Paparazzi for both dark and light themes
- Consistent automatic code style with Spotless and custom `ktlint` rules for Compose

## 🛠️ Tech Stack & Libraries
- 🌐 [Ktor](https://github.com/ktorio/ktor): Asynchronous networking and API calls (with multiplatform support)
- 🖼️ [Coil](https://github.com/coil-kt/coil): Modern image loading with support for Compose and Ktor
- 🧬 [Koin](https://insert-koin.io/): Lightweight dependency injection framework for Kotlin
- 🧩 [Jetpack Compose](https://developer.android.com/jetpack/compose): Declarative UI toolkit for modern Android and multiplatform apps
- 🧭 [Navigation-Compose](https://developer.android.com/jetpack/compose/navigation): Navigation for Compose-based UIs
- 💾 [Room](https://developer.android.com/training/data-storage/room): Local database with SQLite support and compile-time safety
- 🧪 **Testing**:
  - [MockK](https://mockk.io/): Mocking library for Kotlin
  - [Robolectric](http://robolectric.org/): Run Android tests in the JVM
  - [kotlinx-coroutines-test](https://github.com/Kotlin/kotlinx.coroutines): Coroutine testing utilities
- 🧱 [Multiplatform Kotlin](https://kotlinlang.org/docs/multiplatform.html): Shared logic across Android, iOS, and Desktop
- 🧼 [Spotless](https://github.com/diffplug/spotless): Code formatting and linting
- 📸 [Paparazzi](https://github.com/cashapp/paparazzi): Screenshot testing for Compose UIs

## 📱 Platforms
- ✅ Android
- ✅ iOS
- ❌ Desktop/Web (can be added in the future)

## 🧪 Running Scripts

#### ✅ Run Unit Tests

Use the standard Gradle command to execute unit tests:

    ./gradlew test

#### 🖼️ Snapshot Testing with Paparazzi

Record and verify UI snapshots:

**Record snapshots**
    
    ./gradlew :composeApp:recordPaparazziDebug

**Verify snapshots**
    
    ./gradlew :composeApp:verifyPaparazziDebug

#### 🧼 Auto-format with Spotless

Automatically fix code style issues and apply formatting:

    ./gradlew spotlessApply


## 💡 Motivation
The goal of this project is to demystify Compose Multiplatform development, especially for those who want to build production-grade, cross-platform UIs using a unified codebase.

## 🙌 Contributing
Contributions are welcome! Feel free to fork, open issues, or create pull requests.
