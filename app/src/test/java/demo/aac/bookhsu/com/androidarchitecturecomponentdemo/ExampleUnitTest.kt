package demo.aac.bookhsu.com.androidarchitecturecomponentdemo

import android.arch.core.executor.testing.InstantTaskExecutorRule
import demo.aac.bookhsu.com.androidarchitecturecomponentdemo.repo.UserRepository
import demo.aac.bookhsu.com.androidarchitecturecomponentdemo.viewmodel.UserDetailViewModel
import org.junit.Assert
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {

    @Rule
    @JvmField
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    lateinit var mUserDetailViewModel : UserDetailViewModel

    @Before
    fun setUp() {
        mUserDetailViewModel = UserDetailViewModel()
        mUserDetailViewModel.init(UserRepository())
    }

    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

    @Test
    fun test_UserDetailViewModel() {
        mUserDetailViewModel.getUserRepository().initUser("John", 34);
        Assert.assertEquals(mUserDetailViewModel.getUserRepository().getUser().value?.name, "John")
        Assert.assertEquals(mUserDetailViewModel.getUserRepository().getUser().value?.age, 34)

        // val mock = mock<Observer<String>>()
        // mUserDetailViewModel.getUserRepository().getUser().observeForever()

        /*val mock = mock<UserDetailViewModel>()
        mock.getUserRepository().initUser("John", 34)

        val mock1 = mock<UserDetailViewModel> {
            on{ getUserRepository().initUser()
                getUserRepository().getUser().value?.name} doReturn "John"
        }

        verify(mock1).getUserRepository().getUser().value?.name = "John"*/
    }

}
