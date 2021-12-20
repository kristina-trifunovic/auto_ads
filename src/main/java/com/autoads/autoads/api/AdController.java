package com.autoads.autoads.api;

import com.autoads.autoads.model.Ad;
import com.autoads.autoads.service.AdService;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("v1/api/ad")
public class AdController {

    private final AdService adService;


    public AdController(AdService adService) {
        this.adService = adService;
    }

    @PostMapping
    public void addAd(@RequestBody @NonNull Ad ad) {
        adService.addAd(ad);
    }

    @GetMapping(path = "{id}")
    public Ad getAdById(@PathVariable("id") UUID id) {
        return adService.getAdById(id)
                .orElse(null);
    }

    @GetMapping
    public void getAllAds() {
        adService.getAllAds();
    }

    @PutMapping(path = "{id}")
    public int updateAd(@PathVariable("id")UUID id, Ad adUpdate) {
        return adService.updateAd(id, adUpdate);
    }

    @DeleteMapping(path = "{id}")
    public int deleteAd(@PathVariable("id")UUID id) {
        return adService.deleteAdById(id);
    }
}
