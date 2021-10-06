package com.peacecodes.fragmentexample

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.peacecodes.fragmentexample.databinding.FirstFragmentBinding

class FirstFragment: Fragment() {

    private lateinit var binding: FirstFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FirstFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.textLayout.editText?.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, s1: Int, s2: Int, s3: Int) {
            }

            override fun onTextChanged(s: CharSequence?, s1: Int, s2: Int, s3: Int) {
                binding.textLayout.editText
            }

            override fun afterTextChanged(s: Editable?) {}
        })
        binding.btnSubmit.setOnClickListener{
            val move = FirstFragmentDirections.actionFirstFragmentToSecondFragment2(binding.textLayout.editText?.text.toString())
            findNavController().navigate(move)
        }
    }

}