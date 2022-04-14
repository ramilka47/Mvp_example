package com.ramil.mvp_example.fragments

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch

class SplashPresenter {

    private val coroutineIO = CoroutineScope(Dispatchers.IO)
    private val coroutineMain = CoroutineScope(Dispatchers.Main)
    private lateinit var splashView : SplashView

    fun onAttach(splashView_: SplashView){
        splashView = splashView_
    }

    fun onCreate(){
        coroutineIO.launch {
            val msg = "msg" // get msg for Toast
            intoMainThread {
                splashView.showToast(msg)
            }
        }
    }

    fun onDestroy(){
        coroutineIO.cancel()
    }

    private fun intoMainThread(blockMain : suspend ()->Unit){
        coroutineMain.launch {
            blockMain()
        }
    }

}