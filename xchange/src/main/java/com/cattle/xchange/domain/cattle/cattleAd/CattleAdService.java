package com.cattle.xchange.domain.cattle.cattleAd;

import com.cattle.xchange.domain.cattle.CattleAdImage;
import com.cattle.xchange.domain.cattle.cattleAd.dtos.CattleAdImageInsertDTO;
import com.cattle.xchange.domain.cattle.cattleAd.dtos.CattleAdImageMinDTO;
import com.cattle.xchange.domain.cattle.cattleAd.enums.BreedEnum;
import com.cattle.xchange.domain.cattle.cattleAd.enums.CattleStatusEnum;
import jakarta.validation.constraints.Future;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
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
    public CattleAd insert(String title, String desc, double unitValue, int quantity, BreedEnum breed, char sex, UUID userCod, CattleStatusEnum status, List<CattleAdImageInsertDTO> imagesDTO) {

        var cattle = new CattleAd(
                null, title, desc, unitValue, quantity, breed, sex, userCod, LocalDate.now(), status, new ArrayList<>()
        );

        var images = imagesDTO.stream()
                .map(image -> new CattleAdImage(image))
                .collect(Collectors.toList());


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

    public Boolean atualizaStatus(UUID id, CattleStatusEnum status){
        CattleAd cattleAd = _cattleRepository.findById(id).get();
        cattleAd.setStatus(status);
        _cattleRepository.save(cattleAd);
        return true;
    }
}
