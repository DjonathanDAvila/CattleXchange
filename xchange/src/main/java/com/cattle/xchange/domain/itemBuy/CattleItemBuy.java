package com.cattle.xchange.domain.itemBuy;

import com.cattle.xchange.domain.cattleBuy.CattleBuy;
import com.cattle.xchange.domain.cattle.cattleAd.CattleAd;
import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @Column(name = "bd_coditem")
    private UUID id;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "bd_codbuy")
    private CattleBuy cattleBuy;

    @OneToOne
    @JoinColumn(name = "bd_codad")
    private CattleAd cattleAd;

    @Column(name = "bd_valuead")
    private double valueAd;

    public CattleItemBuy(CattleBuy cattleBuy, CattleAd cattleAd, double valueAd) {
        this.cattleBuy = cattleBuy;
        this.cattleAd = cattleAd;
        this.valueAd = valueAd;
    }
}
