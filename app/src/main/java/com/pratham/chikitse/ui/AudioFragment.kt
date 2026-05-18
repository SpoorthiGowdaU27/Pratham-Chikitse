package com.pratham.chikitse.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.pratham.chikitse.R
import com.pratham.chikitse.databinding.FragmentAudioBinding
import com.pratham.chikitse.utils.TTSHelper

class AudioFragment : Fragment() {

    private var _binding: FragmentAudioBinding? = null
    private val binding get() = _binding!!
    private lateinit var ttsHelper: TTSHelper
    private var audioEnabled = false
    private var selectedLang = "kn"

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAudioBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        ttsHelper = TTSHelper(requireContext())

        updateLangUI()

        binding.btnToggleAudio.setOnClickListener {
            audioEnabled = !audioEnabled
            updateAudioUI()
            if (audioEnabled) {
                val testText = if (selectedLang == "kn")
                    "ಆಡಿಯೋ ಮೋಡ್ ಸಕ್ರಿಯಗೊಳಿಸಲಾಗಿದೆ"
                else "Audio mode is now enabled"
                ttsHelper.speak(testText)
            } else {
                ttsHelper.stop()
            }
        }

        binding.btnLangEn.setOnClickListener {
            selectedLang = "en"
            ttsHelper.setLanguage("en")
            updateLangUI()
        }

        binding.btnLangKn.setOnClickListener {
            selectedLang = "kn"
            ttsHelper.setLanguage("kn")
            updateLangUI()
        }
    }

    private fun updateAudioUI() {
        if (audioEnabled) {
            binding.btnToggleAudio.text = "Audio ON — Tap to Disable"
            binding.btnToggleAudio.setBackgroundResource(R.drawable.bg_btn_audio_on)
        } else {
            binding.btnToggleAudio.text = "Tap to Enable Audio"
            binding.btnToggleAudio.setBackgroundResource(R.drawable.bg_btn_audio_off)
        }
    }

    private fun updateLangUI() {
        binding.btnLangKn.isSelected = selectedLang == "kn"
        binding.btnLangEn.isSelected = selectedLang == "en"
    }

    override fun onDestroyView() {
        ttsHelper.shutdown()
        super.onDestroyView()
        _binding = null
    }
}
