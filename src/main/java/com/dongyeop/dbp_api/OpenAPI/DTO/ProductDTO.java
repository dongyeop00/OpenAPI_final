package com.dongyeop.dbp_api.OpenAPI.DTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class ProductDTO {

    private String prdlstNm; //품목명
    private String ntkMthd; //섭취 방법
    private String primaryFnclty; //주된 기능
    private String pog_Daycnt; // 소비기한
    private String IFTKN_ATNT_MATR_CN; //섭취 주의사항
    private String CSTDY_MTHD; //보관방법
    private String RAWMTRL_NM; //원재료

    public ProductDTO(String prdlstNm, String ntkMthd, String primaryFnclty, String pog_Daycnt, String IFTKN_ATNT_MATR_CN, String CSTDY_MTHD, String RAWMTRL_NM) {
        this.prdlstNm = prdlstNm;
        this.ntkMthd = ntkMthd;
        this.primaryFnclty = primaryFnclty;
        this.pog_Daycnt = pog_Daycnt;
        this.IFTKN_ATNT_MATR_CN = IFTKN_ATNT_MATR_CN;
        this.CSTDY_MTHD = CSTDY_MTHD;
        this.RAWMTRL_NM = RAWMTRL_NM;
    }
}
