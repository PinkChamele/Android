package com.example.fragments

import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import android.widget.Toast.makeText
import androidx.annotation.RequiresApi
import androidx.fragment.app.activityViewModels
import com.example.fragments.databinding.FragmentRadioButtonsBinding

class RadioButtons() : Fragment() {
    private val dataModel: DataModel by activityViewModels()
    private lateinit var binding: FragmentRadioButtonsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRadioButtonsBinding.inflate(inflater)
        return binding.root
    }

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.buttonOk.setOnClickListener {
            if(binding.radioGroupFirms.checkedRadioButtonId == -1 || binding.radioGroupTypes.checkedRadioButtonId == -1) {
                makeText(activity, "Make your choice first", Toast.LENGTH_SHORT).show()
            }
            else
            {
                val radioButtonFirm = view.findViewById<RadioButton>(binding.radioGroupFirms.checkedRadioButtonId)
                val radioButtonType = view.findViewById<RadioButton>(binding.radioGroupTypes.checkedRadioButtonId)
                dataModel.message.value = "Your choice is: " + radioButtonType.text + " and " + radioButtonFirm.text
            }
        }

        binding.buttonCancel.setOnClickListener {
            binding.radioGroupFirms.clearCheck()
            binding.radioGroupTypes.clearCheck()
            dataModel.message.value = ""
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() = RadioButtons()
    }
}