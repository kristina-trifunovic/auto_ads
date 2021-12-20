package com.autoads.autoads.service;

import com.autoads.autoads.dao.UserDAO;
import com.autoads.autoads.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {

    private final UserDAO userDAO;

    @Autowired
    public UserService(@Qualifier("postgres") UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public int addUser(User user) {
        return userDAO.insertUser(user);
    }

    public int selectAdsFromOneUser(UUID id) {
        return userDAO.selectAdsFromOneUser(id);
    }

    public Optional<Object> getUserById(UUID id) {
        return userDAO.selectUserById(id);
    }

    public int updateUser(UUID id, User user) {
        return userDAO.updateUserById(id, user);
    }

    public int deleteUserById(UUID id) {
        return userDAO.deleteUserById(id);
    }
}
