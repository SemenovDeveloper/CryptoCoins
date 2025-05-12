package com.semenovdev.cryptocoins.domain

class LoadDataUseCase(private val coinRepository: CoinRepository) {
    operator fun invoke() = coinRepository.loadData()
}