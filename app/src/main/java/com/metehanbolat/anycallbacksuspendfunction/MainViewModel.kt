package com.metehanbolat.anycallbacksuspendfunction

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.metehanbolat.anycallbacksuspendfunction.model.CountryModel
import com.metehanbolat.anycallbacksuspendfunction.service.CountryApiService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers

class MainViewModel: ViewModel() {

    private val countryApiService = CountryApiService()
    private val disposable = CompositeDisposable()
    val countries = MutableLiveData<List<CountryModel>>()

    fun getDataFromApi(){
        disposable.add(
            countryApiService.getData()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : DisposableSingleObserver<List<CountryModel>>() {
                    override fun onSuccess(value: List<CountryModel>?) {
                        countries.value = value
                    }
                    override fun onError(e: Throwable?) {
                        e?.let {
                            println(it.localizedMessage)
                        }
                    }

                })
        )
    }
}