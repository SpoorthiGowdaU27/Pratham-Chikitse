package com.pratham.chikitse.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.pratham.chikitse.R
import com.pratham.chikitse.data.Emergency
import com.pratham.chikitse.data.Severity
import com.pratham.chikitse.databinding.ItemEmergencyTileBinding

class EmergencyAdapter(
    private var emergencies: List<Emergency>,
    private val onClick: (Emergency) -> Unit
) : RecyclerView.Adapter<EmergencyAdapter.ViewHolder>() {

    inner class ViewHolder(val binding: ItemEmergencyTileBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemEmergencyTileBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val emergency = emergencies[position]
        with(holder.binding) {
            tvIcon.text = emergency.icon
            tvNameEn.text = emergency.nameEn
            tvNameKn.text = emergency.nameKn

            when (emergency.severity) {
                Severity.CRITICAL -> {
                    tvSeverity.text = "CRITICAL"
                    tvSeverity.setBackgroundResource(R.drawable.bg_severity_critical)
                    tvSeverity.setTextColor(ContextCompat.getColor(root.context, R.color.red_dark))
                }
                Severity.HIGH -> {
                    tvSeverity.text = "HIGH"
                    tvSeverity.setBackgroundResource(R.drawable.bg_severity_high)
                    tvSeverity.setTextColor(ContextCompat.getColor(root.context, R.color.amber_dark))
                }
                Severity.MODERATE -> {
                    tvSeverity.text = "MODERATE"
                    tvSeverity.setBackgroundResource(R.drawable.bg_severity_moderate)
                    tvSeverity.setTextColor(ContextCompat.getColor(root.context, R.color.green_dark))
                }
            }

            root.setOnClickListener { onClick(emergency) }
        }
    }

    override fun getItemCount() = emergencies.size

    fun updateList(newList: List<Emergency>) {
        emergencies = newList
        notifyDataSetChanged()
    }
}
