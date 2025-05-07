package com.semenovdev.cryptocoins.data.repository

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.map
import com.semenovdev.cryptocoins.data.database.AppDatabase
import com.semenovdev.cryptocoins.data.mapper.CoinMapper
import com.semenovdev.cryptocoins.data.network.ApiFactory
import com.semenovdev.cryptocoins.domain.CoinInfo
import com.semenovdev.cryptocoins.domain.CoinRepository
import kotlinx.coroutines.delay

class CoinRepositoryImpl(
    application: Application
): CoinRepository {
    private val coinInfoDao = AppDatabase.getInstance(application).coinPriceInfoDao()
    private val mapper = CoinMapper()
    private val apiService = ApiFactory.apiService


    override fun getCoinsList(): LiveData<List<CoinInfo>> = coinInfoDao.getPriceList().map {
        it.map {
            mapper.mapDbModelToEntity(it)
        }
    }

    override fun getCoinInfo(fromSymbol: String): LiveData<CoinInfo> {
        return coinInfoDao.getPriceInfoAboutCoin(fromSymbol).map {
            mapper.mapDbModelToEntity(it)
        }
    }

    override suspend fun loadData() {
        while (true) {
            try {
                val topCoins = apiService.getTopCoinsInfo(limit = 50)
                val topSymbols = mapper.mapNamesListToString(topCoins)
                val jsonContainer = apiService.getFullPriceList(fSyms = topSymbols)
                val coinInfoDtoList = mapper.mapJsonContainerToListCoinInfo(jsonContainer)
                val dbModelList = coinInfoDtoList.map { mapper.mapDtoToDbModel(it) }
                coinInfoDao.insertPriceList(dbModelList)
            } catch (e: Exception) { }
            delay(10000)

        }
    }
}