package com.cattle.xchange.domain.cattleBuy;

import com.cattle.xchange.domain.user.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
interface CattleBuyRepository extends JpaRepository<CattleBuy, UUID>, CattleBuyCustomRepository {

    Page<CattleBuy> findAllByUser(User user, Pageable pageable);
}
