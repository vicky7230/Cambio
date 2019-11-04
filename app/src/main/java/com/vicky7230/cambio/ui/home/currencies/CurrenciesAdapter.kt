package com.vicky7230.cambio.ui.home.currencies

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.vicky7230.cambio.R
import com.vicky7230.cambio.data.network.model.currencies.Currency
import kotlinx.android.synthetic.main.currency_list_item.view.*

class CurrenciesAdapter(private var currencies: MutableList<Currency>) :
    RecyclerView.Adapter<CurrenciesAdapter.CurrencyViewHolder>() {

    fun addItems(currencies: List<Currency>) {
        this.currencies.clear()
        this.currencies.addAll(currencies)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CurrencyViewHolder {
        return CurrencyViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.currency_list_item, parent
                , false
            )
        )
    }

    override fun getItemCount() = currencies.size


    override fun onBindViewHolder(holder: CurrencyViewHolder, position: Int) {
        holder.onBind(currencies[position])
    }

    inner class CurrencyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun onBind(currency: Currency) {
            itemView.currency_name.text = currency.currency

            Glide
                .with(itemView.context)
                .load(currency.logoUrl)
                .apply(RequestOptions.circleCropTransform())
                .into(itemView.currency_image)

        }

    }

}