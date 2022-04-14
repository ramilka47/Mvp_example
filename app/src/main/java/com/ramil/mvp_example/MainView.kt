package com.ramil.mvp_example

// обновление ui идет в Main потоке, нужно учитывать
interface MainView {

    fun updateUI()

    fun toSplashFragment()

}