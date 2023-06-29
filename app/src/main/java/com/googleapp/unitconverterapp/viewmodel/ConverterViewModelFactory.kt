package com.googleapp.unitconverterapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.CreationExtras
import com.googleapp.unitconverterapp.data.ConverterRepository

class ConverterViewModelFactory(private val repository: ConverterRepository) :
    ViewModelProvider.NewInstanceFactory() {
    //boilerplate code part when viewmodel class have contructor parameters
    override fun <T : ViewModel> create(modelClass: Class<T>, extras: CreationExtras): T =
        ConverterViewModel(repository) as T


}