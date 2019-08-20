package com.vicky7230.cambio.ui.home.currencies


import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider

import com.vicky7230.cambio.R
import com.vicky7230.cambio.ui.base.BaseFragment
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject

class CurrenciesFragment : BaseFragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private lateinit var currenciesViewModel: CurrenciesViewModel

    companion object {
        fun newInstance() = CurrenciesFragment()
    }

    override fun onAttach(context: Context) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_currencies, container, false)

        currenciesViewModel = ViewModelProvider(
            this,
            viewModelFactory
        )[CurrenciesViewModel::class.java]

        return view
    }

    override fun setUp(view: View) {
        currenciesViewModel.liveData.observe(this, Observer {
            showMessage("Livedata updated")
        })
        showLoading()
        currenciesViewModel.getCurrencies()
    }
}
