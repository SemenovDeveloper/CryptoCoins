package com.semenovdev.cryptocoins.domain

class LoadDataUseCase(private val coinRepository: CoinRepository) {
    suspend operator fun invoke() = coinRepository.loadData()
}