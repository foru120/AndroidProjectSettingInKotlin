package com.example.androidprojectsettinginkotlin.view.dialog

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View.OnClickListener
import androidx.databinding.DataBindingUtil
import com.example.androidprojectsettinginkotlin.R
import com.example.androidprojectsettinginkotlin.databinding.DialogExceptionBinding
import com.example.androidprojectsettinginkotlin.view.BaseDialog

class ExceptionDialog constructor(context: Context): BaseDialog(context) {
    private lateinit var _btnListener: OnClickListener
    var btnListener
        get() = _btnListener
        set(value) {
            _btnListener = value
        }
    private var _errorMessage: String? = null
    var errorMessage
        get() = _errorMessage
        set(value) {
            _errorMessage = value
        }

    private lateinit var binding: DialogExceptionBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.dialog_exception, null, false)

        setDialog()
    }

    private fun setDialog() {
        binding.dialogContent.text = errorMessage
        binding.okBtn.setOnClickListener(btnListener)
    }
}