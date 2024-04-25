package com.cattle.xchange.domain.cattle.cattleAd;

import com.cattle.xchange.domain.cattle.CattleAdImage;
import com.cattle.xchange.domain.cattle.cattleAd.enums.BreedEnum;
import com.cattle.xchange.domain.cattle.cattleAd.enums.CattleStatusEnum;
import com.cattle.xchange.domain.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "tcattle_ad")
@Entity
public class CattleAd {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "bd_codad")
    private UUID id;

    @Column(name = "bd_title")
    private String title;

    @Lob
    @Column(name = "bd_desc")
    private String desc;

    @Column(name = "bd_unitvalue")
    private double unitValue;

    @Column(name = "bd_quantity")
    private int quantity;

    @Enumerated(EnumType.STRING)
    @Column(name = "bd_breed")
    private BreedEnum breed;

    @Column(name = "bd_sex")
    private char sex;

    @Column(name = "bd_coduser")
    private UUID userCod;

//    @Transient
//    private User user;

    @Column(name = "bd_addate")
    private LocalDate adDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "bd_status")
    private CattleStatusEnum status;

    @OneToMany(mappedBy = "cattleAd", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<CattleAdImage> cattleAdImages = new ArrayList<>();
}
