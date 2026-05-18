package com.pratham.chikitse.ui

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.pratham.chikitse.R
import com.pratham.chikitse.data.Emergency
import com.pratham.chikitse.data.EmergencyRepository
import com.pratham.chikitse.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private lateinit var adapter: EmergencyAdapter
    private var allEmergencies = EmergencyRepository.emergencies

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupRecyclerView()
        setupSearch()
        setupSosButton()
    }

    private fun setupRecyclerView() {
        adapter = EmergencyAdapter(allEmergencies) { emergency ->
            val action = HomeFragmentDirections
                .actionHomeFragmentToStepFragment(emergency.id)
            findNavController().navigate(action)
        }
        binding.recyclerEmergencies.layoutManager = GridLayoutManager(requireContext(), 2)
        binding.recyclerEmergencies.adapter = adapter
    }

    private fun setupSearch() {
        binding.editSearch.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                filterEmergencies(s.toString())
            }
            override fun afterTextChanged(s: Editable?) {}
        })
    }

    private fun filterEmergencies(query: String) {
        val filtered = if (query.isEmpty()) {
            allEmergencies
        } else {
            allEmergencies.filter {
                it.nameEn.contains(query, ignoreCase = true) ||
                it.nameKn.contains(query, ignoreCase = true)
            }
        }
        adapter.updateList(filtered)
    }

    private fun setupSosButton() {
        binding.btnCallNow.setOnClickListener {
            val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:108"))
            startActivity(intent)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
