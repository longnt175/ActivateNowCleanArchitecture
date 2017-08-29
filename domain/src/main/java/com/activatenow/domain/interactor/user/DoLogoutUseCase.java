package com.activatenow.domain.interactor.user;

import com.activatenow.domain.entity.UserEntity;
import com.activatenow.domain.entity.VoidEntity;
import com.activatenow.domain.executor.PostExecutionThread;
import com.activatenow.domain.executor.ThreadExecutor;
import com.activatenow.domain.interactor.UseCase;
import com.activatenow.domain.repository.SessionRepository;
import com.activatenow.domain.repository.UserRepository;

import javax.inject.Inject;

import io.reactivex.Observable;

public class DoLogoutUseCase extends UseCase<VoidEntity> {

    private UserRepository userRepository;
    private SessionRepository sessionRepository;

    @Inject
    public DoLogoutUseCase(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread,
                           UserRepository userRepository, SessionRepository sessionRepository) {
        super(threadExecutor, postExecutionThread);
        this.userRepository = userRepository;
        this.sessionRepository = sessionRepository;
    }

    @Override
    protected Observable<VoidEntity> buildUseCaseObservable() {
        UserEntity currentUser = this.sessionRepository.getCurrentUser();
        this.sessionRepository.invalidateSession();
        return this.userRepository.logoutUser(currentUser);
    }
}
