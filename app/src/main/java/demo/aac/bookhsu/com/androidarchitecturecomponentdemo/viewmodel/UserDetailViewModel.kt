package demo.aac.bookhsu.com.androidarchitecturecomponentdemo.viewmodel

import android.arch.lifecycle.*
import android.util.Log
import demo.aac.bookhsu.com.androidarchitecturecomponentdemo.repo.UserRepository

/**
 * Created by bookhsu on 2018/4/25.
 */

class UserDetailViewModel : ViewModel(), LifecycleObserver {
    companion object {
        val TAG: String = UserDetailViewModel.javaClass.simpleName;
    }

    private var mUserRepository : UserRepository = UserRepository()
    private val stringData : MutableLiveData<String> = MutableLiveData()

    fun init(repository: UserRepository) {
        this.mUserRepository = repository;
        mUserRepository.initUser("hello.hsu", 29)
    }

    fun getUserRepository() : UserRepository {
        return mUserRepository;
    }

    fun initStrData(str : String = "default") {
        //stringData.apply { str };
        stringData.value = str;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    fun connectListener() {
        Log.d( TAG , "UserDetailViewModel ON_RESUME connectListener");
    }
}