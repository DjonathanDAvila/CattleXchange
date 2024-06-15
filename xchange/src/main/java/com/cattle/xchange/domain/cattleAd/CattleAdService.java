package com.cattle.xchange.domain.cattleAd;

import com.cattle.xchange.domain.cattleAdImage.CattleAdImage;
import com.cattle.xchange.domain.cattleAdImage.dtos.CattleAdImageInsertDTO;
import com.cattle.xchange.domain.cattleAd.enums.BreedEnum;
import com.cattle.xchange.domain.cattleAd.enums.CattleStatusEnum;
import com.cattle.xchange.domain.cattleAd.enums.SexEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class CattleAdService {

    @Autowired
    private CattleAdRepository _cattleRepository;

    public Optional<CattleAd> findCattleAdById(UUID id) {
        return _cattleRepository.findById(id);
    }

    public List<CattleAd> findCattleAds(Pageable pageable) {
        return _cattleRepository.findAll(pageable).toList();
    }

    @Transactional
    public CattleAd insert(String title, String desc, double unitValue, int quantity, BreedEnum breed, SexEnum sex, UUID userCod, String city, String state, CattleStatusEnum status, List<CattleAdImageInsertDTO> imagesDTO) {

        var cattle = new CattleAd(
                null, title, desc, unitValue, quantity, breed, sex, userCod, city, state, LocalDate.now(), status, new ArrayList<>()
        );

        var images = imagesDTO.stream()
                .map(CattleAdImage::new)
                .toList();


        for (CattleAdImage image : images)
        {
            image.setCattleAd(cattle);
            cattle.getCattleAdImages().add(image);
        }

        return _cattleRepository.save(cattle);
    }

    public void delete(UUID id){
        _cattleRepository.deleteById(id);
    }

    public void updateStatus(UUID id, CattleStatusEnum status){
        CattleAd cattleAd = _cattleRepository.findById(id).get();
        cattleAd.setStatus(status);
        _cattleRepository.save(cattleAd);
    }

    @Transactional(readOnly = true)
    public Page<CattleAd> findByCriteria(List<SexEnum> sex, List<String> city, List<String> state, Double maxPrice, BreedEnum breed, Pageable pageable) {
        return _cattleRepository.findByCriteria(sex, city, state, maxPrice, breed, pageable);
    }

    @Transactional(readOnly = true)
    public Page<CattleAd> findByUser(UUID userId, Pageable pageable) {
        return _cattleRepository.findByUser(userId, pageable);
    }
}
