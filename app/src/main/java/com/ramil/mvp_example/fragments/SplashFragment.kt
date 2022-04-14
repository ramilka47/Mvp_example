package com.ramil.mvp_example.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.ramil.mvp_example.R

class SplashFragment : Fragment(), SplashView {

    private val presenter : SplashPresenter by lazy { SplashPresenter() }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        presenter.onAttach(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_splash, container, false)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // используется для сохранения состояния фрагмента в случае переворота
        // (есть множество способов неиспользования данного метода)
        retainInstance = true
        presenter.onCreate()
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.onDestroy()
    }

    override fun updateUI() {
        // updateUI components
    }

    override fun showToast(msg: String) {
        showShortToast(msg)
    }

    private fun showShortToast(msg : String){
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show()
    }

}