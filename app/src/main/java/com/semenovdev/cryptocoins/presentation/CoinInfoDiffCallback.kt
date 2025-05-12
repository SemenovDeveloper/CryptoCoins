package com.semenovdev.cryptocoins.presentation

import androidx.recyclerview.widget.DiffUtil
import com.semenovdev.cryptocoins.domain.CoinInfo

object CoinInfoDiffCallback: DiffUtil.ItemCallback<CoinInfo>() {
    override fun areItemsTheSame(
        oldItem: CoinInfo,
        newItem: CoinInfo
    ): Boolean {
        return oldItem.fromSymbol == newItem.fromSymbol
    }

    override fun areContentsTheSame(
        oldItem: CoinInfo,
        newItem: CoinInfo
    ): Boolean {
        return oldItem == newItem
    }
}