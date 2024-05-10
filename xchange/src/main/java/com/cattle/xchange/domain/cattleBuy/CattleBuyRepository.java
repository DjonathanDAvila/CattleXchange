package com.cattle.xchange.domain.cattleBuy;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
interface CattleBuyRepository extends JpaRepository<CattleBuy, UUID>, CattleBuyCustomRepository {

}
