package com.semenovdev.cryptocoins.domain

class GetCoinInfoUseCase(private val coinsListRepository: CoinsListRepository) {
    suspend fun getCoinInfoUseCase(coinType: String): CoinPriceInfo {
        return coinsListRepository.getCoinInfo(coinType)
    }
}