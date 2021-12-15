package com.randomuser.app.fragments.list

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.randomuser.app.data.User
import com.randomuser.app.repositories.UsersRepository
import com.randomuser.app.utils.isInternetAvailable
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.*
import javax.inject.Inject

@HiltViewModel
class ListingOfUsersViewModel @Inject constructor(application: Application, private val usersRepository: UsersRepository)
    : AndroidViewModel(application) {

    private val context
        get() = getApplication<Application>()

    private val showNoInternet: MutableLiveData<Boolean> = MutableLiveData(false)
    private val loading = MutableLiveData<Boolean>()
    private val usersList = MutableLiveData<List<User>>()

    private var job: Job? = null
    private val errorMessage = MutableLiveData<String>()
    private val exceptionHandler = CoroutineExceptionHandler { _, throwable ->
        onApiError("Exception: ${throwable.localizedMessage}")
    }

    fun getUsers() {
        if(isInternetAvailable(context)) {
            job = CoroutineScope(Dispatchers.IO + exceptionHandler).launch {
                val response = usersRepository.getAllUsers()
                withContext(Dispatchers.Main) {
                    if (response.isSuccessful) {
                        usersList.postValue(response.body()?.results)
                        loading.value = false
                    } else {
                        onApiError("Error : ${response.message()} ")
                    }
                }
            }
        } else {
            showNoInternet.value = true;
        }
    }

    private fun onApiError(message: String) {
        errorMessage.postValue(message)
        loading.postValue(false)
    }

    override fun onCleared() {
        super.onCleared()
        job?.cancel()
    }

    fun getShowNoInternet(): LiveData<Boolean> {
        return showNoInternet
    }

    fun setShowNoInternet(showNoInternet: Boolean) {
        this.showNoInternet.value = showNoInternet
    }

    fun getUsersList(): LiveData<List<User>> {
        return usersList
    }
}