package com.seregaklim.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import android.os.CountDownTimer
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.seregaklim.testjob.R
import com.seregaklim.testjob.databinding.FragmentLogotipBinding

class FragmentLogotip : Fragment() {
    private lateinit var binding: FragmentLogotipBinding
    private var timer: CountDownTimer? = null


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentLogotipBinding.inflate(
            inflater,
            container,
            false
        )

        startCountDownTimer(1000)

        return binding.root
    }

    private fun startCountDownTimer(timeMillis: Long) {
        timer?.cancel()
        timer = object : CountDownTimer(timeMillis, 1) {
            override fun onTick(timeM: Long) {
                binding.logotipStart
            }

            @SuppressLint("SuspiciousIndentation")
            override fun onFinish() {
                 findNavController().navigate(R.id.action_fragmentLogotip_to_signFragment)

            }
        }.start()
    }

}