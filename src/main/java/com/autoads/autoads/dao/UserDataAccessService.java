package com.autoads.autoads.dao;

import com.autoads.autoads.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("postgres")
public class UserDataAccessService implements UserDAO{

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public UserDataAccessService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int insertUser(UUID id, UUID adId, User user) {
        String sql = "INSERT INTO users(ad_id, name) VALUES(?, ?)";
        return jdbcTemplate.update(sql, user.getAdId(), user.getName());
    }

    @Override
    public int selectAdsFromOneUser(UUID id) {
        return 0;
    }

    /*@Override
    public Object selectAdsFromOneUser(UUID id) {
        String sql = "SELECT name FROM ads JOIN users ON users.ad_id = ads.id WHERE id = ?";
        return jdbcTemplate.query(sql, (resultSet, i) -> {
            String adName = resultSet.getString("ads.name");
            String userName = resultSet.getString("user.name");
            return new Object(adName, userName);
        });
    }*/

    @Override
    public Optional<Object> selectUserById(UUID id) {
        final String sql = "SELECT id, name, ad_id FROM users WHERE id = ?";

        List<User> user = jdbcTemplate.query(
                sql,
                (resultSet, i) -> {
                    UUID userId = UUID.fromString(resultSet.getString("id"));
                    UUID adId = UUID.fromString(resultSet.getNString("ad_id"));
                    String name = resultSet.getString("name");
                    return new User(userId, adId, name);
                },
                id
        );
        return Optional.of(user.stream().findFirst());
    }

    @Override
    public int deleteUserById(UUID id) {
        String sql = "DELETE FROM users WHERE id = ?";
        return jdbcTemplate.update(sql, id);

    }

    @Override
    public int updateUserById(UUID id, User user) {
        String sql = "UPDATE users SET name = " + user.getName() + "WHERE id = ?";
        return jdbcTemplate.update(sql, id);
    }
}
