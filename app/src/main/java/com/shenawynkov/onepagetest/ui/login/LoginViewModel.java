package com.shenawynkov.onepagetest.ui.login;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.shenawynkov.domain.usecases.LoginUseCase;

import javax.inject.Inject;

public class LoginViewModel extends ViewModel {
    private final LoginUseCase loginUseCase;
    private final MutableLiveData<String> message = new MutableLiveData<String>();
    public MutableLiveData<String> apiKey = new MutableLiveData<String>();
    public MutableLiveData<String> userID = new MutableLiveData<String>();
    private final MutableLiveData<Boolean> loginStatus = new MutableLiveData<Boolean>();

    public MutableLiveData<Boolean> getLoginStatus() {
        return loginStatus;
    }

    public MutableLiveData<String> getMessage() {
        return message;
    }

    @Inject
    public LoginViewModel(LoginUseCase loginUseCase) {
        this.loginUseCase = loginUseCase;
    }

    public boolean isUserLoggedIn() {
        return loginUseCase.isUserLoggedIn();
    }

    public void onLoginClicked() {
        String apiKey = this.apiKey.getValue();
        String userID = this.userID.getValue();
        //validation
        if (apiKey == null || userID == null || apiKey.isEmpty() || userID.isEmpty()) {
            message.setValue("please fill all data ");
            return;
        }
        loginUseCase.invoke(userID, apiKey);
        loginStatus.setValue(true);

    }
}
