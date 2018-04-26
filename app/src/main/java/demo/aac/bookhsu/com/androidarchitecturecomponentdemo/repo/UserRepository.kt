package demo.aac.bookhsu.com.androidarchitecturecomponentdemo.repo

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import demo.aac.bookhsu.com.androidarchitecturecomponentdemo.model.User

/**
 * Created by bookhsu on 2018/4/26.
 */
class UserRepository {
    private val userDate : MutableLiveData<User> = MutableLiveData();

    fun initUser(name : String = "ac.hsu", age : Int = 12) {
        var user = User()
        user.name = name;
        user.age = age;

        // main Thread trigger
        // userDate.value = user;
        // background trigger
        // userDate.postValue(user);
    }

    fun getUser() : LiveData<User> {
        return userDate;
    }
}