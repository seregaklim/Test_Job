package com.seregaklim.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.snackbar.Snackbar
import com.seregaklim.adapter.ResponseAdapter
import com.seregaklim.adapter.ResponseInteractionListener
import com.seregaklim.testjob.R
import com.seregaklim.testjob.databinding.FragmentResponseBinding
import com.seregaklim.viewmodel.ResponsePViewModel
import com.seregaklim.viewmodel.SignViewModel

class FragmentResponse : Fragment() {
    private lateinit var binding: FragmentResponseBinding
    private val responsePViewModel: ResponsePViewModel by viewModels(ownerProducer = ::requireParentFragment)
    private val signViewModel: SignViewModel by viewModels(ownerProducer = ::requireParentFragment)
    private var token: String = ""

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {

        binding = FragmentResponseBinding.inflate(
            inflater,
            container,
            false
        )

        loadPayments()
        initAdapner()



        return binding.root
    }

    fun loadPayments() {
        token = signViewModel.tokenData.value.toString()
        responsePViewModel.loadPayments(token)
    }


    fun initAdapner() {
        val adapter = ResponseAdapter(object : ResponseInteractionListener {


        })

        binding.list.adapter = adapter
        binding.list.layoutManager = LinearLayoutManager(requireContext())

        responsePViewModel.data.observe(viewLifecycleOwner
        ) { state ->
            adapter.submitList(state.responseX)
            //   Log.d("MyLog", "state.responseX ${state.responseX}")
            if (state == null) {
                binding.emptyText.visibility = View.VISIBLE
            } else {
                binding.emptyText.visibility = View.GONE
            }
        }
    }

}