package com.randomuser.app.fragments.list

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.randomuser.app.utils.isInternetAvailable
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ListingOfUsersViewModel @Inject constructor(application: Application) : AndroidViewModel(application) {

    private val context
        get() = getApplication<Application>()

    private val showNoInternet: MutableLiveData<Boolean> = MutableLiveData(false)

    fun getUsers() {
        if(isInternetAvailable(context)) {
            
        } else {
            showNoInternet.value = true;
        }
    }

    fun getShowNoInternet(): LiveData<Boolean> {
        return showNoInternet
    }

    fun setShowNoInternet(showNoInternet: Boolean) {
        this.showNoInternet.value = showNoInternet
    }
}