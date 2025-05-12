package com.semenovdev.cryptocoins.data.repository

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.map
import androidx.work.ExistingWorkPolicy
import androidx.work.WorkManager
import com.semenovdev.cryptocoins.data.database.AppDatabase
import com.semenovdev.cryptocoins.data.mapper.CoinMapper
import com.semenovdev.cryptocoins.data.workers.RefreshDataWorker
import com.semenovdev.cryptocoins.domain.CoinInfo
import com.semenovdev.cryptocoins.domain.CoinRepository

class CoinRepositoryImpl(
    private val application: Application
): CoinRepository {
    private val coinInfoDao = AppDatabase.getInstance(application).coinPriceInfoDao()
    private val mapper = CoinMapper()

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

    override fun loadData() {
        val workManager = WorkManager.getInstance(application)
        workManager.enqueueUniqueWork(
            RefreshDataWorker.NAME,
            ExistingWorkPolicy.REPLACE,
            RefreshDataWorker.makeRequest()
        )
    }
}