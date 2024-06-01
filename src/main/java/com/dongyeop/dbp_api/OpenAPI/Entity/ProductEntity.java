package com.dongyeop.dbp_api.OpenAPI.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.SQLInsert;

@Entity
@Setter
@Getter
@Table(name="food")
public class ProductEntity {
    /*
    private String prdlstNm; //품목명
    private String ntkMthd; //섭취 방법
    private String primaryFnclty; //주된 기능
    private String pog_Daycnt; // 소비기한
    private String IFTKN_ATNT_MATR_CN; //섭취 주의사항
    private String CSTDY_MTHD; //보관방법
    private String RAWMTRL_NM; //원재료
     */

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String prdlstNm; //품목명

    @Column
    private String ntkMthd; //섭취 방법

    @Column(name = "primaryFnclty", length = 255)
    private String primaryFnclty; //주된 기능

    @Column
    private String pog_Daycnt; // 소비기한

    @Column
    private String IFTKN_ATNT_MATR_CN; //섭취 주의사항

    @Column
    private String CSTDY_MTHD; //보관방법

    @Column(name= "RAWMTRL_NM", length = 255)
    private String RAWMTRL_NM; //원재료
}
