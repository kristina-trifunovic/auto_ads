package com.autoads.autoads.dao;

import com.autoads.autoads.model.User;

import java.util.Optional;
import java.util.UUID;

public interface UserDAO {

    int insertUser(UUID id, UUID adId, User user);

    default int insertUser(User user) {
        UUID id = UUID.randomUUID();
        UUID adId = UUID.randomUUID(); // CHANGE AFTERWARDS
        return insertUser(id, adId, user);
    }

    int selectAdsFromOneUser(UUID id);

    Optional<Object> selectUserById(UUID id);

    int deleteUserById(UUID id);

    int updateUserById(UUID id, User user);

}
