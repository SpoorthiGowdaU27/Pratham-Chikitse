package com.pratham.chikitse.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.pratham.chikitse.data.EmergencyStep
import com.pratham.chikitse.databinding.ItemStepPageBinding

class StepPagerAdapter(
    private val steps: List<EmergencyStep>,
    private val lang: String
) : RecyclerView.Adapter<StepPagerAdapter.StepViewHolder>() {

    inner class StepViewHolder(val binding: ItemStepPageBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StepViewHolder {
        val binding = ItemStepPageBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return StepViewHolder(binding)
    }

    override fun onBindViewHolder(holder: StepViewHolder, position: Int) {
        val step = steps[position]
        with(holder.binding) {
            tvInstructionEn.text = step.instructionEn
            tvInstructionKn.text = step.instructionKn
            tvDoText.text = step.doText
            tvDontText.text = step.dontText
        }
    }

    override fun getItemCount() = steps.size
}
