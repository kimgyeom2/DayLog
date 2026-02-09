package com.daylog.app.feature.login

import android.os.Bundle
import android.view.LayoutInflater
import androidx.activity.viewModels
import com.daylog.app.core.common.BaseActivity
import com.daylog.app.core.navigation.Navigator
import com.daylog.app.feature.login.databinding.ActivityLoginBinding
import dagger.hilt.android.AndroidEntryPoint
import jakarta.inject.Inject

@AndroidEntryPoint
class LoginActivity : BaseActivity<ActivityLoginBinding>() {

    private val viewModel: LoginViewModel by viewModels()

    @Inject
    lateinit var navigator: Navigator

    override fun inflateBinding(layoutInflater: LayoutInflater): ActivityLoginBinding {
        return ActivityLoginBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.btnJoin.setOnClickListener{
            viewModel.signUp(binding.etId.text.toString(),binding.etPw.text.toString())
        }
        binding.btnLogin.setOnClickListener{
            viewModel.login(binding.etId.text.toString(),binding.etPw.text.toString())
        }
    }
}