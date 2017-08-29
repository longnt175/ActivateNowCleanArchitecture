package com.activatenow.domain.interactor.user;

import com.activatenow.domain.entity.UserEntity;
import com.activatenow.domain.entity.VoidEntity;
import com.activatenow.domain.executor.PostExecutionThread;
import com.activatenow.domain.executor.ThreadExecutor;
import com.activatenow.domain.repository.SessionRepository;
import com.activatenow.domain.repository.UserRepository;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import io.reactivex.Observable;
import io.reactivex.schedulers.TestScheduler;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.verifyZeroInteractions;

public class DeleteUserUseCaseTest {

    @Mock private ThreadExecutor mockThreadExecutor;
    @Mock private PostExecutionThread mockPostExecutionThread;
    @Mock private UserRepository mockUserRepository;
    @Mock private SessionRepository mockSessionRepository;
    @Mock private UserEntity mockUser;

    @Before
    public void setup() { MockitoAnnotations.initMocks(this); }

    @Test
    public void testDeleteUserUseCaseSuccess() {
        DeleteUserUseCase deleteUserUseCase = new DeleteUserUseCase(mockThreadExecutor,
                mockPostExecutionThread, mockUserRepository, mockSessionRepository);
        given(mockSessionRepository.getCurrentUser()).willReturn(mockUser);
        given(mockUserRepository.deleteUser(mockUser))
                .willReturn(Observable.just(new VoidEntity()));
        TestScheduler testScheduler = new TestScheduler();

        deleteUserUseCase.buildUseCaseObservable()
            .observeOn(testScheduler)
            .subscribe();
        testScheduler.triggerActions();

        verify(mockSessionRepository).getCurrentUser();
        verify(mockUserRepository).deleteUser(mockUser);
        verifyNoMoreInteractions(mockUserRepository);
        verify(mockSessionRepository).invalidateSession();
        verifyNoMoreInteractions(mockSessionRepository);
        verifyZeroInteractions(mockThreadExecutor);
        verifyZeroInteractions(mockPostExecutionThread);
    }
}