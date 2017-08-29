package com.activatenow.domain.repository;

import com.activatenow.domain.entity.MessageEntity;
import com.activatenow.domain.entity.UserEntity;
import com.activatenow.domain.entity.VoidEntity;

import io.reactivex.Observable;

public interface UserRepository {
    Observable<UserEntity> createUser(UserEntity user);
    Observable<VoidEntity> deleteUser(UserEntity user);
    Observable<MessageEntity> resetPassword(UserEntity user);

    Observable<UserEntity> loginUser(UserEntity user);
    Observable<VoidEntity> logoutUser(UserEntity user);
}
