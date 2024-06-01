package com.dongyeop.dbp_api.OpenAPI.Service;

import com.dongyeop.dbp_api.OpenAPI.DTO.ProductDTO;
import com.dongyeop.dbp_api.OpenAPI.Entity.ProductEntity;
import com.dongyeop.dbp_api.OpenAPI.Repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    @Transactional
    public void saveProduct(ProductDTO productDTO) {
        ProductEntity productEntity = new ProductEntity();
        productEntity.setPrdlstNm(productDTO.getPrdlstNm());
        productEntity.setNtkMthd(productDTO.getNtkMthd());

        // primaryFnclty 필드의 길이를 확인하고 자르기
        String primaryFnclty = productDTO.getPrimaryFnclty();
        if (primaryFnclty != null && primaryFnclty.length() > 255) {
            primaryFnclty = primaryFnclty.substring(0, 255);
        }
        productEntity.setPrimaryFnclty(primaryFnclty);

        // rawmtrl_nm 필드의 길이를 확인하고 자르기
        String rawmtrlNm = productDTO.getRAWMTRL_NM();
        if (rawmtrlNm != null && rawmtrlNm.length() > 255) { // Assuming the column length is 255
            rawmtrlNm = rawmtrlNm.substring(0, 255);
        }

        productEntity.setRAWMTRL_NM(rawmtrlNm);

        productEntity.setPog_Daycnt(productDTO.getPog_Daycnt());
        productEntity.setIFTKN_ATNT_MATR_CN(productDTO.getIFTKN_ATNT_MATR_CN());
        productEntity.setCSTDY_MTHD(productDTO.getCSTDY_MTHD());

        productRepository.save(productEntity);
    }

    @Transactional
    public void saveProducts(List<ProductDTO> productDTOs) {
        for (ProductDTO productDTO : productDTOs) {
            saveProduct(productDTO);
        }
    }

    @Transactional(readOnly = true)
    public List<ProductEntity> getAllProducts() {
        return productRepository.findAll();
    }


    @Transactional(readOnly = true)
    public List<ProductEntity> getQueryProducts(String filter, String query) {
        System.out.println("서비스 값 : " + filter + " " + query);
        if(Objects.equals(filter, "name")) {
            return productRepository.findByprdlstNmContaining(query);
        }else if(Objects.equals(filter, "efficacy")){
            return productRepository.findByprimaryFncltyContaining(query);
        }else{
            return null;
        }
    }
}
