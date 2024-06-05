package com.dongyeop.dbp_api.Service;

import com.dongyeop.dbp_api.DTO.ProductDTO;
import com.dongyeop.dbp_api.Entity.ProductEntity;
import com.dongyeop.dbp_api.Repository.Product.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
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
        productEntity.setPrimaryFnclty(productDTO.getPrimaryFnclty());
        productEntity.setRAWMTRL_NM(productDTO.getRAWMTRL_NM());
        productEntity.setPog_Daycnt(productDTO.getPog_Daycnt());
        productEntity.setIFTKN_ATNT_MATR_CN(productDTO.getIFTKN_ATNT_MATR_CN());
        productEntity.setCSTDY_MTHD(productDTO.getCSTDY_MTHD());
        productRepository.save(productEntity);


        /*
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
         */



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

    //선택된 모든 모든 영양소
    public List<ProductEntity> getOptionProducts(List<String> options) {
        List<ProductEntity> productEntities = new ArrayList<>();

        for(String option : options){
            List<ProductEntity> foundProducts = productRepository.findByprimaryFncltyContaining(option);
            productEntities.addAll(foundProducts);
        }

        return productEntities;
    }

    //선택된 영양소들이 있는
    public List<ProductEntity> getOptionProducts2(List<String> options) {
        List<ProductEntity> filteredProducts = new ArrayList<>();
        List<ProductEntity> allProducts = productRepository.findAll();

        for (ProductEntity product : allProducts) {
            boolean includeProduct = true;
            for (String option : options) {
                if (!product.getPrimaryFnclty().contains(option)) {
                    includeProduct = false;
                    break;
                }
            }
            if (includeProduct) {
                filteredProducts.add(product);
            }
        }
        return filteredProducts;
    }

}
