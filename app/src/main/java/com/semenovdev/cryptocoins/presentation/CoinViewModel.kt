package com.semenovdev.cryptocoins.presentation

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.semenovdev.cryptocoins.data.repository.CoinRepositoryImpl
import com.semenovdev.cryptocoins.domain.GetCoinInfoUseCase
import com.semenovdev.cryptocoins.domain.GetCoinsListUseCase
import com.semenovdev.cryptocoins.domain.LoadDataUseCase

class CoinViewModel(application: Application) : AndroidViewModel(application) {

    private val repository = CoinRepositoryImpl(application)

    private val getCoinsListUseCase = GetCoinsListUseCase(repository)
    private val getCoinInfoUseCase = GetCoinInfoUseCase(repository)
    private val loadDataUseCase = LoadDataUseCase(repository)

    val priceList = getCoinsListUseCase()

   fun getDetailInfo(fSym: String) = getCoinInfoUseCase(fSym)


    init {
        loadDataUseCase()
    }
}