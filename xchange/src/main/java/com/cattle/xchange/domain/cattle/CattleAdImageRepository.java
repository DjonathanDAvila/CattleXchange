package com.cattle.xchange.domain.cattle;

import com.cattle.xchange.domain.cattle.CattleAdImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
interface CattleAdImageRepository extends JpaRepository<CattleAdImage, UUID> {
}