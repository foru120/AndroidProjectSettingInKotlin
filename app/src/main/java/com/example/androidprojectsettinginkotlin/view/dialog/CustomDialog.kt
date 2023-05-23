package com.example.androidprojectsettinginkotlin.view.dialog

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.databinding.DataBindingUtil
import com.example.androidprojectsettinginkotlin.R
import com.example.androidprojectsettinginkotlin.constants.*
import com.example.androidprojectsettinginkotlin.databinding.DialogCustomBinding
import com.example.androidprojectsettinginkotlin.databinding.DialogCustomBindingImpl
import com.example.androidprojectsettinginkotlin.databinding.DialogExceptionBinding
import com.example.androidprojectsettinginkotlin.view.BaseDialog

class CustomDialog constructor(
    context: Context,
    private val type: String,
    private val onClickListener: View.OnClickListener): BaseDialog(context) {

    private lateinit var binding: DialogCustomBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.dialog_custom, null, false)
        setContentView(binding.root)

        when (type) {
            DIALOG_TYPE_PERMISSION -> {
                binding.dialogTitle.text = context.getText(R.string.dialog_permission_title)
                binding.dialogContent.text = context.getString(R.string.dialog_permission_content)
            }
            DIALOG_TYPE_PERMISSION_ONCE -> {
                binding.dialogTitle.text = context.getText(R.string.dialog_permission_title)
                binding.dialogContent.text = context.getString(R.string.dialog_permission_once_content)
            }
            DIALOG_TYPE_PERMISSION_TWICE -> {
                binding.dialogTitle.text = context.getText(R.string.dialog_permission_title)
                binding.dialogContent.text = context.getString(R.string.dialog_permission_twice_content)
            }
        }

        context.dialogResize(this, 0.8f, 0.23f)
        binding.okBtn.setOnClickListener(onClickListener)
    }
}