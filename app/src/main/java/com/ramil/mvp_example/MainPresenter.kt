package com.ramil.mvp_example

// Можно инициализировать с инъекциями
class MainPresenter {

    private lateinit var mainView: MainView

    fun onAttach(mainView_ : MainView){
        mainView = mainView_
    }

    fun onCreate(){
        mainView.toSplashFragment()
    }

    fun onDestroy(){
    }

}