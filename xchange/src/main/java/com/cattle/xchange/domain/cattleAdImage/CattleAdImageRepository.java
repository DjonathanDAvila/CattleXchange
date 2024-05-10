package com.cattle.xchange.domain.cattleAdImage;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
interface CattleAdImageRepository extends JpaRepository<CattleAdImage, UUID> {
}