# 🚑 Pratham-Chikitse — ಪ್ರಥಮ ಚಿಕಿತ್ಸೆ
### Offline First Aid Emergency Guide | Android App

> Developed as part of MindMatrix Internship — Android App Development Using Gen AI

---

## 📌 Problem Statement
In emergencies like Snake Bite, Heart Attack, and Choking, the first 5 minutes are critical.
People in rural areas panic or follow wrong home remedies due to lack of accurate guidance in their local language.

## ✅ Solution
Pratham-Chikitse is a **fully offline**, bilingual Android app that provides:
- ✅ Step-by-step first aid instructions
- ✅ Do's and Don'ts for each emergency
- ✅ Audio Mode (Text-To-Speech in Kannada & English)
- ✅ Nearest Hospital Finder
- ✅ Emergency Helpline 108 / 112
- ✅ Severity badges — Critical / High / Moderate

---

## 🚨 Emergencies Covered

| Emergency | Kannada | Severity |
|---|---|---|
| Snake Bite | ಹಾವು ಕಡಿತ | 🔴 Critical |
| Heart Attack | ಹೃದಯ ಸ್ತಂಭನ | 🔴 Critical |
| Choking | ಗಂಟಲು ಕಟ್ಟುವಿಕೆ | 🔴 Critical |
| Burns | ಸುಟ್ಟ ಗಾಯ | 🟠 High |
| Fracture | ಮೂಳೆ ಮುರಿತ | 🟠 High |
| Bleeding | ರಕ್ತಸ್ರಾವ | 🟢 Moderate |
| Head Injury | ತಲೆ ಗಾಯ | 🟠 High |
| Poisoning | ವಿಷ ಸೇವನೆ | 🟢 Moderate |

---

## 🛠 Technologies Used

| Technology | Purpose |
|---|---|
| Kotlin | Primary programming language |
| XML Layouts | UI design and screen rendering |
| RecyclerView + GridLayoutManager | Emergency tile grid |
| ViewPager2 | Step-by-step instruction navigation |
| Android TextToSpeech API | Audio mode in Kannada & English |
| Navigation Component | Fragment navigation |
| Emergency Call Intents | Direct 108 dialling |
| Drawable Resources | Offline asset storage |
| Android Studio | IDE for development |

---

## 📱 App Screens

| Screen | Description |
|---|---|
| 🏠 Home | Emergency tiles with severity badges + SOS banner |
| 📋 Step Guide | Step-by-step instructions with Do's & Don'ts + ViewPager2 |
| 🏥 Hospitals | 3 nearest emergency centers with call buttons |
| 🔊 Audio Mode | TTS toggle with Kannada/English language selector |

---

## 🎯 Impact Goals
- 🏥 **Public Safety** — Reducing preventable deaths through basic medical knowledge
- 🌾 **Rural Resilience** — Empowering villagers before the ambulance arrives
- 🗣 **Language Equity** — Medical info available in the mother tongue (ಕನ್ನಡ)

---

## ⚡ Performance
- App loads in **under 500ms** (fully offline assets)
- No internet required — works in remote areas
- Single-tap Audio Mode toggle for hands-free operation

---

## 📁 Project Structure

```
PrathamChikitse/
├── app/src/main/
│   ├── java/com/pratham/chikitse/
│   │   ├── MainActivity.kt
│   │   ├── data/
│   │   │   ├── EmergencyData.kt
│   │   │   └── HospitalData.kt
│   │   ├── ui/
│   │   │   ├── HomeFragment.kt
│   │   │   ├── EmergencyAdapter.kt
│   │   │   ├── StepFragment.kt
│   │   │   ├── StepPagerAdapter.kt
│   │   │   ├── HospitalFragment.kt
│   │   │   ├── HospitalAdapter.kt
│   │   │   └── AudioFragment.kt
│   │   └── utils/
│   │       └── TTSHelper.kt
│   └── res/
│       ├── layout/          # XML layouts
│       ├── navigation/      # nav_graph.xml
│       ├── menu/            # bottom_nav_menu.xml
│       ├── values/          # colors, strings, themes
│       └── drawable/        # Icons and backgrounds
```

---

## 👩‍💻 Developer
**Spoorthi Gowda U**
Dayananda Sagar College of Engineering, Bengaluru
MindMatrix Internship — Android App Development Using Gen AI

---

## 📄 License
MIT License — feel free to use and modify with attribution.
