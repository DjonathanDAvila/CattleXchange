package com.cattle.xchange.domain.cattle.cattleAd;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
interface CattleAdRepository extends JpaRepository<CattleAd, UUID> {
}