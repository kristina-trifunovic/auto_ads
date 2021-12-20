package com.autoads.autoads.dao;

import com.autoads.autoads.model.Ad;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface AdDAO {

    int insertAd(UUID id, Ad ad);

    default int insertAd(Ad ad) {
        UUID id = UUID.randomUUID();
        return insertAd(id, ad);
    }

    Optional<Ad> selectAdById(UUID id);

    int deleteAdById(UUID id);

    int updateAdById(UUID id, Ad ad);

    List<Ad> getAllAds();
}
