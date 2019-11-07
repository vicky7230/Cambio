package com.vicky7230.cambio.ui.currencies

import android.graphics.drawable.PictureDrawable
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestBuilder
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions.withCrossFade
import com.vicky7230.cambio.R
import com.vicky7230.cambio.data.network.model.currencies.Currency
import com.vicky7230.cambio.utils.SvgSoftwareLayerSetter
import kotlinx.android.synthetic.main.currency_list_item.view.*
import java.text.NumberFormat
import java.util.*


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
            itemView.currency_name.text = currency.name
            itemView.currency.text = currency.currency
            itemView.price.text =
                NumberFormat.getCurrencyInstance(Locale.US).format(currency.price?.toDouble())

            currency.logoUrl?.let {

                if (it.contains(".svg")) {

                    val requestBuilder: RequestBuilder<PictureDrawable> =
                        Glide.with(itemView.context)
                            .`as`(PictureDrawable::class.java)
                            .transition(withCrossFade())
                            .listener(SvgSoftwareLayerSetter())

                    requestBuilder
                        .load(Uri.parse(currency.logoUrl))
                        //.apply(RequestOptions.circleCropTransform())
                        .into(itemView.currency_image)
                } else {

                    Glide
                        .with(itemView.context)
                        .load(currency.logoUrl)
                        //.apply(RequestOptions.circleCropTransform())
                        .transition(withCrossFade())
                        .into(itemView.currency_image)
                }
            }
        }

    }

}