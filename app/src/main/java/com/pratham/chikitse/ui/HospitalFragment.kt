package com.pratham.chikitse.ui

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.pratham.chikitse.data.HospitalRepository
import com.pratham.chikitse.databinding.FragmentHospitalBinding

class HospitalFragment : Fragment() {

    private var _binding: FragmentHospitalBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHospitalBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = HospitalAdapter(HospitalRepository.hospitals) { hospital ->
            val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:${hospital.phone}"))
            startActivity(intent)
        }
        binding.recyclerHospitals.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerHospitals.adapter = adapter

        binding.btnCallAmbulance.setOnClickListener {
            val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:108"))
            startActivity(intent)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
