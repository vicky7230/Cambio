package com.vicky7230.cambio.ui.home

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.google.android.material.tabs.TabLayout
import com.vicky7230.cambio.R
import com.vicky7230.cambio.ui.home.currencies.CurrenciesFragment
import com.vicky7230.cambio.ui.home.exchangeRates.ExchangeRatesFragment
import com.vicky7230.cambio.ui.home.markets.MarketsFragment
import kotlinx.android.synthetic.main.activity_home.*
import java.util.*


class HomeActivity : AppCompatActivity() {

    private val TAG_EXCHANGE = "Exchange"
    private val TAG_MARKETS = "Markets"
    private val TAG_CURRENCIES = "Currencies"

    private val stack = Stack<String>()

    private val currenciesFragment = CurrenciesFragment()
    private val marketsFragment = MarketsFragment()
    private val exchangeRatesFragment = ExchangeRatesFragment()

    private var active: Fragment = currenciesFragment

    private var stackEnabled = true

    companion object {
        fun getStartIntent(context: Context): Intent {
            return Intent(context, HomeActivity::class.java)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        init()
    }

    private fun init() {

        view_pager.offscreenPageLimit = 3
        view_pager.adapter = PagerAdapter(supportFragmentManager)

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


        /*supportFragmentManager.beginTransaction()
            .add(R.id.container, exchangeRatesFragment, TAG_EXCHANGE)
            .hide(exchangeRatesFragment)
            .commitNow()

        supportFragmentManager.beginTransaction()
            .add(R.id.container, marketsFragment, TAG_MARKETS)
            .hide(marketsFragment)
            .commitNow()

        supportFragmentManager.beginTransaction()
            .add(R.id.container, currenciesFragment, TAG_CURRENCIES)
            .commitNow()

        bottom_nav_view.setOnNavigationItemSelectedListener {
            if (stackEnabled && it.itemId != bottom_nav_view.selectedItemId) {
                pushActiveFragmentInStack()
            }
            when (it.itemId) {
                R.id.fragment_currencies -> {
                    if (active != currenciesFragment) {
                        supportFragmentManager.beginTransaction()
                            .hide(active)
                            .show(currenciesFragment)
                            .commitNow()
                        active = currenciesFragment
                    }
                    return@setOnNavigationItemSelectedListener true
                }

                R.id.fragment_markets -> {
                    if (active != marketsFragment) {
                        supportFragmentManager.beginTransaction()
                            .hide(active)
                            .show(marketsFragment)
                            .commitNow()
                        active = marketsFragment
                    }
                    return@setOnNavigationItemSelectedListener true
                }

                R.id.fragment_exchange_rates -> {
                    if (active != exchangeRatesFragment) {
                        supportFragmentManager.beginTransaction()
                            .hide(active)
                            .show(exchangeRatesFragment)
                            .commitNow()
                        active = exchangeRatesFragment
                    }
                    return@setOnNavigationItemSelectedListener true
                }

            }
            return@setOnNavigationItemSelectedListener false
        }*/
    }

    /*private fun pushActiveFragmentInStack() {
        when (active) {
            is CurrenciesFragment -> stack.push(TAG_CURRENCIES)
            is MarketsFragment -> stack.push(TAG_MARKETS)
            is ExchangeRatesFragment -> stack.push(TAG_EXCHANGE)
        }
    }*/

    /*override fun onBackPressed() {
        stackEnabled = false
        if (stack.empty())
            finish()
        else {
            when (stack.pop()) {
                TAG_CURRENCIES -> {
                    supportFragmentManager.beginTransaction()
                        .hide(active)
                        .show(currenciesFragment)
                        .commitNow()
                    active = currenciesFragment
                    bottom_nav_view.selectedItemId = R.id.fragment_currencies
                }

                TAG_MARKETS -> {
                    supportFragmentManager.beginTransaction()
                        .hide(active)
                        .show(marketsFragment)
                        .commitNow()
                    active = marketsFragment
                    bottom_nav_view.selectedItemId = R.id.fragment_markets
                }

                TAG_EXCHANGE -> {
                    supportFragmentManager.beginTransaction()
                        .hide(active)
                        .show(exchangeRatesFragment)
                        .commitNow()
                    active = exchangeRatesFragment
                    bottom_nav_view.selectedItemId = R.id.fragment_exchange_rates
                }
            }
        }
        stackEnabled = true
    }*/
}
