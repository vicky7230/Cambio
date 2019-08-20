package com.vicky7230.cambio.ui.home

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.google.android.material.tabs.TabLayout
import com.vicky7230.cambio.R
import com.vicky7230.cambio.ui.base.BaseActivity
import com.vicky7230.cambio.ui.home.currencies.CurrenciesFragment
import com.vicky7230.cambio.ui.home.exchangeRates.ExchangeRatesFragment
import com.vicky7230.cambio.ui.home.markets.MarketsFragment
import dagger.android.AndroidInjection
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.HasSupportFragmentInjector
import kotlinx.android.synthetic.main.activity_home.*
import java.util.*
import javax.inject.Inject


class HomeActivity : BaseActivity(), HasSupportFragmentInjector {

    @Inject
    lateinit var fragmentDispatchingAndroidInjector: DispatchingAndroidInjector<Fragment>
    @Inject
    lateinit var pagerAdapter: PagerAdapter


    companion object {
        fun getStartIntent(context: Context): Intent {
            return Intent(context, HomeActivity::class.java)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        init()
    }

    private fun init() {

        view_pager.offscreenPageLimit = 3
        view_pager.adapter = pagerAdapter

        tab_layout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabReselected(tab: TabLayout.Tab?) {
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
            }

            override fun onTabSelected(tab: TabLayout.Tab?) {

                tab_layout.getTabAt(0)?.text = ""
                tab_layout.getTabAt(1)?.text = ""
                tab_layout.getTabAt(2)?.text = ""
                tab_layout.getTabAt(3)?.text = ""

                tab_layout.getTabAt(0)?.icon =
                    ContextCompat.getDrawable(this@HomeActivity, R.drawable.ic_currency)
                tab_layout.getTabAt(1)?.icon =
                    ContextCompat.getDrawable(this@HomeActivity, R.drawable.ic_markets)
                tab_layout.getTabAt(2)?.icon =
                    ContextCompat.getDrawable(this@HomeActivity, R.drawable.ic_exchange_rates)
                tab_layout.getTabAt(3)?.icon =
                    ContextCompat.getDrawable(this@HomeActivity, R.drawable.ic_settings)

                tab?.text = when (tab?.position) {
                    0 -> "Currency"
                    1 -> "Markets"
                    2 -> "Exchange Rates"
                    3 -> "Settings"
                    else -> ""
                }
            }
        })

        tab_layout.setupWithViewPager(view_pager)
    }

    override fun supportFragmentInjector(): AndroidInjector<Fragment> {
        return fragmentDispatchingAndroidInjector
    }

}
