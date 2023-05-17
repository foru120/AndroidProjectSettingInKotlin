package com.example.androidprojectsettinginkotlin.view.dialog

import android.content.Context
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.View.OnClickListener
import androidx.databinding.DataBindingUtil
import com.example.androidprojectsettinginkotlin.R
import com.example.androidprojectsettinginkotlin.databinding.DialogExceptionBinding
import com.example.androidprojectsettinginkotlin.view.BaseDialog

class ExceptionDialog constructor(
    context: Context,
    private val onClickListener: OnClickListener
): BaseDialog(context) {

    private lateinit var binding: DialogExceptionBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.dialog_exception, null, false)
        setContentView(binding.root)

        context.dialogResize(this, 0.8f, 0.3f)
        binding.okBtn.setOnClickListener(onClickListener)
    }

    fun setErrorMessage(errorMessage: String?) {
        Log.d("kyh", if (!TextUtils.isEmpty(errorMessage)) errorMessage!! else "")
        binding.dialogContent.text = errorMessage
    }
}