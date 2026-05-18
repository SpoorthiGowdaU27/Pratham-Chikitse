package com.pratham.chikitse.data

data class EmergencyStep(
    val instructionEn: String,
    val instructionKn: String,
    val doText: String,
    val dontText: String
)

data class Emergency(
    val id: Int,
    val nameEn: String,
    val nameKn: String,
    val icon: String,
    val severity: Severity,
    val steps: List<EmergencyStep>
)

enum class Severity { CRITICAL, HIGH, MODERATE }

object EmergencyRepository {
    val emergencies = listOf(
        Emergency(
            id = 0,
            nameEn = "Snake Bite",
            nameKn = "ಹಾವು ಕಡಿತ",
            icon = "🐍",
            severity = Severity.CRITICAL,
            steps = listOf(
                EmergencyStep(
                    "Stay calm. Do NOT run or panic.",
                    "ಶಾಂತರಾಗಿರಿ. ಓಡಬೇಡಿ ಅಥವಾ ಗಾಬರಿ ಬೇಡ.",
                    "Keep victim still and at heart level",
                    "Suck venom or make cuts"
                ),
                EmergencyStep(
                    "Remove rings and watch near the bite area.",
                    "ಕಡಿತದ ಬಳಿ ಉಂಗುರ, ವಾಚ್ ತೆಗೆಯಿರಿ.",
                    "Mark bite area with pen and note time",
                    "Apply tourniquet or ice"
                ),
                EmergencyStep(
                    "Carry victim to hospital. Do NOT let them walk.",
                    "ರೋಗಿಯನ್ನು ಆಸ್ಪತ್ರೆಗೆ ಒಯ್ಯಿರಿ. ನಡೆಯಲು ಬಿಡಬೇಡಿ.",
                    "Call 108 immediately",
                    "Give food, drink or medicine"
                )
            )
        ),
        Emergency(
            id = 1,
            nameEn = "Heart Attack",
            nameKn = "ಹೃದಯ ಸ್ತಂಭನ",
            icon = "❤️",
            severity = Severity.CRITICAL,
            steps = listOf(
                EmergencyStep(
                    "Call 108 immediately. Time is critical.",
                    "ತಕ್ಷಣ 108 ಕರೆ ಮಾಡಿ. ಸಮಯ ಅಮೂಲ್ಯ.",
                    "Loosen tight clothing",
                    "Leave the person alone"
                ),
                EmergencyStep(
                    "Sit or lay the person down comfortably.",
                    "ಅವರನ್ನು ಕೂರಿಸಿ ಅಥವಾ ಮಲಗಿಸಿ. ಆರಾಮ ಕೊಡಿ.",
                    "Give aspirin if conscious and not allergic",
                    "Give water or food"
                ),
                EmergencyStep(
                    "If unconscious and not breathing: start CPR.",
                    "ಪ್ರಜ್ಞೆ ಇಲ್ಲ ಮತ್ತು ಉಸಿರಿಲ್ಲದಿದ್ದರೆ: CPR ಪ್ರಾರಂಭಿಸಿ.",
                    "30 chest compressions then 2 breaths",
                    "Stop CPR until help arrives"
                )
            )
        ),
        Emergency(
            id = 2,
            nameEn = "Choking",
            nameKn = "ಗಂಟಲು ಕಟ್ಟುವಿಕೆ",
            icon = "🫁",
            severity = Severity.CRITICAL,
            steps = listOf(
                EmergencyStep(
                    "Ask: Are you choking? If no speech — act fast.",
                    "ಕೇಳಿ: ನಿಮಗೆ ಉಸಿರು ಕಟ್ಟಿದೆಯೇ? ಮಾತಾಡಲಾಗದಿದ್ದರೆ ತಕ್ಷಣ ಕ್ರಮ ತೆಗೆಯಿರಿ.",
                    "Stand behind the person",
                    "Slap back if they can still cough strongly"
                ),
                EmergencyStep(
                    "Give 5 firm back blows between shoulder blades.",
                    "ಭುಜದ ಮಧ್ಯ 5 ಬಾರಿ ಗಟ್ಟಿಯಾಗಿ ಬೆನ್ನು ತಟ್ಟಿ.",
                    "Use the heel of your hand firmly",
                    "Hit softly — it will not help"
                ),
                EmergencyStep(
                    "Still blocked? Give 5 abdominal thrusts (Heimlich).",
                    "ಇನ್ನೂ ಅಡ್ಡಿಯಿದ್ದರೆ? 5 ಹೊಟ್ಟೆ ಒತ್ತಡ ಕೊಡಿ (Heimlich).",
                    "Fist between navel and ribs, pull up and inward",
                    "Use Heimlich on infants under 1 year"
                )
            )
        ),
        Emergency(
            id = 3,
            nameEn = "Burns",
            nameKn = "ಸುಟ್ಟ ಗಾಯ",
            icon = "🔥",
            severity = Severity.HIGH,
            steps = listOf(
                EmergencyStep(
                    "Cool burn under running water for 20 minutes.",
                    "ಸುಟ್ಟ ಜಾಗದಲ್ಲಿ 20 ನಿಮಿಷ ಹರಿಯುವ ತಣ್ಣೀರು ಸುರಿಯಿರಿ.",
                    "Remove jewellery near the burn",
                    "Use ice, butter, or toothpaste"
                ),
                EmergencyStep(
                    "Cover loosely with clean cloth or cling film.",
                    "ಶುಚಿ ಬಟ್ಟೆ ಅಥವಾ ಕ್ಲಿಂಗ್ ಫಿಲ್ಮ್ ಸಡಿಲವಾಗಿ ಹೊದೆಸಿ.",
                    "Keep the victim warm to prevent shock",
                    "Wrap tightly or burst blisters"
                ),
                EmergencyStep(
                    "For large or deep burns: call 108 immediately.",
                    "ದೊಡ್ಡ ಅಥವಾ ಆಳವಾದ ಸುಡುವಿಕೆ: 108 ಕರೆ ಮಾಡಿ.",
                    "Watch for signs of shock",
                    "Remove burnt clothing stuck to skin"
                )
            )
        ),
        Emergency(
            id = 4,
            nameEn = "Fracture",
            nameKn = "ಮೂಳೆ ಮುರಿತ",
            icon = "🦴",
            severity = Severity.HIGH,
            steps = listOf(
                EmergencyStep(
                    "Do NOT move the injured limb. Keep it still.",
                    "ಗಾಯಗೊಂಡ ಅಂಗವನ್ನು ಅಲ್ಲಾಡಿಸಬೇಡಿ. ಸ್ಥಿರವಾಗಿ ಇಡಿ.",
                    "Support limb in position found",
                    "Try to straighten the broken bone"
                ),
                EmergencyStep(
                    "Splint the limb using a stick and cloth.",
                    "ಕೋಲು ಮತ್ತು ಬಟ್ಟೆ ಬಳಸಿ ಕಟ್ಟಿಗೆ ಬಾಂಧಿಸಿ.",
                    "Pad the splint with soft cloth",
                    "Tie too tightly — it cuts blood flow"
                ),
                EmergencyStep(
                    "Apply cloth-wrapped ice to reduce swelling.",
                    "ಬಾವು ಕಡಿಮೆ ಮಾಡಲು ಬಟ್ಟೆಯಲ್ಲಿ ಸುತ್ತಿದ ಐಸ್ ಇಡಿ.",
                    "Take victim to hospital immediately",
                    "Allow patient to walk on broken limb"
                )
            )
        ),
        Emergency(
            id = 5,
            nameEn = "Bleeding",
            nameKn = "ರಕ್ತಸ್ರಾವ",
            icon = "🩹",
            severity = Severity.MODERATE,
            steps = listOf(
                EmergencyStep(
                    "Press firmly and directly on the wound.",
                    "ಗಾಯದ ಮೇಲೆ ನೇರ ಮತ್ತು ಗಟ್ಟಿ ಒತ್ತಡ ಹಾಕಿ.",
                    "Use a clean cloth or bandage",
                    "Remove cloth if soaked — add more on top"
                ),
                EmergencyStep(
                    "Raise wound above heart level if possible.",
                    "ಸಾಧ್ಯವಾದರೆ ಗಾಯವನ್ನು ಹೃದಯಕ್ಕಿಂತ ಮೇಲೆ ಎತ್ತಿ ಹಿಡಿಯಿರಿ.",
                    "Press continuously for at least 10 minutes",
                    "Apply tourniquet unless trained"
                ),
                EmergencyStep(
                    "Bleeding not stopping after 10 min? Call 108.",
                    "10 ನಿಮಿಷದಲ್ಲಿ ರಕ್ತ ನಿಲ್ಲದಿದ್ದರೆ? 108 ಕರೆ ಮಾಡಿ.",
                    "Keep victim calm and lying down",
                    "Give the victim food or drink"
                )
            )
        ),
        Emergency(
            id = 6,
            nameEn = "Head Injury",
            nameKn = "ತಲೆ ಗಾಯ",
            icon = "🤕",
            severity = Severity.HIGH,
            steps = listOf(
                EmergencyStep(
                    "Keep the person still. Do NOT move their head.",
                    "ವ್ಯಕ್ತಿಯನ್ನು ಸ್ಥಿರವಾಗಿ ಇಡಿ. ತಲೆ ಅಲ್ಲಾಡಿಸಬೇಡಿ.",
                    "Support head and neck gently",
                    "Remove any object stuck in the skull"
                ),
                EmergencyStep(
                    "Check breathing. If unconscious — recovery position.",
                    "ಉಸಿರಾಟ ಪರೀಕ್ಷಿಸಿ. ಪ್ರಜ್ಞೆ ಇಲ್ಲದಿದ್ದರೆ ರಿಕವರಿ ಸ್ಥಾನದಲ್ಲಿ ಇಡಿ.",
                    "Watch for vomiting — tilt to side",
                    "Give fluids to unconscious person"
                ),
                EmergencyStep(
                    "Call 108 immediately. Watch for worsening signs.",
                    "ತಕ್ಷಣ 108 ಕರೆ ಮಾಡಿ. ಸ್ಥಿತಿ ಹದಗೆಡುವ ಲಕ್ಷಣ ಗಮನಿಸಿ.",
                    "Note time of injury for doctors",
                    "Let patient sleep before medical check"
                )
            )
        ),
        Emergency(
            id = 7,
            nameEn = "Poisoning",
            nameKn = "ವಿಷ ಸೇವನೆ",
            icon = "💊",
            severity = Severity.MODERATE,
            steps = listOf(
                EmergencyStep(
                    "Call 108 immediately. Identify the poison if possible.",
                    "ತಕ್ಷಣ 108 ಕರೆ ಮಾಡಿ. ಸಾಧ್ಯವಾದರೆ ವಿಷ ಗುರುತಿಸಿ.",
                    "Keep poison container for doctors",
                    "Make the person vomit unless told by doctor"
                ),
                EmergencyStep(
                    "If conscious: give small sips of water only.",
                    "ಪ್ರಜ್ಞೆ ಇದ್ದರೆ: ಸ್ವಲ್ಪ ನೀರು ಮಾತ್ರ ಕೊಡಿ.",
                    "Keep airway clear",
                    "Give milk, juice or food"
                ),
                EmergencyStep(
                    "If unconscious: recovery position and monitor.",
                    "ಪ್ರಜ್ಞೆ ಇಲ್ಲದಿದ್ದರೆ: ರಿಕವರಿ ಸ್ಥಾನದಲ್ಲಿ ಇಡಿ ಮತ್ತು ಗಮನಿಸಿ.",
                    "Stay with victim until help arrives",
                    "Leave them alone at any point"
                )
            )
        )
    )
}
