package com.dongyeop.dbp_api.OpenAPI.Repository;

import com.dongyeop.dbp_api.OpenAPI.Entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Long> {
}
