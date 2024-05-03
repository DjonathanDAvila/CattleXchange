package com.cattle.xchange.domain.cattle;

import com.cattle.xchange.domain.cattle.dtos.CattleAdImageInsertDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "timage_ad")
@Entity
public class CattleAdImage
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "bd_codimage")
    private UUID id;


//    @Column(name = "bd_codad")
//    private UUID cattleAdId;
    @JsonIgnore
    @ManyToOne // Alteração para FetchType.LAZY
    @JoinColumn(name = "bd_codad")
    private CattleAd cattleAd;

    @Column(name = "bd_sequence")
    private int sequence;

    @Column(name = "bd_url")
    private String url;

    public CattleAdImage(CattleAdImageInsertDTO imageMinDTO)
    {
        this
        (
                null,
                null,
                imageMinDTO.sequence(),
                imageMinDTO.url()
        );
    }



}
