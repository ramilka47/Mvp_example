package com.ramil.mvp_example

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ramil.mvp_example.fragments.SplashFragment

// нужно учитывать жизненный цикл в презентере, либо здесь на null ссылки,
// т.к. может быть, что ваш презентер обновляет главный поток после обнуления(gc)
// (Здесь приведены минимальные create/destroy методы к презентору)
class MainActivity : AppCompatActivity(), MainView {

    private val mainPresenter : MainPresenter by lazy {
        // Можно инициализировать здесь в некоторых случаях
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
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragment_container, SplashFragment())
    }

    override fun updateUI() {
        // updateUI
    }

}