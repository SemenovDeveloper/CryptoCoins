package com.semenovdev.cryptocoins.domain

import androidx.lifecycle.LiveData

interface CoinsListRepository {
   fun getCoinsList(): LiveData<List<CoinInfo>>
   fun getCoinInfo(fromSymbol: String): LiveData<CoinInfo>
}