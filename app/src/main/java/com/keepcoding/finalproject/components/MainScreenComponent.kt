package com.keepcoding.finalproject.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.viewinterop.AndroidViewBinding
import com.keepcoding.finalproject.databinding.MainScreenBinding

@Composable
fun MainScreenComponent(
    onClick: (() -> Unit)? = null
) {
    AndroidViewBinding(factory = MainScreenBinding::inflate){
        btnLogin.setOnClickListener{
            if (onClick != null) {
                onClick()
            }
        }
    }
}