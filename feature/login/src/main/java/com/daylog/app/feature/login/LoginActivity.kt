package com.daylog.app.feature.login

import android.os.Bundle
import android.view.LayoutInflater
import com.daylog.app.core.common.BaseActivity
import com.daylog.app.core.navigation.MainNavigator
import com.daylog.app.feature.login.databinding.ActivityLoginBinding
import dagger.hilt.android.AndroidEntryPoint
import jakarta.inject.Inject

@AndroidEntryPoint
class LoginActivity : BaseActivity<ActivityLoginBinding>() {

    @Inject
    lateinit var mainNavigator: MainNavigator

    override fun inflateBinding(layoutInflater: LayoutInflater): ActivityLoginBinding {
        return ActivityLoginBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.btnLogin.setOnClickListener{
            mainNavigator.navigateToMain()
        }
    }
}