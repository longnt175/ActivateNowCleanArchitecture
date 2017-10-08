package com.activatenow.domain.interactor;

import com.activatenow.domain.executor.PostExecutionThread;
import com.activatenow.domain.executor.ThreadExecutor;
import com.activatenow.domain.repository.SessionRepository;

import javax.inject.Inject;

import io.reactivex.Observable;

public class CheckVersionExpirationUseCase extends UseCase<Boolean> {

    private SessionRepository sessionRepository;

    @Inject
    public CheckVersionExpirationUseCase(ThreadExecutor threadExecutor,
                                         PostExecutionThread postExecutionThread,
                                         SessionRepository sessionRepository) {
        super(threadExecutor, postExecutionThread);
        this.sessionRepository = sessionRepository;
    }

    @Override
    protected Observable<Boolean> buildUseCaseObservable() {
        return this.sessionRepository.hasLoggedIn();

    }
}
