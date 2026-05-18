package com.pratham.chikitse.ui

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.viewpager2.widget.ViewPager2
import com.pratham.chikitse.data.EmergencyRepository
import com.pratham.chikitse.databinding.FragmentStepBinding
import com.pratham.chikitse.utils.TTSHelper

class StepFragment : Fragment() {

    private var _binding: FragmentStepBinding? = null
    private val binding get() = _binding!!
    private val args: StepFragmentArgs by navArgs()
    private lateinit var ttsHelper: TTSHelper
    private var audioEnabled = false
    private var currentLang = "kn"

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentStepBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        ttsHelper = TTSHelper(requireContext())
        val emergency = EmergencyRepository.emergencies[args.emergencyId]

        binding.tvStepTitle.text = emergency.nameEn
        binding.tvStepTitleKn.text = emergency.nameKn

        val adapter = StepPagerAdapter(emergency.steps, currentLang)
        binding.viewPagerSteps.adapter = adapter

        binding.viewPagerSteps.registerOnPageChangeCallback(object :
            ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                updateProgress(position, emergency.steps.size)
                if (audioEnabled) speakCurrentStep(position, emergency.steps)
                updateDoneBanner(position, emergency.steps.size)
            }
        })

        updateProgress(0, emergency.steps.size)

        binding.btnBack.setOnClickListener {
            ttsHelper.stop()
            findNavController().popBackStack()
        }

        binding.btnPrev.setOnClickListener {
            val current = binding.viewPagerSteps.currentItem
            if (current > 0) binding.viewPagerSteps.currentItem = current - 1
        }

        binding.btnNext.setOnClickListener {
            val current = binding.viewPagerSteps.currentItem
            if (current < emergency.steps.size - 1) {
                binding.viewPagerSteps.currentItem = current + 1
            }
        }

        binding.btnAudio.setOnClickListener {
            audioEnabled = !audioEnabled
            binding.btnAudio.setImageResource(
                if (audioEnabled) android.R.drawable.ic_lock_silent_mode_off
                else android.R.drawable.ic_lock_silent_mode
            )
            if (audioEnabled) {
                val pos = binding.viewPagerSteps.currentItem
                speakCurrentStep(pos, emergency.steps)
            } else {
                ttsHelper.stop()
            }
        }

        binding.btnCallSos.setOnClickListener {
            val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:108"))
            startActivity(intent)
        }
    }

    private fun updateProgress(position: Int, total: Int) {
        val progress = ((position + 1).toFloat() / total * 100).toInt()
        binding.progressBar.progress = progress
        binding.tvStepCounter.text = "STEP ${position + 1} OF $total"
        binding.btnPrev.isEnabled = position > 0
        binding.btnNext.isEnabled = position < total - 1
    }

    private fun updateDoneBanner(position: Int, total: Int) {
        binding.layoutDoneBanner.visibility =
            if (position == total - 1) View.VISIBLE else View.GONE
    }

    private fun speakCurrentStep(position: Int, steps: List<com.pratham.chikitse.data.EmergencyStep>) {
        val text = if (currentLang == "kn") steps[position].instructionKn
                   else steps[position].instructionEn
        ttsHelper.speak(text)
    }

    override fun onDestroyView() {
        ttsHelper.shutdown()
        super.onDestroyView()
        _binding = null
    }
}
