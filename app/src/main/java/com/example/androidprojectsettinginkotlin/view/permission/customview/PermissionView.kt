package com.example.androidprojectsettinginkotlin.view.permission.customview

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.databinding.DataBindingUtil
import com.example.androidprojectsettinginkotlin.R
import com.example.androidprojectsettinginkotlin.databinding.ViewPermissionBinding

class PermissionView constructor(context: Context, attrs: AttributeSet?): ConstraintLayout(context, attrs) {
    val binding: ViewPermissionBinding

    init {
        binding = DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.view_permission, this, true)

        attrs?.let {
            context.obtainStyledAttributes(
                attrs,
                R.styleable.PermissionView
            ).apply {
                binding.titleView.text = getString(R.styleable.PermissionView_title)
                binding.contentView.text = getString(R.styleable.PermissionView_content)

                recycle()
            }
        }
    }
}