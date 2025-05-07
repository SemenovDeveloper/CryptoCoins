package com.semenovdev.cryptocoins.domain

class GetCoinInfoUseCase(private val coinsListRepository: CoinsListRepository) {
    operator fun invoke(fromSymbol: String) = coinsListRepository.getCoinInfo(fromSymbol)
}