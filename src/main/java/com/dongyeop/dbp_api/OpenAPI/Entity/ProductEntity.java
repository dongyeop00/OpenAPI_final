package com.dongyeop.dbp_api.OpenAPI.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
@Table(name="food")
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String prdlstNm;

    @Column
    private String ntkMthd;

    @Column(name = "primaryFnclty", length = 255)
    private String primaryFnclty;

    @Column
    private String pog_Daycnt; // 소비기한

    @Column
    private String IFTKN_ATNT_MATR_CN; //섭취 주의사항

    @Column
    private String CSTDY_MTHD; //보관방법

    @Column(name= "RAWMTRL_NM", length = 255)
    private String RAWMTRL_NM; //원재료
}
