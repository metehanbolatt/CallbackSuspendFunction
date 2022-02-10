package com.metehanbolat.anycallbacksuspendfunction

import androidx.lifecycle.ViewModel
import com.metehanbolat.anycallbacksuspendfunction.service.CountryApiService
import io.reactivex.disposables.CompositeDisposable

class MainViewModel: ViewModel() {

    private val countryApiService = CountryApiService()
    private val disposable = CompositeDisposable()

    private fun getDataFromApi() {

    }
}