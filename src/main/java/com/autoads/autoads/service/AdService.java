package com.autoads.autoads.service;

import com.autoads.autoads.dao.AdDAO;
import com.autoads.autoads.model.Ad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class AdService {

    private final AdDAO adDAO;

    @Autowired
    public AdService(@Qualifier("postgres")AdDAO adDAO) {
        this.adDAO = adDAO;
    }

    public int addAd(Ad ad) {
        return adDAO.insertAd(ad);
    }

    public Optional<Ad> getAdById(UUID id) {
        return adDAO.selectAdById(id);
    }

    public int updateAd(UUID id, Ad ad) {
        return adDAO.updateAdById(id, ad);
    }

    public int deleteAdById(UUID id) {
        return adDAO.deleteAdById(id);
    }

    public List<Ad> getAllAds() {
        return adDAO.getAllAds();
    }
}
