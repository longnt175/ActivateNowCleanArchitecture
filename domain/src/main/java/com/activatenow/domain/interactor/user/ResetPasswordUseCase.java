package com.activatenow.domain.interactor.user;

import com.activatenow.domain.entity.MessageEntity;
import com.activatenow.domain.entity.UserEntity;
import com.activatenow.domain.executor.PostExecutionThread;
import com.activatenow.domain.executor.ThreadExecutor;
import com.activatenow.domain.interactor.UseCase;
import com.activatenow.domain.repository.SessionRepository;
import com.activatenow.domain.repository.UserRepository;

import javax.inject.Inject;

import io.reactivex.Observable;

public class ResetPasswordUseCase extends UseCase<MessageEntity> {

    private UserRepository userRepository;
    private SessionRepository sessionRepository;

    private UserEntity user;

    @Inject
    public ResetPasswordUseCase(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread,
                                UserRepository userRepository, SessionRepository sessionRepository) {
        super(threadExecutor, postExecutionThread);
        this.userRepository = userRepository;
        this.sessionRepository = sessionRepository;
    }

    public void setParams(UserEntity user) {
        this.user = user;
    }

    @Override
    protected Observable<MessageEntity> buildUseCaseObservable() {
        if (this.user == null) this.user = sessionRepository.getCurrentUser();
        return this.userRepository.resetPassword(this.user);
    }
}
