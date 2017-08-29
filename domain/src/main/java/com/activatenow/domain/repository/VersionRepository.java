package com.activatenow.domain.repository;

import com.activatenow.domain.entity.UserEntity;
import com.activatenow.domain.entity.VersionEntity;

import io.reactivex.Observable;

public interface VersionRepository {
    Observable<VersionEntity> checkVersionExpiration(UserEntity user);
}
