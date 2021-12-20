package com.autoads.autoads.dao;



import com.autoads.autoads.model.Ad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("postgres")
public class AdDataAccessService implements AdDAO{

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public AdDataAccessService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int insertAd(UUID id, Ad ad) {
        String sql = "INSERT INTO ads(name) VALUES(?)";
        return jdbcTemplate.update(sql, ad.getName());
    }

    @Override
    public Optional<Ad> selectAdById(UUID id) {
        final String sql = "SELECT id, name, ad_id FROM users WHERE id = ?";

        List<Ad> ad = jdbcTemplate.query(
                sql,
                (resultSet, i) -> {
                    UUID adId = UUID.fromString(resultSet.getString("id"));
                    String name = resultSet.getString("name");
                    return new Ad(adId, name);
                },
                id
        );
        return ad.stream().findFirst();
    }

    @Override
    public int deleteAdById(UUID id) {
        String sql = "DELETE * FROM ads WHERE id = ?";
        jdbcTemplate.update(sql, id);
        return 0;
    }

    @Override
    public int updateAdById(UUID id, Ad ad) {
        String sql = "UPDATE ads SET name = " + ad.getName() + " WHERE id = ?";
        return jdbcTemplate.update(sql, id);
    }

    @Override
    public List<Ad> getAllAds() {
        String sql = "SELECT * FROM ads";
        return jdbcTemplate.query(sql, (resultSet, i) -> {
            UUID id = UUID.fromString(resultSet.getString("id"));
            String name = resultSet.getString("name");
            return new Ad(id, name);
        });
    }
}
