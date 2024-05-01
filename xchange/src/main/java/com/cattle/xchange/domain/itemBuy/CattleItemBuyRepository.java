package com.cattle.xchange.domain.itemBuy;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CattleItemBuyRepository extends JpaRepository<CattleItemBuy, UUID> {
}
