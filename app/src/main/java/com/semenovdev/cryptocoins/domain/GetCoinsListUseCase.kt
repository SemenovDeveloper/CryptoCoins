package com.semenovdev.cryptocoins.domain

class GetCoinsListUseCase(private val coinRepository: CoinRepository) {
    operator fun invoke() = coinRepository.getCoinsList()
}