package com.activatenow.domain.interactor.user;

import com.activatenow.domain.entity.VoidEntity;
import com.activatenow.domain.executor.PostExecutionThread;
import com.activatenow.domain.executor.ThreadExecutor;
import com.activatenow.domain.interactor.UseCase;
import com.activatenow.domain.repository.SessionRepository;
import com.activatenow.domain.repository.UserRepository;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Function;

public class DeleteUserUseCase extends UseCase<VoidEntity> {

    private UserRepository userRepository;
    private SessionRepository sessionRepository;

    @Inject
    public DeleteUserUseCase(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread,
                             UserRepository userRepository, SessionRepository sessionRepository) {
        super(threadExecutor, postExecutionThread);
        this.userRepository = userRepository;
        this.sessionRepository = sessionRepository;
    }

    @Override
    protected Observable<VoidEntity> buildUseCaseObservable() {
        return this.userRepository.deleteUser(this.sessionRepository.getCurrentUser())
                .doOnComplete(new Action() {
                    @Override
                    public void run() {
                        sessionRepository.invalidateSession();
                    }
                });
    }
}
