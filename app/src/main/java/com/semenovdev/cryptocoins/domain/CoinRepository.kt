package com.semenovdev.cryptocoins.domain

import androidx.lifecycle.LiveData

interface CoinRepository {
   fun getCoinsList(): LiveData<List<CoinInfo>>
   fun getCoinInfo(fromSymbol: String): LiveData<CoinInfo>
   fun loadData()
}