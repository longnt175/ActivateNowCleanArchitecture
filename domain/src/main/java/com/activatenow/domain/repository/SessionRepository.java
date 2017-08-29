package com.activatenow.domain.repository;

import com.activatenow.domain.entity.UserEntity;

public interface SessionRepository {
    UserEntity getCurrentUser();
    void setCurrentUser(UserEntity user);
    void invalidateSession();
}
