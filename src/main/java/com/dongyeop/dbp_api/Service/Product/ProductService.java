package com.dongyeop.dbp_api.Service.Product;

import com.dongyeop.dbp_api.DTO.Product.ProductDTO;
import com.dongyeop.dbp_api.Entity.Product.ProductEntity;
import com.dongyeop.dbp_api.Repository.Product.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

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
        if(Objects.equals(filter, "name")) {
            return productRepository.findByprdlstNmContaining(query);
        } else if(Objects.equals(filter, "efficacy")) {
            return productRepository.findByprimaryFncltyContaining(query);
        } else {
            return null;
        }
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

    public ProductEntity getRandomOptionProduct(String value) {
        List<ProductEntity> filteredProducts = new ArrayList<>();
        List<ProductEntity> allProducts = productRepository.findAll();

        for (ProductEntity product : allProducts) {
            if (!product.getPrimaryFnclty().contains(value)) {
                filteredProducts.add(product);
            }
        }

        if (filteredProducts.isEmpty()) {
            return null; // 만약 일치하지 않는 상품이 없을 경우 null 반환
        }

        Random random = new Random();
        int randomIndex = random.nextInt(filteredProducts.size());
        return filteredProducts.get(randomIndex);
    }

}
