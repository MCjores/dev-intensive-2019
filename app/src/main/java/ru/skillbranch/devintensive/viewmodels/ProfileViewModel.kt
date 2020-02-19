package ru.skillbranch.devintensive.viewmodels

import android.util.Log
import androidx.appcompat.app.AppCompatDelegate
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ru.skillbranch.devintensive.models.Profile
import ru.skillbranch.devintensive.repositories.PreferecesRepository

class ProfileViewModel : ViewModel(){

    private val repository : PreferecesRepository = PreferecesRepository
    private val profileData = MutableLiveData<Profile>()
    private val appTheme = MutableLiveData<Int>()

    init {
        Log.d("M_ProfileViewModel","init view model")
        profileData.value = repository.getProfileData()
        appTheme.value  = repository.getAppTheme()

    }

    override fun onCleared() {
        super.onCleared()
        Log.d("M_ProfileViewModel","View model cleared")
    }

    fun getProfileData(): LiveData<Profile>  = profileData

    fun saveProfileData(profile: Profile){
        repository.saveProfileData(profile)
        profileData.value = profile
    }

    fun getTheme():LiveData<Int> = appTheme


    fun switchTheme() {
        if (appTheme.value == AppCompatDelegate.MODE_NIGHT_YES){
            appTheme.value = AppCompatDelegate.MODE_NIGHT_NO
        }else{
            appTheme.value = AppCompatDelegate.MODE_NIGHT_YES
        }
        repository.saveAppTheme(appTheme.value!!)
    }
}