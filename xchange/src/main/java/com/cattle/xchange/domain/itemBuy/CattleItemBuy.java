package com.cattle.xchange.domain.itemBuy;

import com.cattle.xchange.domain.cattleBuy.CattleBuy;
import com.cattle.xchange.domain.cattle.cattleAd.CattleAd;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "titens_buy")
@Entity
public class CattleItemBuy {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "bd_codBuy")
    private CattleBuy cattleBuy;

    @ManyToOne
    @JoinColumn(name = "bd_codAd")
    private CattleAd cattleAd;
}
