package com.pratham.chikitse.utils

import android.content.Context
import android.speech.tts.TextToSpeech
import android.speech.tts.TextToSpeech.OnInitListener
import android.util.Log
import java.util.Locale

class TTSHelper(context: Context) : OnInitListener {

    private var tts: TextToSpeech = TextToSpeech(context, this)
    private var isReady = false
    private var currentLang = "kn"

    override fun onInit(status: Int) {
        if (status == TextToSpeech.SUCCESS) {
            isReady = true
            setLanguage(currentLang)
        } else {
            Log.e("TTSHelper", "TextToSpeech initialization failed")
        }
    }

    fun setLanguage(lang: String) {
        currentLang = lang
        if (!isReady) return
        val locale = if (lang == "kn") Locale("kn", "IN") else Locale("en", "IN")
        val result = tts.setLanguage(locale)
        if (result == TextToSpeech.LANG_MISSING_DATA || result == TextToSpeech.LANG_NOT_SUPPORTED) {
            Log.w("TTSHelper", "Language not supported: $lang, falling back to English")
            tts.setLanguage(Locale.ENGLISH)
        }
    }

    fun speak(text: String) {
        if (!isReady) return
        tts.stop()
        tts.speak(text, TextToSpeech.QUEUE_FLUSH, null, "PC_TTS_${System.currentTimeMillis()}")
    }

    fun stop() {
        if (isReady) tts.stop()
    }

    fun shutdown() {
        tts.stop()
        tts.shutdown()
    }

    fun isReady() = isReady
}
