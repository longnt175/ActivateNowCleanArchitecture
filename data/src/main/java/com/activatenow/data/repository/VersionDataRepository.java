package com.activatenow.data.repository;

import com.activatenow.data.net.RestApi;
import com.activatenow.domain.entity.UserEntity;
import com.activatenow.domain.entity.VersionEntity;
import com.activatenow.domain.repository.VersionRepository;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Observable;

@Singleton
public class VersionDataRepository extends RestApiRepository implements VersionRepository {

    private final RestApi restApi;

    @Inject
    public VersionDataRepository(RestApi restApi) {
        this.restApi = restApi;
    }

    @Override
    public Observable<VersionEntity> checkVersionExpiration(UserEntity user) {
        return this.restApi.checkVersionExpiration(user.getAuthToken())
                .map(versionEntityResponse -> {
                    handleResponseError(versionEntityResponse);
                    return versionEntityResponse.body();
                });
    }

}
