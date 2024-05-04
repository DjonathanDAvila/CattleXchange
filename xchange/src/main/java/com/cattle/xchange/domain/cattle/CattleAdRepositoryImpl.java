package com.cattle.xchange.domain.cattle;

import com.cattle.xchange.domain.cattle.enums.CattleStatusEnum;
import com.cattle.xchange.domain.common.RepositoryBaseImpl;

import java.util.List;

class CattleAdRepositoryImpl extends RepositoryBaseImpl implements CattleAdCustomRepository {

    @Override
    public List<CattleAd> findByCriteria(String city) {
        QCattleAd qCattleAd = QCattleAd.cattleAd;
        var query = select(qCattleAd)
                    .from(qCattleAd)
                    .where(qCattleAd.status.eq(CattleStatusEnum.ACTIVE));

        if (city != null) {
            query.where(qCattleAd.city.eq(city));
        }

        return query.fetch();
    }
}
