package com.cattle.xchange.domain.cattleBuy;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public interface CattleBuyCustomRepository {
    Page<CattleBuy> findByUserId(UUID userId, Pageable pageable);
}
