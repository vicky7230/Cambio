package com.vicky7230.cambio.ui.currencies

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.vicky7230.cambio.R
import com.vicky7230.cambio.ui.base.BaseActivity
import dagger.android.AndroidInjection
import kotlinx.android.synthetic.main.activity_home.*
import javax.inject.Inject


class CurrenciesActivity : BaseActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    @Inject
    lateinit var currenciesAdapter: CurrenciesAdapter

    private lateinit var currenciesViewModel: CurrenciesViewModel

    companion object {
        fun getStartIntent(context: Context): Intent {
            return Intent(context, CurrenciesActivity::class.java)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        currenciesViewModel = ViewModelProvider(
            this,
            viewModelFactory
        )[CurrenciesViewModel::class.java]

        init()
    }

    private fun init() {

        setSupportActionBar(toolbar)

        currency_list.layoutManager = LinearLayoutManager(this)
        currency_list.addItemDecoration(
            ItemOffsetDecoration(
                resources.getDimensionPixelOffset(R.dimen.currency_list_offset)
            )
        )
        currency_list.adapter = currenciesAdapter

        currenciesViewModel.loading.observe(this, Observer {
            if (it)
                showLoading()
            else
                hideLoading()
        })

        currenciesViewModel.error.observe(this, Observer {
            showError(it)
        })

        currenciesViewModel.currencies.observe(this, Observer {
            currenciesAdapter.addItems(it)
        })

        currenciesViewModel.getCurrencies()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_currencies_activity, menu)
        return super.onCreateOptionsMenu(menu)
    }
}
