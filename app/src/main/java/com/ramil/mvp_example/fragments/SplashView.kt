package com.ramil.mvp_example.fragments

// обновление ui идет в Main потоке, нужно учитывать
interface SplashView {

    fun updateUI()

    fun showToast(msg : String)

}