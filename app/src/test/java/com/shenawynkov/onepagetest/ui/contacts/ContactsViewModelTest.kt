package com.shenawynkov.onepagetest.ui.contacts

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.shenawynkov.domain.model.contact.ContactX
import com.shenawynkov.domain.usecases.ContactsUseCase
import com.shenawynkov.onepagetest.TrampolineSchedulerProvider
import io.mockk.every
import io.mockk.mockk
import io.reactivex.Scheduler
import io.reactivex.Single
import io.reactivex.android.plugins.RxAndroidPlugins
import io.reactivex.disposables.Disposable
import io.reactivex.internal.schedulers.ExecutorScheduler.ExecutorWorker
import io.reactivex.plugins.RxJavaPlugins
import io.reactivex.schedulers.Schedulers
import junit.framework.Assert.assertEquals
import org.junit.*
import org.junit.rules.TestRule
import java.util.concurrent.Callable
import java.util.concurrent.Executor
import java.util.concurrent.TimeUnit


class ContactsViewModelTest {

    private val contactsUseCase: ContactsUseCase = mockk()
    lateinit var SUT: ContactsViewModel


    @get:Rule
    var rule: TestRule = InstantTaskExecutorRule()
    @Before
    @Throws(Exception::class)
    fun setUp() {

        SUT = ContactsViewModel(TrampolineSchedulerProvider(), contactsUseCase)
    }



    @Test
    fun updateContacts_success_resultStoredInLivedata() {
        //Arrange
        val contact = ContactX(
            ArrayList(),
            "s",
            "dd",
            "wds",
            1,
            "dsadd",
            true,
            true,
            ArrayList(),
            true,
            "SS",
            "s",
            "ss",
            "sss",
            "sss",
            "sss",
            "sss",
            "ssssss",
            true,
            ArrayList(),
            "ssssss",
            true,
            "ss",
            "ss",
            ArrayList(),
            1,
            1,
            ArrayList()
        )
        val contacts = arrayListOf(contact)
        val response = Single.just(contacts as List<ContactX>)

        //Act

        every {
            contactsUseCase.invoke()
        } returns response


        SUT.updateContacts()
        //Assert
        assertEquals(SUT.contacts.value, contacts)
        assertEquals(null, SUT.message.value)
    }


    @Test
    fun updateContacts_Error_errorMustBeenShowed() {
        //Arrange
        val error="error"
        val response = Single.error<List<ContactX>>( Throwable(error))

        //Act

        every {
            contactsUseCase.invoke()
        } returns response


        SUT.updateContacts()
        //Assert
        assertEquals( 0,SUT.contacts.value?.size)
        assertEquals(error, SUT.message.value)
    }

}