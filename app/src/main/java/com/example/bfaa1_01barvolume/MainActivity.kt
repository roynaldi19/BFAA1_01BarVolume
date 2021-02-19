package com.example.bfaa1_01barvolume

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    companion object {
        private const val STATE_RESULT = "state_result"
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        btn_calculate.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        if (v.id == R.id.btn_calculate) {
            val inputLength = edt_length.text.toString().trim()
            val inputWidth = edt_width.text.toString().trim()
            val inputHeight = edt_height.text.toString().trim()

            var isEmptyFields = false

            when {
                inputLength.isEmpty() -> {
                    isEmptyFields = true
                    edt_length.error = "Field ini tidak boleh kosong"
                }
                inputWidth.isEmpty() -> {
                    isEmptyFields = true
                    edt_length.error = "Field ini tidak boleh kosong"
                }
                inputHeight.isEmpty() -> {
                    isEmptyFields = true
                    edt_height.error = "Field ini tidak boleh kosong"
                }
            }

            if (!isEmptyFields) {
                val volume = inputLength.toDouble() * inputWidth.toDouble() * inputHeight.toDouble()
                tv_result.text = volume.toString()
            }
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(STATE_RESULT, tv_result.text.toString())
    }
}