package com.activatenow.domain.repository;

import com.activatenow.domain.entity.UserEntity;

import io.reactivex.Observable;

public interface SessionRepository {
    UserEntity getCurrentUser();
    void setCurrentUser(UserEntity user);
    void invalidateSession();

    Observable<Boolean> hasLoggedIn();
}
