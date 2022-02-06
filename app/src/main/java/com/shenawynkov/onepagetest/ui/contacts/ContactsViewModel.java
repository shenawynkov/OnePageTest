package com.shenawynkov.onepagetest.ui.contacts;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.shenawynkov.domain.model.contact.ContactX;
import com.shenawynkov.domain.usecases.ContactsUseCase;
import com.shenawynkov.onepagetest.BaseSchedulerProvider;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableSingleObserver;

public class ContactsViewModel extends ViewModel {
    private Disposable disposable;
    private final BaseSchedulerProvider schedulerProvider;
    private final ContactsUseCase contactsUseCase;
    private final MutableLiveData<Boolean> loading = new MutableLiveData<Boolean>(false);
    private final MutableLiveData<List<ContactX>> contacts = new MutableLiveData<List<ContactX>>(new ArrayList());
    private final MutableLiveData<String> message = new MutableLiveData<String>();

    public MutableLiveData<List<ContactX>> getContacts() {
        return contacts;
    }

    public MutableLiveData<Boolean> getLoading() {
        return loading;
    }

    public MutableLiveData<String> getMessage() {
        return message;
    }

    @Inject
    public ContactsViewModel(BaseSchedulerProvider schedulerProvider, ContactsUseCase contactsUseCase) {
        this.contactsUseCase = contactsUseCase;
        this.schedulerProvider = schedulerProvider;
    }

    void updateContacts() {
        disposable = contactsUseCase.invoke()
                .subscribeOn(schedulerProvider.io())
                .doOnSubscribe(d -> loading.setValue(true))
                .observeOn(schedulerProvider.ui())
                .subscribeWith(
                        new DisposableSingleObserver<List<ContactX>>() {

                            @Override
                            public void onSuccess(List<ContactX> contactXES) {

                                contacts.setValue(contactXES);
                                loading.setValue(false);
                            }

                            @Override
                            public void onError(Throwable e) {
                                message.setValue(e.getMessage());
                                loading.setValue(false);

                            }
                        }


                );


    }

    @Override
    protected void onCleared() {
        super.onCleared();
        disposable.dispose();

    }
}
