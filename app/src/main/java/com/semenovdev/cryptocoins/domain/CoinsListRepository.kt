package com.semenovdev.cryptocoins.domain

import androidx.lifecycle.LiveData

interface CoinsListRepository {
   suspend fun getCoinsList(): LiveData<List<CoinPriceInfo>>
   suspend fun getCoinInfo(type: String): CoinPriceInfo
}