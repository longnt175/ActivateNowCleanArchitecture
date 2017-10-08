package com.activatenow.presentation.presenter;

import com.activatenow.domain.interactor.CheckVersionExpirationUseCase;
import com.activatenow.presentation.dependency.ActivityScope;
import com.activatenow.presentation.view.BaseView;
import com.activatenow.presentation.view.SplashView;

import javax.inject.Inject;

/**
 * Created by mobiledev on 5/10/2017.
 */
@ActivityScope
public class SplashPresenter extends BasePresenter implements Presenter {
    SplashView splashView;
    private CheckVersionExpirationUseCase checkVersionExpirationUseCase;

    @Inject
    public SplashPresenter(CheckVersionExpirationUseCase checkVersionExpirationUseCase) {
        super(checkVersionExpirationUseCase);
        this.checkVersionExpirationUseCase = checkVersionExpirationUseCase;
    }

    @Override
    public void initWithView(BaseView view) {
        super.initWithView(view);
        this.splashView = (SplashView) view;
    }

    @Override
    public void destroy() {
        super.destroy();
        this.splashView = null;
    }

    public void checkSession() {
        this.checkVersionExpirationUseCase.execute(new SessionSubscriber());
    }

    protected class SessionSubscriber extends BaseSubscriber<Boolean> {

        @Override
        public void onNext(Boolean value) {
            if (value)
                splashView.openHome();
            else
                splashView.closeAndDisplayLogin();
        }

    }
}
