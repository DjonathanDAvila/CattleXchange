package com.cattle.xchange.domain.cattleBuy;

import com.cattle.xchange.domain.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "tcattle_buy")
@Entity
public class CattleBuy {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "bd_codbuy")
    private UUID codBuy;

    @ManyToOne
    @JoinColumn(name = "bd_coduser")
    private User user;

    @Column(name = "bd_datebuy")
    private Date dateBuy;

    @Column(name = "bd_totalvalue")
    private double totalValue;
}
