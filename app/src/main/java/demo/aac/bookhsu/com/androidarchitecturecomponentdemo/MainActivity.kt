package demo.aac.bookhsu.com.androidarchitecturecomponentdemo

import android.arch.lifecycle.LifecycleObserver
import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import demo.aac.bookhsu.com.androidarchitecturecomponentdemo.model.User
import demo.aac.bookhsu.com.androidarchitecturecomponentdemo.repo.UserRepository
import demo.aac.bookhsu.com.androidarchitecturecomponentdemo.viewmodel.UserDetailViewModel
import kotlin.concurrent.thread

class MainActivity : AppCompatActivity() {

    private lateinit var mUserDetailViewModel: UserDetailViewModel
    private lateinit var nameTxt: TextView
    private lateinit var changeButton: Button
    private var ageIndex : Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        nameTxt = findViewById(R.id.nameTxt)
        changeButton = findViewById(R.id.changeButton)

        mUserDetailViewModel = ViewModelProviders.of(this).get(UserDetailViewModel::class.java)
        mUserDetailViewModel.init(UserRepository());

        //mUserDetailViewModel.initUser("hello.hsu", 29)

        mUserDetailViewModel.getUserRepository().getUser().observe(this, Observer<User> { t ->
            //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            if (t != null) {
                val result = "user name = " + t.name + " age = " + t.age

                val nullobj : String? = null
                nameTxt.text = nullobj?.length.toString()

                nameTxt.text = result
                Toast.makeText(this@MainActivity, result, Toast.LENGTH_SHORT).show()
            }
        })

        changeButton.setOnClickListener({
            thread (start = true) {
                Thread.sleep(1000 * 2)
                mUserDetailViewModel.getUserRepository().initUser("hello.hsu", ++ageIndex)
            }
        })


        val mLifecycleObservers = arrayOf<LifecycleObserver>(mUserDetailViewModel)
        setLifecycle(mLifecycleObservers)

        //getLifecycle().addObserver(mUserDetailViewModel);
    }


    private fun setLifecycle(models : Array<LifecycleObserver> ) {
        for (model in models) {
            lifecycle.addObserver(model)
        }
    }

}
