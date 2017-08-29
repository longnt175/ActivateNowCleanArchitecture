package com.activatenow.domain.interactor;

import com.activatenow.domain.entity.VersionEntity;
import com.activatenow.domain.executor.PostExecutionThread;
import com.activatenow.domain.executor.ThreadExecutor;
import com.activatenow.domain.repository.SessionRepository;
import com.activatenow.domain.repository.VersionRepository;

import javax.inject.Inject;

import io.reactivex.Observable;

public class CheckVersionExpirationUseCase extends UseCase<VersionEntity> {

    private VersionRepository versionRepository;
    private SessionRepository sessionRepository;

    @Inject
    public CheckVersionExpirationUseCase(ThreadExecutor threadExecutor,
                                         PostExecutionThread postExecutionThread,
                                         VersionRepository versionRepository,
                                         SessionRepository sessionRepository) {
        super(threadExecutor, postExecutionThread);
        this.versionRepository = versionRepository;
        this.sessionRepository = sessionRepository;
    }

    @Override
    protected Observable<VersionEntity> buildUseCaseObservable() {
        return this.versionRepository
                                .checkVersionExpiration(this.sessionRepository.getCurrentUser());
    }
}
