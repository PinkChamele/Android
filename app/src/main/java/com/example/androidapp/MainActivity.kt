package com.example.androidapp

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import androidx.annotation.RequiresApi

class MainActivity : AppCompatActivity() {
    lateinit var radioGroupTypes: RadioGroup;
    lateinit var radioGroupFirms: RadioGroup;
    lateinit var radioButtonType: RadioButton;
    lateinit var radioButtonFirm: RadioButton;
    lateinit var textView: TextView;

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        radioGroupFirms = findViewById(R.id.radio_group_types);
        radioGroupTypes = findViewById(R.id.radio_group_firms);
        textView = findViewById(R.id.text_view_selected)

        val okButton: Button = findViewById(R.id.button_ok);
        okButton.setOnClickListener {
            if(radioGroupFirms.checkedRadioButtonId == -1 || radioGroupTypes.checkedRadioButtonId == -1) {
                Toast.makeText(this, "Make your choice firstly", Toast.LENGTH_SHORT).show();
            }
            else
            {
                val radioTypeId = radioGroupTypes.checkedRadioButtonId;
                val radioFirmId = radioGroupFirms.checkedRadioButtonId;

                radioButtonType = findViewById(radioTypeId);
                radioButtonFirm = findViewById(radioFirmId);

                textView.text = "Your choice is: " + radioButtonType.text + " and " + radioButtonFirm.text;
            }
        }

        val cancelButton: Button = findViewById(R.id.button_cancel);
        cancelButton.setOnClickListener {
            textView.text = "";
        }
    }
}