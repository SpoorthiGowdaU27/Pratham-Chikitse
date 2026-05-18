package com.pratham.chikitse.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.pratham.chikitse.data.Hospital
import com.pratham.chikitse.databinding.ItemHospitalBinding

class HospitalAdapter(
    private val hospitals: List<Hospital>,
    private val onCall: (Hospital) -> Unit
) : RecyclerView.Adapter<HospitalAdapter.ViewHolder>() {

    inner class ViewHolder(val binding: ItemHospitalBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemHospitalBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val hospital = hospitals[position]
        with(holder.binding) {
            tvHospitalName.text = hospital.name
            tvHospitalMeta.text = buildString {
                if (hospital.isOpen24x7) append("24×7 Emergency · ")
                append(hospital.type)
            }
            tvDistance.text = "${hospital.distanceKm} km"
            btnCall.setOnClickListener { onCall(hospital) }
        }
    }

    override fun getItemCount() = hospitals.size
}
