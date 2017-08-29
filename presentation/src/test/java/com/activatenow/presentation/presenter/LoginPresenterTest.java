package com.activatenow.presentation.presenter;

import com.activatenow.data.net.error.RestApiErrorException;
import com.activatenow.domain.entity.UserEntity;
import com.activatenow.domain.interactor.user.DoLoginUseCase;
import com.activatenow.presentation.view.LoginView;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import io.reactivex.Observable;

import static junit.framework.Assert.assertNull;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.verify;

public class LoginPresenterTest {

    @Mock DoLoginUseCase mockDoLoginUseCase;
    @Mock LoginView mockLoginView;
    @Mock Observable mockObservable;

    private LoginPresenter loginPresenter;
    private LoginPresenter.LoginSubscriber loginSubscriber;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        this.loginPresenter = new LoginPresenter(this.mockDoLoginUseCase);
        this.loginPresenter.initWithView(this.mockLoginView);
        this.loginSubscriber = this.loginPresenter.new LoginSubscriber();
    }

    @Test
    public void testDestroy() {

        this.loginPresenter.destroy();

        verify(this.mockDoLoginUseCase).unsubscribe();
        assertNull(this.loginPresenter.loginView);
        assertNull(this.loginPresenter.view);
    }

    @Test
    public void testLoginUser() throws Exception {

        this.loginPresenter.loginUser("email", "password");

        verify(this.mockLoginView).showLoader();
        verify(this.mockDoLoginUseCase).setParams(any(UserEntity.class));
        verify(this.mockDoLoginUseCase).execute(any(BasePresenter.BaseSubscriber.class));
    }

    @Test
    public void testSubscriberOnCompleted() {

        this.loginSubscriber.onComplete();

        verify(this.mockLoginView).hideLoader();
    }

    @Test
    public void testSubscriberOnError() {

        this.loginSubscriber.onError(new RestApiErrorException("Error message", 500));

        verify(this.mockLoginView).hideLoader();
        verify(this.mockLoginView).handleError(any(Throwable.class));
    }

    @Test
    @SuppressWarnings("unchecked")
    public void testSubscriberOnNext() {

        this.loginSubscriber.onNext(new UserEntity("email"));

        verify(this.mockLoginView).hideLoader();
        verify(this.mockLoginView).viewNotes();
    }

}
