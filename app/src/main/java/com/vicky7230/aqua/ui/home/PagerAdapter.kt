package com.vicky7230.aqua.ui.home

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.vicky7230.aqua.ui.home.currencies.CurrenciesFragment
import com.vicky7230.aqua.ui.home.exchangeRates.ExchangeRatesFragment
import com.vicky7230.aqua.ui.home.markets.MarketsFragment
import com.vicky7230.aqua.ui.home.settings.SettingsFragment

class PagerAdapter(fragmentManager: FragmentManager) : FragmentStatePagerAdapter(fragmentManager) {

    override fun getItem(position: Int): Fragment {
        when (position) {
            0 -> {
                return CurrenciesFragment()
            }

            1 -> {
                return MarketsFragment()
            }

            2 -> {
                return ExchangeRatesFragment()
            }

            3 -> {
                return SettingsFragment()
            }

            else -> {
                return CurrenciesFragment()
            }
        }
    }

    override fun getCount(): Int {
        return 4
    }



}