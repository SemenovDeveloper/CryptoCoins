package com.semenovdev.cryptocoins.domain

class GetCoinsListUseCase(private val coinsListRepository: CoinsListRepository) {
    operator fun invoke() = coinsListRepository.getCoinsList()
}