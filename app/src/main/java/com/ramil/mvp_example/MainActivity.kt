package com.ramil.mvp_example

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ramil.mvp_example.fragments.SplashFragment

class MainActivity : AppCompatActivity(), MainView {

    private val mainPresenter : MainPresenter by lazy {
        MainPresenter().apply {
            onAttach(this@MainActivity)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mainPresenter.onCreate()
    }

    override fun onDestroy() {
        super.onDestroy()
        mainPresenter.onDestroy()
    }

    override fun toSplashFragment() {
        supportFragmentManager.beginTransaction().replace(R.id.fragment_container, SplashFragment())
    }

    override fun updateUI() {
        // updateUI
    }

}