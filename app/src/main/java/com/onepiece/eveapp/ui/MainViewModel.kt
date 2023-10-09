package com.onepiece.eveapp.ui

import androidx.lifecycle.ViewModel
import com.onepiece.eveapp.data.DataRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val dataRepository: DataRepository) : ViewModel() {



}