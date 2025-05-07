package com.semenovdev.cryptocoins.domain

import androidx.lifecycle.LiveData

class GetCoinsListUseCase(private val coinsListRepository: CoinsListRepository) {
    suspend fun getCoinInfoUseCase(): LiveData<List<CoinPriceInfo>> {
        return coinsListRepository.getCoinsList()
    }
}